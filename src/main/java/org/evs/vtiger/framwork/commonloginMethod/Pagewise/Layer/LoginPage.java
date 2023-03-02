package org.evs.vtiger.framwork.commonloginMethod.Pagewise.Layer;

import org.evs.vtiger.framwork.MyHomePage.Home.Pasewise.Layer.HomeLandingPage;
import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.LoginOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginOR {


	
	private WebUtil wu;
	
	public LoginPage(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), this);
        wu=genObj;
	}


	public void validLogin(String uName,String uPassword) {	
		wu.sendKeys(locUserNameTB, uName,  "input box in write *** username is success");
		wu.sendKeys(locUserPasswordTB, uPassword, "input box in write *** passwordname is success" );
		wu.click(locLoginBT, "login Button is Clicking Success");

	}



	public void invalidLogin() {	
		wu.sendKeys(locUserNameTB, "userName",  "input box in write *** username is success");
		wu.sendKeys(locUserPasswordTB, "password", "input box in write *** passwordname is success" );
		wu.click(locLoginBT, "login Button is Clicking Success");

	}	



}
