import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NearestLeafNode {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(num.length<=3)
            return l;
        int i,j,k,lk;
        int sum;
        Arrays.sort(num);
        for(i=0;i<num.length-3;i++)
        {
            for(j=i+1;j<num.length-2;j++)
            {
                k = j+1;
                lk = num.length-1;
                while(k<lk)
                {
                    sum = num[i]+num[j]+num[k]+num[lk];
                    if(sum==target)
                    {
                        List<Integer> ll = new ArrayList<Integer>();
                        ll.add(num[i]);
                        ll.add(num[j]);
                        ll.add(num[k]);
                        ll.add(num[lk]);
                        l.add(ll);
                        k++;
                        lk--;
                    }
                    else if(sum<target)
                        k++;
                    else
                        lk--;
                }
            }
        }
        for(i=l.size()-1;i>=1;i--)
        {
            for(j=i-1;j>=0;j--)
            {
            	if((l.get(i).get(0).equals(l.get(j).get(0))) && 
                        (l.get(i).get(1).equals(l.get(j).get(1))) && 
                        (l.get(i).get(2).equals(l.get(j).get(2))) && 
                        (l.get(i).get(3).equals(l.get(j).get(3))))
                {
                    l.remove(j);
                    i--;
                }
            }
        }
        return l;
    }
    
    public static void main(String args[]) {
    	NearestLeafNode n = new NearestLeafNode();
    	int[] arr = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
    	List<List<Integer>> l = n.fourSum(arr, 1682);
    	for(int i=0;i<l.size();i++)
    	{
    		Object[] arr2 = (l.get(i).toArray());
    		for(int j=0;j<arr2.length;j++)
    		{
    			System.out.print(arr2[j]+" ");
    		}
    		System.out.println();
    	}
    }
    
    
    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();
        if(num.length<=2)
            return l;
        Arrays.sort(num);
        int j,k;
        for(int i=0;i<num.length-2;i++)
        {
            j=i+1;
            k = num.length-1;
            while(j<k)
            {
                if(num[i]+num[j]+num[k]==0)
                {
                    ArrayList<Integer> ll = new ArrayList<Integer>();
                    ll.add(num[i]);
                    ll.add(num[j]);
                    ll.add(num[k]);
                    l.add(ll);
                    j++;
                    k--;
                }
                else if(num[i]+num[j]+num[k]<0)
                {
                    j++;
                }
                else
                    k--;
            }
        }
        for(int i=l.size()-1;i>=1;i--)
        {
            for(j=i-1;j>=0;j--)
            {
                if((l.get(i).get(0)==l.get(j).get(0)) && (l.get(i).get(1)==l.get(j).get(1)) && (l.get(i).get(2)==l.get(j).get(2)))
                {
                    l.remove(j);
                    i--;
                }
            }
        }
        
        
        
        return l;
            
    }
}