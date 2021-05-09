package com.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.LoginPageMember;

public class BaseClass {
	
	public   WebDriver driver;
		
		
		public	JavaUtilityMethod ju = new JavaUtilityMethod();
		public JdbcgericMethod jdbc=new JdbcgericMethod();
		
		public WebDriverCommonUtils picker= new WebDriverCommonUtils();
		public static WebDriver staticdriver;// listner


	/**
	 * Create DB Connection
	 * And  Extent Report
	 */
		@BeforeSuite(groups= {"Smoke","Regration"})
		public void beforesuite() 
		{
			System.out.println("==DB connection==");
			System.out.println("==Extent report==");
		}

		@AfterSuite(groups= {"Smoke","Regration"})
		public void afterSuite() 
		{
			System.out.println("==Close DB connection==");
			System.out.println("== Close Extent report==");
		}

		/**
		 * Launch Browser and get the URL
		 * @throws IOException
		 */
		
		@BeforeClass(groups= {"Smoke","Regration"})
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
			staticdriver=driver;
			picker.maximizeWindow(driver);
			picker.implicitwait(driver);
			//staticdriver=driver;
		
			driver.get(picker.getDataFromProperty(Iconstant.propfilePath, "url"));
		}
		
		
		/*
		@Parameters("BrowserValue")
		@BeforeClass
		public void launchBrowserCompatability(String browser) throws IOException {
			Reporter.log("==========Launch combatabilty============");

//String browser=picker.getDataFromProperty(Iconstant.propfilePath, "browser");

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
		*/

		@AfterClass(groups= {"Smoke","Regration"})
		public void closeBrowser() {
			driver.quit();
		}

		@BeforeMethod(groups= {"Smoke","Regration"})
		public void logintoapp() throws IOException {
			LoginPageMember log = new LoginPageMember(driver);
			log.loginToApp(picker.getDataFromProperty(Iconstant.propfilePath, "username"),
					picker.getDataFromProperty(Iconstant.propfilePath, "password"));
			

		}
		public static String getscreenshot( String name) throws IOException 
		{
			/* Date d= new Date();
			String CurrentTimeDate=d.toString().replace(":","-");
			System.out.println(" CurrentTimeDate   " +CurrentTimeDate);
		//	String tCName= agr0.getName();
			///System.out.println(tCName+"    TC fail");
			//System.out.println(agr0.getName()+"  TC  Execition Failed");
			EventFiringWebDriver efwd=new EventFiringWebDriver(staticdriver);
			File sourceFile =efwd.getScreenshotAs(OutputType.FILE);
			String destfile=	"./FailedScreenshot/"+ CurrentTimeDate+".png";
			try
			{   
				//  "./Screenshot/"
			
			FileUtils.copyFile(sourceFile,new File(destfile));
			}
			
			catch(IOException e)
			{
			e.printStackTrace();		
		    }*/
			
		   File srcfile =((TakesScreenshot) staticdriver).getScreenshotAs(OutputType.FILE);
			String destfile= System.getProperty("user.dir")+"/Screenshots/"+name+".png";
			File finaldest = new File(destfile) ;
			FileUtils.copyFile(srcfile,finaldest);
	
			return destfile;
		}

		

		/*@AfterMethod
		public void logoutfromApp() throws InterruptedException {
		//Mouseover to 'Administrator icon' and click on 'sign out'
			HomePageMember home = new HomePageMember(driver);
			home.logOut(driver);
			
			}*/
}
