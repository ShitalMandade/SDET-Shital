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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;
import com.vtiger.objectRepository.ContactsPageMember;
import com.vtiger.objectRepository.CreateNewContactPageMember;
import com.vtiger.objectRepository.CreateNewContactWithOrganizationsChildWindowPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.LoginPageMember;
@Listeners(com.vtiger.generic.ListnerImplementation.class)
public class CreateContactWithOrganizationIT extends BaseClass{
	@Test
	public void CreateContactWithOrganizationIT() throws IOException {
	WebDriverCommonUtils picker= new WebDriverCommonUtils();
		//WebDriver driver=new ChromeDriver();
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
// Validate Home page
		        HomePageMember homeobj=new HomePageMember(driver);
		       String home=homeobj.getValidateHomePage().getText();
		       Assert.assertEquals(home, "Home", "Homepage  pass");
		       homeobj.getContatctlink().click();
//Click on Create contact + icon page
		       ContactsPageMember contacts=new ContactsPageMember(driver);
		       contacts.getCreateContactPlusIcon().click();
//Select salutationtype
		       CreateNewContactPageMember createContact=new CreateNewContactPageMember(driver);
		       WebElement slist=createContact.getSalutationtype();
			   picker.pickItemFromList(slist, "Mrs");
//Enter fistname
	createContact.getFistname().sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT",1, 1));
//Enter lastname 
	createContact.getLastname().sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT",2, 1));
//click on orgonization icon
	     createContact.getOrgonizationIcon().click();
//childWindowPage	 
 CreateNewContactWithOrganizationsChildWindowPageMember cwpgm=new CreateNewContactWithOrganizationsChildWindowPageMember(driver);
		picker.childWindowHanlde(driver);
		   //bytiltle
		//picker.switchtodwindow(driver, "childwindtit");
// Enter org in search box
		cwpgm.getSearch_Txt().sendKeys("vtiger");
//click on search btn
		     cwpgm.getsearch_Btn().click();
//Select org
		    cwpgm.getclickOnOrg();
//Swicth to main window		    
		picker.mainWindowHandle(driver);
		             //bytiltle
                     // picker.switchtodwindow(driver, "Contacts");
//Enter mobile no	
createContact.getMobileNo().sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT", 3, 1));
//click on save
	           createContact.getSave_Btn().click();
		soft.assertAll();
	}
	}


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*		//validate the login page 
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
	*/
	

