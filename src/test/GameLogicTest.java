package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.card.CardPilesManager;
import model.player.IPlayerListBuilder;
import model.player.PlayerListBuilder;
import model.player.PlayerManager;

public class GameLogicTest {

  @Before
  public void setUp() throws Exception {
    //pilesMngr = new CardPilesManager(deck);
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    //playerBuilder
    //playerMngr = new PlayerManager(playerBuilder);
  }

  @Test
  public void testHasEnded() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetCurrentPlayer() {
    fail("Not yet implemented");
  }

  @Test
  public void testGetCurrentPlayedCard() {
    fail("Not yet implemented");
  }

  @Test
  public void testAutoShoutUNO() {
    fail("Not yet implemented");
  }

  @Test
  public void testStartTurn() {
    fail("Not yet implemented");
  }

  @Test
  public void testSkipPlayer() {
    fail("Not yet implemented");
  }

  @Test
  public void testAddToDrawWell() {
    fail("Not yet implemented");
  }

  @Test
  public void testResetDrawWell() {
    fail("Not yet implemented");
  }

  @Test
  public void testIsDrawWellEmpty() {
    fail("Not yet implemented");
  }

  @Test
  public void testDrawCardsFromWell() {
    fail("Not yet implemented");
  }

  @Test
  public void testInvertDirection() {
    fail("Not yet implemented");
  }

  @Test
  public void testPlayCard() {
    fail("Not yet implemented");
  }

  @Test
  public void testDrawOneCard() {
    fail("Not yet implemented");
  }

  @Test
  public void testAnnounceWinner() {
    fail("Not yet implemented");
  }

}
