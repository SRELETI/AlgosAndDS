
public class TestingFactory {

	public static void main(String args[]) {
		ShipFactory s = new ShipFactory();
		EnemyShips enemy = null;
		enemy = s.makeShip("R");
		if(enemy!=null) {
			doStuff(enemy);
		}
	}
	
	public static void doStuff(EnemyShips enemy) {
		System.out.println(enemy.getName());
		System.out.println(enemy.getAmtDamaged());
		enemy.followHero();
		enemy.shipOnBoard();
		enemy.damagedMade();
	}
}
