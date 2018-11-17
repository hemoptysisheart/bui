package com.github.hemoptysisheart.bui.admin.dao;

import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.domain.OperatorCredential;
import com.github.hemoptysisheart.bui.admin.jpa.entity.OperatorCredentialEntity;
import com.github.hemoptysisheart.bui.admin.jpa.entity.OperatorEntity;
import com.github.hemoptysisheart.bui.admin.jpa.repository.OperatorCredentialRepository;
import com.github.hemoptysisheart.bui.admin.jpa.repository.OperatorRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Service
class OperatorDaoImpl implements OperatorDao {
  private static final Logger log = getLogger(OperatorDaoImpl.class);

  @Autowired
  private OperatorRepository operatorRepository;
  @Autowired
  private OperatorCredentialRepository operatorCredentialRepository;

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.admin.dao.OperatorDao
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public Operator create(Operator operator) {
    if (log.isTraceEnabled()) {
      log.trace("#create args : operator={}", operator);
    }

    if (this.operatorRepository.existsByName(operator.getName())) {
      throw new IllegalArgumentException(format("operator name already exists : name='%s'", operator.getName()));
    }
    if (this.operatorRepository.existsByEmail(operator.getEmail())) {
      throw new IllegalArgumentException(format("operator email already exists : email=%s", operator.getEmail()));
    }

    operator = this.operatorRepository.save((OperatorEntity) operator);

    if (log.isTraceEnabled()) {
      log.trace("#create return : {}", operator);
    }
    return operator;
  }

  @Override
  public List<OperatorCredential> create(OperatorCredential... credentials) {
    if (log.isTraceEnabled()) {
      log.trace("#create args : credentials={}", credentials);
    }

    List<OperatorCredential> list = new ArrayList<>();
    for (OperatorCredential credential : credentials) {
      credential = this.operatorCredentialRepository.save((OperatorCredentialEntity) credential);
      list.add(credential);
    }

    if (log.isTraceEnabled()) {
      log.trace("#create return : {}", list);
    }
    return list;
  }
}