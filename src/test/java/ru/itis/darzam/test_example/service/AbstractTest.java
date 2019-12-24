package ru.itis.darzam.test_example.service;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public abstract class AbstractTest {

  @BeforeClass
  public static void setUp() {
    AppManager.getInstance().getNavigationHelper().openHomePage();
  }

  @AfterClass
  public static void tearDown() throws Exception {
    AppManager.getInstance().getDriver().quit();
  }
}
