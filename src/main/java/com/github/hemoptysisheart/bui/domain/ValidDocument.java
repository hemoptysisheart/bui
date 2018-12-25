package com.github.hemoptysisheart.bui.domain;

/**
 * 데이터 기반으로 서비스하는 도큐먼트.
 *
 * @author H2
 * @since 2018/11/19
 */
public interface ValidDocument extends Document {
  /**
   * @return 문서 ID.
   */
  long getId();
}