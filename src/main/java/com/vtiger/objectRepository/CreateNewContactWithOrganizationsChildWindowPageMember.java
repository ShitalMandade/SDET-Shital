package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactWithOrganizationsChildWindowPageMember {
	//Validate Home page
		@FindBy(id="search_txt")
		private WebElement search_Txt;
		public WebElement getSearch_Txt() {
			return  search_Txt;
			
		}
		@FindBy(name="search")
		private WebElement search_Btn;
		public WebElement getsearch_Btn() {
			return  search_Btn;
			
		}
		
		@FindBy(linkText="vtiger")
		private WebElement clickOnOrg;
		public WebElement getclickOnOrg() {
			return  clickOnOrg;
			
		}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public CreateNewContactWithOrganizationsChildWindowPageMember(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

}
