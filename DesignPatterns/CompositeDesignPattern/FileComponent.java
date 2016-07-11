
public class FileComponent extends Component {

	private String fileName;
	private String fileDesc;
	private int fileSize;
	
	public FileComponent(String newFile, String newDesc, int newSize) {
		fileName = newFile;
		fileDesc = newDesc;
		fileSize = newSize;
	}
	
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return fileSize;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return fileName;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return fileDesc;
	}

	@Override
	public void displayInfo() {
		// TODO Auto-generated method stub
		System.out.println(getName()+" file is having following desc "+getDescription()+" and is having size "+getSize());
	}

	@Override
	public void addComponent(Component c) {
		// TODO Auto-generated method stub
		System.out.println("This class doesnt support it ");
	}

	@Override
	public void removeComponent(int index) {
		// TODO Auto-generated method stub
		System.out.println("This class doesnt support it ");
	}

	
}
