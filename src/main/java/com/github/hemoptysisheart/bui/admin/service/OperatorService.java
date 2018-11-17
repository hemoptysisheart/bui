package com.github.hemoptysisheart.bui.admin.service;

import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.service.params.CreateOperatorParams;

/**
 * @author H2
 * @since 2018/11/17
 */
public interface OperatorService {
  Operator create(CreateOperatorParams params);
}