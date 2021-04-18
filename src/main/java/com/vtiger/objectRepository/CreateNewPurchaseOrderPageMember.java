package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewPurchaseOrderPageMember {
	
	//Enetr Subject
		@FindBy(name="subject")
		private WebElement subject_txt;
		public WebElement getSubject_txt() {
		return subject_txt;
		}
	//Select Vendor + icon
				@FindBy(xpath="//img[@title='Select']")
				private WebElement venderPlusIcon;
				public WebElement getVenderPlusIcon() {
				return venderPlusIcon;
				}
	//Enter Billing Address
				@FindBy(name="bill_street")
				private WebElement billingAddress_txt;
				public WebElement getBillingAddress_txt() {
				return billingAddress_txt;
				}
	//Enter Shipping  Address
				@FindBy(name="ship_street")
				private WebElement shippingAddress_txt;
				public WebElement getShippingAddress_txt() {
				return shippingAddress_txt;
				}
			
//click on products icon item
				@FindBy(xpath="//textarea[contains(@id,'comment')]")
			//	@FindBy(id="comment1")
				private WebElement item_Txt;
				public WebElement getItem_Txt() {
				return item_Txt;
				}
				//Enter item in textBox
				@FindBy(xpath="//img[@title='Products']")
				private WebElement productsIcon;
				public WebElement getProductsIcon() {
				return productsIcon;
				}


//Enter Qty                    
				                @FindBy(xpath="//input[contains(@id,'qty')]")
								//@FindBy(id="qty1")
								private WebElement qty_txt;
								public WebElement getQty_txt() {
								return qty_txt;
								}
//Enter List Price
								@FindBy(xpath="//input[contains (@id,'listPrice')]")
								private WebElement listPrice;
								public WebElement getListPrice() {
								return listPrice;
								}
								
										
				
				
//click on save
				
				@FindBy(css="input[type=submit]")
				private WebElement save_Btn;

				public WebElement getSave_Btn() {
				return save_Btn;
			}
	
	
//click 'Add service' button
	@FindBy(xpath="//input[@name='Button'][2]")
	private WebElement addService_Btn;
	public WebElement getAddService_Btn() {
	return addService_Btn;
	}
	
	
	//click on icon services 
		@FindBy(xpath="//img[@title='Services']")
		private WebElement servicesIcon;
		public WebElement getServicesIcon() {
		return servicesIcon;
		}
		
		
		
	
//Click on "Downward" symbol
				@FindBy(xpath="//a[@title='Move Downward']")
				private WebElement downwardSymbol;
				public WebElement getDownwardSymbol() {
				return downwardSymbol;
				}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public CreateNewPurchaseOrderPageMember(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }


}
