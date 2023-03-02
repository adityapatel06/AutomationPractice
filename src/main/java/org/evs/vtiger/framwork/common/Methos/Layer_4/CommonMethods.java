package org.evs.vtiger.framwork.common.Methos.Layer_4;

import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.LoginOR;
import org.evs.vtiger.framwork.common.Element.OR.Layer_5.CommonOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.support.PageFactory;

public class CommonMethods extends CommonOR{
	
private WebUtil wu;
	
	public CommonMethods(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), this);
        wu=genObj;
	}
	
	
	
	public void validLogin() {	
		wu.sendKeys(locUserNameTB, "admin",  "input box in write *** username is success");
		wu.sendKeys(locUserPasswordTB, "admin", "input box in write *** passwordname is success" );
		wu.click(locLoginBT, "login Button is Clicking Success");

	}



	public void invalidLogin() {	
		wu.sendKeys(locUserNameTB, "userName",  "input box in write *** username is success");
		wu.sendKeys(locUserPasswordTB, "password", "input box in write *** passwordname is success" );
		wu.click(locLoginBT, "login Button is Clicking Success");

	}	

	
	
	

public void tcLogOut() {
	
}	
	
	
	
	
	
}
