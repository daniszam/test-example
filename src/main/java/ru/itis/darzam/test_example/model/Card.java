package ru.itis.darzam.test_example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Setter
@Builder
@XmlRootElement
@NoArgsConstructor
@AllArgsConstructor
public class Card {

  private String cardName;
  private String cardBody;

  @XmlElement
  public String getCardName() {
    return cardName;
  }

  @XmlElement
  public String getCardBody() {
    return cardBody;
  }
}
