package com.github.hemoptysisheart.bui.web;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * {@link org.springframework.web.method.support.HandlerMethodArgumentResolver}의 {@link NativeWebRequest}의 래핑 구현.
 *
 * @author H2
 * @since 2018/11/18
 */
public class WrapBuiRequest implements BuiRequest {
  private final ServletWebRequest request;

  private Verb verb;
  private URL url;
  private URI uri;
  private Path path;

  public WrapBuiRequest(ServletWebRequest request) {
    requireNonNull(request);

    this.request = request;
    this.verb = Verb.from(request.getHttpMethod());
    try {
      this.url = new URL(request.getRequest().getRequestURL().toString());
    } catch (MalformedURLException e) {
      throw new IllegalArgumentException(e);
    }
    try {
      this.uri = this.url.toURI();
    } catch (URISyntaxException e) {
      throw new IllegalArgumentException(e);
    }

    this.path = Paths.get(this.uri.getPath());
  }

  @Override
  public Verb getVerb() {
    return this.verb;
  }

  @Override
  public URL getUrl() {
    return this.url;
  }

  @Override
  public URI getUri() {
    return this.uri;
  }

  @Override
  public Path getPath() {
    return this.path;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof WrapBuiRequest)) return false;
    WrapBuiRequest that = (WrapBuiRequest) o;
    return Objects.equals(this.request, that.request);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.request);
  }

  @Override
  public String toString() {
    return this.request.toString();
  }
}