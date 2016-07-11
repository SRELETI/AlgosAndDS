/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

import com.ibm.bluepages.BPResults;
import com.ibm.bluepages.BluePages;

public class BluePages23 {
	
	
	public static Map<String,List<String>> getEmployees(List<String> emails) {
	
		//Map which stores the employees for each business unit in alphabetical order
		
		Map<String,List<String>> result = new TreeMap<String,List<String>>();
		
		String temp_email,temp_Bunit;
		
		Vector<String> temp_orgCode;
		
		// Iterate through the list of emails
		Iterator<String> i = emails.iterator();
		
		while(i.hasNext())
		{
			//get each email
			temp_email = i.next();
			// get all details of the person
			BPResults bpr = BluePages.getPersonsByInternet(temp_email);
			//get the orgcode for the person
			temp_orgCode = bpr.getColumn("ORGCODE");
			if(temp_orgCode.size()==0)
				continue;
			//using the orgcode get the business unit
			 temp_Bunit=  (String) BluePages.getOrganizationCode(temp_orgCode.get(0)).get("ORGDISPLAY");
			
			// If the same business is already present, just append the email to the existing list
			if(result.containsKey(temp_Bunit)) {
				List<String> new_list = new ArrayList<String>(result.get(temp_Bunit));
				new_list.add(temp_email);
				result.put(temp_Bunit, new_list);
			}
			// else create new entry for the business unit
			else
			{
				List<String> new_list = new ArrayList<String>();
				new_list.add(temp_email);
				result.put(temp_Bunit, new_list);
			}
		}
		return result;
	}

	//Main Method
	public static void main(String args[]) throws IOException {
		
		// Read input from file
		
		List<String> input = readFile("C:\\Users\\IBM_ADMIN\\Desktop\\users.txt");
		
		//call the method which gets the employee business unit
		Map<String,List<String>> result = getEmployees(input);
		FileWriter f = new FileWriter("C:\\Users\\IBM_ADMIN\\Desktop\\out.doc");
		Iterator i = result.entrySet().iterator();
		while(i.hasNext()) {
			Map.Entry<String,List<String>> pairs = (Map.Entry<String,List<String>>) i.next();
			f.write(pairs.getKey()+":\n");
			List<String> temp = pairs.getValue();
			Iterator<String> j = temp.iterator();
			while(j.hasNext()) {
				f.write("\t\t"+j.next()+"\n");
			}
		}
		f.close();
	}
	
	private static List<String> readFile(String fileName) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		List<String> result = new ArrayList<String>();
		String line;
		try {
			line = br.readLine();
			while(line!=null) {
				result.add(line);
				line = br.readLine();
			}
		}
		finally {
			br.close();
		}
		return result;
	}
}
*/