
public class QuadraProbeApp {

	public static void main(String args[])
	{
		QuadraProbe q = new QuadraProbe(10);
		
		Hash h = new Hash(2);
		Hash h1 = new Hash(12);
		Hash h2 = new Hash(22);
		Hash h3 = new Hash(32);
		Hash h4 = new Hash(42);
		q.insert(h);
		q.insert(h1);
		q.insert(h2);
		q.insert(h3);
		q.displayHash();
		q.delete(32);
		System.out.println();
		q.displayHash();
		q.insert(h4);
		System.out.println();
		q.displayHash();
	}
}
