package com.vtiger.generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.vtiger.generic.BaseClass;


public class ListnerImplementation extends BaseClass implements ITestListener{
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	
	public void onTestFailure(ITestResult result) {
      /* Date d= new Date();
		String CurrentTimeDate=d.toString().replace(":","-");
		System.out.println(" CurrentTimeDate   " +CurrentTimeDate);
		String tCName= agr0.getName();
		System.out.println(tCName+"    TC fail");
		System.out.println(agr0.getName()+"  TC  Execition Failed");
		EventFiringWebDriver efwd=new EventFiringWebDriver(staticdriver);
		File sourceFile =efwd.getScreenshotAs(OutputType.FILE);
		try
		{                                  //  "./Screenshot/"
		FileUtils.copyFile(sourceFile,new File("./FailedScreenshot/"+tCName + CurrentTimeDate+".png"));
		}
		
		catch(IOException e)
		{
		e.printStackTrace();		
	    }*/
		System.out.println("name of fail   "+result.getName());
		
	
		ExtentReportrceation.testlog.log(Status.FAIL, result.getName()+" is Fail");
		ExtentReportrceation.testlog.log(Status.FAIL, "TC failed" + result.getThrowable());
		try {
			
			BaseClass.getscreenshot(result.getName());
			ExtentReportrceation.testlog.addScreenCaptureFromPath(System.getProperty("user.dir")+"/Screenshots/"+result.getName()+".png");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}


	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
