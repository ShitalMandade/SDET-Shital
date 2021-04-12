package ShitaJdbc.ShitaJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;

public class Shitaljdbc {

	public static void main(String[] args) throws Exception {
		WebDriverCommonUtils wc=new WebDriverCommonUtils();
	/*	Connection con=null;
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTable","root","root");
		Statement stat=con.createStatement();
		
		//ResultSet result=stat.executeQuery("create database Mytable;");//1
		ResultSet result2= stat.executeQuery(" Show databases;"); //2
		while(result2.next())
		{
			System.out.println( result2.getString(1));

			//System.out.println(result2.getString(1)+"\t"+result2.getString(2));
		}
		 ResultSet result3= stat.executeQuery(" use shital;");//3
		//crete table
		//int crttable= stat.executeUpdate("create table MyNameIdAgeTable(name varchar (20),id Integer ,age Integer);");
			
		 
		 
		 System.out.println("---------Table to use----------");
		 
		 ResultSet result=stat.executeQuery("select * from shital;");
	     while(result.next())
		{
			System.out.println(result.getString(1)+"\t"+result.getString(2));
		}
	   
		//con.close();
*/
             // wc.fetchDataFromDataBaseExecuteQuery();
		wc.fetchDataFromDataBaseExecuteQuery(" Show databases;"," use shital;","select * from shital;");
		
}

}
