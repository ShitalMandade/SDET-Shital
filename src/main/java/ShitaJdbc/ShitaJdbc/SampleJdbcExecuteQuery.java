package ShitaJdbc.ShitaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;

public class SampleJdbcExecuteQuery {
	public static void main(String[] args) throws Exception {
		WebDriverCommonUtils wc=new WebDriverCommonUtils();
		Connection con=null;
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTable","root","root");
		Statement stat=con.createStatement();
		ResultSet result=stat.executeQuery("select * from shital;");
	     while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2));
		}
		con.close();
				

	}


}
