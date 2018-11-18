package com.github.hemoptysisheart.bui.controller;

import com.github.hemoptysisheart.bui.borderline.DocumentLoader;
import com.github.hemoptysisheart.bui.domain.Document;
import com.github.hemoptysisheart.bui.domain.FallbackDocument;
import com.github.hemoptysisheart.bui.web.BuiRequest;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * 프론트 컨트롤러.
 *
 * @author H2
 * @since 2018/11/18
 */
@Controller
class FrontControllerImpl implements FrontController {
  private static final Logger log = getLogger(FrontControllerImpl.class);

  @Autowired
  private FallbackDocument fallbackDocument;

  private List<DocumentLoader> loaders;

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  @Autowired(required = false)  // TODO required 삭제.
  private void setLoaders(List<DocumentLoader> loaders) {
    if (log.isTraceEnabled()) {
      log.trace("args : loaders={}", loaders);
    }

    List<DocumentLoader> temp = new ArrayList<>(loaders);
    temp.sort(comparingInt(DocumentLoader::order));
    this.loaders = temp;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * 리퀘스트에 해당하는 큐먼트를 찾아 반환한다.
   *
   * @param request 리퀘스트.
   *
   * @return 도큐먼트. non null.
   */
  private Document loadDocument(BuiRequest request) {
    Document document;
    if (null != this.loaders) {
      for (DocumentLoader loader : this.loaders) {
        document = loader.load(request);
        if (null != document) {
          return document;
        }
      }
    }

    return this.fallbackDocument;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.controller.FrontController
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public String read(BuiRequest request, Model model) {
    if (log.isTraceEnabled()) {
      log.trace("args : request={}, model={}", request, model);
    }

    Document document = loadDocument(request);
    String template = document.getLayout();

    if (log.isTraceEnabled()) {
      log.trace("result : template='{}', model={}", template, model);
    }
    return template;
  }
}