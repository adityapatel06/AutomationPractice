package org.evs.vtiger.framwork.marketing.accounts.pagewise.layer;

import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.AccountCreatoinOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountsCreationPage extends AccountCreatoinOR {

	private WebUtil wu;

	public AccountsCreationPage(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), this);
		wu=genObj;
	}


	public void validateAccountsCreation(){


	}



	public void saveAccountsData() {
		enterAccountsData();
		wu.click(locAccountsSaveBT, "click on save button");

	}




	public void cancelAccountsData() {
		enterAccountsData();
		wu.click(locAccountsCancelBT, "click on cancel button");
	}


	public void enterAccountsData() {
		String AccountsName=  wu.getRandomName(10);
		wu.sendKeys(locAccountsNameTB, AccountsName, "enter account name");
		wu.sendKeys(locAccountsPhoneTB, "7309189560", "enter phone number");
	}








}
