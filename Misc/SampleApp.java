import java.util.Arrays;


public class SampleApp {
		public static void main(String args[])
		{
			int length=20;
			Sample ss;
			ss=new Sample(length);
			ss.insert(10);
			ss.insert(20);
			ss.insert(30);
			ss.insert(25);
			ss.insert(56);
			ss.insert(40);
			ss.insert(70);
			ss.insert(35);
			ss.insert(30);
			ss.insert(30);
			ss.display();
			ss.search(25);
			ss.search(20);
			//ss.delete(50);
			//ss.delete(10);
			ss.display();
			/*int[] arr=new int[length];
			int i=0;
			while(ss.getMax()!=-1)
			{
				arr[i]=ss.getMax();
				ss.removeMax(arr[i]);
				i++;
			}
			System.out.println(Arrays.toString(arr));*/
			ss.nodup(30);
			ss.display();
			ss.InsertionSort();
			ss.display();
		}
	}

