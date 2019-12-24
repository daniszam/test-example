package ru.itis.darzam.test_example.service.helper;

import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public NavigationHelper(WebDriver driver) {
    super(driver);
  }

  public void openHomePage() {
    driver.get("https://trello.com/logged-out");
  }
}
