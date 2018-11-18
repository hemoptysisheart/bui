package com.github.hemoptysisheart.bui.web;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;

/**
 * @author H2
 * @since 2018/11/18
 */
public interface BuiRequest {
  /**
   * @return HTTP method에 해당.
   */
  Verb getVerb();

  /**
   * @return 리퀘스트 URL.
   */
  URL getUrl();

  /**
   * @return 리퀘스트 URI.
   */
  URI getUri();

  /**
   * @return 리퀘스트 패스.
   */
  Path getPath();
}