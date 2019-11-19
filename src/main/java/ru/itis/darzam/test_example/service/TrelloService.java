package ru.itis.darzam.test_example.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.itis.darzam.test_example.model.Card;
import ru.itis.darzam.test_example.model.User;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class TrelloService {

  private WebDriver driver;

  public TrelloService(String browserPath){
    Path path = Paths.get(browserPath);

    File pathBinary = new File(path.toUri());
    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
    DesiredCapabilities desired = DesiredCapabilities.firefox();
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(path);
    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));

    driver = new FirefoxDriver(options);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  public void login(User user) {
    driver.findElement(By.linkText("Log In")).click();
    driver.findElement(By.id("user")).click();
    driver.findElement(By.id("user")).clear();
    driver.findElement(By.id("user")).sendKeys("daniszamaliev@gmail.com");
    driver.findElement(By.xpath("//section")).click();
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("dREAM1cACAO");
    driver.findElement(By.id("login")).click();
  }

  public void logout() {
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div[2]/button[3]/div/span")).click();
    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[3]/div/div[3]/nav/ul/li[8]/button")).click();
  }

  public void openHomePage() {
    driver.get("https://trello.com/logged-out");
  }

  public void destroy(){
    driver.quit();
  }

  public void createCard(Card card) {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмеченные доски'])[2]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить карточку'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='#28'])[1]/following::textarea[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='#28'])[1]/following::textarea[1]")).sendKeys(card.getCardName());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='#28'])[1]/following::input[1]")).click();
  }
}
