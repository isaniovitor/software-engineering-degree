import java.util.List;

public class Screen {

  //intro
  public void intro() {
		System.out.println("This is the classic Snake & Ladders");
  }

  public void qtdPlayers() {
		System.out.println("Alright, how many players are there ?");
  }

  //Ladders & snakes 
  public void nearestSL(Player player, List<Snake> snakes, List<Ladder> ladders) {
		int currentPosition = player.tile.tileCoordinate;
		int nearest = 101;
		int dif;

		System.out.println(player.name + " is at Tile no. " + currentPosition);

		for (Snake i : snakes) {
			dif = i.tileOnHead.tileCoordinate;

			if ((dif < nearest) && ((dif - currentPosition) > 0))
				nearest = dif;
		}

		System.out.println(nearest != 101 ? player.name + "'s nearest snake is at " + nearest : "");
		nearest = 101;

		for (Ladder i : ladders) {
			dif = i.tileOnTail.tileCoordinate;

			if ((dif < nearest) && ((dif - currentPosition) > 0))
				nearest = dif;
		}

		System.out.println(nearest != 101 ? player.name + "'s nearest ladder is at " + nearest : "");
	}
  
}

