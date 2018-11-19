package com.github.hemoptysisheart.bui.test.configuration;

/**
 * @author H2
 * @since 2018/11/19
 */
public class FallbackDocumentProperties {
  private String title;

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String toString() {
    return new StringBuilder('{')
        .append("title='").append(this.title).append('\'')
        .append('}').toString();
  }
}