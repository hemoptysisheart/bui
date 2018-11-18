package com.github.hemoptysisheart.bui.controller;

import com.github.hemoptysisheart.bui.web.BuiRequest;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * 프론트 컨트롤러.
 *
 * @author H2
 * @since 2018/11/18
 */
@Controller
class FrontControllerImpl implements FrontController {
  private static final Logger log = getLogger(FrontControllerImpl.class);

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.controller.FrontController
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String read(BuiRequest request, Model model) {
    if (log.isTraceEnabled()) {
      log.trace("args : request={}, model={}", request, model);
    }

    String template = null;

    if (log.isTraceEnabled()) {
      log.trace("result : template='{}', model={}", template, model);
    }
    return template;
  }
}