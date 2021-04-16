package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageMember {
	
	//validate the loginpage 
	@FindBy(linkText="vtiger")
	private WebElement validate_loginpage;
	
	public WebElement getvalidate_loginpage() {
		return validate_loginpage;
	}
	//Enter valid USERNAME and PASSWORD and click on LOGIN
	@FindBy(name="user_name")
	private WebElement username_tf;
	
	public WebElement getUsername_tf() {
		return username_tf;
	}
	
	
	
	
	@FindBy(name="user_password")
	private WebElement password_tf;
	
	public WebElement getPassword_tf() {
		return password_tf;
	}
	
	
	
	//click on login button
	@FindBy(id="submitButton")
	private WebElement log_Btn;
	
	public WebElement getlog_Btn() {
		return log_Btn;
	}
	
	public void loginToApp(String username,String password)
	{
		username_tf.sendKeys(username);
		password_tf.sendKeys(password);
		log_Btn.click();
		}
	public LoginPageMember(WebDriver driver) {             //Rule -4
		PageFactory.initElements(driver, this);
		}
}