package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderMember {
	
	@FindBy(css="img[title='Create Purchase Order...']")
	private WebElement createPurchaseOrderPlusIcon;
	public WebElement getCreatePurchaseOrderPlusIcon() {
	return createPurchaseOrderPlusIcon;
	}
	
	
	
	public PurchaseOrderMember(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }

}
