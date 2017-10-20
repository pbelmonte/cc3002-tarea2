package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

public class PlayerManager implements IPlayerManager {
  
  private IPlayer currentPlayer;
  private ArrayList<IPlayer> playerList;
  private IPlayerListBuilder listBuilder;
  
  public PlayerManager() {
    listBuilder = new PlayerListBuilder();
    playerList = listBuilder.buildPlayerList();
    currentPlayer = playerList.get((int) Math.floor(Math.random() * playerList.size()));
  }

  @Override
  public IPlayer getCurrentPlayer() {
    return this.currentPlayer;
  }

  @Override
  public ArrayList<IPlayer> getPlayers() {
    return this.playerList;
  }

  @Override
  public void invertDirection() {
        
  }

  @Override
  public void startTurn() {
        
  }

  @Override
  public void skipPlayer() {
    // TODO Auto-generated method stub
    
  }

}
