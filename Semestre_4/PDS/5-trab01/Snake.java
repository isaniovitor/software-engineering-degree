public final class Snake extends Obstacle {

	@Override
	public void pull(Player p) {
		if (p.getTile().equals(tileOnHead)) {
			System.out.println(p.getName() + " has gone down a snake.");
			p.setTile(tileOnTail);
		}
	}
}
