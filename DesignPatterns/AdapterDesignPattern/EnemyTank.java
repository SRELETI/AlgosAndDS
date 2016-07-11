
public class EnemyTank implements EnemyAttacker {

	@Override
	public void fireWeapon(String name) {
		// TODO Auto-generated method stub
		System.out.println("Enemy Tank "+name+" fires the weapon ");
	}

	@Override
	public void moveForward(String name) {
		// TODO Auto-generated method stub
		System.out.println("Enemy Tank "+name+" is moving forward ");
	}

	@Override
	public void assignDriver(String driverName) {
		// TODO Auto-generated method stub
		System.out.println("Enemy tank "+driverName+" is assigned a driver ");
	}

	
}
