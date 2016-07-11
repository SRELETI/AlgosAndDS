import java.io.IOException;
import java.sql.*;

public class Validate {
	public static boolean checkUser(String Username) throws IOException
	//void main(String args[]) 
	//boolean checkUser(String Username)
	{
		//String Username="sudeep";
		boolean st=true;
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver");
		//}
		/*catch (ClassNotFoundException e) {
			 System.out.println("Please include Classpath  Where your DB2 Driver is located");
			 e.printStackTrace();
			 return;
			 }*/
		//try
		//{
			Connection con=DriverManager.getConnection("jdbc:db2://ideas.canlab.ibm.com:50000/I2TEST","Administrator","ideaadmin1");
		/*if (con != null)
		{
		   System.out.println("DB2 Database Connected");
		}
		   else
		{
		      System.out.println("Db2 connection Failed ");
		 }*/
			PreparedStatement ps=con.prepareStatement("select GROUPS from TEALEAF.LOGIN where USERNAME=?");
			ps.setString(1,Username);
			ResultSet rs=ps.executeQuery();
			/*if(rs!=null)
			{
				while(rs.next())
				{
					st=true;
					System.out.println("Groups"+rs.getString("GROUPS"));
				}
			}
			if(st==false)
			{
				System.out.println("No Information found");
			}*/
			//System.out.println(rs);
			st=rs.next();
		}
		catch(Exception e)
		{
			System.out.println("Class not found");
		}
		/*catch(SQLException e)
		{
			System.out.println("class found");
			e.printStackTrace();
		}*/
		//System.out.println(st);
		return st;
	//}
	}
	/*public static void main(String args[]) throws IOException
	{
		Validate.checkUser("sudeep");
		
	}*/
}
