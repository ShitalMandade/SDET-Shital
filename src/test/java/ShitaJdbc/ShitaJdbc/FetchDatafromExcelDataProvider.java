package ShitaJdbc.ShitaJdbc;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;

public class FetchDatafromExcelDataProvider {
	WebDriverCommonUtils picker=new WebDriverCommonUtils();

	@Test(dataProvider="getdata")
	public void testcity1(String src,String dest) throws InterruptedException, IOException 
	{
		System.out.println(src+"  "+dest);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(picker.getDataFromProperty(Iconstant.makeMytripproperties, "url"));

		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 20);

		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).click().perform();

		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(src);
		driver.findElement(By.xpath("//div[contains(text(),'"+src+"')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(dest);
		driver.findElement(By.xpath("//div[contains(text(),'"+dest+"')]")).click();

		WebElement departure=driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
		wait.until(ExpectedConditions.elementToBeClickable(departure)).click();
	
		driver.findElement(By.xpath("//div[@aria-label='Wed Apr 10 2021']")).click();
		
		driver.close();
		
	}

	@DataProvider
	public  Object[][] getdata() throws IOException
	{
		int rcount=picker.getExcelRowCount(Iconstant.makeMytripExcel, "city");
		Object[][] arr= new Object[rcount][2];
	    for(int i=0;i< arr.length;i++) {
	try {	        int num=i+1;
	arr[i][0]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", num, 0);
	arr[i][1]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", num, 1);
	}
	catch(StaleElementReferenceException e)
	{
		
	}
	   }
		return arr;
		}}

/*arr[0][0]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 1, 0);//"BOM";
		arr[0][1]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 1, 1);//"PNQ";

		arr[1][0]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 2, 0);//"DEL";
		arr[1][1]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 2, 1);//"BOM";
		
		arr[2][0]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 3, 0);
		arr[2][1]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 3, 1);

		arr[3][0]= picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 4, 0);
		arr[3][1]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 4, 1);;


		arr[4][0]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 5, 0);
		arr[4][1]=picker.getDataFromExcel(Iconstant.makeMytripExcel, "city", 5, 1);
*/
	


