package model.card.deck;

import model.card.ICardPile;

/**
 * Strategy to create a normal UNO deck.
 * 
 * @author Pedro Belmonte
 *
 */
public class NormalDeck implements IDeckStrategy {

  @Override
  public ICardPile createDeck() {
    DeckBuilder builder = new DeckBuilder();
    return builder.addNumericCards().addActionCards().addWildCards().build();
  }

}
