package com.Vtiger.tc;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;
import com.vtiger.objectRepository.ContactsPageMember;
import com.vtiger.objectRepository.CreateNewContactPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.LoginPageMember;
@Listeners(com.vtiger.generic.ListnerImplementation.class)
public class CreateNewContactPage extends BaseClass{
	@Test
	 public void CreateaContact() throws IOException
	{ 
	WebDriverCommonUtils picker= new WebDriverCommonUtils();
			//WebDriver driver=new ChromeDriver();
			picker.implicitwait(driver);
			picker.maximizeWindow(driver);
			//Open Vtiger application
			driver.get(picker.getDataFromProperty(Iconstant.propfilePath,"url"));
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
//Enter lastname and save
createContact.lastNameAndSave(picker.getDataFromExcel(Iconstant.vtigerExcel,"CreateContactWithOrganizationIT",2, 1));
		soft.assertAll();
}
}