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
import com.vtiger.objectRepository.CreateNewOrgonizationPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.LoginPageMember;
import com.vtiger.objectRepository.OginizationPageMember;

public class CreateNewOrgonization {	
@Test
	public static void CreateOrgonization() throws IOException 
	{
	WebDriverCommonUtils picker= new WebDriverCommonUtils();
	WebDriver driver=new ChromeDriver();
	picker.implicitwait(driver);
	picker.maximizeWindow(driver);
//Open Vtiger application
	driver.get(picker.getDataFromProperty(Iconstant.propfilePath, "url"));
	LoginPageMember log=new LoginPageMember(driver);
//validate the login page 
	        String lg=log.getvalidate_loginpage().getText();
	          SoftAssert soft= new SoftAssert();
			  soft.assertEquals(lg, "vtiger", "loing pass");
	          String un=picker.getDataFromProperty(Iconstant.propfilePath,"username");
	          String pwd=picker.getDataFromProperty(Iconstant.propfilePath,"password");
	          log.loginToApp(un,pwd);
//Validate Home page
	        HomePageMember homeobj=new HomePageMember(driver);
	       String home=homeobj.getValidateHomePage().getText();
	       Assert.assertEquals(home, "Home", "Homepage  pass");
//Navigate to More and click on Organizations
	      WebElement moveToMore = homeobj.getMoveToMore();
          picker.movetoelement(driver,moveToMore);
//click on Orgonizations module
          homeobj.getOrglink().click();
          OginizationPageMember orgpage=new OginizationPageMember(driver);
 //Click on Create Organization + icon
       orgpage.getOrganizationPlusIcon().click();
       
 CreateNewOrgonizationPageMember createorg=new CreateNewOrgonizationPageMember(driver);
//provide random org name	
	JavaUtilityMethod ju=new JavaUtilityMethod();
	int random= ju.createRandomNumber();
	String OrgonizationName= "orgo"+random; //cn.getOrgonizationName();
	createorg.getEnterOrganizationName().sendKeys(OrgonizationName);
//Enter phone
	createorg.getEnterPhone().sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",1,1));
//click on save button
	createorg.getSave_Btn().click();
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



