package com.github.hemoptysisheart.bui.configuration;

import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
  private static final Logger log = getLogger(WebConfiguration.class);

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    if (log.isTraceEnabled()) {
      log.trace("#addViewControllers args : registry={}", registry);
    }

    registry.addViewController("/admin/signin").setViewName("admin/index/signin");
  }
}