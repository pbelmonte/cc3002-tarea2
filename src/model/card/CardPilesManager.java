package model.card;

import java.util.ArrayList;

import model.card.type.ICard;
import model.player.type.IPlayer;

/**
 * Card piles manager of the game.
 * 
 * @author Pedro Belmonte
 *
 */
public class CardPilesManager implements ICardPilesManager {

  private ICardPile deck;
  private ICardPile discard;

  /**
   * CardPilesManager constructor. It initializes the deck, and the discard pile.
   * 
   * @param deck Deck to be used in the game
   */
  public CardPilesManager(ICardPile deck) {
    this.deck = deck;
    this.deck.shuffle();
    this.discard = new CardPile();
    ICard first = this.drawCard();
    while (!first.isFirstPlayable()) {
      this.deck.pushCard(first);
      this.deck.shuffle();
      first = this.drawCard();
    }
    this.discard(first);
  }

  @Override
  public void rebuildDeck() {
    ICard first = discard.popCard();
    deck.pushCards(discard);
    deck.shuffle();
    discard.pushCard(first);
  }

  @Override
  public ICard drawCard() {
    return deck.popCard();
  }

  @Override
  public int getDrawableCardsNumber() {
    return deck.getSize() + discard.getSize() - 1;
  }

  @Override
  public ArrayList<ICard> drawCards(int cardsNumber) {
    cardsNumber = Math.min(cardsNumber, getDrawableCardsNumber());
    ArrayList<ICard> cards = new ArrayList<ICard>();
    for (int i = 0; i < cardsNumber; i++) {
      if (deck.getSize() == 0) {
        rebuildDeck();
      }
      cards.add(this.drawCard());
    }
    return cards;
  }

  @Override
  public ICard getCurrentPlayedCard() {
    return discard.peekCard();
  }

  @Override
  public void discard(ICard newCard) {
    discard.pushCard(newCard);
  }

  @Override
  public ArrayList<ICard> addCardsToPlayer(IPlayer player, int number) {
    ArrayList<ICard> cards = drawCards(number);
    player.addToHand(cards);
    return cards;
  }

}
