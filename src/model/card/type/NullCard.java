package model.card.type;

import controller.IController;
import model.IGameLogic;

public class NullCard implements ICard {

  @Override
  public boolean isPlayableOver(ICard otherCard) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isFirstPlayable() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public Color getColor() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Symbol getSymbol() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    
  }

  @Override
  public boolean isDiscardable() {
    // TODO Auto-generated method stub
    return false;
  }

}
