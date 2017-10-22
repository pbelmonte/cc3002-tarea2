package model.player.type;

import controller.IController;
import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;

/**
 * Represents a human player.
 * 
 * @author Pedro Belmonte
 *
 */
public class HumanPlayer extends AbstractPlayer {

  /**
   * HumanPlayer constructor.
   * 
   * @param player Player number
   */
  public HumanPlayer(int player) {
    super(player);
  }

  @Override
  public ICard getCardToPlay(IGameLogic game, IController ctrl) {
    ICard card = NullCard.uniqueInstance();
    ICard currentCard = game.getCurrentPlayedCard();
    while (!card.isPlayableOver(currentCard)) {
      int num = ctrl.AskForCardFromHand(this);
      card = getCardFromHand(num);
      if (!card.isDiscardable()) {
        card = game.drawOneCard(this);
        if (!card.isPlayableOver(currentCard)) {
          card = NullCard.uniqueInstance();
          ctrl.showMessage("[" + toString() + " pasa]");
          break;
        }
      } else if (!card.isPlayableOver(currentCard)) {
        ctrl.showMessage("Por favor, juegue una carta válida");
      }
    }
    removeCardFromHand(card);
    return card;
  }

  @Override
  public Color selectColor(IGameLogic game, IController ctrl) {
    Color color = ctrl.askForColor();
    return color;
  }

}
