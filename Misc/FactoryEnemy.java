
public class FactoryEnemy {

	EnemyShip enemy;
	public FactoryEnemy() {
		enemy = null;
	}
	
	public EnemyShip getEnemyShip(String option) {
		if(option.equals("U")) 
			enemy = new UFOEnemyShip();
		else if(option.equals("Ind"))
			enemy = new IndianArmy();
		return enemy;
	}
}
