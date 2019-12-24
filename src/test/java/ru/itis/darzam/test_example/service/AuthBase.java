package ru.itis.darzam.test_example.service;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.itis.darzam.test_example.model.User;

public class AuthBase extends AbstractTest {

  private static final String USERNAME = "daniszamaliev@gmail.com";
  private static final String PASSWORD = "dREAM1cACAO";

  @BeforeClass
  public static void setUp() {
    AppManager appManager = AppManager.getInstance();
    appManager.getNavigationHelper().openHomePage();
    appManager.getLoginHelper().login(User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build()
    );
  }
}
