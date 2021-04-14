package com.Vtiger.tc;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.JavaUtilityMethod;
import com.vtiger.generic.WebDriverCommonUtils;

public class CreateOrgonizationWithDifflist {
	/*public static void main (String []args) throws InterruptedException, IOException
	{*/
	@Test 
	public CreateOrgonizationWithDifflist() throws IOException, InterruptedException{
	    CreateOrgonizationWithDifflist cn=new CreateOrgonizationWithDifflist();
		JavaUtilityMethod  ju=new JavaUtilityMethod ();
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
	  //Navigate to More and click on Projects
	  WebElement moveToMore = driver.findElement(By.linkText("More"));
	  picker.movetoelement(driver, moveToMore);
	  		driver.findElement(By.name("Organizations")).click();
	  //Click on Create Organization + icon
driver.findElement(By.cssSelector("img[title='Create Organization...']")).click(); 
//provide org name	randomly
	  		int random= ju.createRandomNumber();
	  		String OrgonizationName= "orgo"+random; //cn.getOrgonizationName();
	  		driver.findElement(By.name("accountname")).sendKeys(OrgonizationName);
	 //Enter phone
driver.findElement(By.id("phone")).sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",1,1));
	  		//select Industry from list
	  		
 WebElement ilist=driver.findElement(By.name("industry"));
picker.pickItemFromList(ilist, picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",2,1));
//Select accounttype from list
	  	WebElement typelist=driver.findElement(By.name("accounttype"));
picker.pickItemFromList(typelist, picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",3,1));
	  		//Slect rating from list
	  		WebElement ratinglist=driver.findElement(By.name("rating"));
picker.pickItemFromList(ratinglist, picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",4,1));
	  		
	  	//click on save  //(//input[@value="  Save  "])[2]
driver.findElement(By.cssSelector("input[value=\"  Save  \"]")).click();
String actual=driver.findElement(By.className("dvHeaderText")).getText();
 String expected=picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",5,1);//"Organization Information";
 String result=   actual.contentEquals(expected)?"Organization Information pass":"Organization Information fail";
 driver.findElement(By.linkText("Organizations")).click();
 
 
 
 
	  //validate new orgonization added in list or not
	/*List<WebElement> olist=driver.findElements(By.xpath("//table[@class=\"lvt small\"]/tbody/tr[*]/td[3]"));
	 
	  	for(WebElement wb: olist)
	  	{
	  		//System.out.println(wb.getText());
	  		if(wb.getText().equals(OrgonizationName))
	  		{
	  			
	  			System.out.println(wb.getText()+ " :- is newly added");
	  		}
	  	}*/
	  
	  
	  WebElement search=driver.findElement(By.name("search_text"));
	  picker.elementisclickable(driver, search);
	  search.sendKeys(OrgonizationName);
	  WebElement olist=driver.findElement(By.xpath("//select[@id='bas_searchfield']"));
	 // select Organization Name and click();
	  picker.pickItemFromList(olist,picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",6,1));
	  //click on search button
	  driver.findElement(By.name("submit")).click();
	  //wait for element until display
	  WebElement actualorgname1=driver.findElement(By.xpath("//a[text()='"+OrgonizationName+"']/ancestor::table[@class='lvt small']"));
      picker.waitforElement(actualorgname1);
//System.out.println(actualorgname);
//	System.out.println(actualorgname1.getText());
boolean result1=actualorgname1.getText().contains(OrgonizationName);

		System.out.println(result1);
		 soft.assertAll();
		  

		  
		  }
}	
	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 /*String aname=driver.findElement(By.xpath("//a[text()="+OrgonizationName+"]/ancestor::table[@class='lvt small']")).getText();
	                                           //a[text()="+OrgonizationName+"]/ancestor::table[@class='lvt small']
	  System.out.println(aname);
	 boolean result1= aname.contentEquals(OrgonizationName);
	 System.out.println(result1);
	  				*/
	  		
	 
		
	/*Random r=new Random();
	int random=r.nextInt(1000);
	public String getOrgonizationName() {
		return "orgo"+random;
	}*/
	/*public void  pickItemFromList(WebElement list ,String item)
		{

			Select s=new Select(list);
			List<WebElement>alllist=s.getOptions();
			for(WebElement wb:alllist)
  		{
  			if(wb.getText().equals(item))
  			{
  				s.selectByVisibleText(item);
  			}
  		}
		}
	*/
	









/*wait.until(ExpectedConditions.elementToBeClickable(search)).click();
Thread.sleep(5000);

String name = driver.findElement(By.xpath("//table[@class='lvt small']//a[@title = 'Organizations']")).getText();
System.out.println(orgName.equals(name));
*/