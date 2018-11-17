package com.github.hemoptysisheart.bui.admin.jpa.repository;

import com.github.hemoptysisheart.bui.support.jpa.converter.JpaConverterAnchor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author H2
 * @since 2018/11/17
 */
@Configuration
@EnableJpaRepositories
@EntityScan(basePackageClasses = {JpaConverterAnchor.class})
public class AdminRepositoryConfiguration {
}