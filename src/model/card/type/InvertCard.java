package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Represents Invert card.
 * 
 * @author Pedro Belmonte
 *
 */
public class InvertCard extends AbstractColorCard {

  /**
   * InvertCard constructor. Sets its color and symbol.
   * 
   * @param color Color of the card
   */
  public InvertCard(Color color) {
    super(color, Symbol.INVERT);
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    ctrl.updatePlayedCard();
    game.invertDirection();
  }

}
