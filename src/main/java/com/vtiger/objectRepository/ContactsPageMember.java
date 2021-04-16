package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPageMember {
	
	//Click on Create contact + icon page
	
	@FindBy(css="img[title='Create Contact...']")
	private WebElement createContactPlusIcon;
	public WebElement getCreateContactPlusIcon() {
	return createContactPlusIcon;
	}
	
	 public ContactsPageMember(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }

}
