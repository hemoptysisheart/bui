package com.github.hemoptysisheart.bui.test.configuration;

/**
 * @author H2
 * @since 2018/11/19
 */
public class BuiTestProperties {
  private FallbackDocumentProperties fallbackDocument;

  public FallbackDocumentProperties getFallbackDocument() {
    return this.fallbackDocument;
  }

  public void setFallbackDocument(
      FallbackDocumentProperties fallbackDocument) {
    this.fallbackDocument = fallbackDocument;
  }

  @Override
  public String toString() {
    return new StringBuilder('{')
        .append("fallbackDocument=").append(this.fallbackDocument)
        .append('}').toString();
  }
}