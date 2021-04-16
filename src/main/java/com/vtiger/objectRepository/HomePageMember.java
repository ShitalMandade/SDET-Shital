package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageMember {

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
	
	
	
	public HomePageMember(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
}
