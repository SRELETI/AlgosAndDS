
public class StackUndoRedomain {
	private StackUndoRedoList main;
	private StackUndoRedoList undo;
	private StackUndoRedoList redo;
	public StackUndoRedomain(int length)
	{
		main = new StackUndoRedoList(length);
		undo = new StackUndoRedoList(length);
		redo = new StackUndoRedoList(length);
	}
	public void push(String value)
	{
		main.push(value);
		undo.push("push");
		redo.clear();
	}
	public String pop()
	{
		String popped=main.pop();
		undo.push(popped);
		undo.push("pop");
		redo.clear();
		return popped;
	}
	public void undo()
	{
		if(undo.isEmpty())
		{
			System.out.println("Not allowed");
			return;
		}
		else
		{
			String popped = undo.pop();
			if(popped=="pop")
			{
				String result= undo.pop();
				main.push(result);
				redo.push("pop");
			}
			else
			{
				String result=main.pop();
				redo.push(result);
				redo.push("push");
			}
		}
	}
	public void redo()
	{
		if(redo.isEmpty())
		{
			System.out.println("Redo not allowed ");
			return;
		}
		else
		{
			String popped = redo.pop();
			if(popped=="pop")
			{
				String result=main.pop();
				undo.push(result);
				undo.push("pop");
			}
			else
			{
				String result = redo.pop();
				main.push(result);
				undo.push("push");
			}
		}
	}
	public void display()
	{
		main.display();
	}
}
