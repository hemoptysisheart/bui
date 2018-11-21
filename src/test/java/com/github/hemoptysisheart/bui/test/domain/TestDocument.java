package com.github.hemoptysisheart.bui.test.domain;

import com.github.hemoptysisheart.bui.domain.ValidDocument;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * @author H2
 * @since 2018/11/19
 */
public class TestDocument implements ValidDocument {
  private long id;
  private String layout;

  public TestDocument(String layout) {
    this(1L, layout);
  }

  public TestDocument(long id, String layout) {
    setId(id);
    setLayout(layout);
  }

  public void setId(long id) {
    if (0L >= id) {
      throw new IllegalArgumentException("not positive id : " + id);
    }
    this.id = id;
  }

  public void setLayout(String layout) {
    requireNonNull(layout, "layout is null.");
    if (layout.isEmpty()) {
      throw new IllegalArgumentException("layout is empty.");
    }
    this.layout = layout;
  }


  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.domain.ValidDocument
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public long getId() {
    return this.id;
  }

  @Override
  public String getLayout() {
    return this.layout;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TestDocument)) return false;
    TestDocument that = (TestDocument) o;
    return this.id == that.id;
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }

  @Override
  public String toString() {
    return new StringBuilder(TestDocument.class.getSimpleName())
        .append("{id=").append(this.id)
        .append(", layout='").append(this.layout).append('\'')
        .append('}').toString();
  }
}