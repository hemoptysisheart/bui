package com.github.hemoptysisheart.bui.configuration;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
  private static final Logger log = getLogger(WebSecurityConfiguration.class);

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    if (log.isTraceEnabled()) {
      log.trace("#configure args : http={}", http);
    }

    http.formLogin()
        .loginPage("/admin/login")
        .defaultSuccessUrl("/admin");
    http.logout()
        .logoutUrl("/admin/logout")
        .logoutSuccessUrl("/");

    http.authorizeRequests()
        .antMatchers("/admin").permitAll()
        .antMatchers("/admin/signup").anonymous()
        .antMatchers("/admin/**").authenticated()
        .antMatchers("/**").permitAll()
    ;
  }
}