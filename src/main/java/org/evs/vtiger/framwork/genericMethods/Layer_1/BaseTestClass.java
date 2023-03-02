package org.evs.vtiger.framwork.genericMethods.Layer_1;

import java.lang.reflect.Method;
import java.util.Properties;

import org.evs.vtiger.framwork.common.Methos.Layer_4.CommonMethods;
import org.evs.vtiger.framwork.commonloginMethod.Pagewise.Layer.LoginPage;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;


public class BaseTestClass {

	protected WebUtil wu=new WebUtil();
	protected Properties prop;

	@BeforeSuite
	public void tcOpenApplicationofVtiger() {
		
		wu.getextentreportObject("reports//Aditya.html");	

	}


	@BeforeClass
	public void LaunchingMethod() {
		prop= wu.getPropObj();
		String	urlvalue= prop.getProperty("url");
		String	browserName= prop.getProperty("browser");
		wu.openLoginPage(wu, browserName, urlvalue);

	}


	@BeforeMethod
	public void LoginPageMethod(Method method) {
		String tcName=method.getName();
		wu.startExtentTest(tcName);
		wu.reportBrowserInfo();
		LoginPage login=new LoginPage(wu);
		String	userNamevalue= prop.getProperty("username");
		String	userPasswordvalue= prop.getProperty("password");

		login.validLogin(userNamevalue, userPasswordvalue);

	}

	@DataProvider(name="data")
	public void dataProviderFromExecelSheet() {
		
	}
	
	
	
	
	
	@AfterMethod
	public void tclogOut(ITestResult result ,Method method) {
		int status=result.getStatus();
		if(status==ITestResult.FAILURE) {
			String tcName=method.getName();
			String imgPath=	wu.Snapshort(tcName);
			wu.attachSnapShortCaptureReport(imgPath);	

		}
		CommonMethods cmm=new CommonMethods(wu);
		cmm.tcLogOut();
		wu.fluse();

	}


	@AfterClass(enabled = false)
	public void closeBrowser() {
		wu.closeBrowser();
		wu.quiteBrowser();


	}



	@AfterSuite
	public void closeApplication() {
		System.out.println("Application is close");	
	}


}
