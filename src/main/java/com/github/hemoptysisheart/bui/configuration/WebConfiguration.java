package com.github.hemoptysisheart.bui.configuration;

import com.github.hemoptysisheart.bui.web.BuiHandlerMethodArgumentResolver;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
  private static final Logger log = getLogger(WebConfiguration.class);

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // org.springframework.web.servlet.config.annotation.WebMvcConfigurer
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    if (log.isTraceEnabled()) {
      log.trace("#addViewControllers args : registry={}", registry);
    }

    registry.addViewController("/admin/signin").setViewName("admin/index/signin");
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    if (log.isTraceEnabled()) {
      log.trace("args : resolvers={}", resolvers);
    }

    resolvers.add(new BuiHandlerMethodArgumentResolver());
  }
}