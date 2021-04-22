package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.BaseClass;

public class OginizationPageMember extends BaseClass{
//click on Create Organization + icon
			@FindBy(css="img[title='Create Organization...']")
			private WebElement OrganizationPlusIcon;
			public WebElement getOrganizationPlusIcon() {
		      return  OrganizationPlusIcon ;
		
}
//Enter org in search textbox
			@FindBy(name="search_text")
			private WebElement search_org;
			public WebElement getSearch_org() {
		      return  search_org ;
		
}
//Capture 'In'  List
			@FindBy(xpath="//select[@id='bas_searchfield']")
			private WebElement inList;
			public WebElement getInList() {
		      return  inList ;
		
}
			
 //click on search button
			@FindBy(name="submit")
			private WebElement search_Btn;
			public WebElement getSearch_Btn() {
		      return  search_Btn ;
		
}
					
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	public OginizationPageMember (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
			
			
			
			
}
