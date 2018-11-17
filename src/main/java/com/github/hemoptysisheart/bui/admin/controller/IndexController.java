package com.github.hemoptysisheart.bui.admin.controller;

import com.github.hemoptysisheart.bui.admin.controller.request.SignupReq;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author H2
 * @since 2018/11/17
 */
@RequestMapping("/admin")
public interface IndexController {
  @GetMapping
  String index(Model model);

  @GetMapping("/signup")
  String signupForm(Model model);

  @PostMapping("/signup")
  String signup(SignupReq req, BindingResult binding, Model model);
}