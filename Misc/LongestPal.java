import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class LongestPal {

	public int longest(String s) {
		if(s.length()<=1)
			return 0;
		Stack<Integer> ss = new Stack<Integer> ();
		int maxLength = 0;
		int curLen = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') 
				ss.push(i);
			else
			{
				if(!ss.isEmpty() && s.charAt(ss.peek())=='(')
				{
					ss.pop();
					int lastPos = 0;
					if(!ss.isEmpty())
						lastPos = ss.peek();
					curLen = i-lastPos;
					if(curLen>maxLength) 
						maxLength = curLen;
				}
			}
		}
		return maxLength;
	}
	
public void solveSudoku(char[][] board) {
     List<Integer> arr = getArray(board);
     dfs(board,arr,0);
     
    }

private List<Integer> getArray(char[][] board) {
	List<Integer> l = new ArrayList<Integer>();
	for(int i=0;i<9;i++) {
		for(int j=0;j<9;j++) {
			if(board[i][j]=='.') {
				l.add(i*9+j);
			}
		}
	}
	return l;
}

private boolean dfs(char[][] board, List<Integer> arr, int index) {
	int len = arr.size();
	if(index == len) 
		return true;
	int data = arr.get(index);
	int row = data/9;
	int col = data%9;
	for(int i=1;i<=9;i++) {
		if(isValid(board,row,col,i))
			board[row][col] = (char) (i+'0');
		if(dfs(board,arr,index+1))
			return true;
		board[row][col] = '.';
	}
	return false;
  }

private boolean isValid(char[][] board, int row, int col, int data) {
	for(int i=0;i<9;i++) {
		if(board[row][i]-'0'==data)
			return false;
		if(board[i][col]-'0'==data)
			return false;
		int row_s = 3*(row/3) + row/3;
		int col_s = 3*(col/3) + col%3;
		if(board[row_s][col_s]-'0'==data)
			return false;
	}
	return true;
}
}
