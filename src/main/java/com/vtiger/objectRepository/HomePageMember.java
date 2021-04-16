package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.WebDriverCommonUtils;

public class HomePageMember {
	public WebDriverCommonUtils picker= new WebDriverCommonUtils();

	//Validate Home page
	@FindBy(className="hdrLink")
	private WebElement validateHomePage;
	public WebElement getValidateHomePage() {
		return  validateHomePage;
		
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contatctlink;
	public WebElement getContatctlink() {
		return contatctlink;
		
	}
	@FindBy(name="Organizations")
	private WebElement orglink;
	public WebElement getOrglink() {
	return orglink;
	}
	//Navigate to More and click on Organizations
	
	@FindBy(linkText="More")
	private WebElement moveToMore;
	public WebElement getMoveToMore() {
	return moveToMore;
	}
	
	
	//Mouseover to 'Administrator icon' and click on 'sign out'
	
	@FindBy(css="td[onmouseout=\"fnHideDrop('ondemand_sub');\"]")
	private WebElement moveToAdministrator;
	public WebElement getMoveToAdministrator() {
	return moveToAdministrator;
	}
	//click on siognout
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	public WebElement getSignOut() {
	return signOut;
	}
	
     public void logOut(WebDriver driver)
        {
    	//Mouseover to 'Administrator icon' and click on 'sign out'
		   picker.movetoelement(driver, moveToAdministrator);
	       signOut.click();
    	 
   }		
	public HomePageMember(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
}
