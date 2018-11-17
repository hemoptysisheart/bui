package com.github.hemoptysisheart.bui.admin.service;

import com.github.hemoptysisheart.bui.admin.dao.AdminDaoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@ComponentScan(basePackageClasses = {AdminDaoConfiguration.class})
public class AdminServiceConfiguration {
}