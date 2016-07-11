
public class WorkingWithComposite {

	public static void main(String args[]) {
		Component mainCom = new FolderComponent("Main Folder"," Created today", 50);
		Composite com = new Composite(mainCom);
		Component sudeep = new FolderComponent("Sudeep Folder"," Created Jan 8th", 25);
		mainCom.addComponent(sudeep);
		Component rootFile = new FileComponent("Root File"," Created on Jan 1st", 1);
		Component root2File = new FileComponent("Root2 File","Created on Jan 2nd",1);
		
		mainCom.addComponent(rootFile);
		mainCom.addComponent(root2File);
		
		Component sudeep_root = new FileComponent("Sudeep root file","Created on jan 8th 2014",1);
		Component sudeep_root2 = new FileComponent("Sudeep root2 file","Created on jan 8th 2015",1);
		
		sudeep.addComponent(sudeep_root);
		sudeep.addComponent(sudeep_root2);
		
		com.displaySongInfo();
	}
}
