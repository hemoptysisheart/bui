package com.github.hemoptysisheart.bui.domain;

import static java.util.Objects.requireNonNull;

/**
 * 고정된 내용의 도큐먼트.
 *
 * @author H2
 * @since 2018/11/18
 */
public class SimpleFallbackDocument implements FallbackDocument {
  private String layout;

  public SimpleFallbackDocument(String layout) {
    requireNonNull(layout, "layout is null.");
    if (layout.isEmpty()) {
      throw new IllegalArgumentException("layout is empty.");
    }

    this.layout = layout;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.domain.FallbackDocument
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String getLayout() {
    return this.layout;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder(SimpleFallbackDocument.class.getSimpleName())
        .append("{layout='").append(this.layout).append('\'')
        .append('}').toString();
  }
}