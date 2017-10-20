package model.player.type;

import java.util.ArrayList;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;

public abstract class AbstractPlayer implements IPlayer {

  private ArrayList<ICard> hand;
  private boolean saidUNO;

  public AbstractPlayer() {
    hand = new ArrayList<ICard>();
    saidUNO = false;
  }

  @Override
  public void addToHand(ArrayList<ICard> hand) {
    this.hand.addAll(hand);
  }

  @Override
  public boolean hasWon() {
    return this.getHandSize() == 0;
  }

  @Override
  public abstract ICard getCardToPlay(IGameLogic game, IController ctrl);

  @Override
  public abstract Color selectColor(IGameLogic game, IController ctrl);

  @Override
  public int getHandSize() {
    return hand.size();
  }

  @Override
  public boolean hasOneCard() {
    return hand.size() == 1;
  }

  @Override
  public ArrayList<ICard> getHand() {
    return hand;
  }

  @Override
  public void setSaidUNO(boolean status) {
    saidUNO = status;
  }

  @Override
  public boolean hasSaidUNO() {
    return saidUNO;
  }

  @Override
  public void removeCardFromHand(ICard card) {
    
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
