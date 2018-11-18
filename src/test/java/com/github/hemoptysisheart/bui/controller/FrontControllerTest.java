package com.github.hemoptysisheart.bui.controller;

import com.github.hemoptysisheart.bui.BuiTestConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author H2
 * @since 2018/11/18
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FrontControllerImpl.class)
@ContextConfiguration(classes = BuiTestConfiguration.class)
public class FrontControllerTest {
  @Autowired
  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    assertThat(this.mvc).isNotNull();
  }

  @Test
  public void test_get_index() throws Exception {
    this.mvc.perform(get("/"))
        .andExpect(status().isOk())
        .andDo(print());
  }
}