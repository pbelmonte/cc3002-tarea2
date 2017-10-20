package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public class HumanPlayer extends AbstractPlayer {
  
  public HumanPlayer() {
    super();
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void removeCardFromHand(ICard card) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean needsToDrawCard(ICard currentCard) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ICard getCardFromHand(int number) {
    // TODO Auto-generated method stub
    return null;
  }

}
