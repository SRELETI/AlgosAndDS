
public class StackUndoMain {
	public static void main(String args[])
	{
		StackUndoRedomain sur = new StackUndoRedomain(5);
		sur.push("5");
		sur.push("4");
		sur.undo();
		sur.undo();
		sur.redo();
		sur.redo();
		sur.redo();
	//	sur.undo();
		sur.display();
	}
}
