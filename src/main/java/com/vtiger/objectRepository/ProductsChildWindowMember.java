package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsChildWindowMember {

	public ProductsChildWindowMember(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }

	
	
	//Select any product
		//@FindBy(xpath="//table/tbody/tr[@class='lvtColData'][1]/td/a")
		@FindBy(xpath="//*[@id=\"popup_product_52\"]")
		private WebElement selectChildwin_Product_link;
		public WebElement getSelectChildwin_Product_link() {
		return selectChildwin_Product_link;
		}

}
