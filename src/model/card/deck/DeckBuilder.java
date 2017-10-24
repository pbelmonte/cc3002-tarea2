package model.card.deck;

import model.card.CardPile;
import model.card.ICardPile;
import model.card.type.Color;
import model.card.type.DrawFourCard;
import model.card.type.DrawTwoCard;
import model.card.type.ICard;
import model.card.type.InvertCard;
import model.card.type.NumberCard;
import model.card.type.SkipCard;
import model.card.type.Symbol;
import model.card.type.WildCard;

/**
 * Deck builder to create the deck.
 * 
 * @author Pedro Belmonte
 *
 */
public class DeckBuilder implements IDeckBuilder {

  private ICardPile deck;
  private Color[] colors;
  private Symbol[] numbers;

  /**
   * DeckBuilder constructor.
   */
  public DeckBuilder() {
    deck = new CardPile();
    colors = Color.getColors();
    numbers = Symbol.getNumeric();
  }

  @Override
  public ICardPile build() {
    return deck;
  }

  @Override
  public IDeckBuilder addNumericCards() {
    for (int i = 0; i < colors.length; i++) {
      for (int j = 0; j < numbers.length; j++) {
        deck.pushCard(new NumberCard(colors[i], numbers[j]));
        if (j != 0) {
          deck.pushCard(new NumberCard(colors[i], numbers[j]));
        }
      }
    }
    return this;
  }

  @Override
  public IDeckBuilder addActionCards() {
    for (int i = 0; i < colors.length; i++) {
      deck.pushCard(new SkipCard(colors[i]));
      deck.pushCard(new SkipCard(colors[i]));
      deck.pushCard(new DrawTwoCard(colors[i]));
      deck.pushCard(new DrawTwoCard(colors[i]));
      deck.pushCard(new InvertCard(colors[i]));
      deck.pushCard(new InvertCard(colors[i]));
    }
    return this;
  }

  @Override
  public IDeckBuilder addWildCards() {
    for (int i = 0; i < 4; i++) {
      deck.pushCard(new WildCard());
      deck.pushCard(new DrawFourCard());
    }
    return this;
  }

  @Override
  public IDeckBuilder addCard(ICard card) {
    deck.pushCard(card);
    return this;
  }

}
