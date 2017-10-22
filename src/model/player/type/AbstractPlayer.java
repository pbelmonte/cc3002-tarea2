package model.player.type;

import java.util.ArrayList;
import java.util.Iterator;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Represents an abstract player.
 * 
 * @author Pedro Belmonte
 *
 */
public abstract class AbstractPlayer implements IPlayer {

  private ArrayList<ICard> hand;
  private boolean saidUNO;
  private int player;

  /**
   * AbstractPlayer constructor. Initializes the hand, the saidUNO state and the player number.
   * 
   * @param player
   */
  public AbstractPlayer(int player) {
    hand = new ArrayList<ICard>();
    saidUNO = false;
    this.player = player;
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
    if (card.isDiscardable()) {
      hand.remove(card);
    }
  }

  @Override
  public boolean needsToDrawCard(ICard currentCard) {
    for (Iterator<ICard> i = hand.iterator(); i.hasNext();) {
      ICard card = (ICard) i.next();
      if (card.isPlayableOver(currentCard)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public ICard getCardFromHand(int number) {
    if (hand.size() > number) {
      return hand.get(number);
    }
    return NullCard.uniqueInstance();
  }

  @Override
  public String toString() {
    return "Jugador " + this.player;
  }

}
