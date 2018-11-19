package com.github.hemoptysisheart.bui.controller;

import com.github.hemoptysisheart.bui.BuiTestConfiguration;
import com.github.hemoptysisheart.bui.borderline.SimpleDocumentLoader;
import com.github.hemoptysisheart.bui.domain.FallbackDocument;
import com.github.hemoptysisheart.bui.test.configuration.BuiTestProperties;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author H2
 * @since 2018/11/18
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FrontControllerImpl.class)
@ContextConfiguration(classes = BuiTestConfiguration.class)
public class FrontControllerTest {
  private static final Logger log = getLogger(FrontControllerTest.class);

  @Autowired
  private MockMvc mvc;

  @Autowired
  private BuiTestProperties properties;
  @MockBean
  private SimpleDocumentLoader simpleDocumentLoader;
  @MockBean
  private FallbackDocument fallbackDocument;

  @Before
  public void setUp() throws Exception {
    assertThat(this.mvc).isNotNull();
    assertThat(this.simpleDocumentLoader).isNotNull();

    log.info("SETUP - properties={}", this.properties);
    log.info("SETUP - simpleDocumentLoader({})={}", this.simpleDocumentLoader.getClass(), this.simpleDocumentLoader);
    log.info("SETUP - fallbackDocument({})={}", this.fallbackDocument.getClass(), this.fallbackDocument);
  }

  @Test
  public void test_for_fallback() throws Exception {
    // Given
    final String layout = "fallback/default";
    given(this.simpleDocumentLoader.load(any()))
        .willReturn(null);
    given(this.fallbackDocument.getLayout())
        .willReturn(layout);
    given(this.fallbackDocument.getPanelMap())
        .willReturn(Map.of());

    this.mvc
        // When
        .perform(get("/"))

        // Then
        .andExpect(status().isOk())
        .andExpect(view().name(layout))
        .andExpect(model().size(0))
        .andExpect(xpath("/html/head/title")
            .string(this.properties.getFallbackDocument().getTitle()))
        .andExpect(xpath(".//*[@id='fallback-main']")
            .exists())
        .andDo(print());
  }
}