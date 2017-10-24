package model.card.deck;

import model.card.ICardPile;
import model.card.type.ICard;

/**
 * Strategy to create a testing deck.
 * 
 * @author Pedro Belmonte
 *
 */
public class TestingDeck implements IDeckStrategy {

  DeckBuilder builder;

  public TestingDeck() {
    builder = new DeckBuilder();
  }

  @Override
  public ICardPile createDeck() {
    return builder.build();
  }

  public void addCard(ICard card) {
    builder.addCard(card);
  }

}
