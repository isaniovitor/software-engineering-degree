public abstract class Obstacle {
	Tile tileOnHead;
	Tile tileOnTail;

	void setTiles(Tile tileOnHead, Tile tileOnTail) {
		this.tileOnHead = tileOnHead;
		this.tileOnTail = tileOnTail;
	}

	public abstract void pull(Player p);
}