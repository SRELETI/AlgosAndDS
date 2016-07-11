import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

class SafeResultSet {
	
	private TimeZone tz = TimeZone.getTimeZone("GMT");
	private Calendar tzcal = Calendar.getInstance(tz);

	private Map<String,Integer> columns;
	private String [] columnnames;
	private ResultSet rs;
	private ResultSetMetaData rmd;
	public SafeResultSet(ResultSet rs) throws SQLException {
		this.rs = rs;
		rmd = rs.getMetaData(); 
		
		columnnames = new String[rmd.getColumnCount()];
		columns = new HashMap<String,Integer>();
		for (int i=0; i<rmd.getColumnCount(); i++) {
			String name = rmd.getColumnLabel(i+1).toLowerCase();
			//System.out.println(name);
			columns.put(name, i+1);
			columnnames[i] = name; 
		}
	}
	
	public void printColumnInfo() {
		for (Map.Entry<String,Integer> col: columns.entrySet()) {
			System.out.println("Column: " + col.getKey() + "," + col.getValue());
		}
	}
	
	public String[] getColumnNames() {
		return columnnames;
	}
	
	public boolean hasColumn(final String name) {
		return columns.containsKey(name.toLowerCase());
	}
	
	public int getColumnType(final String name) throws SQLException {
		if (hasColumn(name)) {
			return rmd.getColumnType(columns.get(name.toLowerCase()));
		}
		return -1;
	}
	
	public String getColumnTypeName(final String name) throws SQLException {
		if (hasColumn(name)) {
			return rmd.getColumnTypeName(columns.get(name.toLowerCase()));
		}
		return null;
	}

	public String getString(final int num) throws SQLException {
		if (num>columnnames.length) {
			return null;
		}
		String name = columnnames[num-1];
		if (hasColumn(name)) {
			return rs.getString(name);
		}
		return null;
	}
	
	
	public String getString(final String name) throws SQLException {
		if (hasColumn(name)) {
			return rs.getString(name);
		}
		return null;
	}
	
	public Object getObject(final String name) throws SQLException {
		if (hasColumn(name)) {
			Object o =  rs.getObject(name);
			if (!rs.wasNull()) {
				return o;
			}
		}
		return null;
	}

	public byte[] getBytes(final String name) throws SQLException {
		if (hasColumn(name)) {
			byte[] b = rs.getBytes(name);
			if (!rs.wasNull()) {
				return b;
			}
		}
		return null;
	}
	
		
}

public class DatabaseCon {

	public void testing() throws SQLException {
		String recordSql = "select srctable,from,language,source,abstract,additionalkeywords,attr1,attr2,attr3,component,content AS content,currentreviewers,date,defectnum,diagnosis,division,docexpire,docmodified,docnumber,doctype,draftstatus,editorcomments,editorkeywords,env,family,form,historicalnumber,ibmtasks,ibmtopics,internaluseonly,level1,level2,level3,modifydate,neverexpire,originator,product,productalias,publishdate,publishto,reviewerlog,reviseflag,segment,status,subject,symptom,team,timecreated,topic,cause,unid,noteid,notes_url,doccategory,writerscomments,docmodifieddate  from  DCF.DLOADDOCS where UNID=? order by status desc";
		Connection con = getConnection();
		if(con==null) {
			System.out.println("Error");
		}
		PreparedStatement ps = con.prepareStatement(recordSql,ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY, ResultSet.HOLD_CURSORS_OVER_COMMIT);
		ps.setString(1, "94299412F0CA759D85257D400049E2B0");
		try{
			SafeResultSet rs = new SafeResultSet(ps.executeQuery());
			System.out.println(rs.getString("SRCTABLE"));
		}
		catch (SQLException ex){
			System.out.println("Error");
		}
		finally {
			
		}
		
	}
	
	public Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			connection=DriverManager.getConnection("jdbc:db2://wsearch.lenexa.ibm.com:50000/srdl","srdlrd","gr54Ds3r");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void main(String args[]) throws SQLException {
		DatabaseCon s = new DatabaseCon();
		s.testing();
	}
} 
