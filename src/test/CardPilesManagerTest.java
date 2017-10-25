package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.card.CardPilesManager;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.deck.NormalDeck;
import model.card.type.ICard;

public class CardPilesManagerTest {

  private ICardPilesManager pilesMngr;

  @Before
  public void setUp() throws Exception {
    ICardPile deck = new NormalDeck().createDeck();
    pilesMngr = new CardPilesManager(deck);
  }

  @Test
  public void testRebuildDeck() {
    ArrayList<ICard> cards = pilesMngr.drawCards(106);
    assertEquals(1, pilesMngr.getDrawableCardsNumber());
    for (int i = 0; i < 50; i++) {
      pilesMngr.discard(cards.get(i));
    }
    pilesMngr.drawCard();
    assertEquals(50, pilesMngr.getDrawableCardsNumber());
  }

  @Test
  public void testGetDrawableCardsNumber() {
    assertEquals(107, pilesMngr.getDrawableCardsNumber());
    pilesMngr.drawCard();
    assertEquals(106, pilesMngr.getDrawableCardsNumber());
  }

}
