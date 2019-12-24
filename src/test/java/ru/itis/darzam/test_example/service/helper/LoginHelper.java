package ru.itis.darzam.test_example.service.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.darzam.test_example.model.User;
import ru.itis.darzam.test_example.service.Settings;


public class LoginHelper extends HelperBase {

  private boolean isLoggedIn;

  public LoginHelper(WebDriver driver) {
    super(driver);
  }

  public void logout() {
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[3]/div/span")).click();
    driver.findElement(By.xpath("//button[contains(.,'Выйти')]")).click();
    isLoggedIn = false;
  }

  public void login(User user) {
    if (isLoggedIn()) {
      if (isLoggedIn(Settings.username)) {
        return;
      }
      logout();
    }
    driver.findElement(By.linkText("Log In")).click();
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys(user.getUsername());
    driver.findElement(By.xpath("//section")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(user.getPassword());
    driver.findElement(By.id("login")).click();
    if (!checkIncorrect()) {
      isLoggedIn = true;
    }
  }

  public boolean checkIncorrect() {
    return driver.findElement(By.xpath("/html/body/div[1]/section/div/div/div[2]/p")) != null;
  }

  public boolean isLoggedIn() {
    return isLoggedIn;
  }

  public boolean isLoggedIn(String username) {
    String loggedIdusername = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div[1]/span")).getText();
    return loggedIdusername == username;
  }
}
