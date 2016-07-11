
public class EnemyAdapter implements EnemyAttacker{

	private EnemyRobot robot;
	
	public EnemyAdapter(EnemyRobot rob) {
		robot = rob;
	}
	@Override
	public void fireWeapon(String name) {
		// TODO Auto-generated method stub
		robot.fightWithHands(name);
	}

	@Override
	public void moveForward(String name) {
		// TODO Auto-generated method stub
		robot.movesForwardRobot(name);
	}

	@Override
	public void assignDriver(String driverName) {
		// TODO Auto-generated method stub
		robot.fightDriver(driverName);
	}

	
}
