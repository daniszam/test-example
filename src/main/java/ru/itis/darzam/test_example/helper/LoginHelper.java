package ru.itis.darzam.test_example.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.darzam.test_example.model.User;

public class LoginHelper extends HelperBase {

  public LoginHelper(WebDriver driver) {
    super(driver);
  }

  public void logout() {
//    driver.findElement(By.id("header-member-menu-button")).click();
//    driver.findElement(By.xpath("//span[contains(@class,'24AWINHReYjNBf')]")).click();
//    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[3]")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[3]/div/span")).click();

    driver.findElement(By.xpath("//button[contains(.,'Выйти')]")).click();
  }

  public void login(User user) {
    driver.findElement(By.linkText("Log In")).click();
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys(user.getUsername());
    driver.findElement(By.xpath("//section")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys(user.getPassword());
    driver.findElement(By.id("login")).click();
  }
}
