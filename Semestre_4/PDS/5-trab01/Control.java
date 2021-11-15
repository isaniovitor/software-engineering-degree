import java.util.InputMismatchException;
import java.util.Scanner;

public final class Control {
  private Scanner sc = new Scanner(System.in);
  //boolean exceptionCaught = false;
  Screen screen = new Screen();
  Game game = new Game();

  public Control() {
    intro();
		nameAllotment();
    initGame();
	}

  public void intro() {
		screen.intro();
    screen.qtdPlayers();
		game.numOfPlayers = sc.nextInt();

		// do {
		// 	try {
		// 		screen.qtdPlayers();
		// 		game.numOfPlayers = sc.nextInt();
		// 	}catch (InputMismatchException e) {
		// 		System.out.println("Please enter correctly.");
		// 		exceptionCaught = true;
		// 	}
		// } while (!exceptionCaught);
	}

	public void nameAllotment() {
		String name;

		for (int i = 0; i < game.numOfPlayers; i++) {
			System.out.println("Enter your name, player " + (i + 1));
			name = sc.next();
			Player e = new Player(name, game.board.getBoardMap().get(0));
			game.players.add(e);
		}
	}

  public void initGame() {
    game.game();
  }

}