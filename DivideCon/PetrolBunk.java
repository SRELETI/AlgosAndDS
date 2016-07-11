
class Petrol
{
	int bunk;
	int dist;
	public Petrol(int bun, int dis)
	{
		bunk = bun;
		dist = dis;
	}
}
public class PetrolBunk {

	public void petrol(Petrol[] arr)
	{
		int sum;
		int j;
		for(int i=0;i<arr.length;i++)
		{
			j=i;
			sum =0;
			int count =arr.length;
			while(count>0)
			{
				sum = sum + arr[j].bunk-arr[j].dist;
				if(sum<0)
					break;
				count--;
				j = (j+1)%arr.length;
			}
			if(count==0)
			{
				System.out.println("The Circular tour can be achived by starting at "+i);
				return;
			}
		}
		System.out.println("Nothing found");
	}
	
	public void modified_method(Petrol[] arr)
	{
		int start=0;
		int end=1;
		int cur_sum = arr[0].bunk-arr[0].dist;
		while(end!=start || cur_sum<0)
		{
			while(end!=start && cur_sum<0)
			{
				cur_sum = cur_sum - (arr[start].bunk-arr[start].dist);
				start = (start+1)%arr.length;
				if(start==0)
				{
					System.out.println("not found");
					return;
				}
			}
			cur_sum = cur_sum + arr[end].bunk-arr[end].dist;
			end = (end+1)%arr.length;
		}
		System.out.println("Starts at: "+start);
	}
	
	public static void main(String args[])
	{
		PetrolBunk p = new PetrolBunk();
		Petrol pp = new Petrol(4,6);
		Petrol pp1 = new Petrol(6,5);
		Petrol pp2 = new Petrol(7,3);
		Petrol pp3 = new Petrol(4,5);
		Petrol arr[] = {pp,pp1,pp2,pp3};
		p.petrol(arr);
		p.modified_method(arr);
		
	}
}
