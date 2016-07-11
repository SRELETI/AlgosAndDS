
public class ShipFactory {

	private EnemyShips ship = null;
	public EnemyShips makeShip(String typeOfShip) {
		
		if(typeOfShip=="U") {
			ship = new UFOEnemyShips();
		}
		else if(typeOfShip=="B") {
			ship = new BigUFOEnemyShips();
		}
		else if(typeOfShip=="R") {
			ship = new RocketEnemyShips();
		}
		return ship;
	}
}
