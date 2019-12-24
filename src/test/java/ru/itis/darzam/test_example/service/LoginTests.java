package ru.itis.darzam.test_example.service;

import org.junit.Test;
import ru.itis.darzam.test_example.model.User;

import static org.junit.Assert.assertTrue;
import static ru.itis.darzam.test_example.service.Generator.generateData;

public class LoginTests extends AbstractTest {

  @Test
  public void loginWithValidData() {
    AppManager appManager = AppManager.getInstance();
    appManager.getNavigationHelper().openHomePage();
    appManager.getLoginHelper().login(User.builder()
            .username(Settings.username)
            .password(Settings.password)
            .build()
    );
    appManager.getLoginHelper().logout();
  }

  @Test
  public void loginWithInvalidData() {
    User user = (User) Generator.createData(User.class);
    AppManager appManager = AppManager.getInstance();
    appManager.getNavigationHelper().openHomePage();
    appManager.getLoginHelper().login(user);
    assertTrue(appManager.getLoginHelper().checkIncorrect());
  }
}
