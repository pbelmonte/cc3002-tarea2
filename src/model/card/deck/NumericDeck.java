package model.card.deck;

import model.card.ICardPile;

/**
 * Strategy to create a deck that contains only numeric cards.
 * 
 * @author Pedro Belmonte
 *
 */
public class NumericDeck implements IDeckStrategy {

  @Override
  public ICardPile createDeck() {
    DeckBuilder builder = new DeckBuilder();
    return builder.addNumericCards().build();
  }

}
