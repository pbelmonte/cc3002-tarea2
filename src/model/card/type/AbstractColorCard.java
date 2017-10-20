package model.card.type;

import controller.IController;
import model.IGameLogic;

public abstract class AbstractColorCard implements ICard {
  
  private Color color;
  private Symbol symbol;
  
  /**
   * NumericCard constructor.
   * @param color Color of the card
   * @param symbol Numeric value of the card
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
  public abstract void executeAction(IGameLogic game, IController ctrl);

  @Override
  public boolean isDiscardable() {
    return true;
  }

}
