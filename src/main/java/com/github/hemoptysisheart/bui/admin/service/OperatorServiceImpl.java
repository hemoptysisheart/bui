package com.github.hemoptysisheart.bui.admin.service;

import com.github.hemoptysisheart.bui.admin.dao.OperatorDao;
import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.domain.OperatorCredential;
import com.github.hemoptysisheart.bui.admin.jpa.entity.OperatorCredentialEntity;
import com.github.hemoptysisheart.bui.admin.jpa.entity.OperatorEntity;
import com.github.hemoptysisheart.bui.admin.service.params.CreateOperatorParams;
import com.github.hemoptysisheart.bui.util.TimeProvider;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Service
class OperatorServiceImpl implements OperatorService {
  private static final Logger log = getLogger(OperatorServiceImpl.class);

  @Autowired
  private OperatorDao operatorDao;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private TimeProvider timeProvider;

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.admin.service.OperatorService
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public Operator create(CreateOperatorParams params) {
    if (log.isTraceEnabled()) {
      log.trace("#create args : params={}", params);
    }

    final Instant now = this.timeProvider.now();

    Operator operator = new OperatorEntity(params.getName(), params.getEmail(), now);
    operator = this.operatorDao.create(operator);

    List<OperatorCredential> credentials = this.operatorDao.create(
        new OperatorCredentialEntity(operator, params.getName(),
            this.passwordEncoder.encode(params.getPassword()), now),
        new OperatorCredentialEntity(operator, params.getEmail(),
            this.passwordEncoder.encode(params.getPassword()), now));

    if (log.isTraceEnabled()) {
      log.trace("#create return : {}", operator);
    }
    return operator;
  }
}