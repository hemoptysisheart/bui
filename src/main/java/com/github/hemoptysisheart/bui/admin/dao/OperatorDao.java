package com.github.hemoptysisheart.bui.admin.dao;

import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.domain.OperatorCredential;

import java.util.List;

/**
 * @author H2
 * @since 2018/11/17
 */
public interface OperatorDao {
  Operator create(Operator operator);

  List<OperatorCredential> create(OperatorCredential... credentials);
}