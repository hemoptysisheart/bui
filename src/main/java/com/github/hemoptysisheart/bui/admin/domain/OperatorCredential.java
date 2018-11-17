package com.github.hemoptysisheart.bui.admin.domain;

import java.time.Instant;

/**
 * @author H2
 * @since 2018/11/17
 */
public interface OperatorCredential {
  int PUBLIC_KEY_MAX_LENGTH = 255;
  int PRIVATE_KEY_MAX_LENGTH = 255;
  String PRIVATE_KEY_PATTERN = "\\A\\$2a?\\$\\d\\d\\$[./0-9A-Za-z]{53}";

  int getId();

  Operator getOperator();

  String getPublicKey();

  String getPrivateKey();

  Instant getCreatedAt();

  Instant getUpdatedAt();
}