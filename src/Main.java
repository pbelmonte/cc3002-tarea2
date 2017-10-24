import controller.ConsoleController;
import model.GameLogic;
import model.IGameLogic;
import model.card.CardPilesManager;
import model.card.ICardPile;
import model.card.ICardPilesManager;
import model.card.deck.NormalDeck;
import model.player.IPlayerListBuilder;
import model.player.IPlayerManager;
import model.player.PlayerListBuilder;
import model.player.PlayerManager;
import model.player.type.HumanPlayer;
import model.player.type.RandomPlayer;
import view.ConsoleView;

/**
 * Main class of UNO Game
 * 
 * It instantiates model, view and controller and makes the turn loop while the game hasn't ended.
 * 
 * @author Pedro Belmonte
 *
 */
public class Main {

  public static void main(String[] args) {
    ICardPile deck = new NormalDeck().createDeck();
    ICardPilesManager pilesMngr = new CardPilesManager(deck);
    IPlayerListBuilder playerBuilder = new PlayerListBuilder();
    createPlayers(playerBuilder, 1, 1);
    IPlayerManager playerMngr = new PlayerManager(playerBuilder);
    IGameLogic game = new GameLogic(playerMngr, pilesMngr);
    ConsoleView view = new ConsoleView(game);
    ConsoleController ctrl = new ConsoleController(game, view);
    while (!game.hasEnded()) {
      ctrl.playTurn();
    }
    game.announceWinner(ctrl);
  }

  /**
   * Creates the players using the PlayerListBuilder
   * 
   * @param playerBuilder PlayerListBuilder
   * @param humans Amount of human players to create
   * @param virtuals Amount of virtual players to create
   */
  public static void createPlayers(IPlayerListBuilder playerBuilder, int humans, int virtuals) {
    if (humans + virtuals < 2 || humans + virtuals > 10) {
      throw new IllegalArgumentException();
    } else {
      for (int i = 1; i <= humans; i++) {
        playerBuilder.addPlayer(new HumanPlayer(i));
      }
      for (int i = humans + 1; i <= humans + virtuals; i++) {
        playerBuilder.addPlayer(new RandomPlayer(i));
      }
    }
  }

}
