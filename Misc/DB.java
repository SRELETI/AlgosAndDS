import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DB {

	public static void main(String args[])
	{
		Connection con = getCon();
		
	}
	
	public static Connection getCon()
	{
		Connection connection=null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			connection=DriverManager.getConnection("jdbc:db2://ideas.canlab.ibm.com:50000/I2TEST","Administrator","T3mp4n0");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;	
		}
}
