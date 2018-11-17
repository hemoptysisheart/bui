package com.github.hemoptysisheart.bui.admin.service.params;

/**
 * @author H2
 * @since 2018/11/17
 */
public class CreateOperatorParams {
  private String name;
  private String email;
  private String password;

  public CreateOperatorParams() {
  }

  public CreateOperatorParams(String name, String email, String password) {
    setName(name);
    setEmail(email);
    setPassword(password);
  }

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

  @Override
  public String toString() {
    return new StringBuilder(CreateOperatorParams.class.getSimpleName())
        .append("{name='").append(this.name).append('\'')
        .append(", email='").append(this.email).append('\'')
        .append(", password=[ PROTECTED ]")
        .append('}').toString();
  }
}