package com.Vtiger.tc;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;

public class CreateContactWithOrganizationIT {
	
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
	   SoftAssert soft= new SoftAssert();
	   soft.assertEquals(lg, "vtiger", "loing pass");
    driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath,"username"));
    driver.findElement(By.name("user_password")).sendKeys(Iconstant.propfilePath,"password");
		  
		driver.findElement(By.id("submitButton")).click();
		     // Validate Home page
	String home =driver.findElement(By.className ("hdrLink")).getText();
	//System.out.println( home.equals("Home")? "Homepage  pass":"HomePage fail");
	    Assert.assertEquals(home, "Home", "Homepage  pass");
	driver.findElement(By.linkText("Contacts")).click();
	//Click on Create contact + icon
	driver.findElement(By.cssSelector("img[title='Create Contact...']")).click(); 
	//Select salutationtype
	WebElement slist=driver.findElement(By.name("salutationtype"));
	        Select s=new Select(slist);
	         List<WebElement> stype=s.getOptions();
			for(WebElement wb:stype)
			{
			if(wb.getText().equals("Mrs."))
				{
					s.selectByVisibleText("Mrs.");
			}
			}
			
       //Enter fistname
	driver.findElement(By.name("firstname")).sendKeys("Shital");
	driver.findElement(By.name("lastname")).sendKeys("Gurnule");
	//click on orgonization icon
	driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
	String mainid=driver.getWindowHandle();
	Set<String> allid=driver.getWindowHandles();
	   Iterator itr=   allid.iterator();
	   while(itr.hasNext())
	   {
		  String ids= itr.next().toString();
		  if( !mainid.equals(ids))
		  {
			 driver.switchTo().window(ids);
		  }
	   }
	   driver.findElement(By.id("search_txt")).sendKeys("vtiger");
	   driver.findElement(By.name("search")).click();
	   driver.findElement(By.linkText("vtiger")).click();
	//List<WebElement>olist=driver.findElements(By.xpath("//table/tbody/tr[*]/td[@class='lvtCol'][1]"));
	driver.switchTo().window(mainid);
    driver.findElement(By.id("mobile")).sendKeys("90908962231");
	
	
	//click on save
	driver.findElement(By.cssSelector("input[type=submit]")).click();
	
	//driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	soft.assertAll();
	
	
	
	
	
	
}
}


