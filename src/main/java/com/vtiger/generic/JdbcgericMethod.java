package com.vtiger.generic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class JdbcgericMethod {
	

/**
 * @throws SQLException 
 * @author Shital
 *To fetch data from Database
 *@param pass  Show databases Query
 *@param pass  use databases Query
 *@param pass  eQuery
 * */				
public void fetchDataFromDataBaseExecuteQuery(String Showdbquery ,String usedbquery,String equery) throws SQLException
{
	Connection con=null;
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/MyTable","root","root");
	
	Statement stat=con.createStatement();
	ResultSet result2= stat.executeQuery(Showdbquery ); //2
	while(result2.next())
	{System.out.println( result2.getString(1));
     }
	 ResultSet result3= stat.executeQuery(usedbquery);//3
	//crete table
	//int crttable= stat.executeUpdate("create table MyNameIdAgeTable(name varchar (20),id Integer ,age Integer);");
	System.out.println("---------Table to use----------");
	 ResultSet result=stat.executeQuery(equery);
	 while(result.next())
	{
		System.out.println(result.getString(1)+"\t"+result.getString(2));
	}
}


}
