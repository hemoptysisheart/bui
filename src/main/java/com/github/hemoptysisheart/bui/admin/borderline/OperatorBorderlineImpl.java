package com.github.hemoptysisheart.bui.admin.borderline;

import com.github.hemoptysisheart.bui.admin.service.OperatorService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Service
@Transactional
class OperatorBorderlineImpl implements OperatorBorderline {
  private static final Logger log = getLogger(OperatorBorderlineImpl.class);

  @Autowired
  private OperatorService operatorService;
}