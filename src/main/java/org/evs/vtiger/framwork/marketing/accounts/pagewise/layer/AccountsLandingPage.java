package org.evs.vtiger.framwork.marketing.accounts.pagewise.layer;

import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.AccountLandingOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsLandingPage extends AccountLandingOR {
	

	private	WebUtil wu;
	
	public AccountsLandingPage(WebUtil genObj) {
	 PageFactory.initElements(genObj.getDriver(), this);
	wu= genObj;
	}

	
	public void validateAccountsLandingPage() {

	}	


	public void openCreationAccounts() {
		wu.click(locAcccountsPlusBT, "click on Accounts Creation Plus Button");
	}		











}
