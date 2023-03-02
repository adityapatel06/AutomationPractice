package org.evs.vtiger.framwork.common.Element.OR.Layer_5;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CommonOR {
	@FindBy(xpath="//input[@name='user_name']")
	protected WebElement locUserNameTB;

	@FindBy(xpath="//input[@name='user_password']")
	protected WebElement locUserPasswordTB;

	@FindBy(xpath="//input[@name='Login']")
	protected WebElement locLoginBT;

}
