package com.Vtiger.PurchaseOrderTc;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.generic.BaseClass;
import com.vtiger.generic.Iconstant;
import com.vtiger.generic.WebDriverCommonUtils;
import com.vtiger.objectRepository.CreateNewPurchaseOrderPageMember;
import com.vtiger.objectRepository.HomePageMember;
import com.vtiger.objectRepository.PurchaseOrderMember;
import com.vtiger.objectRepository.VendorsChildWindowMember;
@Listeners(com.vtiger.generic.ListnerImplementation.class)
public class CreatePurchaseOrderWithAllMandatoryFieldsExceptItems extends BaseClass {
	WebDriverCommonUtils picker= new WebDriverCommonUtils();
	
	
	@Test(groups= {"Smoke"})
	
	public void CreatePurchaseOrderWithItemQtyAndListprice() throws IOException, InterruptedException
	{
		WebDriverCommonUtils picker= new WebDriverCommonUtils();
		 CreateNewPurchaseOrderPageMember cnpopm=new CreateNewPurchaseOrderPageMember(driver);
		//Validate Home page
	       HomePageMember homeobj=new HomePageMember(driver);
	       String home=homeobj.getValidateHomePage().getText();
	       Assert.assertEquals(home, "Home", "Homepage  pass");
//Click on Purchase Order link 
	       homeobj.getPurchaseOrderlink().click();
//click on create Purchase order icon  "+"
	       PurchaseOrderMember po=new PurchaseOrderMember(driver);
	       po.getCreatePurchaseOrderPlusIcon().click();
 //Enter sub billing add,ship adress
	       
cnpopm.getSubject_txt().sendKeys((picker.getDataFromExcel(Iconstant.vtigerExcel, "Creating New Purchase Order", 1, 1))); 
  
 //Select Vendor  and  product item 
	 cnpopm.getVenderPlusIcon().click();
	 picker.childWindowHanlde(driver);
	 VendorsChildWindowMember vcw=new VendorsChildWindowMember(driver);
	 vcw.getSelectChildwin_vendor_link().click();
	 picker.mainWindowHandle(driver);
   cnpopm.getBillingAddress_txt().sendKeys((picker.getDataFromExcel(Iconstant.vtigerExcel, "Creating New Purchase Order", 2, 1)));
    cnpopm.getShippingAddress_txt().sendKeys((picker.getDataFromExcel(Iconstant.vtigerExcel, "Creating New Purchase Order", 3, 1)));  
	cnpopm.getQty_txt().sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"Creating New Purchase Order",6,1));
   
	/*String item=picker.getDataFromExcel(Iconstant.vtigerExcel,"Creating New Purchase Order",4,1);
    System.out.println(item);
    cnpopm.getItem_Txt().sendKeys(item);
	*/
	cnpopm.getListPrice().sendKeys(picker.getDataFromExcel(Iconstant.vtigerExcel,"Creating New Purchase Order",5,1));
 cnpopm.getSave_Btn().click();
    String altmsg =picker.switchToAlertCapturemsg(driver);
    Assert.assertEquals(altmsg, picker.getDataFromExcel(Iconstant.vtigerExcel,"Creating New Purchase Order",8,1));

}

}

