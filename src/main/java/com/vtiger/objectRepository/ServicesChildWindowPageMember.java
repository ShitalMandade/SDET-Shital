package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Vtiger.PurchaseOrderTc.CreatePurchaseOrderWithItemAndClickOnDownwardSymbol;

public class ServicesChildWindowPageMember  {
	
	
	public ServicesChildWindowPageMember(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }

	
	
	//Select any service
		@FindBy(xpath="//table/tbody/tr[@class='lvtColData']/td[3]/a")
		private WebElement selectChildwin_Service_link;
		public WebElement getSelectChildwin_Service_link() {
		return selectChildwin_Service_link;
		}
		
		
		
		

}
