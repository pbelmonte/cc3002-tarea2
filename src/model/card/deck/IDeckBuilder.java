package model.card.deck;

import model.card.ICardPile;
import model.card.type.ICard;

public interface IDeckBuilder {

  /**
   * Returns the generated deck.
   * 
   * @return ICardPile with the created cards
   */
  public ICardPile build();

  /**
   * Adds a single card.
   * 
   * @return Itself
   */
  public IDeckBuilder addCard(ICard card);

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
