package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controller.IController;
import controller.TestingController;
import model.GameLogic;
import model.IGameLogic;
import model.card.CardPilesManager;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.deck.TestingDeck;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NumberCard;
import model.card.type.Symbol;
import model.player.IPlayerListBuilder;
import model.player.IPlayerManager;
import model.player.PlayerListBuilder;
import model.player.PlayerManager;
import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import model.player.type.RandomPlayer;

public class GameLogicTest {

  private IGameLogic game;
  private IController ctrl;
  private ICardPile deck;
  private ICardPilesManager pilesMngr;
  private IPlayer firstPlayer;
  private ICard firstCard;

  @Before
  public void setUp() throws Exception {
    TestingDeck deckStrategy = new TestingDeck();
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ZERO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ONE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.TWO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.THREE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FOUR));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FIVE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SIX));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SEVEN));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.EIGHT));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.NINE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ZERO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ONE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.TWO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.THREE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FOUR));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FIVE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SIX));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SEVEN));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.EIGHT));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.NINE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ZERO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ONE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.TWO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.THREE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FOUR));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FIVE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SIX));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SEVEN));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.EIGHT));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.NINE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ZERO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.ONE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.TWO));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.THREE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FOUR));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.FIVE));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SIX));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.SEVEN));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.EIGHT));
    deckStrategy.addCard(new NumberCard(Color.RED, Symbol.NINE));
    deck = deckStrategy.createDeck();
    pilesMngr = new CardPilesManager(deck);
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    playerBuilder.addPlayer(new HumanPlayer(1));
    playerBuilder.addPlayer(new RandomPlayer(2));
    IPlayerManager playerMngr = new PlayerManager(playerBuilder);
    game = new GameLogic(playerMngr, pilesMngr);
    ctrl = new TestingController(game);
    ctrl.playTurn();
    firstPlayer = playerMngr.getCurrentPlayer();
    firstCard = pilesMngr.getCurrentPlayedCard();
  }

  @Test
  public void testHasEnded() {
    assertFalse(game.hasEnded());
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 6 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 5 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 4 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 3 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 2 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le queda 1 carta
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 0 cartas
    assertTrue(game.hasEnded());
  }

  @Test
  public void testGetCurrentPlayer() {
    assertEquals(firstPlayer, game.getCurrentPlayer());
  }

  @Test
  public void testGetCurrentPlayedCard() {
    assertEquals(firstCard, game.getCurrentPlayedCard());
  }

  @Test
  public void testAutoShoutUNO() {
    assertFalse(game.getCurrentPlayer().hasSaidUNO());
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 6 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 5 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 4 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 3 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le quedan 2 cartas
    ctrl.playTurn();
    ctrl.playTurn(); // le queda 1 carta
    assertTrue(game.getCurrentPlayer().hasSaidUNO());
  }

  @Test
  public void testStartTurn() {
    game.startTurn(ctrl);
    assertNotEquals(firstPlayer, game.getCurrentPlayer());
    game.addToDrawWell(2);
    game.startTurn(ctrl);
    assertNotEquals(firstPlayer, game.getCurrentPlayer());
  }

  @Test
  public void testSkipPlayer() {
    game.skipPlayer();
    game.startTurn(ctrl);
    assertEquals(firstPlayer, game.getCurrentPlayer());
  }

  @Test
  public void testAddToDrawWell() {
    assertTrue(game.isDrawWellEmpty());
    game.addToDrawWell(3);
    assertFalse(game.isDrawWellEmpty());
  }

  @Test
  public void testResetDrawWell() {
    game.addToDrawWell(3);
    assertFalse(game.isDrawWellEmpty());
    game.resetDrawWell();
    assertTrue(game.isDrawWellEmpty());
  }

  @Test
  public void testIsDrawWellEmpty() {
    assertTrue(game.isDrawWellEmpty());
    game.addToDrawWell(1);
    assertFalse(game.isDrawWellEmpty());
  }

  @Test
  public void testDrawCardsFromWell() {
    game.addToDrawWell(3);
    int originalHand = firstPlayer.getHandSize();
    game.drawCardsFromWell(firstPlayer, ctrl);
    assertEquals(originalHand + 3, firstPlayer.getHandSize());
    assertTrue(game.isDrawWellEmpty());
  }

  @Test
  public void testInvertDirection() {
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    playerBuilder.addPlayer(new HumanPlayer(1));
    playerBuilder.addPlayer(new RandomPlayer(2));
    playerBuilder.addPlayer(new RandomPlayer(3));
    IPlayerManager playerMngr = new PlayerManager(playerBuilder);
    game = new GameLogic(playerMngr, pilesMngr);
    ctrl = new TestingController(game);
    ctrl.playTurn();
    firstPlayer = playerMngr.getCurrentPlayer();
    ctrl.playTurn();
    game.invertDirection();
    ctrl.playTurn();
    assertEquals(firstPlayer, game.getCurrentPlayer());
  }

  @Test
  public void testPlayCard() {
    ICard card = new NumberCard(Color.RED, Symbol.FOUR);
    game.playCard(card, ctrl);
    assertEquals(card, game.getCurrentPlayedCard());
  }

  @Test
  public void testDrawOneCard() {
    int originalHand = firstPlayer.getHandSize();
    game.drawOneCard(firstPlayer);
    assertEquals(originalHand + 1, firstPlayer.getHandSize());
  }

}
