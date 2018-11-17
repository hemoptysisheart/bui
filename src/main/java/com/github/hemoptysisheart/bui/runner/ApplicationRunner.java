package com.github.hemoptysisheart.bui.runner;

import com.github.hemoptysisheart.bui.admin.controller.AdminControllerAnchor;
import com.github.hemoptysisheart.bui.configuration.ConfigurationAnchor;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@SpringBootApplication(scanBasePackageClasses = {ApplicationRunner.class,
    ConfigurationAnchor.class,
    AdminControllerAnchor.class})
public class ApplicationRunner {
  private static final Logger log = getLogger(ApplicationRunner.class);

  public static void main(String... args) {
    SpringApplication application = new SpringApplication(ApplicationRunner.class);
    application.addListeners(new ApplicationPidFileWriter("config/bui.pid"));

    ApplicationContext context = application.run(args);
    if (log.isTraceEnabled()) {
      for (String name : context.getBeanDefinitionNames()) {
        log.trace("bean:{}={}", name, context.getBean(name));
      }
    }
  }
}