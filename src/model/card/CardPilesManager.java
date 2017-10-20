package model.card;

import java.util.ArrayList;


import model.card.type.ICard;
import model.player.type.IPlayer;

public class CardPilesManager implements ICardPilesManager {
  
  private ICardPile deck;
  private ICardPile discard;
  
  public CardPilesManager(ICardPile deck) {
    this.deck = deck;
    this.discard = new CardPile();
  }

  @Override
  public void rebuildDeck() {
    ICard first = discard.popCard();
    deck.pushCards(discard);
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
    ArrayList<ICard> cards = new ArrayList<ICard>();
    for (int i = 0; i < cardsNumber; i++) {
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
    ArrayList<ICard> hand = player.getHand();
    ArrayList<ICard> cards = drawCards(number);
    player.addToHand(cards);
    ArrayList<ICard> newHand = player.getHand();
    newHand.removeAll(hand);
    return newHand;
  }

}
