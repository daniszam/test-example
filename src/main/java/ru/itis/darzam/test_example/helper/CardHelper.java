package ru.itis.darzam.test_example.helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.itis.darzam.test_example.model.Card;

public class CardHelper extends HelperBase {

  public CardHelper(WebDriver driver) {
    super(driver);
  }

  public void createCard(Card card) {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмеченные доски'])[2]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить карточку'])[1]/following::span[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='#28'])[1]/following::textarea[1]")).clear();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='#28'])[1]/following::textarea[1]")).sendKeys(card.getCardName());
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='#28'])[1]/following::input[1]")).click();
  }

  public void editaCard(Card card) {
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Отмеченные доски'])[2]/following::div[1]")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Добавить карточку'])[1]/following::span[1]")).click();

    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/a[6]/div[3]/span")).click();
    driver.findElement(By.xpath("//div[@id='chrome-container']/div[3]/div/div/div/div[3]/div/textarea")).click();
    driver.findElement(By.xpath("//div[@id='chrome-container']/div[3]/div/div/div/div[3]/div/textarea")).click();
    driver.findElement(By.xpath("//div[@id='chrome-container']/div[3]/div/div/div/div[3]/div/textarea")).clear();
    driver.findElement(By.xpath("//div[@id='chrome-container']/div[3]/div/div/div/div[3]/div/textarea")).sendKeys(card.getCardName());
    driver.findElement(By.xpath("//div[@id='chrome-container']/div[3]/div/div/a")).click();

    String editedValue = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div[4]/div/div[1]/div[3]/div[1]/div[1]/div/div[2]/a[6]/div[3]/span")).getText();
    Assert.assertEquals(card.getCardName(), editedValue);
  }
}
