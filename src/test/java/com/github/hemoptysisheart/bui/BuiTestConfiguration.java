package com.github.hemoptysisheart.bui;

import com.github.hemoptysisheart.bui.configuration.ConfigurationAnchor;
import com.github.hemoptysisheart.bui.controller.ControllerConfiguration;
import com.github.hemoptysisheart.bui.domain.FallbackDocument;
import com.github.hemoptysisheart.bui.domain.SimpleFallbackDocument;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author H2
 * @since 2018/11/17
 */
@SpringBootApplication(scanBasePackages = {"com.github.hemoptysisheart.bui.test"},
    scanBasePackageClasses = {ConfigurationAnchor.class, ControllerConfiguration.class})
public class BuiTestConfiguration {
  @Bean
  public FallbackDocument fallbackDocument() {
    return new SimpleFallbackDocument("fallback/default");
  }
}