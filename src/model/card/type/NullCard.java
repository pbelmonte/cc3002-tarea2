package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Represents a fictional card that does nothing.
 * 
 * @author Pedro Belmonte
 *
 */
public class NullCard implements ICard {

  private static NullCard uniqueInstance;

  /**
   * NullCard constructor.
   */
  private NullCard() {}

  /**
   * Forbids more than one instance of the class, since is not necessary to have more than one.
   * 
   * @return The unique instance of the class
   */
  public static NullCard uniqueInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new NullCard();
    }
    return uniqueInstance;
  }

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    return false;
  }

  @Override
  public boolean isFirstPlayable() {
    return false;
  }

  @Override
  public Color getColor() {
    return Color.NONE;
  }

  @Override
  public Symbol getSymbol() {
    return Symbol.NONE;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {}

  @Override
  public boolean isDiscardable() {
    return false;
  }

}
