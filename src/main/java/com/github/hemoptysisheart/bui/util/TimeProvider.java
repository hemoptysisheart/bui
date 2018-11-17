package com.github.hemoptysisheart.bui.util;

import java.time.*;

/**
 * @author H2
 * @since 2018/11/17
 */
public interface TimeProvider {
  ZoneId zoneId();

  default ZoneOffset zoneOffset() {
    return zoneId().getRules().getOffset(now());
  }

  Instant now();

  default ZonedDateTime zonedDateTime() {
    return now().atZone(zoneId());
  }

  default OffsetDateTime offsetDateTime() {
    return OffsetDateTime.ofInstant(now(), zoneId());
  }

  default OffsetTime offsetTime() {
    return OffsetTime.ofInstant(now(), zoneId());
  }

  default LocalDateTime localDateTime() {
    return LocalDateTime.ofInstant(now(), zoneId());
  }

  default LocalDate localDate() {
    return LocalDate.ofInstant(now(), zoneId());
  }

  default LocalTime localTime() {
    return LocalTime.ofInstant(now(), zoneId());
  }
}