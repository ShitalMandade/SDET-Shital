package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPageMember {
	
//Validation Organization Information page
	@FindBy(className="dvHeaderText")
	private WebElement organizationInformationVal;
	public WebElement getOrganizationInformationVal() {
      return  organizationInformationVal;
	}
//  click on Organizations
      
      @FindBy(linkText="Organizations")
  	private WebElement organizationClick;
  	public WebElement getOrganizationClick() {
        return  organizationClick ;

}
  	
  	
public OrganizationInformationPageMember(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
}
