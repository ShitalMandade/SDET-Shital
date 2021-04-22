package com.Vtiger.tc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;



public class ListSorintingOfOrg {
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
		driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath, "username"));
		driver.findElement(By.name("user_password")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath, "password"));
		  
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
	    ArrayList<String> list=new ArrayList<String>();
	    System.out.println("before sort"+list);
	     // Collections.sort(list);
	      for(int i=0;i<onamelist.size();i++)
	      {
	    	  list.get(i);
	      }
	      Collections.sort(list);
	      driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a")).click();
	      
	      ArrayList<String> list1=new ArrayList<String>();
	     List<WebElement>onamelist1=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	      for(int i=0;i<onamelist1.size();i++)
	      {
	    	  list1.get(i);
	      }
	      Collections.sort(list1);
	      System.out.println(list);
	      System.out.println(list1);
	      Assert.assertEquals(list, list1);
	    
	      
	    
	    
	    

}
	}

