package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

/**
 * Manager for the logic of the player list.
 * 
 * @author Pedro Belmonte
 *
 */
public class PlayerManager implements IPlayerManager {

  private IPlayer currentPlayer;
  private ArrayList<IPlayer> playerList;
  private Direction direction;
  private int currentPlayerNumber;
  private int nextPlayerNumber;

  /**
   * PlayerManager constructor. Builds the playerList obtained from the PlayerListBuilder and
   * initializes the current player, the next player and the direction of the game.
   * 
   * @param playerBuilder
   */
  public PlayerManager(IPlayerListBuilder playerBuilder) {
    playerList = playerBuilder.buildPlayerList();
    currentPlayerNumber = (int) Math.floor(Math.random() * playerList.size());
    currentPlayer = playerList.get((currentPlayerNumber + 1) % playerList.size());
    direction = Direction.COUNTERCLOCKWISE;
    nextPlayerNumber = (currentPlayerNumber + 1) % playerList.size();
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return currentPlayer;
  }

  @Override
  public ArrayList<IPlayer> getPlayers() {
    return playerList;
  }

  @Override
  public void invertDirection() {
    if (getPlayers().size() > 2) {
      direction = (direction.getValue() == -1) ? Direction.COUNTERCLOCKWISE : Direction.CLOCKWISE;
      int aux = currentPlayerNumber + direction.getValue();
      aux = (aux >= 0) ? aux : playerList.size() + aux;
      nextPlayerNumber = aux % playerList.size();
    } else {
      skipPlayer();
    }
  }

  @Override
  public void startTurn() {
    currentPlayerNumber = nextPlayerNumber;
    int aux = currentPlayerNumber + direction.getValue();
    aux = (aux >= 0) ? aux : playerList.size() + aux;
    nextPlayerNumber = aux % playerList.size();
    currentPlayer = playerList.get(currentPlayerNumber);
  }

  @Override
  public void skipPlayer() {
    /*int aux = currentPlayerNumber + 2 * direction.getValue();
    aux = (aux >= 0) ? aux : playerList.size() + aux;
    nextPlayerNumber = aux % playerList.size();*/
    startTurn();
  }

  /**
   * Returns the direction of the game.
   * 
   * @return Actual direction
   */
  public Direction getDirection() {
    return direction;
  }

}
