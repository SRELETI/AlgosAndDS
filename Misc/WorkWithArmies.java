import java.util.Scanner;


public class WorkWithArmies {

	public static void main(String args[]) {
		EnemyShip enemy = null;
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the enemy name: ");
		String name = s.nextLine();
		FactoryEnemy f  = new FactoryEnemy();
		enemy = f.getEnemyShip(name);
		if(enemy!=null) {
			doSomething(enemy);
		}
	}
	
	public static void doSomething(EnemyShip enemy) {
		enemy.followHero();
		enemy.destroyed();
	}
}
