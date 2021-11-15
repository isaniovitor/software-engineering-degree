import java.util.Scanner;

public class Player {
  Scanner sc = new Scanner(System.in);

	final String name;
	int newPos = 0;
  Tile tile;

	Player(String name, Tile tile) {
		this.name = name;
		this.tile = tile;
	}

	void input(Dice dice) {
		System.out.println();
		System.out.println(name + "! Enter anything to roll your die.");
		sc.next();
    
		newPos = dice.roll();
    System.out.println("number: " + newPos);
	}

	int getNewPos() {
		return newPos;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public Tile getTile() {
		return tile;
	}

	public String getName() {
		return name;
	}
}