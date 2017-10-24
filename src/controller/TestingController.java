package controller;

import model.IGameLogic;
import model.card.type.Color;
import model.card.type.ICard;
import model.player.type.IPlayer;

public class TestingController implements IController {
  
  IGameLogic game;

  /**
   * Controller constructor. Initializes model.
   * Also, it plays the card in discard pile.
   * @param game
   * @param viewand
   */
  public TestingController(IGameLogic game) {
    this.game = game;
    game.getCurrentPlayedCard().executeAction(game, this);
  }

  @Override
  public Color askForColor() {
    return Color.RED;
  }

  @Override
  public int AskForCardFromHand(IPlayer player) {
    return 0;
  }

  @Override
  public void showMessage(String message) {
  }

  @Override
  public void playTurn() {
    game.startTurn(this);
    IPlayer currentPlayer = game.getCurrentPlayer();
    boolean cardPlayed = false;
    while (!cardPlayed) {
      ICard card = currentPlayer.getCardToPlay(game, this);
      cardPlayed = game.playCard(card, this);
    }
  }

  @Override
  public void updatePlayedCard() {
  }

}
