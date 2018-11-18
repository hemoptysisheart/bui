package com.github.hemoptysisheart.bui.admin.controller;

import com.github.hemoptysisheart.bui.admin.borderline.OperatorBorderline;
import com.github.hemoptysisheart.bui.admin.controller.request.SignupReq;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.validation.Valid;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/17
 */
@Controller
class IndexControllerImpl implements IndexController {
  private static final Logger log = getLogger(IndexControllerImpl.class);

  @Autowired
  private OperatorBorderline operatorBorderline;

  private String doSignupForm(Model model) {
    if (!model.containsAttribute("signupReq")) {
      model.addAttribute("signupReq", new SignupReq());
    }
    String template = "admin/index/signup";
    return template;
  }

  private String doSignUp(SignupReq req, BindingResult binding, Model model) {
    if (binding.hasErrors()) {
      return doSignupForm(model);
    }

    if (!req.getPassword().equals(req.getConfirm())) {
      binding.addError(
          new FieldError("signupReq", "confirm", null, false,
              new String[]{"err.page.signup.password-not-match"}, null, "password does not match."));
      return doSignupForm(model);
    }

    String template;
    template = "redirect:/admin";
    return template;
  }

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

  @Override
  public String signupForm(Model model) {
    if (log.isTraceEnabled()) {
      log.trace("#signupForm args : model={}", model);
    }

    String template = doSignupForm(model);

    if (log.isTraceEnabled()) {
      log.trace("#signupForm result : template='{}', model={}", template, model);
    }
    return template;
  }

  @Override
  public String signup(@Valid SignupReq req, BindingResult binding, Model model) {
    if (log.isTraceEnabled()) {
      log.trace("#signup args : req={}, binding={}, model={}", req, binding, model);
    }

    String template = doSignUp(req, binding, model);

    if (log.isTraceEnabled()) {
      log.trace("#signup result : template='{}', model={}", template, model);
    }
    return template;
  }
}