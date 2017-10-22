package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Represents a SkipCard.
 * 
 * @author Pedro Belmonte
 *
 */
public class SkipCard extends AbstractColorCard {

  /**
   * SkipCard constructor. Sets its color and symbol.
   * 
   * @param color Color of the card
   */
  public SkipCard(Color color) {
    super(color, Symbol.SKIP);
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    ctrl.updatePlayedCard();
    game.skipPlayer();
  }

}
