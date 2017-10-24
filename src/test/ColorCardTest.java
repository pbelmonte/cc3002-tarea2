package test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import model.card.type.Color;
import model.card.type.DrawTwoCard;
import model.card.type.ICard;
import model.card.type.InvertCard;
import model.card.type.NumberCard;
import model.card.type.SkipCard;
import model.card.type.Symbol;

public class ColorCardTest {
  
  private static ICard red4;
  private static ICard blue5;
  private static ICard green6;
  private static ICard yellow7;
  private static ICard red5;
  private static ICard blue7;
  private static ICard green4;
  private static ICard yellow6;
  private static ICard redSkip;
  private static ICard blueInvert;
  private static ICard greenDrawTwo;
  private static ICard blueSkip;
  private static ICard greenInvert;
  private static ICard yellowDrawTwo;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    red4 = new NumberCard(Color.RED, Symbol.FOUR);
    blue5 = new NumberCard(Color.BLUE, Symbol.FIVE);
    green6 = new NumberCard(Color.GREEN, Symbol.SIX);
    yellow7 = new NumberCard(Color.YELLOW, Symbol.SEVEN);
    red5 = new NumberCard(Color.RED, Symbol.FIVE);
    blue7 = new NumberCard(Color.BLUE, Symbol.SEVEN);
    green4 = new NumberCard(Color.GREEN, Symbol.FOUR);
    yellow6 = new NumberCard(Color.YELLOW, Symbol.SIX);
    redSkip = new SkipCard(Color.RED);
    blueInvert = new InvertCard(Color.BLUE);
    greenDrawTwo = new DrawTwoCard(Color.GREEN);
    blueSkip = new SkipCard(Color.BLUE);
    greenInvert = new InvertCard(Color.GREEN);
    yellowDrawTwo = new DrawTwoCard(Color.YELLOW);
  }

  @Test
  public void testIsPlayableOver() {
    assertFalse(red4.isPlayableOver(blue5));
    assertFalse(blue5.isPlayableOver(green4));
    assertFalse(green6.isPlayableOver(yellow7));
    assertFalse(yellow6.isPlayableOver(red5));
    assertFalse(redSkip.isPlayableOver(blue5));
    assertFalse(blueInvert.isPlayableOver(red5));
    assertFalse(greenDrawTwo.isPlayableOver(red5));
    
    assertTrue(red4.isPlayableOver(red5));
    assertTrue(red4.isPlayableOver(green4));
    assertTrue(blue5.isPlayableOver(blue7));
    assertTrue(blue5.isPlayableOver(red5));
    assertTrue(green6.isPlayableOver(green4));
    assertTrue(green6.isPlayableOver(yellow6));
    assertTrue(yellow7.isPlayableOver(yellow6));
    assertTrue(yellow7.isPlayableOver(blue7));
    assertTrue(redSkip.isPlayableOver(red4));
    assertTrue(redSkip.isPlayableOver(blueSkip));
    assertTrue(blueInvert.isPlayableOver(blue7));
    assertTrue(blueInvert.isPlayableOver(greenInvert));
    assertTrue(yellowDrawTwo.isPlayableOver(yellow7));
    assertTrue(yellowDrawTwo.isPlayableOver(greenDrawTwo));
  }

  @Test
  public void testIsFirstPlayable() {
    assertTrue(red4.isFirstPlayable());
    assertTrue(blue5.isFirstPlayable());
    assertTrue(green6.isFirstPlayable());
    assertTrue(yellow7.isFirstPlayable());
    assertTrue(redSkip.isFirstPlayable());
    assertTrue(blueInvert.isFirstPlayable());
    assertTrue(greenDrawTwo.isFirstPlayable());
  }

  @Test
  public void testGetColor() {
    assertEquals(Color.RED, red4.getColor());
    assertEquals(Color.BLUE, blue5.getColor());
    assertEquals(Color.GREEN, green6.getColor());
    assertEquals(Color.YELLOW, yellow7.getColor());
    assertEquals(Color.RED, redSkip.getColor());
    assertEquals(Color.BLUE, blueInvert.getColor());
    assertEquals(Color.GREEN, greenDrawTwo.getColor());
  }

  @Test
  public void testGetSymbol() {
    assertEquals(Symbol.FOUR, red4.getSymbol());
    assertEquals(Symbol.FIVE, blue5.getSymbol());
    assertEquals(Symbol.SIX, green6.getSymbol());
    assertEquals(Symbol.SEVEN, yellow7.getSymbol());
    assertEquals(Symbol.SKIP, redSkip.getSymbol());
    assertEquals(Symbol.INVERT, blueInvert.getSymbol());
    assertEquals(Symbol.DRAW_TWO, greenDrawTwo.getSymbol());
  }

  @Test
  public void testIsDiscardable() {
    assertTrue(red4.isDiscardable());
    assertTrue(blue5.isDiscardable());
    assertTrue(green6.isDiscardable());
    assertTrue(yellow7.isDiscardable());
    assertTrue(redSkip.isDiscardable());
    assertTrue(blueInvert.isDiscardable());
    assertTrue(greenDrawTwo.isDiscardable());
  }

}
