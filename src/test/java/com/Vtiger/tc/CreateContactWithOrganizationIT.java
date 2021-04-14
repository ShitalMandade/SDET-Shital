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
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;

public class CreateContactWithOrganizationIT {
	/*public static void main (String []args) throws InterruptedException, IOException
	{*/
	@Test
	public void CreateContactWithOrganizationIT() throws IOException {
	WebDriverCommonUtils picker= new WebDriverCommonUtils();
		WebDriver driver=new ChromeDriver();
		picker.implicitwait(driver);
		picker.maximizeWindow(driver);
		//Open Vtiger application
		driver.get(picker.getDataFromProperty(Iconstant.propfilePath, "url"));
		//validate the login page 
	String lg =driver.findElement(By.linkText("vtiger")).getText();
	   SoftAssert soft= new SoftAssert();
	   soft.assertEquals(lg, "vtiger", "loing pass");
    driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath,"username"));
    driver.findElement(By.name("user_password")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath,"password"));
	driver.findElement(By.id("submitButton")).click();
	// Validate Home page
	String home =driver.findElement(By.className ("hdrLink")).getText();
    Assert.assertEquals(home, "Home", "Homepage  pass");
	driver.findElement(By.linkText("Contacts")).click();
	//Click on Create contact + icon
	driver.findElement(By.cssSelector("img[title='Create Contact...']")).click(); 
	//Select salutationtype
	WebElement slist=driver.findElement(By.name("salutationtype"));
	picker.pickItemFromList(slist, "Mrs.");
	//Enter fistname
	driver.findElement(By.name("firstname")).sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT", 1, 1));
	driver.findElement(By.name("lastname")).sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT", 2, 1));
	//click on orgonization icon
	driver.findElement(By.xpath("//img[@title='Select'][1]")).click();
	picker.childWindowHanlde(driver);
	driver.findElement(By.id("search_txt")).sendKeys("vtiger");
	   driver.findElement(By.name("search")).click();
	   driver.findElement(By.linkText("vtiger")).click();
	 picker.mainWindowHandle(driver);
    driver.findElement(By.id("mobile")).sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT", 3, 1));
	//click on save
	driver.findElement(By.cssSelector("input[type=submit]")).click();
	soft.assertAll();
}
}


