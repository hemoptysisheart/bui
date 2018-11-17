package com.github.hemoptysisheart.bui.admin.dao;

import com.github.hemoptysisheart.bui.admin.jpa.repository.AdminRepositoryConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@ComponentScan(basePackageClasses = {AdminRepositoryConfiguration.class})
public class AdminDaoConfiguration {
}