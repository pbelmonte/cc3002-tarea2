package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Represents Draw Two card.
 * 
 * @author Pedro Belmonte
 *
 */
public class DrawTwoCard extends AbstractColorCard implements ICard {

  /**
   * DrawTwoCard constructor. Sets its color and symbol.
   * 
   * @param color Color of the card
   */
  public DrawTwoCard(Color color) {
    super(color, Symbol.DRAW_TWO);
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    ctrl.updatePlayedCard();
    game.addToDrawWell(2);
  }

}
