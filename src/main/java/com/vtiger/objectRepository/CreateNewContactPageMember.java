package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.generic.Iconstant;

public class CreateNewContactPageMember {
	
	//Select salutationtype
	@FindBy(name="salutationtype")
	private WebElement salutationtype;
	
	public WebElement getSalutationtype() {
		return salutationtype;
	}
	
	//Enter fistname
	@FindBy(name="firstname")
	private WebElement fistname;
	public WebElement getFistname() {
		return fistname;
	}
	//Enter lastname
	@FindBy(name="lastname")
	private WebElement lastname;
	public WebElement getLastname() {
		return lastname;
	}
	//click on orgonization icon
	
	@FindBy(xpath="//img[@title='Select'][1]")
	private WebElement orgonizationIcon;

	public WebElement getOrgonizationIcon() {
	return orgonizationIcon;
}

	//Enter Mobile no
	@FindBy(id="mobile")
	private WebElement mobileNo;

	public WebElement getMobileNo() {
	return mobileNo;
}
	
	
	
	

	//click on save
	
	@FindBy(css="input[type=submit]")
	private WebElement save_Btn;

	public WebElement getSave_Btn() {
	return save_Btn;
}
public void lastNameAndSave(String Minditorylastname)
{
	lastname.sendKeys(Minditorylastname);
	save_Btn.click();
	
	
}
	
	
				
	public CreateNewContactPageMember(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	
}
