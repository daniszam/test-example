package ru.itis.darzam.test_example.service;

import org.junit.Test;
import ru.itis.darzam.test_example.model.Card;
import ru.itis.darzam.test_example.model.User;

public class UntitledTestCase extends AbstractTest{

  private static final String USERNAME = "daniszamaliev@gmail.com";
  private static final String PASSWORD = "dREAM1cACAO";

  private static final String CARD_NAME = "Card Name 1";
  private static final String NEW_CARD_NAME = "New card name 10";

  @Test
  public void testLoginLogout() {
    AppManager appManager = AppManager.getInstance();
    appManager.getNavigationHelper().openHomePage();
    appManager.getLoginHelper().login(User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build()
    );
    appManager.getLoginHelper().logout();
  }

  @Test
  public void createCard() {
    AppManager appManager = AppManager.getInstance();
    appManager.getNavigationHelper().openHomePage();
    appManager.getLoginHelper().login(User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build());
    appManager.getCardHelper().createCard(Card.builder()
            .cardName(CARD_NAME)
            .build());
    appManager.getLoginHelper().logout();
  }

  @Test
  public void editCard(){
    AppManager appManager = AppManager.getInstance();
    appManager.getNavigationHelper().openHomePage();
    appManager.getLoginHelper().login(User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build());
    appManager.getCardHelper().editaCard(Card.builder()
            .cardName(NEW_CARD_NAME)
            .build());
    appManager.getLoginHelper().logout();
  }
}
