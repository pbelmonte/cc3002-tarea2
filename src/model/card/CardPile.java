package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.deck.DeckStrategy;
import model.card.type.ICard;

public class CardPile implements ICardPile {

  private Stack stack;

  public CardPile() {
    stack = new Stack();
  }

  @Override
  public int getSize() {
    return 0;
  }

  @Override
  public ICard pushCard(ICard newCard) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ICard popCard() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ICard peekCard() {
    return null;
  }

  @Override
  public void shuffle() {
    Collections.shuffle(stack);
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void pushCards(ICardPile otherPile) {
    // TODO Auto-generated method stub

  }

}
