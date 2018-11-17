package com.github.hemoptysisheart.bui.configuration;

import com.github.hemoptysisheart.bui.util.JpaTimeProvider;
import com.github.hemoptysisheart.bui.util.TimeProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
public class BeanConfiguration {
  @Bean
  public TimeProvider timeProvider() {
    return new JpaTimeProvider();
  }
}