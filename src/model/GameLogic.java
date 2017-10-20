package model;

import java.util.ArrayList;

import controller.IController;
import model.card.CardPilesManager;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.type.ICard;
import model.player.IPlayerManager;
import model.player.PlayerManager;
import model.player.type.IPlayer;

public class GameLogic implements IGameLogic {

  private IPlayerManager playerMngr;
  private ICardPilesManager pilesMngr;
  private ArrayList<ICard> drawWell;

  public GameLogic(ICardPile deck) {
    playerMngr = new PlayerManager();
    pilesMngr = new CardPilesManager(deck);
    drawWell = new ArrayList<ICard>();
  }

  @Override
  public boolean hasEnded() {
    return getCurrentPlayer().hasWon();
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return this.playerMngr.getCurrentPlayer();
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return this.pilesMngr.getCurrentPlayedCard();
  }

  @Override
  public void autoShoutUNO(IController ctrl) {

  }

  @Override
  public void startTurn(IController ctrl) {
    // TODO Auto-generated method stub

  }

  @Override
  public void skipPlayer() {
    // TODO Auto-generated method stub

  }

  @Override
  public void addToDrawWell(int number) {
    this.drawWell.addAll(this.pilesMngr.drawCards(number));
  }

  @Override
  public void resetDrawWell() {
    this.drawWell.clear();
  }

  @Override
  public boolean isDrawWellEmpty() {
    return this.drawWell.isEmpty();
  }

  @Override
  public void drawCardsFromWell(IPlayer player, IController ctrl) {

  }

  @Override
  public void invertDirection() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean playCard(ICard playedCard, IController ctrl) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public ICard drawOneCard(IPlayer player) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void announceWinner(IController ctrl) {
    ctrl.showMessage("El ganador es: " + this.getCurrentPlayer().toString());
  }

}
