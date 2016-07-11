import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.Service;


/**
 * @author Sudeep Reddy Eleti
 * 
 * It's hard enough to find an error in your code when you're looking for it; it's even harder when you've assumed your code is error-free. 
 */
public class PCC {
	
	public static void main(String args[]) {
		String x = "FOO";
		List<Integer> list = new ArrayList<Integer>(2);
		Map m = new HashMap();
		Object o1 = new Object();
		Object o2 = o1;
		m.put(o1, 1);
		m.put(o2, 2);
		System.out.println(m.get(o1));
	}
	
/*	void a(Service s, Connection c) {
        s.setConnection(c);
        try {
            s.execute();
            c.commit();
        }
        catch(Exception e) {
            c.rollback();
            e.printStackTrace();
            throw new Exception("Error occured while executing, rolling back"+e.getMessage());
        }
        finally{
            if (c!=null)
                c.close();
        }
        
    }
    */
}	
