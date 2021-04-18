package com.vtiger.generic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.LoginPageMember;

public class BaseClass {
	
		public static WebDriver	driver;
		public	JavaUtilityMethod ju = new JavaUtilityMethod();
		public JdbcgericMethod jdbc=new JdbcgericMethod();
		
		public WebDriverCommonUtils picker= new WebDriverCommonUtils();


	/**
	 * Create DB Connection
	 * And  Extent Report
	 */
		@BeforeSuite
		public void beforesuite() 
		{
			System.out.println("==DB connection==");
			System.out.println("==Extent report==");
		}

		@AfterSuite
		public void afterSuite() 
		{
			System.out.println("==Close DB connection==");
			System.out.println("== Close Extent report==");
		}

		/**
		 * Launch Browser and get the URL
		 * @throws IOException
		 */
		@BeforeClass
		public void launchBrowser() throws IOException {

			String browser=picker.getDataFromProperty(Iconstant.propfilePath, "browser");

			if(browser.equalsIgnoreCase("chrome")) {
				driver= new ChromeDriver();
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			}
			else if(browser.equalsIgnoreCase("ie")) {
				driver= new InternetExplorerDriver();
			}
			picker.maximizeWindow(driver);
			picker.implicitwait(driver);
			driver.get(picker.getDataFromProperty(Iconstant.propfilePath, "url"));
		}

		@AfterClass
		public void closeBrowser() {
			driver.quit();
		}

		@BeforeMethod
		public void logintoapp() throws IOException {
			LoginPageMember log = new LoginPageMember(driver);
			log.loginToApp(picker.getDataFromProperty(Iconstant.propfilePath, "username"),
					picker.getDataFromProperty(Iconstant.propfilePath, "password"));
			

		}

		/*@AfterMethod
		public void logoutfromApp() throws InterruptedException {
		//Mouseover to 'Administrator icon' and click on 'sign out'
			HomePageMember home = new HomePageMember(driver);
			home.logOut(driver);
			
			}*/
}
