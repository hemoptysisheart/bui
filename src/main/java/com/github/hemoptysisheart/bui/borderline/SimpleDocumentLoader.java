package com.github.hemoptysisheart.bui.borderline;

import com.github.hemoptysisheart.bui.domain.Document;
import com.github.hemoptysisheart.bui.web.BuiRequest;
import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * {@link com.github.hemoptysisheart.bui.web.Verb}와 {@code path}에 해당하는 도큐먼트를 찾는 로더.
 *
 * @author H2
 * @since 2018/11/18
 */
public class SimpleDocumentLoader implements DocumentLoader {
  private static final Logger log = getLogger(SimpleDocumentLoader.class);

  public static final String NAME = "com.github.hemoptysisheart.bui.borderline.SimpleDocumentLoader";

  private final int order;

  public SimpleDocumentLoader() {
    this(0);
  }

  public SimpleDocumentLoader(int order) {
    validateOrder(order);

    this.order = order;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.borderline.DocumentLoader
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public int order() {
    return this.order;
  }

  @Override
  public Document load(BuiRequest request) {
    if (log.isTraceEnabled()) {
      log.trace("args : request={}", request);
    }

    Document document = null;

    if (log.isTraceEnabled()) {
      log.trace("return : {}", document);
    }
    return document;
  }
}