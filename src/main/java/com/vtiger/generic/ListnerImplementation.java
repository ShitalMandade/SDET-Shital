package com.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class ListnerImplementation extends BaseClass implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult agr0) {
		Date d= new Date();
		String CurrentTimeDate=d.toString().replace(":","-");
		System.out.println(" CurrentTimeDate   " +CurrentTimeDate);
		String tCName= agr0.getName();
		System.out.println(tCName+"    TC fail");
		System.out.println(agr0.getName()+"  TC  Execition Failed");
		EventFiringWebDriver efwd=new EventFiringWebDriver(BaseClass .driver);
		File sourceFile = efwd.getScreenshotAs(OutputType.FILE);
		try
		{                                  //  "./Screenshot/"
		FileUtils.copyFile(sourceFile,new File("./FailedScreenshot/"+tCName + CurrentTimeDate+".png"));
		}
		
		catch(IOException e)
		{
		e.printStackTrace();		
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
