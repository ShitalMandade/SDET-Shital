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
import com.vtiger.objectRepository.ProductsChildWindowMember;
import com.vtiger.objectRepository.PurchaseOrderMember;
import com.vtiger.objectRepository.VendorsChildWindowMember;
@Listeners(com.vtiger.generic.ListnerImplementation.class)
public class CreatePurchaseOrderWithItemWithoutEnteringQTY extends BaseClass{
	@Test
	public void CreatePurchaseOrderWithItemWithoutEnteringQTY() throws IOException
	{
		WebDriverCommonUtils picker= new WebDriverCommonUtils();
		 CreateNewPurchaseOrderPageMember cnpopm=new CreateNewPurchaseOrderPageMember(driver);
		//Validate Home page
	       HomePageMember homeobj=new HomePageMember(driver);
	       String home=homeobj.getValidateHomePage().getText();
	       Assert.assertEquals(home, "Homee", "Homepage  pass");
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
	cnpopm.getProductsIcon().click();
	 picker.childWindowHanlde(driver);
	 ProductsChildWindowMember pcw=new ProductsChildWindowMember(driver);
	 pcw.getSelectChildwin_Product_link().click();
	 picker.mainWindowHandle(driver);

cnpopm.getSave_Btn().click();       
String altmsg =picker.switchToAlertCapturemsg(driver);
Assert.assertEquals(altmsg, picker.getDataFromExcel(Iconstant.vtigerExcel,"Creating New Purchase Order",7,1));
	       
		
	}
	

}
