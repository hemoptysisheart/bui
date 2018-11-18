package com.github.hemoptysisheart.bui.domain;

/**
 * Web UI에서 화면(HTML)의 일정 영역을 담당하는 단위. 하나의 {@link org.springframework.ui.Model 모델 어트리뷰트}에 해당한다.
 *
 * @param <M> 모델 어트리뷰트 타입.
 *
 * @author H2
 * @see org.springframework.ui.Model
 * @since 2018/11/18
 */
public interface Panel<M> {
  /**
   * @return 패널 이름.
   */
  String getName();

  /**
   * @return 패널이 출력하는 모델.
   */
  M getModel();
}