import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Game {
  int numOfPlayers = 0;

  List<Player> players = new ArrayList<Player>();

	Scanner sc = new Scanner(System.in);
  Board board = new Board();
  Screen screen = new Screen();
  Dice dice = new Dice();
	Player player;

  public boolean getWon(int tileCoordinate) {
		  return (tileCoordinate >= 100);
	}

	public void game() {
		outer: do {
			for (int j = 0; j < numOfPlayers; j++) {
				player = players.get(j);
				player.input(dice);
        player.setTile(board.getBoardMap().get(player.getTile().tileCoordinate + player.getNewPos()));
        
				if (getWon(player.getTile().tileCoordinate)) {
          // fazer la no screen
					System.out.println(player.getName() + "! You won!");
					continue outer;
				}

				for (int k = 0; k < Board.NUMBER_OF_SNAKES; k++){
					board.snakes.get(k).pull(player);
					board.ladders.get(k).pull(player);
				}

				screen.nearestSL(player, board.snakes, board.ladders);
			}
		} while (!getWon(player.getTile().tileCoordinate));
		sc.close();
	}
}