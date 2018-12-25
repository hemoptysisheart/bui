package com.github.hemoptysisheart.bui.domain;

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
}