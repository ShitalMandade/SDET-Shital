package com.Vtiger.tc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class OpenVtiger {
	public static void main (String []args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//Open Vtiger application
		driver.get("http://localhost:8888/");
		      //validate the login page 
	String lg =driver.findElement(By.linkText("vtiger")).getText();
	System.out.println(lg.equals("vtiger")? "loing pass":"login fail");
	 //Enter valid USERNAME and PASSWORD and click on LOGIN
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		     // Validate Home page
	String home =driver.findElement(By.className ("hdrLink")).getText();
	System.out.println( home.equals("Home")? "Homepage  pass":"HomePage fail");
		//Navigate to More and click on Projects
		WebElement moveToMore = driver.findElement(By.linkText("More"));
		Actions act= new Actions(driver);
		act.moveToElement(moveToMore).perform();
		driver.findElement(By.name("Projects")).click();
		    // Validate Project page
	String project =driver.findElement(By.className ("hdrLink")).getText();
	System.out.println(project.equals("Projects")? "ProjectPage pass":"ProjectPage  fail");
		
			WebElement administrator=driver.findElement(By.cssSelector("td[onmouseout=\"fnHideDrop('ondemand_sub');\"]"));
			Actions act1= new Actions(driver);
			act.moveToElement(administrator).perform();
	        driver.findElement(By.linkText("Sign Out")).click();
	      //validate the login page 
	    	String lg1 =driver.findElement(By.linkText("vtiger")).getText();
	    	System.out.println(lg1.equals("vtiger")? "loing pass":"login fail");
			
}}


