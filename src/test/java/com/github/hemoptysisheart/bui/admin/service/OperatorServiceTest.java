package com.github.hemoptysisheart.bui.admin.service;

import com.github.hemoptysisheart.bui.TestConfiguration;
import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.service.params.CreateOperatorParams;
import com.github.hemoptysisheart.bui.test.admin.service.OperatorServiceTestUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
@Transactional
public class OperatorServiceTest {
  private static final Logger log = getLogger(OperatorServiceTest.class);

  @Autowired
  private OperatorService operatorService;
  @Autowired
  private OperatorServiceTestUtil operatorServiceTestUtil;

  @Before
  public void setUp() throws Exception {
    assertThat(this.operatorService).isNotNull();
  }

  @Test
  public void testCreate() throws Exception {
    // Given
    CreateOperatorParams params = this.operatorServiceTestUtil.createParams();
    log.info("GIVEN - params={}", params);

    // When
    Operator operator = this.operatorService.create(params);
    log.info("WHEN - operator={}", operator);

    // Then
    assertThat(operator)
        .isNotNull()
        .extracting(Operator::getName, Operator::getEmail)
        .containsSequence(params.getName(), params.getEmail());
    assertThat(operator.getId())
        .isGreaterThan(0);
    assertThat(operator.getCreatedAt())
        .isNotNull()
        .isEqualTo(operator.getUpdatedAt());
  }
}