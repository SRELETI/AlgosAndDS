import java.sql.*;
public class JDBCConnection {
	public static void main(String args[])
	{
		DBConnect db = new DBConnect();
		Connection conn = db.connect("jdbc:db2://wsearch.lenexa.ibm.com:50000/SERVICES","db2inst1","FKh23TcG");
		//db.importData(conn,args[0]);
	}
}
	
class DBConnect
{
	public DBConnect()
	{
	}
	public Connection connect(String db_connect_str, String db_userid, String db_password)
	{
		Connection conn;
		try
		{
			Class.forName("com.ibm.db2.jcc.DB2Driver").newInstance();
			conn=DriverManager.getConnection(db_connect_str,db_userid,db_password);			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			conn=null;
		}
		return conn;
	}
	/*public void importData(Connection conn, String filename)
	{
		Statement stmt;
		String query;
		try
		{
			stmt=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			query="LOAD DATA LOCAL INFILE '"+filename+"'INTO TABLE ACCESS_LOG_FINDER FIELDS TERMINATED BY ','(CLIENT,CLIENT_INFO,CLIENT_IP,TIMESTAMP,URL,KEYWORD,STATUS_CODE,PROCESS_TIME)";
			stmt.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			stmt=null;
		}
	}*/
}

		
		
		
		
		
		
		
		
		
		