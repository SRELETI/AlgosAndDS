import java.util.ArrayList;
import java.util.Iterator;


public class FolderComponent extends Component {

	private ArrayList<Component> list;
	private String folderName;
	private String desc;
	private int size;
	public FolderComponent(String folderName, String desc, int size) {
		this.folderName = folderName;
		this.desc = desc;
		this.size = size;
		list = new ArrayList<Component>();
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return folderName;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return desc;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println("The folder name is " +getName()+" and the description is "+getDescription()+" and has size "+getSize());
		
		Iterator i = list.iterator();
		while(i.hasNext()) {
			Component c = (Component) i.next();
			c.displayInfo();
		}
	}
	
	public void addComponent(Component newComponent) {
		list.add(newComponent);
	}
	
	public void removeComponent(int index) {
		list.remove(index);
	}
	
	
}
