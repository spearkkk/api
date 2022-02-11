package com.spearkkk.api.configuration.auth.dto;

import com.spearkkk.api.domain.user.User;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class SessionUser implements Serializable {
  private String name;
  private String email;
  private String picture;

  public SessionUser(final User user) {
    this.name = user.getName();
    this.email = user.getEmail();
    this.picture = user.getPicture();
  }
}
