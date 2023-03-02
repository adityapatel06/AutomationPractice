package org.evs.vtiger.framwork.MyHomePage.Home.Pasewise.Layer;

import java.io.IOException;

import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.HomePageOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.evs.vtiger.framwork.inventory.invoice.pagewise.Layer_2.InvoiceLandingPage;
import org.evs.vtiger.framwork.marketing.accounts.pagewise.layer.AccountsLandingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLandingPage extends HomePageOR {


	
	private WebUtil wu ;

	public HomeLandingPage(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), this);
		wu=genObj;    
	}


	public void verifyHomePageHeader() {
		wu.verifyContainsText(locMarkCompaingsLk, "My Home Page", "HomePageverificationpicture");

	}
	public void gotoMarketingcompaings() {
		wu.actionmouseOver(locMarketinLK, "marketing Page is MouseOver is Successfuly");
		wu.click(locMarkCompaingsLk,"click bottun successfuly on compaings modules");



	}




	public void gotoMarketinAccounts() {
		wu.actionmouseOver(locMarketinLK, "marketing Page is MouseOver is Successfuly");
		wu.click(locMarkAccountsLK,"click bottun successfuly on Accounts modules");

	}





	public void gotoMarketingContacts() {
		wu.actionmouseOver(locMarketinLK, "marketing Page is MouseOver is Successfuly");
		wu.click(locMarkContactsLK,"click bottun successfuly on Contacts modules");

	}




	public void gotoMarketingLeads() {
		wu.actionmouseOver(locMarketinLK, "marketing Page is MouseOver is Successfuly");
		wu.click(locMarkLeadsLK,"click bottun successfuly on Leads modules");

	}	




	public void gotoSalesLeads() {

	}	




	public void gotoSalesAccounts() {

	}	




	public void gotoSalesContacts() {

	}	



	public void gotoInventoryInvoice() {
		wu.actionmouseOver(locInvenInvoiceLK, "Inventory Module is Mouseover Successfuly");
		wu.click(locInvoiceLK, "Click On Inventory  Invoice Link");
//		return PageFactory.initElements(wu.getDriver(), this);
	}













}
