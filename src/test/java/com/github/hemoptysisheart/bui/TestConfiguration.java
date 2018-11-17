package com.github.hemoptysisheart.bui;

import com.github.hemoptysisheart.bui.admin.controller.AdminControllerConfiguration;
import com.github.hemoptysisheart.bui.configuration.ConfigurationAnchor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author H2
 * @since 2018/11/17
 */
@SpringBootApplication(scanBasePackages = {"com.github.hemoptysisheart.bui.test"},
    scanBasePackageClasses = {ConfigurationAnchor.class, AdminControllerConfiguration.class})
public class TestConfiguration {
}