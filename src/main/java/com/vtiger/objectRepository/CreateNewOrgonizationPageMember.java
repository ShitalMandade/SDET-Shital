package com.vtiger.objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrgonizationPageMember {
	

//provide random org name
		@FindBy(name="accountname")
		private WebElement EnterOrganizationName;
		public WebElement getEnterOrganizationName() {
	      return  EnterOrganizationName ;
		}
	
		
//Enter phone
		@FindBy(id="phone")
		private WebElement EnterPhone;
		public WebElement getEnterPhone() {
	      return  EnterPhone ;
		}
		
//click on save	
		@FindBy(css="input[value=\"  Save  \"]")
		private WebElement save_Btn;
		public WebElement getSave_Btn() {
	      return  save_Btn ;
		}
		
	@FindBy(xpath="//input[value=\\\"  Save  \\\"]")
		private WebElement saveBtn;
	//Select Industry from list
		@FindBy(name="industry")
		private List<WebElement> industry;
		
		public List<WebElement> getIndustry() {
			return industry;
		}
	//Select Type from list
			@FindBy(name="accounttype")
			private WebElement type;
			
			public WebElement getType() {
				return type;
			}
		
	//Slect rating from list
			@FindBy(name="rating")
			private WebElement rating;
			
			public WebElement getRating() {
				return rating;
			}

		
		
		
		
		
		
		
		
		
		
		
		
	public CreateNewOrgonizationPageMember(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

}
