package org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountCreatoinOR {
	@FindBy(xpath ="//input[@name='accountname']" )
	protected WebElement locAccountsNameTB;
	
	@FindBy(xpath ="//input[@id='phone']" )
	protected WebElement locAccountsPhoneTB ;
	
	@FindBy(xpath = "//input[@class='crmbutton small save']")
	protected WebElement locAccountsSaveBT;
	
	@FindBy(xpath = "//input[class='crmbutton small cancel']")
	protected WebElement locAccountsCancelBT;
}
