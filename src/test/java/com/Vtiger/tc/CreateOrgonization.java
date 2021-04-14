package com.Vtiger.tc;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.Iconstant;
import com.vtiger.generic.JavaUtilityMethod;
import com.vtiger.generic.WebDriverCommonUtils;

public class CreateOrgonization {	
	/*public static void main (String []args) throws InterruptedException, IOException
{*/
	@Test
	public static void CreateOrgonization() throws IOException 
	{
  WebDriverCommonUtils picker= new WebDriverCommonUtils();
  JavaUtilityMethod  ju=new JavaUtilityMethod ();
	WebDriver driver=new ChromeDriver();
	picker.implicitwait(driver);
	picker.maximizeWindow(driver);
	//Open Vtiger application
	driver.get(picker.getDataFromProperty(Iconstant.propfilePath, "url"));
	//validate the login page 
String lg =driver.findElement(By.linkText("vtiger")).getText();
SoftAssert soft= new SoftAssert();
soft.assertEquals(lg, "vtiger", "loing pass");
//Enter valid USERNAME and PASSWORD and click on LOGIN
driver.findElement(By.name("user_name")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath,"username"));
driver.findElement(By.name("user_password")).sendKeys(picker.getDataFromProperty(Iconstant.propfilePath,"password"));
driver.findElement(By.id("submitButton")).click();
// Validate Home page
String home =driver.findElement(By.className ("hdrLink")).getText();
Assert.assertEquals(home, "Home", "Homepage  pass");
//Navigate to More and click on Organizations
WebElement moveToMore = driver.findElement(By.linkText("More"));
picker.movetoelement(driver,moveToMore);
driver.findElement(By.name("Organizations")).click();
//Click on Create Organization + icon
	driver.findElement(By.cssSelector("img[title='Create Organization...']")).click(); 
//provide random org name	
	int random= ju.createRandomNumber();
	String OrgonizationName= "orgo"+random; //cn.getOrgonizationName();
	driver.findElement(By.name("accountname")).sendKeys(OrgonizationName);
	//Enter phone
	driver.findElement(By.id("phone")).sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",1,1));
	//click on save button
	driver.findElement(By.cssSelector("input[value=\"  Save  \"]")).click();
}
}



/*List<WebElement>onamelist=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
for(WebElement oname:onamelist)
{
System.out.println(oname.getText());
	if(oname.getText().equals("vtigerCRM Inc")){
	String x= "//a[text()='"+oname.getText()+"']/../..td[1]/a";
driver.findElement(By.xpath(x)).click();
driver.findElement(By.xpath("//a[text()='\"+oname.getText() + \"']/../../td[1]/../td[8]/a[2]")).click();
}
}*/



