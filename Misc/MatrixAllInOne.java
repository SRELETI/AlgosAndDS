import java.util.Arrays;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class MatrixAllInOne {

	/*
	 * Search for a element in a row wise and column wise sorted array
	 */
	public void searchRowColSorted(int[][] arr, int val) {
		if(arr==null || arr.length==0) return;
		int row = arr.length;
		int col = arr[0].length;
		int i=0;
		int j=col-1;
		while(i<row && j>=0) {
				if(arr[i][j]==val) {
					System.out.println("Element found at "+(i+1)+" row and "+(j+1)+" column");
					return;
				}
				else if(arr[i][j]<val)
					i++;
				else
					j--;
		}
	}
	
	/*
	 * Print a matrix in spiral form
	 */
	public void printSpiral(int[][] arr) {
		if(arr==null || arr.length==0) return;
		int startR = 0;
		int endR = arr.length;
		int startC = 0;
		int endC = arr[0].length;
		int iterator;
		while(startR<endR && startC<endC) {
			iterator = startC;
			while(iterator<endC) {
				System.out.print(arr[startR][iterator]+" ");
				iterator++;
			}
			startR++;
			iterator = startR;
			while(iterator<endR) {
				System.out.print(arr[iterator][endC-1]+" ");
				iterator++;
			}
			endC--;
			if(startR<endR) {
				iterator = endC-1;
				while(iterator>=startC) {
					System.out.print(arr[endR-1][iterator]+" ");
					iterator--;
				}
				endR--;
			}
			if(startC<endC) {
				iterator = endR-1;
				while(iterator>=startR) {
					System.out.print(arr[iterator][startC]+" ");
					iterator--;
				}
				startC++;
			}
		}
	}
	
	
	/*
	 * Boolean Matrix 
	 */
	public void booleanMatrix(int[][] mat) {
		if(mat==null || mat.length==0) return;
		boolean rowFlag = false;
		boolean colFlag = false;
		for(int i=0;i<mat.length;i++) {
			if(mat[i][0]==1) {
				rowFlag = true;
				break;
			}
		}
		for(int j=0;j<mat[0].length;j++) {
			if(mat[0][j]==1) {
				colFlag = true;
				break;
			}
		}
		for(int i=1;i<mat.length;i++) {
			for(int j=1;j<mat[i].length;j++) {
				if(mat[i][j]==1) {
					mat[i][0] = 1;
					mat[0][j] = 1;
				}
			}
		}
		
		for(int i=1;i<mat.length;i++) {
			for(int j=1;j<mat[i].length;j++) {
				if(mat[i][0]==1 || mat[0][j]==1) {
					mat[i][j] =1;
				}
			}
		}
		
		if(rowFlag) {
			for(int i=0;i<mat.length;i++) {
				mat[i][0] = 1;
			}
		}
		if(colFlag) {
			for(int j=0;j<mat[0].length;j++) {
				mat[0][j] = 1;
			}
		}
		
		System.out.println(Arrays.deepToString(mat));
	}
	
	/*
	 * Maximum size sqaure sub matrix with all 1s
	 */
	public void maxSum(int[][] max) {
		if(max == null || max.length==0) return;
		int[][] sum = new int[max.length][max[0].length];
		for(int i=0;i<max.length;i++) {
			sum[i][0] = max[i][0];
		}
		for(int j=0;j<max[0].length;j++) {
			sum[0][j] = max[0][j];
		}
		
		for(int i=1;i<max.length;i++) {
			for(int j=1;j<max[i].length;j++) {
				if(max[i][j]==1)
					sum[i][j] = min(sum[i-1][j],sum[i][j-1],sum[i-1][j-1])+1;
				else
					sum[i][j]=0;
			}
		}
		
		int maxSize = 0;
		int max_i = -1;
		int max_j = -1;
		
		for(int i=0;i<max.length;i++) {
			for(int j=0;j<max[i].length;j++) {
				if(sum[i][j]>maxSize) {
					maxSize = sum[i][j];
					max_i = i;
					max_j = j;
				}
			}
		}
	
	//	System.out.println(max_i+" "+max_j+" "+maxSize);
		for(int i=max_i;i>max_i-maxSize;i--) {
			for(int j=max_j;j>max_j-maxSize;j--) {
				System.out.print(max[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	private int min(int a,int b,int c) {
		return Math.min(a, Math.min(b,c));
	}
	
	/*
	 * Print Unique rows in a array
	 */
	public void uniqueRows(int[][] arr) {
		if(arr==null || arr.length==0) return;
		System.out.println(Arrays.toString(arr[0]));
		for(int i=1;i<arr.length;i++) {
			int[] row = arr[i];
			int j=0;
			for( j=0;j<i;j++) {
				int[] upperRow = arr[j];
				if(checkXORSame(row,upperRow))
					break;
			}
			if(j==i) 
				System.out.println(Arrays.toString(arr[i]));
		}
	}
	
	private boolean checkXORSame(int[] arr1, int[] arr2) {
		for(int i=0;i<arr1.length;i++) {
			if((arr1[i]^arr2[i])!=0) 
				return false;
		}
		return true;
	}
	
	/*
	 * Print Matrix Diagonally
	 */
	public void printDiagonally(int[][] arr) {
		for(int row=0;row<arr.length;row++) {
			for(int i=row,j=0;i>=0 && j<arr[row].length;i--,j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		for(int col=1;col<arr[0].length;col++) {
			for(int i=arr.length-1,j=col;j<arr[0].length && i>=0;i--,j++) 
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
	}
	
	
	/*
	 * Transpose a m/n matrix.
	 */
	
	
	/*
	 * Max SubArr
	 */
	public void maxSubArr(int[][] arr) {
		if(arr==null || arr.length==0) return;
		int maxSum =Integer.MIN_VALUE;
		int maxLeft = -1;
		int maxRight = -1;
		int maxStart = -1;
		int maxEnd = -1;
		for(int i=0;i<arr[0].length;i++) {
			int[] tmp = new int[arr.length];
			for(int j=i;j<arr[0].length;j++) {
				for(int k=0;k<arr.length;k++) 
					tmp[k] = tmp[k]+arr[k][j];
				Wrapper_SF sf = new Wrapper_SF();
				int sum = kadane(tmp,sf);
				if(sum>maxSum) {
					maxSum = sum;
					maxLeft = i;
					maxRight = j;
					maxStart = sf.start;
					maxEnd = sf.finish;
				}
			}
		}
		
		System.out.println("Mx subarr is "+maxLeft+" "+maxRight+" "+maxStart+" "+maxEnd+" "+maxSum);
	}
	
	public int kadane(int[] arr, Wrapper_SF sf) {
		int cur_sum = arr[0];
		sf.start = 0;
		int max_sum = arr[0];
		sf.finish = 0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>cur_sum+arr[i]) {
				cur_sum = arr[i];
				sf.start = i;
			}
			else
				cur_sum = cur_sum+arr[i];
			
			if(cur_sum>max_sum) {
				sf.finish = i;
				max_sum = cur_sum;
			}
		}
		return max_sum;
	}
	
	/*
	 * Create matrix with alternating rectangles of O and X
	 */
	public void createRectangle(int m, int n) {
		if(m<=0 && n<=0) return;
		char[][] rec = new char[m][n];
		int iterator;
		int startR = 0;
		int endR = m;
		int startC = 0;
		int endC = n;
		boolean isX = false;
		while(startR<endR && startC<endC) {
			isX = !isX;
			iterator = startC;
			while(iterator<endC) {
				rec[startR][iterator] = isX ? 'X':'O';
				iterator++;
			}
			startR++;
			
			iterator = startR;
			while(iterator<endR) {
				rec[iterator][endC-1] = isX ? 'X':'O';
				iterator++;
			}
			endC--;
			
			if(startR<endR) {
				iterator = endC-1;
				while(iterator>=startC) {
					rec[endR-1][iterator] = isX ? 'X':'O';
					iterator--;
				}
				endR--;
			}
			if(startC<endC) {
				iterator = endR-1;
				while(iterator>=startR) {
					rec[iterator][startC] = isX ? 'X':'O';
					iterator--;
				}
				startC++;
			}
		}
		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(rec[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/*
	 * Row with max 1's
	 */
	public void max1sRow(int[][] arr) {
		if(arr==null || arr.length==0) return;
		int j= arr[0].length-1;
		int maxRow = -1;
		for(int i=0;i<arr.length;i++) {
			while(j>=0 && arr[i][j]==1) {
				j--;
				maxRow = i;
			}
		}
		System.out.println("The max row is "+maxRow);
	}
	
	/*
	 * Print Elements in a rowwise and columnwise sorted array
	 */
	public void rowColSortedPrint(int[][] arr) {
		for(int i=0;i<arr.length*arr[0].length;i++) {
			System.out.print(extractMin(arr)+" ");
		}
	}
	
	private int extractMin(int[][] arr) {
		int val  = arr[0][0];
		arr[0][0] = Integer.MAX_VALUE;
		yognify(arr,0,0);
		return val;
	}
	
	private void yognify(int[][] arr, int i, int j) {
		int dwnVal = i+1<arr.length ? arr[i+1][j] : Integer.MAX_VALUE;
		int rigtVal = j+1<arr.length ? arr[i][j+1] : Integer.MAX_VALUE;
		
		if(dwnVal==Integer.MAX_VALUE && rigtVal == Integer.MAX_VALUE) 
			return;
		
		if(dwnVal<rigtVal) {
			arr[i][j] = dwnVal;
			arr[i+1][j] = Integer.MAX_VALUE;
			yognify(arr,i+1,j);
		}
		else{
			arr[i][j] = rigtVal;
			arr[i][j+1] = Integer.MAX_VALUE;
			yognify(arr,i,j+1);
		}
	}
	
	/*
	 * Find sum of all k*k sub matrices.
	 */
	public void sumOfSubMatrix(int[][] arr,int k) {
		for(int i=0;i<=arr.length-k;i++) {
			for(int j=0;j<=arr[i].length-k;j++) {
				int sum = 0;
				for(int p=i;p<k+i;p++) {
					for(int q=j;q<k+j;q++) {
						sum = sum + arr[p][q];
					}
				}
				System.out.print(sum+" ");
			}
			System.out.println();
		}
	}
	
	public void sumOfSubMatrix2(int[][] arr, int k) {
		if(arr==null || arr.length==0) return;
		int[][] sum = new int[arr.length-k+1][arr[0].length];
		
		for(int j=0;j<arr[0].length;j++) {
			int sum_val = 0;
			for(int i=0;i<k;i++) 
				sum_val += arr[i][j];
			sum[0][j] = sum_val;
			for(int i=1;i<=arr.length-k;i++) {
				sum_val += (arr[i+k-1][j] - arr[i-1][j]);
				sum[i][j] = sum_val;
			}
		}
		
		for(int i=0;i<sum.length;i++) {
			int sum_val=0;
			for(int j=0;j<k;j++) {
				sum_val += sum[i][j];
			}
			System.out.print(sum_val+" ");
			for(int j=1;j<=arr[0].length-k;j++) {
				sum_val += (sum[i][j+k-1]-sum[i][j-1]);
				System.out.print(sum_val+" ");
			}
			System.out.println();
		}
		return;
	}
	
	
	/*
	 * Numbr of Islands
	 */
	public void countIslands(char[][] arr) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]=='X') {
					if((i==0 || arr[i-1][j]=='O') && (j==0 || arr[i][j-1]=='O')) 
						count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public void findElementInSorted(int[][] arr) {
		if(arr==null || arr.length==0) return;
		int[] colMin = new int[arr.length];
		int min_row = 0;
		for(int i=0;i<colMin.length;i++) {
			colMin[i] = arr[0].length-1;
		}
		while(colMin[min_row]>=0) {
			for(int i=0;i<arr.length;i++) {
				if(arr[i][colMin[i]]<arr[min_row][colMin[min_row]]) {
					min_row = i;
				}
			}
			int equal = 0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i][colMin[i]]>arr[min_row][colMin[min_row]]) {
					if(colMin[i]==0) {
						System.out.println("No Element found ");
						return;
					}
					colMin[i] -= 1;
				}
				else 
					equal++;
			}
			if(equal==arr.length) {
				System.out.println(arr[min_row][colMin[min_row]]);
				return;
			}
		}
	}
	
	/*
	 * Replace 'O'(single or group of 'O') with 'X' if surrounded by 'X'
	 */
	public void replaceOX(char[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(arr[i][j]=='O')
					arr[i][j]='-';
			}
		}
		
		for(int i=0;i<arr.length;i++) {
			floodFill(arr,i,0,'-','O');
			floodFill(arr,i,arr[0].length-1,'-','O');
		}
		for(int j=0;j<arr[0].length;j++) {
			floodFill(arr,0,j,'-','O');
			floodFill(arr,arr.length-1,j,'-','O');
		}
		for(int i=0;i<arr.length;i++) {
			
		}
		for(int j=0;j<arr[0].length;j++) {
			
		}
		
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(arr[i][j]=='-') 
					arr[i][j]='X';
			}
		}
		
		System.out.println(Arrays.deepToString(arr));
	}
	
	private void floodFill(char[][] arr, int i, int j, char prev, char newVal) {
		if(i<0 || i>arr.length-1 || j<0 || j>arr[0].length-1)
			return;
		if(arr[i][j]!=prev) return;
		arr[i][j] = newVal;
		floodFill(arr,i-1,j,prev,newVal);
		floodFill(arr,i,j-1,prev,newVal);
		floodFill(arr,i+1,j,prev,newVal);
		floodFill(arr,i,j+1,prev,newVal);
	}
	
	/*
	 * IN Place algorithm for string transformation or matrix transpose
	 */
	public void inPlace(char[] arr) {
		int lenRem = arr.length;
		int shift =0 ;
		int lenFirst;
		while(lenRem>0) {
			int k=0;
			while(Math.pow(3, k)+1<=lenRem) 
				k++;
			lenFirst = (int)Math.pow(3, k-1)+1;
			lenRem -= lenFirst;
			cycleLeader(arr,shift,lenFirst);
			
			reverse(arr,shift/2,shift-1);
			reverse(arr,shift,shift+lenFirst/2-1);
			reverse(arr,shift/2,shift+lenFirst/2-1);
			shift += lenFirst;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	private void cycleLeader(char[] arr, int shift, int len) {
		for(int i=1;i<len;i=i*3) {
			int j = i;
			char item = arr[j+shift];
			do {
				if(j%2!=0) {
					j = len/2 + j/2;
				}
				else {
					j = j/2;
				}
				char temp = item;
				item = arr[j+shift];
				arr[j+shift] = temp;
			}while(j!=i);
		}
	}
	
	
	private void swap(char a, char b) {
		char temp=a;
		a = b;
		b=temp;
	}
	
	private void reverse(char[] arr, int left, int right) {
		while(left<right) {
			char temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}
	
	/*
	 * Get sum between two positions in O(1) time
	 */
	public int getSum(int[][] arr, int[][] sum,int x1, int y1, int x2, int y2) {
		return sum[x2][y2]- (y1>0 ? sum[x2][y1-1]:0) - (x1>0? sum[x1-1][y2]:0) + ((x1>0 && y1>0) ? sum[x1-1][y1-1]:0);
	}
	
	private void preProcess(int[][] sum, int[][] arr) {
		sum[0][0] = arr[0][0];
		for(int col=1;col<arr[0].length;col++) {
			sum[0][col] = sum[0][col-1] + arr[0][col]; 
		}
		for(int row=1;row<arr.length;row++) {
			sum[row][0] = sum[row-1][0]+arr[row][0];
		}
		
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<arr[0].length;j++) {
				sum[i][j] = arr[i][j]+sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1];
			}
		}
		
	}
	
	/*
	 * Print matrix in described form
	 */
	public void changeOrder(int[][] arr) {
		int[][] b = new int[arr.length][arr[0].length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i%2==0)
					b[j][i] = arr[i][j];
				else
					b[j][i] = arr[i][arr[0].length-1-j];
			}
		}
		System.out.println(Arrays.deepToString(b));
	}
	
	/*
	 * Transpose
	 */
	public void transpose(int[][] arr) {
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				swap(arr,i,j);
			}
		}
		System.out.println(Arrays.deepToString(arr));
	}
	
	private void swap(int[][] arr,int i,int j) {
		int temp= arr[i][j];
		arr[i][j] = arr[j][i];
		arr[j][i] = temp;
	}
	
	/*
	 * Find the occurence of a word in a matrix
	 */
	public void findOcc(char[][] arr, String word) {
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr[0].length;j++) {
				findWords(arr,i,j,0,"",word);
			}
		}
	}
	
	private void findWords(char[][] arr,int i, int j, int idx, String positions, String word) {
		if(i<0 || i>arr.length-1 || j<0 || j>arr[0].length-1)
			return;
		if(arr[i][j]!=word.charAt(idx))
			return;
		positions += word.charAt(idx)+" - ["+i+","+j+"]";
		
		if(idx<word.length()-1) {
			findWords(arr,i-1,j-1,idx+1,positions,word);
			findWords(arr,i-1,j,idx+1,positions,word);
			findWords(arr,i-1,j+1,idx+1,positions,word);
			findWords(arr,i,j-1,idx+1,positions,word);
			findWords(arr,i,j+1,idx+1,positions,word);
			findWords(arr,i+1,j-1,idx+1,positions,word);
			findWords(arr,i+1,j,idx+1,positions,word);
			findWords(arr,i+1,j+1,idx+1,positions,word);
		}
		else {
			System.out.println(positions);
		}
	}
	
	public int maxSumPath(int[][] arr) {
		int row = arr.length-1;
		int col = arr[0].length-1;
		for(int i=row;i>=0;i--) {
			for(int j=col;j>=0;j--) {
				if(i==row && j==col) {
					arr[i][j] = arr[i][j];
				}
				else if(i==row && j!=col) {
					arr[i][j] = arr[i][j] + arr[i][j+1];
				}
				else if(i!=row && j==col) {
					arr[i][j] = arr[i][j] + arr[i+1][j];
				}
				else {
					arr[i][j] = arr[i][j]+ Math.max(arr[i+1][j], arr[i][j+1]);
				}
			}
		}
		return arr[0][0];
	}
	
	
	public static void main(String args[]) {
		MatrixAllInOne mat = new MatrixAllInOne();
		char[][] arr = {{'X', 'O', 'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'X'},
                {'O', 'X', 'X', 'X', 'X', 'X'},
                {'X', 'X', 'X', 'O', 'X', 'O'},
                {'O', 'O', 'X', 'O', 'O', 'O'},
               };
		char[] arr2 = {'a','1','b','2','c','3','d','4','e','5','f','6','g','7'};
	//	mat.searchRowColSorted(arr, 29);
	//	mat.printSpiral(arr);
	//	mat.booleanMatrix(arr);
	//	mat.maxSum(arr);
	//	mat.uniqueRows(arr);
	//	mat.printDiagonally(arr);
	//	mat.maxSubArr(arr);
	//	mat.createRectangle(6, 7);
	//	mat.max1sRow(arr);
	//	mat.rowColSortedPrint(arr);
	//	mat.sumOfSubMatrix2(arr, 3);
	//	mat.countIslands(arr);
	//	mat.replaceOX(arr);
	//	mat.inPlace(arr2);
		int[][] arr3 = {{1,2,3},{4,5,6},{7,8,9}};
		int[][] sum = new int[arr3.length][arr3[0].length];
		char[][] arr4 = {{'A','N','L','Y','S'},{'I','S','D','E','S'},{'I','G','N','D','E'}};
	//	mat.changeOrder(arr3);
	//	mat.transpose(arr3);
	//	mat.preProcess(sum, arr3);
	//	System.out.println(mat.getSum(arr3, sum, 0, 2, 2, 4));
	//	mat.findOcc(arr4, "DES");
	}
}



class Wrapper_SF {
	public int start =-1;
	public int finish =-1;
}
