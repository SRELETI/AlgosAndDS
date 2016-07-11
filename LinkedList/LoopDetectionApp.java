import java.sql.Timestamp;


public class LoopDetectionApp {
	public static void main(String args[])
	{
		LoopDetection ld = new LoopDetection();
		ld.addFront(3);
		ld.addFront(2);
		ld.addFront(1);
		ld.addFront(0);
		//ld.head.next.next.next=ld.head.next;
		ld.detectLoop();
		System.out.println(new Timestamp(399));
	}
}
