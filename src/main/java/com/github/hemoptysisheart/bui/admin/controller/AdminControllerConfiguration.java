package com.github.hemoptysisheart.bui.admin.controller;

import com.github.hemoptysisheart.bui.admin.service.AdminServiceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@ComponentScan(basePackageClasses = {AdminServiceConfiguration.class})
public class AdminControllerConfiguration {
}