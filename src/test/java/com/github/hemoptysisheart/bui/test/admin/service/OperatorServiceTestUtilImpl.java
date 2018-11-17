package com.github.hemoptysisheart.bui.test.admin.service;

import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.service.params.CreateOperatorParams;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Service
class OperatorServiceTestUtilImpl implements OperatorServiceTestUtil {
  private static final Logger log = getLogger(OperatorServiceTestUtilImpl.class);

  private ThreadLocalRandom random;

  @PostConstruct
  private void postConstruct() {
    this.random = ThreadLocalRandom.current();
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.test.admin.service.OperatorServiceTestUtil
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public CreateOperatorParams createParams() {
    String name = random(this.random.nextInt(1, 1 + Operator.NAME_MAX_LENGTH));
    String email = format("%s@%s",
        randomAlphabetic(1, Operator.EMAIL_MAX_LENGTH / 2), randomAlphabetic(1, Operator.EMAIL_MAX_LENGTH / 2));
    String password = random(this.random.nextInt(8, 512));
    CreateOperatorParams params = new CreateOperatorParams(name, email, password);

    if (log.isTraceEnabled()) {
      log.trace("#createParams return : {}", params);
    }
    return params;
  }
}