package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.DrawFourCard;
import model.card.type.InvertCard;
import model.card.type.NumberCard;
import model.card.type.SkipCard;
import model.card.type.Symbol;
import model.card.type.WildCard;

public class WildCardTest {
  
  private static WildCard wild;
  private static DrawFourCard four;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    wild = new WildCard();
    four = new DrawFourCard();
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
