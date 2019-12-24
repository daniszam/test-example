package ru.itis.darzam.test_example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class User {

  private String username;
  private String password;

  @XmlElement
  public String getUsername() {
    return username;
  }

  @XmlElement
  public String getPassword() {
    return password;
  }
}
