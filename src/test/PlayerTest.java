package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.player.type.HumanPlayer;
import model.player.type.IPlayer;
import model.player.type.RandomPlayer;
import model.card.type.Color;
import model.card.type.ICard;
import model.card.type.NullCard;
import model.card.type.NumberCard;
import model.card.type.SkipCard;
import model.card.type.Symbol;

public class PlayerTest {

  private IPlayer human;
  private IPlayer random;
  private ICard red4;
  private ICard red5;
  private ICard red6;

  @Before
  public void setUp() throws Exception {
    human = new HumanPlayer(1);
    random = new RandomPlayer(2);
    ArrayList<ICard> hand = new ArrayList<ICard>();
    red4 = new NumberCard(Color.RED, Symbol.FOUR);
    red5 = new NumberCard(Color.RED, Symbol.FIVE);
    red6 = new NumberCard(Color.RED, Symbol.SIX);
    hand.add(red4);
    hand.add(red5);
    hand.add(red6);
    human.addToHand(hand);
    random.addToHand(hand);
  }

  @Test
  public void testHasWon() {
    assertFalse(human.hasWon());
    assertFalse(random.hasWon());
    human.removeCardFromHand(red4);
    human.removeCardFromHand(red5);
    human.removeCardFromHand(red6);
    assertTrue(human.hasWon());
  }

  @Test
  public void testGetHandSize() {
    assertEquals(3, human.getHandSize());
    assertEquals(3, random.getHandSize());
  }

  @Test
  public void testHasOneCard() {
    assertFalse(human.hasOneCard());
    assertFalse(random.hasOneCard());
    human.removeCardFromHand(red4);
    human.removeCardFromHand(red5);
    assertTrue(human.hasOneCard());
  }

  @Test
  public void testGetHand() {
    ArrayList<ICard> hand2 = new ArrayList<ICard>();
    hand2.add(red4);
    hand2.add(red5);
    hand2.add(red6);
    assertEquals(hand2, human.getHand());
    assertEquals(hand2, random.getHand());
  }

  @Test
  public void testRemoveCardFromHand() {
    ArrayList<ICard> hand2 = new ArrayList<ICard>();
    hand2.add(red4);
    hand2.add(red5);
    human.removeCardFromHand(red6);
    random.removeCardFromHand(red6);
    assertEquals(hand2, human.getHand());
    assertEquals(hand2, random.getHand());
    human.removeCardFromHand(NullCard.uniqueInstance());
    random.removeCardFromHand(NullCard.uniqueInstance());
    assertEquals(hand2, human.getHand());
    assertEquals(hand2, random.getHand());
  }

  @Test
  public void testNeedsToDrawCard() {
    assertTrue(human.needsToDrawCard(new SkipCard(Color.BLUE)));
    assertTrue(random.needsToDrawCard(new SkipCard(Color.BLUE)));
    assertFalse(human.needsToDrawCard(new NumberCard(Color.RED, Symbol.EIGHT)));
    assertFalse(random.needsToDrawCard(new NumberCard(Color.RED, Symbol.EIGHT)));
  }

  @Test
  public void testGetCardFromHand() {
    assertEquals(red4, human.getCardFromHand(0));
    assertEquals(red4, random.getCardFromHand(0));
    assertEquals(NullCard.uniqueInstance(), human.getCardFromHand(4));
    assertEquals(NullCard.uniqueInstance(), random.getCardFromHand(4));
  }

}
