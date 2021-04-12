package com.Vtiger.tc;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;

public class CreateOrgonization {	
	public static void main (String []args) throws InterruptedException, IOException
{
  WebDriverCommonUtils picker= new WebDriverCommonUtils();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	//Open Vtiger application
	driver.get(picker.getDataFromProperty(Iconstant.propfilePath, "url"));
	      //validate the login page 
String lg =driver.findElement(By.linkText("vtiger")).getText();
System.out.println(lg.equals("vtiger")? "loing pass":"login fail");
 //Enter valid USERNAME and PASSWORD and click on LOGIN
	driver.findElement(By.name("user_name")).sendKeys(Iconstant.propfilePath,"username");
	driver.findElement(By.name("user_password")).sendKeys(Iconstant.propfilePath,"password");
	  
	driver.findElement(By.id("submitButton")).click();
	     // Validate Home page
String home =driver.findElement(By.className ("hdrLink")).getText();
System.out.println( home.equals("Home")? "Homepage  pass":"HomePage fail");
//Navigate to More and click on Projects
		WebElement moveToMore = driver.findElement(By.linkText("More"));
		Actions act= new Actions(driver);
		act.moveToElement(moveToMore).perform();
		driver.findElement(By.name("Organizations")).click();
List<WebElement>onamelist=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
for(WebElement oname:onamelist)
{
	
	System.out.println(oname.getText());
	if(oname.getText().equals("vtigerCRM Inc"))
	{
		
		//a[text()='vtigerCRM Inc']/../../td[1]
		
     String x= "//a[text()='"+oname.getText()+"']/../..td[1]/a";
driver.findElement(By.xpath(x)).click();
driver.findElement(By.xpath("//a[text()='\"+oname.getText() + \"']/../../td[1]/../td[8]/a[2]")).click();
		           
		
		
		
	}
}
	
	

}
}
