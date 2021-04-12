package ShitaJdbc.ShitaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleJdbcdropTable {

	
	public static void main(String[] args) throws Exception {
		Connection con=null;
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTable","root","root");
		Statement stat=con.createStatement();
		int result= stat.executeUpdate("DROP TABLE Mytable");
		if(result==1)
		{
			System.out.println("qury executed");
		}
		else
			System.out.println("qury failed");
		
	      con.close();

}
}