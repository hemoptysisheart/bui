package com.github.hemoptysisheart.bui;

import com.github.hemoptysisheart.bui.admin.controller.AdminControllerAnchor;
import com.github.hemoptysisheart.bui.admin.jpa.entity.AdminEntityAnchor;
import com.github.hemoptysisheart.bui.admin.jpa.repository.AdminRepositoryAnchor;
import com.github.hemoptysisheart.bui.configuration.ConfigurationAnchor;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author H2
 * @since 2018/11/17
 */
@SpringBootApplication(scanBasePackageClasses = {ConfigurationAnchor.class,
    AdminControllerAnchor.class,
    AdminRepositoryAnchor.class,
    AdminEntityAnchor.class})
public class TestConfiguration {
}