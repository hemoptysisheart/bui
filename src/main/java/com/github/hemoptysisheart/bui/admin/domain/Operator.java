package com.github.hemoptysisheart.bui.admin.domain;

import java.time.Instant;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author H2
 * @since 2018/11/17
 */
public interface Operator {
  int NAME_MAX_LENGTH = 255;
  int EMAIL_MAX_LENGTH = 255;

  static void validateName(String name) {
    requireNonNull(name, "name is null.");

    if (name.isEmpty()) {
      throw new IllegalArgumentException("name is empty.");
    }
    if (NAME_MAX_LENGTH < name.length()) {
      throw new IllegalArgumentException(format("name is too long : length=%d, max=%d, name='%s'",
          name.length(), NAME_MAX_LENGTH, name));
    }
  }

  static void validateEmail(String email) {
    requireNonNull(email, "email is null.");

    if (email.isEmpty()) {
      throw new IllegalArgumentException("email is empty.");
    }
    if (EMAIL_MAX_LENGTH < email.length()) {
      throw new IllegalArgumentException(format("email is too long : length=%d, max=%d, email=%s",
          email.length(), EMAIL_MAX_LENGTH, email));
    }
  }

  int getId();

  String getName();

  String getEmail();

  Instant getCreatedAt();

  Instant getUpdatedAt();
}