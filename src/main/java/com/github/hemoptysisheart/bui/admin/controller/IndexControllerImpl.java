package com.github.hemoptysisheart.bui.admin.controller;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Controller
class IndexControllerImpl implements IndexController {
  private static final Logger log = getLogger(IndexControllerImpl.class);

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.admin.controller.IndexController
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String index(final Model model) {
    if (log.isTraceEnabled()) {
      log.trace("#index args : model={}", model);
    }

    String template = "admin/index/index";

    if (log.isTraceEnabled()) {
      log.trace("#index result : template='{}', model={}", template, model);
    }
    return template;
  }
}