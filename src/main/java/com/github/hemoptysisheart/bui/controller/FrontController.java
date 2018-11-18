package com.github.hemoptysisheart.bui.controller;

import com.github.hemoptysisheart.bui.web.BuiRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author H2
 * @since 2018/11/18
 */
@RequestMapping("/**")
public interface FrontController {
  /**
   * GET 리퀘스트의 프론트 컨트롤러.
   *
   * @param request
   * @param model
   *
   * @return 뷰 템플릿 이름.
   */
  @GetMapping
  String read(BuiRequest request, Model model);
}