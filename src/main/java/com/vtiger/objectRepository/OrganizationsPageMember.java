package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPageMember {
	//Click on Create contact + icon page
	
	@FindBy(css="img[title='Create Organization...']")
	private WebElement createOrgonizationPlusIcon;
	public WebElement getCreateOrgonizationPlusIcon() {
	return createOrgonizationPlusIcon;
	}
		
		 public OrganizationsPageMember(WebDriver driver)
		 {
			 PageFactory.initElements(driver, this);
			 
		 }

}
