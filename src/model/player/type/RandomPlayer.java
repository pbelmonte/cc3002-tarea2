package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Represents a virtual player.
 * 
 * @author Pedro Belmonte
 *
 */
public class RandomPlayer extends AbstractPlayer {

  /**
   * RandomPlayer constructor.
   * 
   * @param player Player number
   */
  public RandomPlayer(int player) {
    super(player);
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    ICard card = NullCard.uniqueInstance();
    ICard currentCard = game.getCurrentPlayedCard();
    if (this.needsToDrawCard(currentCard)) {
      game.drawOneCard(this);
    }
    if (!this.needsToDrawCard(currentCard)) {
      while (!card.isPlayableOver(currentCard)) {
        card = getCardFromHand((int) Math.floor(Math.random() * getHandSize()));
      }
    } else {
      ctrl.showMessage("[" + toString() + " pasa]");
    }
    removeCardFromHand(card);
    return card;
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    int num = (int) Math.floor(Math.random() * 4);
    return Color.getColors()[num];
  }

}
