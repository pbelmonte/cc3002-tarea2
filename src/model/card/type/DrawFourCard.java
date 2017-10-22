package model.card.type;

import controller.IController;
import model.IGameLogic;

/**
 * Represents Draw Four wild card.
 * 
 * @author Pedro Belmonte
 *
 */
public class DrawFourCard extends WildCard {

  /**
   * DrawFourCard constructor. Sets the symbol to WILD_DRAW_FOUR.
   */
  public DrawFourCard() {
    setSymbol(Symbol.WILD_DRAW_FOUR);
  }

  @Override
  public void executeAction(IGameLogic game, IController ctrl) {
    game.addToDrawWell(4);
    setColor(game.getCurrentPlayer().selectColor(game, ctrl));
    ctrl.updatePlayedCard();
  }

}
