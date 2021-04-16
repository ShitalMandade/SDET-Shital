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
import com.vtiger.objectRepository.CreateNewOrgonizationPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.LoginPageMember;
import com.vtiger.objectRepository.OginizationPageMember;
import com.vtiger.objectRepository.OrganizationInformationPageMember;

public class CreateNewOrgonizationWithDifflist
{
	
	public static void main(String []args)throws IOException, InterruptedException
	//@Test
	//public CreateNewOrgonizationWithDifflist() throws IOException, InterruptedException
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
//Select Industry from list
		WebElement ilist=createorg.getIndustry();

picker.pickItemFromList(ilist, picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",2,1));
//Select accounttype from list
     WebElement typelist= createorg.getType();
	  
picker.pickItemFromList(typelist, picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",3,1));
//Slect rating from list
     WebElement ratinglist=createorg.getRating();

picker.pickItemFromList(ratinglist, picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",4,1));
    createorg.getSave_Btn().click();
	  	


//Validation Organization Information page
    OrganizationInformationPageMember oinfopg=new OrganizationInformationPageMember(driver);
    String actual =oinfopg.getOrganizationInformationVal().getText();

 String expected=picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",5,1);//"Organization Information";
 String result=   actual.contentEquals(expected)?"Organization Information pass":"Organization Information fail";
//click on Organizations
         oinfopg.getOrganizationClick().click();
 //Check new organization added on Orgonization page
 //Enter org in search textbox 
    WebElement search= orgpage.getSearch_org();
	  
	  picker.elementisclickable(driver, search);
	  search.sendKeys(OrgonizationName);
//Capture 'In'  List
	  WebElement olist= orgpage.getInList();
	  
// select Organization Name and click();
	  picker.pickItemFromList(olist,picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateOrgonizationWithDifflist",6,1));
//click on search button
	  orgpage.getSearch_Btn().click();
	
//wait for element until display(Dynamic xpath)
	  WebElement actualorgname1=driver.findElement(By.xpath("//a[text()='"+OrgonizationName+"']/ancestor::table[@class='lvt small']"));
      picker.waitforElement(actualorgname1);

boolean result1=actualorgname1.getText().contains(OrgonizationName);

		System.out.println(result1);
		 soft.assertAll();
	}}

	 
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
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