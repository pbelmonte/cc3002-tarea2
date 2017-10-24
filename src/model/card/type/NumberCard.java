package model.card.type;

/**
 * Represents a numeric card.
 * 
 * @author Pedro Belmonte
 *
 */
public class NumberCard extends AbstractColorCard implements ICard {

  /**
   * NumberCard constructor. Sets its color and symbol.
   * 
   * @param color Color of the card
   * @param symbol Number of the card
   */
  public NumberCard(Color color, Symbol symbol) {
    super(color, symbol);
  }
}
