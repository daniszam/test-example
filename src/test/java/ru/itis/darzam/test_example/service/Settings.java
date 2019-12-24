package ru.itis.darzam.test_example.service;

import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public final class Settings {

  public static String username;
  public static String password;
  public static String browserPath;

  private String getUsername() {
    return Settings.username;
  }

  private String getPassword() {
    return Settings.password;
  }

  private String getBrowserPath() {
    return Settings.browserPath;
  }

  @XmlElement(name = "username")
  private void setUsername(String username) {
    Settings.username = username;
  }

  @XmlElement(name = "password")
  private void setPassword(String password) {
    Settings.password = password;
  }

  @XmlElement(name = "browserPath")
  private void setBrowserPath(String browserPath) {
    Settings.browserPath = browserPath;
  }
}
