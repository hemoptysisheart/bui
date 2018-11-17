package com.github.hemoptysisheart.bui.admin.jpa.entity;

import com.github.hemoptysisheart.bui.admin.domain.Operator;

import javax.persistence.*;
import java.time.Instant;

import static java.util.Objects.hash;
import static java.util.Objects.requireNonNull;

/**
 * @author H2
 * @since 2018/11/17
 */
@Entity
@Table(name = "op_operator",
    uniqueConstraints = {@UniqueConstraint(name = "UQ_OPERATOR_NAME", columnNames = {"name"}),
        @UniqueConstraint(name = "UQ_OPERATOR_EMAIL", columnNames = {"email"})})
public class OperatorEntity implements Operator {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false, insertable = false, updatable = false)
  private int id;
  @Column(name = "name", nullable = false, unique = true, length = NAME_MAX_LENGTH, updatable = false)
  private String name;
  @Column(name = "email", nullable = false, unique = true, length = 255, updatable = false)
  private String email;
  @Column(name = "created_at", nullable = false, updatable = false)
  private Instant createdAt;
  @Column(name = "updated_at", nullable = false)
  private Instant updatedAt;

  private OperatorEntity() {// JPA only
  }

  public OperatorEntity(String name, String email, Instant createdAt) {
    Operator.validateName(name);
    Operator.validateEmail(email);
    requireNonNull(createdAt);

    this.name = name;
    this.email = email;
    this.createdAt = createdAt;
    this.updatedAt = createdAt;
  }

  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  // com.github.hemoptysisheart.bui.admin.domain.Operator
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getEmail() {
    return this.email;
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
  public boolean equals(Object o) {
    if (this == o) return true;
    if (0 >= this.id || !(o instanceof OperatorEntity)) return false;
    OperatorEntity that = (OperatorEntity) o;
    return this.id == that.id;
  }

  @Override
  public int hashCode() {
    return hash(this.id);
  }

  @Override
  public String toString() {
    return new StringBuilder(OperatorEntity.class.getSimpleName())
        .append("{id=").append(this.id)
        .append(", name='").append(this.name).append('\'')
        .append(", email='").append(this.email).append('\'')
        .append(", createdAt=").append(this.createdAt)
        .append(", updatedAt=").append(this.updatedAt)
        .append('}').toString();
  }
}