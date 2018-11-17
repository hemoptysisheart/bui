package com.github.hemoptysisheart.bui.util;

import java.time.Instant;
import java.time.ZoneId;

/**
 * @author H2
 * @since 2018/11/17
 */
public class JpaTimeProvider implements TimeProvider {
  @Override
  public ZoneId zoneId() {
    return ZoneId.systemDefault();
  }

  @Override
  public Instant now() {
    return Instant.ofEpochMilli(System.currentTimeMillis());
  }
}