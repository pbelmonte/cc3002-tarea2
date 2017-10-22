package model.card;

import java.util.Collections;
import java.util.Stack;

import model.card.type.ICard;

/**
 * Card pile logic for the game.
 * 
 * @author Pedro Belmonte
 *
 */
public class CardPile implements ICardPile {

  private Stack<ICard> stack;

  /**
   * CardPile constructor. It initializes the stack.
   */
  public CardPile() {
    stack = new Stack<ICard>();
  }

  @Override
  public int getSize() {
    return stack.size();
  }

  @Override
  public ICard pushCard(ICard newCard) {
    stack.push(newCard);
    return newCard;
  }

  @Override
  public ICard popCard() {
    return stack.pop();
  }

  @Override
  public ICard peekCard() {
    return stack.peek();
  }

  @Override
  public void shuffle() {
    Collections.shuffle(stack);
  }

  @Override
  public boolean isEmpty() {
    return stack.isEmpty();
  }

  @Override
  public void pushCards(ICardPile otherPile) {
    ICardPile aux = new CardPile();
    while (otherPile.getSize() != 0) {
      aux.pushCard(otherPile.popCard());
    }
    while (aux.getSize() != 0) {
      this.pushCard(aux.popCard());
    }
  }

}
