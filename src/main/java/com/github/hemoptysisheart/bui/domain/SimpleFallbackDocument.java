package com.github.hemoptysisheart.bui.domain;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.unmodifiableMap;
import static java.util.Objects.requireNonNull;

/**
 * 고정된 내용의 도큐먼트.
 *
 * @author H2
 * @since 2018/11/18
 */
public class SimpleFallbackDocument implements FallbackDocument {
  private String layout;
  private Map<String, Panel> panelMap;

  public SimpleFallbackDocument(String layout) {
    this(layout, Map.of());
  }

  public SimpleFallbackDocument(String layout, Map<String, Panel> panelMap) {
    requireNonNull(layout, "layout is null.");
    requireNonNull(panelMap, "panelMap is null.");
    if (layout.isEmpty()) {
      throw new IllegalArgumentException("layout is empty.");
    }

    this.layout = layout;
    this.panelMap = unmodifiableMap(new HashMap<>(panelMap));
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.domain.FallbackDocument
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String getLayout() {
    return this.layout;
  }

  @Override
  public Map<String, Panel> getPanelMap() {
    return this.panelMap;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder(SimpleFallbackDocument.class.getSimpleName())
        .append("{layout='").append(this.layout).append('\'')
        .append(", panelMap=").append(this.panelMap)
        .append('}').toString();
  }
}