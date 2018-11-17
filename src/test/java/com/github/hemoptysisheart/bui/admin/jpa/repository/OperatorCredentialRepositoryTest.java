package com.github.hemoptysisheart.bui.admin.jpa.repository;

import com.github.hemoptysisheart.bui.TestConfiguration;
import com.github.hemoptysisheart.bui.admin.jpa.entity.OperatorCredentialEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestConfiguration.class)
@Transactional
public class OperatorCredentialRepositoryTest {
  private static final Logger log = getLogger(OperatorCredentialRepositoryTest.class);

  @Autowired
  private OperatorCredentialRepository operatorCredentialRepository;

  @Before
  public void setUp() throws Exception {
    assertThat(this.operatorCredentialRepository).isNotNull();
  }

  @Test
  public void testFindAll() throws Exception {
    List<OperatorCredentialEntity> list = this.operatorCredentialRepository.findAll();
    log.info("WHEN - list={}", list);

    assertThat(list)
        .isEmpty();
  }
}