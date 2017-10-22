package model.player;

import java.util.ArrayList;

import model.player.type.IPlayer;

/**
 * Class to build a player list.
 * 
 * @author Pedro Belmonte
 *
 */
public class PlayerListBuilder implements IPlayerListBuilder {

  private ArrayList<IPlayer> playerList;

  /**
   * PlayerList constructor. Initializes the list.
   */
  public PlayerListBuilder() {
    playerList = new ArrayList<IPlayer>();
  }

  @Override
  public void addPlayer(IPlayer player) {
    playerList.add(player);
  }

  @Override
  public ArrayList<IPlayer> buildPlayerList() {
    return playerList;
  }

}
