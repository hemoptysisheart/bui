package com.github.hemoptysisheart.bui.domain;

import java.util.Map;

/**
 * HTTP 리퀘스트에 해당하는 도큐먼트.
 *
 * @author H2
 * @since 2018/11/18
 */
public interface Document {
  /**
   * @return 도큐먼트의 렌더링할 레이아웃 템플릿 이름.
   */
  String getLayout();

  /**
   * @return 도큐먼트가 가지는 패널 정보.
   */
  Map<String, Panel> getPanelMap();
}