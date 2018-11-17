package com.github.hemoptysisheart.bui.test.admin.service;

import com.github.hemoptysisheart.bui.admin.service.params.CreateOperatorParams;

/**
 * @author H2
 * @since 2018/11/17
 */
public interface OperatorServiceTestUtil {
  /**
   * @return 임의의 관리자 계정 생성 파라미터.
   */
  CreateOperatorParams createParams();
}