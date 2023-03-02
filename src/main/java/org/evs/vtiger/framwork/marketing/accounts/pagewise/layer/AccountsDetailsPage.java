package org.evs.vtiger.framwork.marketing.accounts.pagewise.layer;


import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.AccountDetailOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsDetailsPage extends AccountDetailOR {

	private	WebUtil wu;

	public  AccountsDetailsPage(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), this);
		wu=genObj;		
	}


	public void verifyAccountsDetailsHeader() {
		wu.verifyContainsText(locAccountDetailHeader, "Account Information", "HomeDetailspage");
	}
}










