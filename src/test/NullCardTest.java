package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.DrawTwoCard;
import model.card.type.ICard;
import model.card.type.NullCard;
import model.card.type.NumberCard;
import model.card.type.Symbol;
import model.card.type.WildCard;

public class NullCardTest {
  
  private static ICard card;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    card = NullCard.uniqueInstance();
  }

  @Test
  public void testUniqueInstance() {
    ICard card1 = NullCard.uniqueInstance();
    ICard card2 = NullCard.uniqueInstance();
    // assertTrue and not assertEquals because we want to test if they are the same object, and this
    // is achieved using ==
    assertTrue(card1 == card2);
  }

  @Test
  public void testIsPlayableOver() {
    assertFalse(card.isPlayableOver(new NumberCard(Color.YELLOW, Symbol.FOUR)));
    assertFalse(card.isPlayableOver(new DrawTwoCard(Color.RED)));
    assertFalse(card.isPlayableOver(new WildCard()));
  }

  @Test
  public void testIsFirstPlayable() {
    assertFalse(card.isFirstPlayable());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.NONE, card.getColor());
  }

  @Test
  public void testGetSymbol() {
    assertEquals(Symbol.NONE, card.getSymbol());
  }

  @Test
  public void testIsDiscardable() {
    assertFalse(card.isDiscardable());
  }

}
