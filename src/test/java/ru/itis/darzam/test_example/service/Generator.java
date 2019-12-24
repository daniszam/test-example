package ru.itis.darzam.test_example.service;

import org.apache.commons.lang.RandomStringUtils;
import ru.itis.darzam.test_example.model.Card;
import ru.itis.darzam.test_example.model.User;

import javax.xml.bind.JAXB;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.nio.file.Paths;

public class Generator {

  public static String generateData(int length, boolean useLetters, boolean useNumbers) {
    return RandomStringUtils.random(length, useLetters, useNumbers);
  }

  private static void saveToXml(Class<?> clazz, Object model, String fileName) {
    File file = new File("./src/test/java/ru/itis/darzam/test_example/service/generated/" + fileName);
    System.out.println(file.getAbsolutePath());
    try {

      JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
      Marshaller marshaller = jaxbContext.createMarshaller();

      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      marshaller.marshal(model, file);
      marshaller.marshal(model, System.out);

    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }

  public static Object readFromXml(Class<?> clazz, String fileName) {
    File file = new File("./src/test/java/ru/itis/darzam/test_example/service/generated/" + fileName);
    try {

      JAXBContext jaxbContext = JAXBContext.newInstance(clazz);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      return jaxbUnmarshaller.unmarshal(file);

    } catch (JAXBException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static Object createData(Class<?> clazz) {
    if (clazz.equals(Card.class)) {
      Card card = Card.builder()
              .cardName(generateData(10, true, false))
              .cardBody(generateData(15, true, true))
              .build();
      saveToXml(clazz, card, "card.xml");
      return card;
    } else if (clazz.equals(User.class)){
      User user = User.builder()
              .username(generateData(10, true, false))
              .password(generateData(15, true, true))
              .build();
      saveToXml(clazz, user, "user.xml");
      return user;
    }
    return null;
  }

  public static void main(String[] args) {
    Generator generator = new Generator();
    generator.createData(User.class);

    File file = new File("./src/test/java/ru/itis/darzam/test_example/service/settings/Settings.xml");
    try {

      JAXBContext jaxbContext = JAXBContext.newInstance(Settings.class);
      Marshaller marshaller = jaxbContext.createMarshaller();

      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      Settings.password = "dREAM1cACAO";
      Settings.username = "daniszamaliev@gmail.com";
      Settings.browserPath = "/Applications/Firefox.app/Contents/MacOS/firefox";
      marshaller.marshal(new Settings(), file);

    } catch (JAXBException e) {
      e.printStackTrace();
    }
  }
}


