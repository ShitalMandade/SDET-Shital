package com.vtiger.generic;

import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class JavaUtilityMethod {
	

	
	/**
	 * @author Shital
	 *  Generate a random number
	 * @return randomnumber till 10000
	 */
	public int createRandomNumber() 
	{
		Random r = new Random();
		int randomnumber= r.nextInt(10000);
		return randomnumber;
	}
	/**
	 * @author Shital
	 *  Scroll down 
	 * @param driver
	 */public void scrollDown(WebDriver driver) 
		{
		 EventFiringWebDriver efwd=new EventFiringWebDriver(driver );
	       efwd.executeAsyncScript("window.scrollBy(0,1000);");
		}
	
	
	
	

	/**
	 * @author AMAR-G
	 * Provide Current System Date
	 * @return currentSysDate
	 */

	public String getCurrentSystemDate() 
	{
		Date dateobj= new  Date();
		String currentSysDate=dateobj.toString();
		return currentSysDate;

	}
	/**
	 * @author AMAR-G
	 * Provide current month
	 * @return current month
	 */
	public int getCurrentMonth() 
	{
		Date dateobj= new  Date();
		return dateobj.getMonth();

	}

	/**
	 * @author AMAR-G
	 * Gives current date
	 * @return date
	 */
	public String getDate()
	{
		Date dateobj= new  Date();
		String currentSysDate=dateobj.toString();
		String arr[]=currentSysDate.split(" ");
		return arr[2];

	}

}
