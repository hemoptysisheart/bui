package com.github.hemoptysisheart.bui;

import com.github.hemoptysisheart.bui.borderline.SimpleDocumentLoader;
import com.github.hemoptysisheart.bui.configuration.ConfigurationAnchor;
import com.github.hemoptysisheart.bui.controller.ControllerConfiguration;
import com.github.hemoptysisheart.bui.domain.FallbackDocument;
import com.github.hemoptysisheart.bui.domain.SimpleFallbackDocument;
import com.github.hemoptysisheart.bui.test.configuration.BuiTestProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author H2
 * @since 2018/11/17
 */
@SpringBootApplication(scanBasePackages = {"com.github.hemoptysisheart.bui.test"},
    scanBasePackageClasses = {ConfigurationAnchor.class, ControllerConfiguration.class})
public class BuiTestConfiguration {
  @Bean
  public SimpleDocumentLoader simpleDocumentLoader() {
    return new SimpleDocumentLoader();
  }

  @Bean
  public FallbackDocument fallbackDocument() {
    return new SimpleFallbackDocument("fallback/default");
  }

  @Bean
  @ConfigurationProperties("com.github.hemoptysisheart.bui.test")
  public BuiTestProperties buiTestProperties() {
    return new BuiTestProperties();
  }
}