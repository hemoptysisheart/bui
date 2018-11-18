package com.github.hemoptysisheart.bui.admin.controller;

import com.github.hemoptysisheart.bui.admin.borderline.AdminBorderlineConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@ComponentScan(basePackageClasses = {AdminBorderlineConfiguration.class})
public class AdminControllerConfiguration {
}