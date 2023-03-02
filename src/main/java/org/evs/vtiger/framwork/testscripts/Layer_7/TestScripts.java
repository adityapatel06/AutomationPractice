package org.evs.vtiger.framwork.testscripts.Layer_7;

import java.io.IOException;

import org.evs.vtiger.framwork.MyHomePage.Home.Pasewise.Layer.HomeLandingPage;
import org.evs.vtiger.framwork.commonloginMethod.Pagewise.Layer.LoginPage;
import org.evs.vtiger.framwork.genericMethods.Layer_1.BaseTestClass;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.evs.vtiger.framwork.inventory.invoice.pagewise.Layer_2.InvoiceCreationPage;
import org.evs.vtiger.framwork.inventory.invoice.pagewise.Layer_2.InvoiceLandingPage;
import org.evs.vtiger.framwork.marketing.accounts.pagewise.layer.AccountsCreationPage;
import org.evs.vtiger.framwork.marketing.accounts.pagewise.layer.AccountsDetailsPage;
import org.evs.vtiger.framwork.marketing.accounts.pagewise.layer.AccountsLandingPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

public class TestScripts extends BaseTestClass {
	
	
    @Test
	public void tsvalidateInvoiceAcountsData() {   	
		HomeLandingPage home=new HomeLandingPage(wu);
		home.gotoMarketinAccounts();
		AccountsLandingPage homelanding=new AccountsLandingPage(wu);
		homelanding.openCreationAccounts();
		AccountsCreationPage Acl=new AccountsCreationPage(wu);
		Acl.saveAccountsData();	 	
		AccountsDetailsPage AccounDetail=new AccountsDetailsPage(wu);
		AccounDetail.verifyAccountsDetailsHeader();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		home.gotoInventoryInvoice();
	
		InvoiceLandingPage invoiceLp= new InvoiceLandingPage(wu);	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		invoiceLp.openCreationInvoice();
		

	}
    
@Test(enabled = false)
public void tsValidateAccountsDetails() {
	
	
}






}
