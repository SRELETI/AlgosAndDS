

public class InorderLevelApp {

	public static void main(String args[])
	{
		int in[] = {4,8,10,12,14,20,22};
		int level[] = {20,8,22,4,12,10,14};
		
		InorderLevel i = new InorderLevel();
		
		i.constructTree(in, level);
	}
}
