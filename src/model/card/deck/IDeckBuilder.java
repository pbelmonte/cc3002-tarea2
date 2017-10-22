package model.card.deck;

import model.card.ICardPile;

public interface IDeckBuilder {

  /**
   * Returns the generated deck.
   * 
   * @return ICardPile with the created cards
   */
  public ICardPile build();

  /**
   * Adds the numeric cards to the deck.
   * 
   * @return Itself
   */
  public IDeckBuilder addNumericCards();

  /**
   * Adds the action cards to the deck.
   * 
   * @return Itself
   */
  public IDeckBuilder addActionCards();

  /**
   * Adds the wild cards to the deck.
   * 
   * @return Itself
   */
  public IDeckBuilder addWildCards();

}
