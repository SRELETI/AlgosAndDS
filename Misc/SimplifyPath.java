import java.util.*;
public class SimplifyPath {

	public String simplify(String path) {
		if(path.length()<=1)
			return path;
		String[] arr = path.split("/+");
		System.out.println(Arrays.toString(arr));
		
		Stack<String> s = new Stack<String>();
		for(String ss: arr) 
		{
			if(ss.equals("."))
				continue;
			else if(ss.equals("..")) {
				if(s.isEmpty()) 
					continue;
				else
					s.pop();
			}
			else
				s.push(ss);
		}
		String result ="";
		while(!s.isEmpty()) {
			result = "/" + s.pop()+result;
		}
		if(result.length()==0)
			result = "/"+result;
		return result;
	}
	
	public static void main(String args[]) {
		SimplifyPath s = new SimplifyPath();
		System.out.print(s.simplify("/..."));
	}
}
