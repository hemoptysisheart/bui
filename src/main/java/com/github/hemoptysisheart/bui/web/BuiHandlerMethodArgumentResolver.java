package com.github.hemoptysisheart.bui.web;

import org.slf4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import static java.lang.String.format;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * @author H2
 * @since 2018/11/18
 */
public class BuiHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
  private static final Logger log = getLogger(BuiHandlerMethodArgumentResolver.class);

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // org.springframework.web.method.support.HandlerMethodArgumentResolver
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    if (log.isTraceEnabled()) {
      log.trace("args : parameter={}", parameter);
    }

    boolean supports = BuiRequest.class.getName().equals(parameter.getParameterType());
    supports = supports || BuiRequest.class.isAssignableFrom(parameter.getParameterType());

    if (log.isTraceEnabled()) {
      log.trace("return : {}", supports);
    }
    return supports;
  }

  @Override
  public BuiRequest resolveArgument(MethodParameter param, ModelAndViewContainer mav, NativeWebRequest request,
      WebDataBinderFactory binder) throws Exception {
    if (log.isTraceEnabled()) {
      log.trace("args : param={}, mav={}, request={}, binder={}", param, mav, request, binder);
    }

    if (!(ServletWebRequest.class.isAssignableFrom(request.getClass()))) {
      throw new IllegalArgumentException(format("unsupported request type : %s", request.getClass()));
    }
    BuiRequest wrapper = new WrapBuiRequest((ServletWebRequest) request);

    if (log.isTraceEnabled()) {
      log.trace("return : {}", wrapper);
    }
    return wrapper;
  }
}