package model;

import java.util.ArrayList;

import controller.IController;
import model.card.ICardPilesManager;
import model.card.type.ICard;
import model.player.IPlayerManager;
import model.player.type.IPlayer;

/**
 * Class that defines the logic used by the game.
 * 
 * @author Pedro Belmonte
 *
 */
public class GameLogic implements IGameLogic {

  private IPlayerManager playerMngr;
  private ICardPilesManager pilesMngr;
  private ArrayList<ICard> drawWell;

  /**
   * GameLogic constructor. It initializes the PlayerManager, CardPilesManager and the drawWell.
   * Also, it deals the cards to the players.
   * 
   * @param playerMngr PlayerManager used in the game
   * @param pilesMngr CardPilesManager used in the game
   */
  public GameLogic(IPlayerManager playerMngr, ICardPilesManager pilesMngr) {
    this.playerMngr = playerMngr;
    this.pilesMngr = pilesMngr;
    drawWell = new ArrayList<ICard>();
    for (int i = 0; i < playerMngr.getPlayers().size(); i++) {
      pilesMngr.addCardsToPlayer(playerMngr.getPlayers().get(i), 7);
    }
  }

  @Override
  public boolean hasEnded() {
    return getCurrentPlayer().hasWon();
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return playerMngr.getCurrentPlayer();
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return pilesMngr.getCurrentPlayedCard();
  }

  @Override
  public void autoShoutUNO(IController ctrl) {
    if (getCurrentPlayer().getHandSize() == 1) {
      getCurrentPlayer().setSaidUNO(true);
      ctrl.showMessage("[" + getCurrentPlayer() + "]: UNO!");
    }
  }

  @Override
  public void startTurn(IController ctrl) {
    autoShoutUNO(ctrl);
    playerMngr.startTurn();
    if (!isDrawWellEmpty()) {
      drawCardsFromWell(getCurrentPlayer(), ctrl);
      playerMngr.startTurn();
    }
  }

  @Override
  public void skipPlayer() {
    playerMngr.skipPlayer();
  }

  @Override
  public void addToDrawWell(int number) {
    drawWell.addAll(pilesMngr.drawCards(number));
  }

  @Override
  public void resetDrawWell() {
    drawWell.clear();
  }

  @Override
  public boolean isDrawWellEmpty() {
    return drawWell.isEmpty();
  }

  @Override
  public void drawCardsFromWell(IPlayer player, IController ctrl) {
    ctrl.showMessage("[" + player.toString() + " roba " + drawWell.size() + "]");
    player.addToHand(drawWell);
    resetDrawWell();
  }

  @Override
  public void invertDirection() {
    playerMngr.invertDirection();
  }

  @Override
  public boolean playCard(ICard playedCard, IController ctrl) {
    if (playedCard.isDiscardable()) {
      pilesMngr.discard(playedCard);
      playedCard.executeAction(this, ctrl);
      return true;
    }
    return true;
  }

  @Override
  public ICard drawOneCard(IPlayer player) {
    ArrayList<ICard> card = pilesMngr.addCardsToPlayer(player, 1);
    return card.get(0);
  }

  @Override
  public void announceWinner(IController ctrl) {
    ctrl.showMessage("El ganador es: " + this.getCurrentPlayer().toString());
  }

}
