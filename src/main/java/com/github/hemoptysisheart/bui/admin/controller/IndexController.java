package com.github.hemoptysisheart.bui.admin.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author H2
 * @since 2018/11/17
 */
@RequestMapping("/admin")
public interface IndexController {
  @GetMapping
  String index(Model model);
}