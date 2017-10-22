package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Represents a wild card
 * 
 * @author Pedro Belmonte
 *
 */
public class WildCard implements ICard {

  private Color color;
  private Symbol symbol;

  /**
   * WildCard constructor. Sets its color and symbol.
   */
  public WildCard() {
    this.color = Color.NONE;
    setSymbol(Symbol.WILD);
  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return true;
  }

  @Override
  public boolean isFirstPlayable() {
    return false;
  }

  @Override
  public Color getColor() {
    return color;
  }

  @Override
  public Symbol getSymbol() {
    return symbol;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    setColor(game.getCurrentPlayer().selectColor(game, ctrl));
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

  /**
   * Sets the color of the card.
   * 
   * @param color New color
   */
  void setColor(Color color) {
    this.color = color;
  }

  /**
   * Sets the symbol of the card.
   * 
   * @param color New symbol
   */
  void setSymbol(Symbol symbol) {
    this.symbol = symbol;
  }

}
