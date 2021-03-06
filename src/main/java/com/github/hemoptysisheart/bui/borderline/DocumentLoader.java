package com.github.hemoptysisheart.bui.borderline;

import com.github.hemoptysisheart.bui.domain.Document;
import com.github.hemoptysisheart.bui.web.BuiRequest;
import org.springframework.lang.Nullable;

/**
 * {@link Document}를 찾아 반환한다.
 *
 * @author H2
 * @since 2018/11/18
 */
public interface DocumentLoader {
  default void validateOrder(int order) {
    if (0 > order) {
      throw new IllegalArgumentException("negative order : " + order);
    }
  }

  /**
   * 로더의 적용 순서. 작은 로더를 먼저 시험한다.
   *
   * @return 로더의 적용 순서. {@code 0 <= order}.
   */
  int order();

  /**
   * 리퀘스트를 기반으로 도큐먼트를 찾는다.
   *
   * @param request 리퀘스트.
   *
   * @return 도큐먼트. 없으면 {@code null}.
   */
  @Nullable
  Document load(BuiRequest request);
}