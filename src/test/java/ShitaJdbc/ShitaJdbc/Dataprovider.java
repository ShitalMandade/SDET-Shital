package ShitaJdbc.ShitaJdbc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {
	@Test(dataProvider="getdata")
	public void testcity1(String src,String dest) throws InterruptedException 
	{
		System.out.println(src+"  "+dest);
	}
	
	@DataProvider
	public  Object[][] getdata()
	{
		Object[][] arr= new Object[5][2];

		arr[0][0]="BOM";
		arr[0][1]="PNQ";

		arr[1][0]="DEL";
		arr[1][1]="BOM";
		
		arr[2][0]="JFK";
		arr[2][1]="BOM";

		arr[3][0]="NYC";
		arr[3][1]="DEL";

		arr[4][0]="BLR";
		arr[4][1]="DEL";

		return arr;
	}
	
}
