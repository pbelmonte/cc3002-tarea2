package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Abstract color card, defines common functionalities to all cards except wild cards.
 * 
 * @author Pedro Belmonte
 *
 */
public abstract class AbstractColorCard implements ICard {

  private Color color;
  private Symbol symbol;

  /**
   * AbstractColorCard constructor. Initializes the color and the symbol.
   * 
   * @param color Color of the card
   * @param symbol Symbol of the card
   */
  public AbstractColorCard(Color color, Symbol symbol) {
    this.color = color;
    this.symbol = symbol;
  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return this.color == otherCard.getColor() || this.symbol == otherCard.getSymbol();
  }

  @Override
  public boolean isFirstPlayable() {
    return true;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  @Override
  public Symbol getSymbol() {
    return this.symbol;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    ctrl.updatePlayedCard();
  }

  @Override
  public boolean isDiscardable() {
    return true;
  }

  @Override
  public String toString() {
    return symbol.getName() + " " + color.getName();
  }

}
