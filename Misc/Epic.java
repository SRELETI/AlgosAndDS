import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class Epic {

	public void getRobotSteps(int[][] arr) {
		if(arr==null || arr.length==0) return;
		if(arr[0][0]==0)
			return;
		int[][] dp = new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]==0)
					dp[i][j] = Integer.MAX_VALUE;
				else if(i==0 && j==0)
					dp[i][j] = 0;
				else if(i==0) 
					dp[i][j] = dp[i][j-1]==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[i][j-1]+1;
				else if(j==0)
					dp[i][j] = dp[i-1][j]==Integer.MAX_VALUE?Integer.MAX_VALUE:dp[i-1][j]+1;
				else 
					dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1])==Integer.MAX_VALUE? Integer.MAX_VALUE:Math.min(dp[i-1][j], dp[i][j-1])+1;
			}
		}
		System.out.println(dp[arr.length-1][arr[0].length-1]);
	}
	
	public void phoneNumbers(String num) {
		Map<Integer,List<Character>> map = new HashMap<Integer,List<Character>>();
		map.put(1,new ArrayList<Character>());
		map.put(2,Arrays.asList('A','B','C'));
		map.put(3, Arrays.asList('D','E','F'));
		map.put(4, Arrays.asList('G','H','I'));
		map.put(5, Arrays.asList('J','K','L'));
		map.put(6, Arrays.asList('M','N','O'));
		map.put(7, Arrays.asList('P','Q','R','S'));
		map.put(8, Arrays.asList('T','U','V'));
		map.put(9, Arrays.asList('W','X','Y','Z'));
		if(num==null || num.length()==0) return;
		String[] nums = num.split("#");
		StringBuilder sb = new StringBuilder("");
		for(String n:nums) {
			int letter = Character.getNumericValue(n.charAt(0));
			int index = n.length()-1;
			sb.append(map.get(letter).get(index));
		}
		System.out.println(sb.toString());
	}
	
	public void printCord(Point start, int area) {
		List<Point> points = getAllPoints(area);
		for(Point point: points) {
			if(point.x!=point.y) {
				Point newPoint = new Point(point.y,point.x);
				findAllRegions(start,newPoint);
			}
			findAllRegions(start,point);
		}
	}
	
	private void findAllRegions(Point start, Point point) {
		Point newPoint = new Point(point.x,point.y);
		pointPrint(start,newPoint);
		
		newPoint = new Point(-point.x,-point.y);
		pointPrint(start,newPoint);
		
		newPoint = new Point(-point.x,point.y);
		pointPrint(start,newPoint);
		
		newPoint = new Point(point.x,-point.y);
		pointPrint(start,newPoint);
	}
	
	private void pointPrint(Point start, Point point) {
		point.x += start.x;
		point.y += start.y;
		
		System.out.print("("+start.x +","+point.y+")");
		System.out.print("("+point.x +","+start.y+")");
		System.out.print("("+point.x +","+point.y+")");
		
		System.out.println();
	}
	private List<Point> getAllPoints(int area) {
		int last = (int)Math.sqrt(area);
		List<Point> points = new LinkedList<Point>();
		for(int i=1;i<=last;i++) {
			if(area%i==0) {
				Point newPoint = new Point(i,area/i);
				points.add(newPoint);
			}
		}
		return points;
	}
	int steps= 0;
	int distanceStart = 0;
	int mul = 1;
	int nextMove = 0;
	int x = 0;
	int y = 0;
	int total = 0;
	boolean direction = true;
	public void glitchMove(int x, int y, int totalSteps) {
		
		while(steps<totalSteps) {
			nextMove = mul*x;
			calTotalMoves();
			calDirectionChange();
			direction = !direction;
			nextMove = mul+x;
			calTotalMoves();
			calDirectionChange();
			direction = !direction;
			mul++;
		}
		System.out.println("Distance from strt "+distanceStart);
	}
	
	
	private void calTotalMoves() {
		if(steps+nextMove>total) {
			nextMove = total-steps;
			steps = total;
		}
		else {
			steps = steps+nextMove;
		}
	}
	
	private void calDirectionChange() {
		int change = nextMove/y;
		int offset = 0;
		if(direction) 
			offset = distanceStart;
		else
			offset = y-distanceStart;
		if((offset+nextMove%y)>=y) 
			change++;
		if(change%2!=0) {
			direction=!direction;
		}
		int newOffset = ((offset+nextMove%y)%y);
		if(direction) 
			distanceStart = newOffset;
		else
			distanceStart = y-newOffset;
	}
	
	public Set<Set<Integer>> printPossibleComb(List<Integer> num) {
		Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
		if(num.isEmpty()) {
			sets.add(new HashSet<Integer>());
			return sets;
		}
		Integer head = num.get(0);
		List<Integer> rest = new ArrayList<Integer>(num.subList(1, num.size()));
		for(Set<Integer> set:printPossibleComb(rest)) {
			Set<Integer> newSet = new HashSet<Integer>();
			newSet.add(head);
			newSet.addAll(set);
			sets.add(newSet);
			sets.add(set);
		}
		return sets;
	}
	
	public int numberOfHits(double hits, double chances, int gamesRem) {
		double presentRatio = hits/chances; 
		System.out.println(presentRatio);
		int totalChances =  (int)(162*(4.5));
		System.out.println(totalChances);
		return (int) ((totalChances-chances)*presentRatio);
	}
	
	/*
	 * Create with values as "epic"
	 */
	public void createBST(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		Node_BST head = constructBSTFromSortArr(content,0,content.length-1);
		display(head);
	}
	
	public void display(Node_BST head) {
		if(head!=null) {
			display(head.left);
			System.out.print(head.data+" ");
			display(head.right);
		}
	}
	
	private Node_BST constructBSTFromSortArr(char[] content, int start, int end) {
		if(end<start) 
			return null;
		int mid = (start+end)/2;
		Node_BST head = new Node_BST(content[mid]);
		head.left = constructBSTFromSortArr(content,start,mid-1);
		head.right = constructBSTFromSortArr(content,mid+1,end);
		return head;
	}
	
	public boolean checkValidPassword(int num1, int num2) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		while(num1>0) {
			int val = num1%10;
			map.put(val, map.containsKey(val)?map.get(val)+1:1);
			num1 = num1/10;
		}
		int missing = Integer.MAX_VALUE;
		while(num2>0) {
			int val = num2%10;
			if(map.containsKey(val) && map.get(val)>0) {
				map.put(val, map.get(val)-1);
			}
			else {
				if(missing==Integer.MAX_VALUE) 
					missing = val;
				else {
					if(missing!=val) 
						return false;
				}
			}
			num2 = num2/10;
 		}
		return true;
	}
	 
	public static void main(String args[]) {
		Epic epic = new Epic();
		int[][] arr = {{1,1,1,1},
				       {1,0,1,1},
				       {1,1,0,1},
				       {1,0,1,1}};
	//	epic.getRobotSteps(arr);
	//	epic.phoneNumbers("22#22");
	//	Point start = new Point(0,0);
	//	epic.printCord(start, 1);
	//	List<Integer> list = Arrays.asList(new Integer[]{1,2,3});
	//	Set<Set<Integer>> set = epic.printPossibleComb(list);
	//	for(Set<Integer> s: set) {
	//		System.out.println(s);
	//	}
	//	System.out.println(epic.numberOfHits(15, 73, 14));
	//	epic.createBST("epic");
		int num2 = 123444456;
		int num1 = 12356;
		System.out.println(epic.checkValidPassword(num1, num2));
		}
	
} 

class Point {
	public int x=0;
	public int y=0;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Node_BST {
	public char data;
	public Node_BST left;
	public Node_BST right;
	
	public Node_BST(char val) {
		data = val;
		left = null;
		right = null;
	}
}

class Node_Word {
	public int x;
	public int y;
	public boolean xMove;
	public boolean yMove;
	public Node_Word(int x, int y) {
		this.x = x;
		this.y = y;
		xMove = false;
		yMove = false;
	}
}