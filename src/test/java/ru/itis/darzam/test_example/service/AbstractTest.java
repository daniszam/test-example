package ru.itis.darzam.test_example.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.itis.darzam.test_example.helper.CardHelper;
import ru.itis.darzam.test_example.helper.LoginHelper;
import ru.itis.darzam.test_example.helper.NavigationHelper;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public abstract class AbstractTest {

//  private static WebDriver driver;
//  protected static LoginHelper loginHelper;
//  protected static NavigationHelper navigationHelper;
//  protected static CardHelper cardHelper;
//  private static ThreadLocal<WebDriver> app = new ThreadLocal<WebDriver>();

//  @BeforeClass
//  public static void setUp() throws Exception {
//    String browserPath = "/Applications/Firefox.app/Contents/MacOS/firefox";
////
////    Path path = Paths.get(browserPath);
////
////    File pathBinary = new File(path.toUri());
////    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
////    DesiredCapabilities desired = DesiredCapabilities.firefox();
////    FirefoxOptions options = new FirefoxOptions();
////    options.setBinary(path);
////    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
////
////    driver = new FirefoxDriver(options);
////    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
////
////    loginHelper = new LoginHelper(driver);
////    navigationHelper = new NavigationHelper(driver);
////    cardHelper = new CardHelper(driver);
//  }

//  protected static WebDriver getInstance() {
//    if (app.get()==null) {
//      String browserPath = "/Applications/Firefox.app/Contents/MacOS/firefox";
//
//      Path path = Paths.get(browserPath);
//
//      File pathBinary = new File(path.toUri());
//      FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
//      DesiredCapabilities desired = DesiredCapabilities.firefox();
//      FirefoxOptions options = new FirefoxOptions();
//      options.setBinary(path);
//      desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));
//
//      WebDriver driver = new FirefoxDriver(options);
//      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//
//      loginHelper = new LoginHelper(driver);
//      navigationHelper = new NavigationHelper(driver);
//      cardHelper = new CardHelper(driver);
//      app.set(driver);
//    }
//    return app.get();
//  }

  @AfterClass
  public static void tearDown() throws Exception {
    AppManager.getInstance().getDriver().quit();
  }
}
