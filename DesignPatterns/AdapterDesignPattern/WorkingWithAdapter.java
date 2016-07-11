
public class WorkingWithAdapter {

	public static void main(String args[]) {
		EnemyAttacker tank = new EnemyTank();
		EnemyRobot robot = new EnemyRobot();
		
		EnemyAttacker roboTank = new EnemyAdapter(robot);
		
		System.out.println("Tank: ");
		tank.fireWeapon("sam");
		tank.moveForward("sam");
		tank.assignDriver("sam");
		
		System.out.println("Robot: ");
		robot.fightWithHands("roboSam");
		robot.movesForwardRobot("roboSam");
		robot.fightDriver("roboSam");
		
		System.out.println("RoboTank: ");
		
		roboTank.fireWeapon("roboTankSam");
		roboTank.moveForward("roboTankSam");
		roboTank.assignDriver("roboTankSam");
		
	}
}
