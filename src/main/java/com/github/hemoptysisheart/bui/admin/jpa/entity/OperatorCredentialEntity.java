package com.github.hemoptysisheart.bui.admin.jpa.entity;

import com.github.hemoptysisheart.bui.admin.domain.Operator;
import com.github.hemoptysisheart.bui.admin.domain.OperatorCredential;

import javax.persistence.*;
import java.time.Instant;

import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

/**
 * @author H2
 * @since 2018/11/17
 */
@Entity
@Table(name = "op_operator_credential",
    uniqueConstraints = {@UniqueConstraint(name = "UQ_OPERATOR_CREDENTIAL_PUBLIC_KEY", columnNames = {"public_key"})})
public class OperatorCredentialEntity implements OperatorCredential {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int id;
  @ManyToOne(targetEntity = OperatorEntity.class)
  @JoinColumn(name = "operator",
      nullable = false,
      updatable = false,
      foreignKey = @ForeignKey(name = "FK_OPERATOR_CREDENTIAL_PK_OPERATOR"),
      referencedColumnName = "id")
  private Operator operator;
  @Column(name = "public_key", length = PUBLIC_KEY_MAX_LENGTH, nullable = false, unique = true, updatable = false)
  private String publicKey;
  @Column(name = "private_key", length = PRIVATE_KEY_MAX_LENGTH, nullable = false)
  private String privateKey;
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;
  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  private OperatorCredentialEntity() {// JPA only
  }

  public OperatorCredentialEntity(Operator operator, String publicKey, String privateKey, Instant createdAt) {
    requireNonNull(operator);
    requireNonNull(publicKey);
    requireNonNull(privateKey);
    requireNonNull(createdAt);

    if (!operator.getName().equals(publicKey) && operator.getEmail().equals(publicKey)) {
      throw new IllegalArgumentException(
          format("publicKey does not match to name or email : publicKey='%s', operator=%s", publicKey, operator));
    }

    if (!privateKey.matches(PRIVATE_KEY_PATTERN)) {
      throw new IllegalArgumentException("illegal privateKey pattern.");
    }

    this.operator = operator;
    this.publicKey = publicKey;
    this.privateKey = privateKey;
    this.createdAt = createdAt;
    this.updatedAt = createdAt;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.admin.domain.OperatorCredential
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public Operator getOperator() {
    return this.operator;
  }

  @Override
  public String getPublicKey() {
    return this.publicKey;
  }

  @Override
  public String getPrivateKey() {
    return this.privateKey;
  }

  @Override
  public Instant getCreatedAt() {
    return this.createdAt;
  }

  @Override
  public Instant getUpdatedAt() {
    return this.updatedAt;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // java.lang.Object
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public int hashCode() {
    return this.id;
  }

  @Override
  public boolean equals(Object obj) {
    if (null == obj) return false;
    if (this == obj) return true;

    return (0 < this.id && obj instanceof OperatorCredentialEntity)
        && this.id == ((OperatorCredentialEntity) obj).id;
  }

  @Override
  public String toString() {
    return new StringBuilder(OperatorCredentialEntity.class.getSimpleName())
        .append("{id=").append(this.id)
        .append(", operator=").append(this.operator.getId())
        .append(", publicKey='").append(this.publicKey).append('\'')
        .append(", privateKey='").append(this.privateKey).append('\'')
        .append(", createdAt=").append(this.createdAt)
        .append(", updatedAt=").append(this.updatedAt)
        .append('}').toString();
  }
}