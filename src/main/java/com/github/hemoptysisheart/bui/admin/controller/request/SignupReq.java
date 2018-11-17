package com.github.hemoptysisheart.bui.admin.controller.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author H2
 * @since 2018/11/17
 */
public class SignupReq {
  @NotEmpty
  @Size(max = 255)
  private String name;
  @NotEmpty
  @Email
  @Size(max = 255)
  private String email;
  @Size(min = 8, max = 255)
  private String password;
  @Size(min = 8, max = 255)
  private String confirm;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirm() {
    return this.confirm;
  }

  public void setConfirm(String confirm) {
    this.confirm = confirm;
  }

  @Override
  public String toString() {
    return new StringBuilder(SignupReq.class.getSimpleName())
        .append("{name='").append(this.name).append('\'')
        .append(", email='").append(this.email).append('\'')
        .append(", password=[ PROTECTED ], confirm=[ PROTECTED ]")
        .append('}').toString();
  }
}