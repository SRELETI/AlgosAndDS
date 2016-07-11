
public abstract class Component {

	public abstract int getSize();
	public abstract String getName();
	public abstract String getDescription();
	public abstract void displayInfo();
	public abstract void addComponent(Component c);
	public abstract void removeComponent(int index);
}
