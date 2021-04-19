package com.Vtiger.PurchaseOrderTc;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.WebDriverCommonUtils;
import com.vtiger.objectRepository.CreateNewPurchaseOrderPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.PurchaseOrderMember;
import com.vtiger.objectRepository.ServicesChildWindowPageMember;
@Listeners(com.vtiger.generic.ListnerImplementation.class)
public class CreatePurchaseOrderWithItemAndClickOnDownwardSymbol extends BaseClass{
	@Test
	public void CreatePurchaseOrderWithItemAndClickOnDownwardSymbol() throws IOException, InterruptedException 
	{
	WebDriverCommonUtils picker= new WebDriverCommonUtils();
	 CreateNewPurchaseOrderPageMember cnpopm=new CreateNewPurchaseOrderPageMember(driver);
	 ServicesChildWindowPageMember scwpm=new ServicesChildWindowPageMember(driver);
	

//Validate Home page
	       HomePageMember homeobj=new HomePageMember(driver);
	       String home=homeobj.getValidateHomePage().getText();
	       Assert.assertEquals(home, "Home", "Homepage  pass");
//Click on Purchase Order link 
	       homeobj.getPurchaseOrderlink().click();
//click on create Purchase order icon  "+"
	       PurchaseOrderMember po=new PurchaseOrderMember(driver);
	       po.getCreatePurchaseOrderPlusIcon().click();
//Click On AddServices button, click on service icon and  Click On Downward Symbol
	       //scroll down
	       //ju.scrollDown(driver);
	      // picker.waitforElement(cnpopm.getAddService_Btn());
	       
	       cnpopm.getAddService_Btn().click();
			cnpopm.getServicesIcon().click();
			//switch to childWindow
			picker.childWindowHanlde(driver);
			//select sevice link
			scwpm.getSelectChildwin_Service_link();
			picker.mainWindowHandle(driver);
			cnpopm.getDownwardSymbol();

}
}
