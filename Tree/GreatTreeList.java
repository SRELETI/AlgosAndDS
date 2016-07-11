
public class GreatTreeList {

	private TreeInt root;
	
	public GreatTreeList() {
		root = null;
	}
	
	public TreeInt convert(TreeInt temp) {
		if(temp == null)
			return null;
		TreeInt aList = convert(temp.left);
		TreeInt bList = convert(temp.right);
		temp.left = temp;
		temp.right = temp;
		aList = append(aList,temp);
		aList = append(aList,bList);
		return aList;
	}
	
	public TreeInt append(TreeInt aList, TreeInt bList) {
		if(aList==null)
			return bList;
		if(bList==null)
			return aList;
		TreeInt aNode = aList.left;
		TreeInt bNode = bList.left;
		
		join(aNode,bList);
		join(bNode,aList);
		return aList;
	}
	
	private void join(TreeInt node, TreeInt list) {
		node.right = list;
		list.left = node;
	}
	
	public void display(TreeInt temp) {
		if(temp==null)
			return;
		TreeInt temp2 = temp;
		do
		{
			temp2.display();
			temp2 = temp2.right;
		}while(temp2!=temp);
	}
	
	public static void main(String args[]) {
		GreatTreeList g = new GreatTreeList();
		g.root = new TreeInt(4);
		g.root.left = new TreeInt(2);
		g.root.right = new TreeInt(5);
		g.root.left.left = new TreeInt(1);
		g.root.left.right = new TreeInt(3);
		
		TreeInt temp = g.convert(g.root);
		g.display(temp);
	}
}
