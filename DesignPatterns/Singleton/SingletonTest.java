
public class SingletonTest {

	public static void main(String args[]){
		Singleton instance = Singleton.getInstance();
		
		System.out.println("Instance 1");
		System.out.println(System.identityHashCode(instance));
		System.out.println(instance.getList());
		System.out.println(instance.getTiles(7));
		
		System.out.println("Instance 2");
		
		Singleton instanceTwo = Singleton.getInstance();
		System.out.println(System.identityHashCode(instanceTwo));
		System.out.println(instanceTwo.getList());
		System.out.println(instanceTwo.getTiles(7));
	}
}
