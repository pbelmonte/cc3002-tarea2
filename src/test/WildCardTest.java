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
import model.card.deck.NormalDeck;
import model.card.type.Color;
import model.card.type.DrawFourCard;
import model.card.type.InvertCard;
import model.card.type.NumberCard;
import model.card.type.SkipCard;
import model.card.type.Symbol;
import model.card.type.WildCard;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.PlayerManager;
import model.player.type.HumanPlayer;

public class WildCardTest {

  private WildCard wild;
  private DrawFourCard four;
  private IGameLogic game;
  private IController ctrl;
  private PlayerManager playerMngr;

  @Before
  public void setUp() throws Exception {
    wild = new WildCard();
    four = new DrawFourCard();
    ICardPile deck = new NormalDeck().createDeck();
    ICardPilesManager pilesMngr = new CardPilesManager(deck);
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    playerBuilder.addPlayer(new HumanPlayer(1));
    playerBuilder.addPlayer(new HumanPlayer(2));
    playerMngr = new PlayerManager(playerBuilder);
    game = new GameLogic(playerMngr, pilesMngr);
    ctrl = new TestingController(game);
  }

  @Test
  public void testIsPlayableOver() {
    assertTrue(wild.isPlayableOver(new NumberCard(Color.BLUE, Symbol.EIGHT)));
    assertTrue(wild.isPlayableOver(new SkipCard(Color.RED)));
    assertTrue(wild.isPlayableOver(four));
    assertTrue(four.isPlayableOver(new NumberCard(Color.GREEN, Symbol.ONE)));
    assertTrue(four.isPlayableOver(new InvertCard(Color.YELLOW)));
    assertTrue(four.isPlayableOver(wild));
  }

  @Test
  public void testIsFirstPlayable() {
    assertFalse(wild.isFirstPlayable());
    assertFalse(wild.isFirstPlayable());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.NONE, wild.getColor());
    assertEquals(Color.NONE, four.getColor());
  }

  @Test
  public void testGetSymbol() {
    assertEquals(Symbol.WILD, wild.getSymbol());
    assertEquals(Symbol.WILD_DRAW_FOUR, four.getSymbol());
  }

  @Test
  public void testExecuteAction() {
    game.playCard(wild, ctrl);
    assertEquals(Color.RED, game.getCurrentPlayedCard().getColor());

    assertTrue(game.isDrawWellEmpty());
    game.playCard(four, ctrl);
    assertEquals(Color.RED, game.getCurrentPlayedCard().getColor());
    four.executeAction(game, ctrl);
    assertFalse(game.isDrawWellEmpty());
  }

  @Test
  public void testIsDiscardable() {
    assertTrue(wild.isDiscardable());
    assertTrue(four.isDiscardable());
  }

  @Test
  public void testSetColor() {
    wild.setColor(Color.BLUE);
    assertEquals(Color.BLUE, wild.getColor());
    four.setColor(Color.GREEN);
    assertEquals(Color.GREEN, four.getColor());
  }

}
