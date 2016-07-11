
public class InorderSuccess {

	public TreeInt success(TreeInt root, int val,TreeInt suc) {
		if(root==null)
			return null;
		if(root.data>val) {
			suc = root;
			return success(root.left,val,suc);
		}
		else if(root.data<val) {
			return success(root.right,val,suc);
		}
		else {
			if(root.right==null)
				return suc;
			else {
				return getSuc(root.right);
			}
		}
	}
	
	private TreeInt getSuc(TreeInt root) {
		if(root==null)
			return null;
		while(root.left!=null) {
			root = root.left;
		}
		return root;
	}
	
	public TreeInt insert(TreeInt head, int val) {
		if(head==null) {
			head = new TreeInt(val);
			return head;
		}
		TreeInt temp = head;
		TreeInt parent = null;
		while(temp!=null) {
			parent = temp;
			if(val<temp.data) {
				temp = temp.left;
				if(temp==null) {
					parent.left = new TreeInt(val);
					return head;
				}
			}
			else {
				temp = temp.right;
				if(temp==null) {
					parent.right = new TreeInt(val);
					return head;
				}
			}
		}
		return head;
	}
	public static void main(String args[]) {
		InorderSuccess i = new InorderSuccess();
		TreeInt head = i.insert(null, 20);
		head = i.insert(head, 22);
		head = i.insert(head, 8);
		head = i.insert(head, 12);
		head = i.insert(head, 4);
		head = i.insert(head, 10);
		head = i.insert(head, 14);
		TreeInt temp = i.success(head, 20, null);
		System.out.println(temp==null?"null":temp.data);
	}
}
