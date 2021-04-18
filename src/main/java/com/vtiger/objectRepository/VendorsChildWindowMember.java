package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsChildWindowMember {
	
	
	
	public VendorsChildWindowMember(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }

	
	
	//Select any vendor
	
	@FindBy(xpath="//*[@id=\"1\"]")
		private WebElement selectChildwin_Vendor_link;
		public WebElement getSelectChildwin_vendor_link() {
		return selectChildwin_Vendor_link;
		}
		

}
