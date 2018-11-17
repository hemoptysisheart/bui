package com.github.hemoptysisheart.bui.support.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;

/**
 * @author H2
 * @since 2018/11/17
 */
@Converter(autoApply = true)
public class InstantConverter implements AttributeConverter<Instant, Long> {
  @Override
  public Long convertToDatabaseColumn(Instant instant) {
    return null == instant
        ? null
        : instant.toEpochMilli();
  }

  @Override
  public Instant convertToEntityAttribute(Long epochMillis) {
    return null == epochMillis
        ? null
        : Instant.ofEpochMilli(epochMillis);
  }
}