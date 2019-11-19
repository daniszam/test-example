package ru.itis.darzam.test_example.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.itis.darzam.test_example.model.Card;
import ru.itis.darzam.test_example.model.User;

public class UntitledTestCase {

  private TrelloService trelloService;

  private static final String USERNAME = "daniszamaliev@gmail.com";
  private static final String PASSWORD = "dREAM1cACAO";

  private static final String CARD_NAME = "Card Name";

  @Before
  public void setUp() throws Exception {
    trelloService = new TrelloService("/Applications/Firefox.app/Contents/MacOS/firefox");
  }

  @Test
  public void testLoginLogout() throws Exception {
    trelloService.openHomePage();
    trelloService.login(User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build()
    );
    trelloService.logout();
  }

  @Test
  public void createCard() {
    trelloService.openHomePage();
    trelloService.login(User.builder()
            .username(USERNAME)
            .password(PASSWORD)
            .build());
    trelloService.createCard(Card.builder()
            .cardName(CARD_NAME)
            .build());
    trelloService.logout();
  }

  @After
  public void tearDown() throws Exception {
    trelloService.destroy();
  }
}
