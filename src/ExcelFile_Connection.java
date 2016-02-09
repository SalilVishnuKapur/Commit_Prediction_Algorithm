import java.io.*; 
import java.net.*;
import java.sql.*; 
import java.util.*; 
public class ExcelFile_Connection 
{ 

static final String DRIVER_NAME = "sun.jdbc.odbc.JdbcOdbcDriver";
static final String DATABASE_URL = "jdbc:odbc:statepopulation.xls";
public static void main(String[] args) 
{
	try
    {
	   Class.forName(DRIVER_NAME);
       Connection conn = null;
       conn = DriverManager.getConnection(DATABASE_URL); 
       Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("select State,Population from [Sheet1$]"); 
       while (rs.next()) 
{
String state = rs.getString(1); 
int population = rs.getInt(2);
System.out.println(state + " - " + population);
} 
rs.close();
stmt.close();
} catch (ClassNotFoundException cnfe) 
{
System.err.println("ClassNotFoundException Was Thrown"); 
cnfe.printStackTrace();
} catch (SQLException sqle) 
{ 
System.err.println("SQLException Was Thrown"); 
sqle.printStackTrace(); 
}
}
}