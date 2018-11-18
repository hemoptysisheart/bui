package com.github.hemoptysisheart.bui.web;

import org.springframework.http.HttpMethod;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author H2
 * @since 2018/11/18
 */
public enum Verb {
  /**
   * @see org.springframework.http.HttpMethod#POST
   */
  CREATE,
  /**
   * @see org.springframework.http.HttpMethod#GET
   */
  READ,
  /**
   * @see org.springframework.http.HttpMethod#PATCH
   */
  UPDATE,
  /**
   * @see org.springframework.http.HttpMethod#DELETE
   */
  DELETE;

  /**
   * HTTP 리퀘스트 메서드를 {@link Verb}로 변환.
   *
   * @param method {@link HttpMethod HTTP request method}.
   *
   * @return 해당하는 {@link Verb}.
   */
  public static Verb from(HttpMethod method) {
    requireNonNull(method, "method is null.");

    switch (method) {
      case POST:
        return CREATE;
      case GET:
        return READ;
      case PATCH:
        return UPDATE;
      case DELETE:
        return DELETE;
      default:
        throw new IllegalArgumentException(format("unsupported method : %s", method));
    }
  }
}