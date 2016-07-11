
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import java.util.Random;


public class KnapsackSolver {
	private int capacity;
	private ArrayList<Knapsack> Items ;
	private int elements;
	public KnapsackSolver(int Item, int cap)
	{
		capacity=cap;
		elements=Item;
		Items=new ArrayList<Knapsack>(Item);
	}
	public void random_Items()
	{
		int v,w;
		Random rad = new Random();
		for(int i=0;i<elements;i++)
		{
			w=rad.nextInt(capacity/2);
			v=rad.nextInt(20);
			Knapsack e=new Knapsack(w,v);
			Items.add(e);
		}
	}
	public void display()
	{
		for(int i=0;i<elements;i++)
		{
			Items.get(i).display();
		}
	}
 	public List<List<Knapsack>> powerset2()
	{
		List<List<Knapsack>> powerset=new ArrayList<List<Knapsack>>();
		int elements=Items.size();
		int set_size=(int) Math.pow(2, elements);
		for(int i=0;i<set_size;i++)
		{
			String binary=intToBinary(i,elements);
			List<Knapsack> innerSet=new ArrayList<Knapsack>();
			for(int j=0;j<binary.length();j++)
			{
				if(binary.charAt(j)=='1')
					innerSet.add(Items.get(j));
			}
			powerset.add(innerSet);
		}
		return powerset;
	}
	public String intToBinary(int i,int elements)
	{
		String binary=Integer.toBinaryString(i);
		int foundDigits=binary.length();
		String reverse=binary;
		for(int j=foundDigits;j<elements;j++)
			reverse="0"+reverse;
		return reverse;
	}
	public int knapsack()
	{
		List<Knapsack> result= new ArrayList<Knapsack>();
		int best_value=0;
		int best_weight=0;
		
		List<List<Knapsack>> power= powerset2();
		for(List<Knapsack> item: power)
		{
			int set_weight=0;
			int set_value=0;
			for(Knapsack e:item)
			{
				set_weight=set_weight+e.weight();
				set_value=set_value+e.value();
				if(set_value>best_value & set_weight<=capacity)
				{
					best_value=set_value;
					best_weight=set_weight;
					result=item;
				}
			}
		}
		return best_weight;
	}
	public void solve()
	{
		int VD[][]=new int[elements+1][capacity+1];
		for(int col=0;col<=capacity;col++)
			VD[0][col]=0;
		for(int row=0;row<=elements;row++)
			VD[row][0]=0;
		for(int items=1;items<=elements;items++)
		{
			for(int weigths=1;weigths<=capacity;weigths++)
			{
				if(Items.get(items-1).weight()<=weigths)
				{
					VD[items][weigths]=Math.max(Items.get(items-1).value()+VD[items-1][weigths-Items.get(items-1).weight()], VD[items-1][weigths]);
				}
				else
				{
					VD[items][weigths]=VD[items-1][weigths];
				}
			}
		}
		System.out.println(VD[elements][capacity]);
	}
	public int recursive_solve(int cap,int[] wt, int[] val, int items)
	{
	if(items ==0 || cap ==0)
		return 0;
	if(wt[items-1]>cap)
		return recursive_solve(cap,wt,val,items-1);
	else
		return Math.max(val[items-1]+recursive_solve(cap-wt[items-1],wt,val,items-1), recursive_solve(cap,wt,val,items-1));
	}
	public static void main(String args[])
	{
		int max_c=10;
		int items=4;
		int[] wt={4,5,6,3};
		int[] val={4,8,7,9};
		KnapsackSolver ks = new KnapsackSolver(items,max_c);
		ks.random_Items();
		ks.display();
		ks.powerset2();
		int  result=ks.recursive_solve(max_c, wt, val, items);
		System.out.println(result);
		//ks.solve();
	}
}
