import java.util.Arrays;

class Trie_mat {
	public int data;
	public Trie_mat[] child;
	
	public Trie_mat() {
		data = 0;
		child = new Trie_mat[2];
		for(int i=0;i<child.length;i++) 
			child[i]= null;
	}
}





public class TrieMatrix {

	public Trie_mat root;
	
	public TrieMatrix() {
		root = new Trie_mat();
	}
	
	public boolean add(int[][] mat, int row) {
		Trie_mat cur = this.root;
		int count=0;
		for(int i=0;i<mat[row].length;i++) {
			if(cur.child[mat[row][i]]==null) {
				count++;
				cur.child[mat[row][i]] = new Trie_mat();
			}		
			cur = cur.child[mat[row][i]];
		}
	//	System.out.println(count);
		return count!=0;
	}
	
	public static void main(String args[]) {
		int[][] mat = {{0,1,0,0,1},{1,0,1,1,0},{1,1,1,0,0},{0,1,0,0,1}};
		TrieMatrix t = new TrieMatrix();
		int count=0;
		for(int i=0;i<mat.length;i++) {
			if(t.add(mat, i)==true) {
				t.printRow(mat,i);
			}
		}
	}
	
	private void printRow(int[][] mat, int row) {
		for(int i=0;i<mat[row].length;i++) 
			System.out.print(mat[row][i]+" ");
		System.out.println();
	}
}
