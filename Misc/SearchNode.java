
public class SearchNode {

	TreeInt head;
	public SearchNode() {
		head = null;
	}
	public boolean searchNow(int v) {
		if(head==null) {
			return false;
		}
		TreeInt temp = head;
		while(temp!=null) {
			if(temp.data==v) {
				return true;
			}
			else if(temp.data>v) {
				temp = temp.left;
			}
			else
				temp = temp.right;
		}
		return false;
	}
	
	public void insert(int val) {
		if(head ==null) {
			head = new TreeInt(val);
			return;
		}
		TreeInt parent = null;
		TreeInt temp = head;
		while(temp!=null) {
			parent = temp;
			if(val<temp.data) {
				temp = temp.left;
				if(temp==null) {
					parent.left = new TreeInt(val);
					return;
				}
			}
			else {
				temp = temp.right;
				if(temp==null) {
					parent.right = new TreeInt(val);
					return;
				}
			}
		}
		
	}
	
	public void display() {
		
		displayNow(head);
	}
	
	public void displayNow(TreeInt head) {
		if(head==null)
			return;
		displayNow(head.left);
		System.out.print(head.data+" ");
		displayNow(head.right);
	}
	
	public static void main(String args[]) {
		SearchNode s = new SearchNode();
		s.insert(5);
		s.insert(3);
		s.insert(2);
		s.insert(4);
		s.insert(6);
		
		s.display();
		
	//	System.out.println(s.searchNow(2));
	//	System.out.println(s.searchNow(1));
		TreeInt temp = s.delete(s.head, 4);
		System.out.println();
		s.displayNow(temp);
	}
	
	public TreeInt delete(TreeInt head, int val) {
		if(head == null) {
			return head;
		}
		TreeInt temp = head;
			if(temp.data==val ) {
				
				if(temp.right==null) {
					temp = temp.left;
					return temp;
				}
				else if(temp.left==null) {
					temp = temp.right;
					return temp;
				}
				TreeInt temp2 = getSuccessor(temp.right);
				temp.data = temp2.data;
				temp.right = delete(temp.right, temp.data);
			}
			else if(temp.data>val) {
				temp.left = delete(temp.left,val);
			}
			else 
				temp.right = delete(temp.right,val);
		return temp;
	}
	
	public TreeInt getSuccessor(TreeInt temp) {
		if(temp==null)
			return null;
		while(temp.left!=null) {
			temp = temp.left;
		}
		return temp;
	}
}
