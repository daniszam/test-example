package ru.itis.darzam.test_example.service;

import lombok.Getter;
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

@Getter
public class AppManager {

  private LoginHelper loginHelper;
  private NavigationHelper navigationHelper;
  private CardHelper cardHelper;
  private static ThreadLocal<AppManager> app = new ThreadLocal<>();
  private WebDriver driver;

  private AppManager (){
    String browserPath = "/Applications/Firefox.app/Contents/MacOS/firefox";

    Path path = Paths.get(browserPath);

    File pathBinary = new File(path.toUri());
    FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
    DesiredCapabilities desired = DesiredCapabilities.firefox();
    FirefoxOptions options = new FirefoxOptions();
    options.setBinary(path);
    desired.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options.setBinary(firefoxBinary));

    driver = new FirefoxDriver(options);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    loginHelper = new LoginHelper(driver);
    navigationHelper = new NavigationHelper(driver);
    cardHelper = new CardHelper(driver);
  }

  public static AppManager getInstance() {
    if (app.get()==null) {
      AppManager appManager = new AppManager();
      app.set(appManager);
    }
    return app.get();
  }
}
