package ShitaJdbc.ShitaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Samplejdbcupdate {
	
	
	public static void main(String[] args) throws Exception {
		Connection con=null;
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTable","root","root");
		Statement stat=con.createStatement();
		//insert  Data In MyNameIdAgeTable
		for(int i=1;i<=2;i++)
		{
		//int insertDataInMyNameIdAgeTable= stat.executeUpdate(" insert into MyNameIdAgeTable(name, id,age) values ('Moti', 1, 21);");
		
		ResultSet insertDataInMyNameIdAgeTable =stat.executeQuery(" insert into MyNameIdAgeTable(name, id,age) values ('Monti', 1, 21);");
		/*if(insertDataInMyNameIdAgeTable==10)
		{
			System.out.println("qury executed");
		}
		else
			
		System.out.println("qury failed");
		
		}
		*/
	
	      con.close();

	}
	}
}
