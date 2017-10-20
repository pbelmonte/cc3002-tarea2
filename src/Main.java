import controller.ConsoleController;
import model.IGameLogic;
import model.player.IPlayerListBuilder;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop
 * while the game hasn't ended.
 * @author Pedro Belmonte
 *
 */
public class Main {

  public static void main(String[] args) {
    IPlayerListBuilder playerBuilder;
    //TODO: Create one human player and 3 random players
    //TODO: Assign the players to playerBuilder.
    IGameLogic game = null;
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }
}
