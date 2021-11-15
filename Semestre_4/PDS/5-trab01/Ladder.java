public final class Ladder extends Obstacle {

	@Override
	public void pull(Player p) {
		if (p.getTile() == tileOnTail) {
			System.out.println(p.getName() + " has climbed up a ladder");
			p.setTile(tileOnHead);
		}
	}
}
