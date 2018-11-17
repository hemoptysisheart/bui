package com.github.hemoptysisheart.bui.admin.jpa.repository;

import com.github.hemoptysisheart.bui.admin.jpa.entity.OperatorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author H2
 * @since 2018/11/17
 */
@Repository
public interface OperatorRepository extends JpaRepository<OperatorEntity, Integer> {
}