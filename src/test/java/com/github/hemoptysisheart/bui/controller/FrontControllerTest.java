package com.github.hemoptysisheart.bui.controller;

import com.github.hemoptysisheart.bui.BuiTestConfiguration;
import com.github.hemoptysisheart.bui.borderline.SimpleDocumentLoader;
import com.github.hemoptysisheart.bui.domain.FallbackDocument;
import com.github.hemoptysisheart.bui.domain.ValidDocument;
import com.github.hemoptysisheart.bui.test.configuration.BuiTestProperties;
import com.github.hemoptysisheart.bui.test.domain.TestDocument;
import com.github.hemoptysisheart.bui.test.web.TestBuiRequest;
import com.github.hemoptysisheart.bui.web.BuiRequest;
import com.github.hemoptysisheart.bui.web.Verb;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/18
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = BuiTestConfiguration.class)
public class FrontControllerTest {
  private static final Logger log = getLogger(FrontControllerTest.class);

  @Autowired
  private FrontController frontController;

  @Autowired
  private BuiTestProperties properties;
  @MockBean
  private SimpleDocumentLoader simpleDocumentLoader;
  @MockBean
  private FallbackDocument fallbackDocument;

  @Before
  public void setUp() throws Exception {
    assertThat(this.simpleDocumentLoader).isNotNull();

    log.info("SETUP - properties={}", this.properties);
    log.info("SETUP - simpleDocumentLoader({})={}", this.simpleDocumentLoader.getClass(), this.simpleDocumentLoader);
    log.info("SETUP - fallbackDocument({})={}", this.fallbackDocument.getClass(), this.fallbackDocument);
  }

  @Test
  public void test_random_document_has_layout() throws Exception {
    // Given
    BuiRequest request = TestBuiRequest.random(Verb.READ);
    Model model = new ExtendedModelMap();
    log.info("GIVEN - request={}", request);

    final String layout = randomAlphabetic(10, 20);
    ValidDocument document = new TestDocument(layout);
    log.info("GIVEN - document={}", document);
    given(this.simpleDocumentLoader.load(any()))
        .willReturn(document);

    // When
    String template = this.frontController.read(request, model);
    log.info("WHEN - template={}", template);

    // Then
    assertThat(template)
        .isNotEmpty()
        .isEqualTo(layout);
    assertThat(model.asMap())
        .isEmpty();
  }

  @Test
  public void test_runtime_layout_replace() throws Exception {
    // Given
    BuiRequest request = TestBuiRequest.random(Verb.READ);
    Model model = new ExtendedModelMap();
    log.info("GIVEN - request={}, model={}", request, model);

    String layout1 = randomAlphabetic(10, 20);
    String layout2 = randomAlphabetic(20, 30);
    log.info("GIVEN - layout1={}, layout2={}", layout1, layout2);

    ValidDocument document = mock(ValidDocument.class);
    when(document.getLayout()).thenReturn(layout1, layout2);
    when(this.simpleDocumentLoader.load(request)).thenReturn(document);

    // When
    String template1 = this.frontController.read(request, model);
    String template2 = this.frontController.read(request, model);
    log.info("WHEN - template1={}, template2={}", template1, template2);

    // Then
    assertThat(template1)
        .isEqualTo(layout1);
    assertThat(template2)
        .isEqualTo(layout2);
  }
}