package org.evs.vtiger.framwork.genericMethods.Layer_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.evs.vtiger.framwork.commonloginMethod.Pagewise.Layer.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.google.common.io.Files;

public class WebUtil {

	private WebDriver driver;
	private ExtentTest extTest;
	private ExtentReports extReport;
	private Properties prop;


	public Properties getPropObj() {
		return prop;
	}


	public WebUtil() {
		loaderConfigFile();
	}


	public void loaderConfigFile() {
		prop=new Properties();
		FileInputStream fis=null;		
		try {
			fis=new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



	public void getextentreportObject(String reportResultName) {
		ExtentHtmlReporter ExtHtmlRport = new ExtentHtmlReporter(reportResultName);
		ExtHtmlRport.config().setReportName("Function Reports Automation");
		ExtHtmlRport.config().setDocumentTitle("vtiger Functionality Reports");
		extReport =new ExtentReports();	
		extReport.attachReporter(ExtHtmlRport);
		extReport.setSystemInfo("username", System.getProperty("user.name"));
		extReport.setSystemInfo("OS", System.getProperty("user.os"));
		extReport.setSystemInfo("Envoirment", "QA");
	}


	public void startExtentTest(String testCaseName) {
		extTest=extReport.createTest(testCaseName);
	}


	//==================== OpenlaunchBrowser==========================================

	public void LaunchBrowser(String browsername) {
		if(browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
			driver=new ChromeDriver();		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		}else if(browsername.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "driver\\geckodriver.exe");			
			driver=new FirefoxDriver();		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}



	public void reportBrowserInfo() {
		if(driver instanceof ChromeDriver) {
			extTest.log(Status.INFO, "Chrome Browser is Launched Success");

		}else if(driver instanceof FirefoxDriver) {
			extTest.log(Status.INFO, "fireFox Browser is Launched Success");

		}else if(driver instanceof InternetExplorerDriver) {
			extTest.log(Status.INFO, " Browser is Launched Success");

		}
	}



	public void closeBrowser() {
		driver.close();
	}	



	public void quiteBrowser() {
		driver.quit();
	}	



	public void fluse() {
		extReport.flush();
	}	


	//================================ OpenUrl ===============================================//

	public void openUrl(String url) {
		try {
			driver.get(url);
			//extTest.log(Status.INFO, "url opened successfully");
		}catch(Exception e) {		
			extTest.log(Status.ERROR, "url does't open successfully");
			throw e;
		}
	}




	public WebDriver getDriver() {
		return driver;
	}




	public void openLoginPage(WebUtil wu, String browserName, String Url) {
		wu.LaunchBrowser(browserName);
		wu.openUrl(Url);


	}


	//============================ return of object WebElement ==========================//

	//	public WebElement getwebElement(WebElement webEle) {
	//
	//		//WebElement webEle;
	//
	//		try {
	//			
	//		}catch(NoSuchElementException e){
	//
	//			e.printStackTrace();
	//			extTest.log(Status.INFO, "exceptoin occured while finding element "+e);		
	//			
	//		}
	//		return webEle;
	//
	//	}



	//==================================== input Data method =============================//



	public void sendKeys(WebElement webEle, String inputvalue, String msg) {

		try {
			webEle.clear();
			webEle.sendKeys(inputvalue);
		}catch(StaleElementReferenceException e){			
			webEle.clear();
			webEle.sendKeys(inputvalue);
		}catch(ElementNotInteractableException e){

		}
		extTest.log(Status.INFO, msg);	


	}






	public void click( WebElement webEle, String msg) {
		try {
			webEle.click();			
		}catch(StaleElementReferenceException e){

			webEle.click();
		}catch(ElementNotInteractableException e){

		}
		extTest.log(Status.INFO, msg);	


	}





	public void selectByVisibleText(WebElement webEle,String selectText, String msg  ) {


		try {
			Select selobj=new Select(webEle);
			selobj.selectByVisibleText(selectText);
		}catch(StaleElementReferenceException e) {

			Select selobj=new Select(webEle);
			selobj.selectByVisibleText(selectText);

		}catch (ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);
	}




	public void selectByValue(WebElement webEle,String selectText, String msg  ) {


		try {
			Select selobj=new Select(webEle);
			selobj.selectByValue(selectText);
		}catch(StaleElementReferenceException e) {

			Select selobj=new Select(webEle);
			selobj.selectByValue(selectText);

		}catch (ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);
	}




	public void selectByIndex(WebElement webEle, ExtentTest extTest, int index, String msg  ) {

		try {
			Select selobj=new Select(webEle);
			selobj.selectByIndex(index);
		}catch(StaleElementReferenceException e) {

			Select selobj=new Select(webEle);
			selobj.selectByIndex(index);

		}catch (ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);
	}






	public void verifyInnerText(WebElement webEle ,String ExpectedText, String snapshortName) {

		String	Actualgettext=webEle.getText();
		if (Actualgettext.equalsIgnoreCase(ExpectedText)) {
			extTest.log(Status.PASS, "where Actual title is("+Actualgettext+") & expected title Text-("+ExpectedText+") verify Title Page Passed");
		} else {
			extTest.log(Status.FAIL, "where Actual title is("+Actualgettext+") & expected title Text-("+ExpectedText+") verify Title Page Passed");
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}





	public void verifygetAttributevalue(WebElement webEle,String ExpecText,String msg, String inputValue,String snapshortName ) {
		String getAttributeText= webEle.getAttribute(inputValue); 		
		if (getAttributeText.equalsIgnoreCase(ExpecText)) {
			extTest.log(Status.PASS, "where Actual title is("+getAttributeText+") & expected title Text-("+ExpecText+") verify Title Page Passed");
		} else {
			extTest.log(Status.FAIL, "where Actual title is("+getAttributeText+") & expected title Text-("+ExpecText+") verify Title Page Passed");
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  

	}



	public void verifygetTitle(String exptitlevalue ,String msg ,String snapshortName) {
		String ActualTitleText=driver.getTitle();
		if (ActualTitleText.equalsIgnoreCase(exptitlevalue)) {
			extTest.log(Status.PASS, "where Actual title is("+ActualTitleText+") & expected title Text-("+exptitlevalue+") verify Title Page Passed");
		} else {
			extTest.log(Status.FAIL, "where Actual title is("+ActualTitleText+") & expected title Text-("+exptitlevalue+") verify Title Page not Passed");
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}


	public void verifyElementsVisible(WebElement webEle ,String snapshortName) {
		boolean Visibletext=webEle.isDisplayed();
		if (Visibletext==true) {
			extTest.log(Status.PASS, "where Element is visible Because Element is Display"+Visibletext);
		} else {
			extTest.log(Status.PASS, "where Element is visible Because Element is Display"+Visibletext);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}



	public void verifyElementsinVisible(WebElement webEle ,String snapshortName) {
		boolean Visibletext=webEle.isDisplayed();
		if (Visibletext==false) {
			extTest.log(Status.PASS, "where Element is invisible Because Element is not Display"+Visibletext);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			extTest.log(Status.FAIL, "where Element is visible Because Element is Display "+Visibletext);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}


	}


	public void verifyisSeleccted(WebElement webEle, String snapshortName) {
		boolean ElementSelected=webEle.isSelected();
		if (ElementSelected==true) {
			extTest.log(Status.PASS, "where Element is Selected "+ElementSelected);
		} else {
			extTest.log(Status.FAIL, "where Element is unSelected"+ElementSelected);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}



	public void verifyisdeSeleccted(WebElement webEle, String snapshortName) {
		boolean ElementSelected=webEle.isSelected();
		if (ElementSelected==false) {
			extTest.log(Status.PASS, "where Element is deSelected "+ElementSelected);
		} else {
			extTest.log(Status.FAIL, "where Element is selected"+ElementSelected);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


	}


	public void verifyisEnable(WebElement webEle, String snapshortName) {
		boolean ElementEnable=webEle.isSelected();
		if (ElementEnable==true) {
			extTest.log(Status.PASS, "where Element is Enable "+ElementEnable);
		} else {
			extTest.log(Status.FAIL, "where Element is Enable "+ElementEnable);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


	}

	public void verifyisdisEnable(WebElement webEle, String snapshortName) {
		boolean ElementEnable=webEle.isSelected();
		if (ElementEnable==false) {
			extTest.log(Status.PASS, "where Element is isdisEnable "+ElementEnable);
		} else {
			extTest.log(Status.FAIL, "where Element is isdisEnable "+ElementEnable);
			String imgpath=Snapshort(snapshortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


	}


	public void verifyContainsText(WebElement webEle , String expectedText , String SnapShortName) {
		String ActualText=webEle.getText();
		if (ActualText.contains(expectedText)) {
			extTest.log(Status.PASS, "where Actual title Text("+ActualText+") & expected title Text-("+expectedText+") verify Title Page Passed");

		} else {
			extTest.log(Status.FAIL, "where Actual title Text("+ActualText+") & expected title Text-("+expectedText+") verify Title Page Passed");
			String imgpath=Snapshort(SnapShortName);			
			try {
				extTest.addScreenCaptureFromPath(imgpath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}




	public void actionmouseOver(WebElement webEle, String msg) {
		Actions actionobj=new Actions(driver);
		try {
			actionobj.moveToElement(webEle).build().perform();	
		}catch(StaleElementReferenceException e) {

			actionobj.moveToElement(webEle).build().perform();	

		}catch(ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);

	}






	public void actoinRightClick(WebElement webEle,String msg) {
		Actions actionobj=new Actions(driver);
		try {
			actionobj.contextClick(webEle).build().perform();	
		}catch(StaleElementReferenceException e) {

			actionobj.contextClick(webEle).build().perform();	

		}catch(ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);




	}






	public void actionsendkeys(WebElement webEle,String msg, String inputValue) {
		Actions actionobj=new Actions(driver);
		try {
			actionobj.sendKeys(webEle ,inputValue).build().perform();	
		}catch(StaleElementReferenceException e) {

			actionobj.sendKeys(webEle ,inputValue).build().perform();	

		}catch(ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);

	}






	public void actiondoubleCLick(WebElement webEle,String msg) {
		Actions actionobj=new Actions(driver);
		try {
			actionobj.doubleClick(webEle).build().perform();	
		}catch(StaleElementReferenceException e) {

			actionobj.doubleClick(webEle).build().perform();	

		}catch(ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);

	}







	public void dragAndDrop(WebElement webEle,WebElement webEle2,String msg) {

		Actions actionobj=new Actions(driver);
		try {
			actionobj.dragAndDrop(webEle, webEle2).build().perform();	
		}catch(StaleElementReferenceException e) {

			actionobj.dragAndDrop(webEle, webEle2).build().perform();	

		}catch(ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);

	}






	public void switchToFrameByXpath(WebElement webEle,String msg) {
		try {
			driver.switchTo().frame(webEle);
		}catch(NoSuchElementException e) {
			driver.switchTo().frame(webEle);

		}catch(StaleElementReferenceException e) {

		}catch(ElementNotInteractableException e) {

		}
		extTest.log(Status.INFO, msg);




	}





	public void switchToMainwindow(ExtentTest extText ,String msg) {


		try {

			driver.switchTo().defaultContent();

		}catch(NoSuchElementException x) {

		}catch(StaleElementReferenceException e) {

		}catch(ElementNotInteractableException e) {

		}
		extText.log(Status.INFO, msg);

	}





	public void getWindoHandleTitle(String ExpTitlevalue,String msg) {		
		Set<String> AllWindowValue=driver.getWindowHandles();		
		for(String AllValue: AllWindowValue) {		
			driver.switchTo().window(AllValue);		
			String  getTitleValue=	driver.getTitle();	
			if(getTitleValue.contains(ExpTitlevalue)) {
				break;
			}

		}
		extTest.log(Status.INFO, msg);
	}






	public void getWindoHandleUrl(String ExpURLvalue ,String msg) {		
		Set<String> AllWindowValue=driver.getWindowHandles();		
		for(String AllValue: AllWindowValue) {		
			driver.switchTo().window(AllValue);		
			String  getTitleValue=	driver.getCurrentUrl();	
			if(getTitleValue.contains(ExpURLvalue)) {
				break;
			}

		}
		extTest.log(Status.INFO, msg);
	}







	public void getAllertmsg(String msg) {
		try {
			Alert alertObj=	driver.switchTo().alert();
			alertObj.accept();
		}catch(NoAlertPresentException e) {
			Alert alertObj=	driver.switchTo().alert();
			alertObj.accept();
		}
		extTest.log(Status.INFO, msg);


	}


	public String Snapshort(String snapshortname) {
		TakesScreenshot scrtsho=(TakesScreenshot) driver;
		File soursefile=scrtsho.getScreenshotAs(OutputType.FILE);
		String Time=getTimeStamp();
		File distinationFile = new File("reports\\"+snapshortname+Time+".jpeg");
		try {
			Files.copy(soursefile, distinationFile);
		}catch(IOException e) {

		}
		return distinationFile.getAbsolutePath();
	}


	public void attachSnapShortCaptureReport(String imgPath) {
		try {
			extTest.addScreenCaptureFromPath(imgPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}




	public String getTimeStamp(){
		SimpleDateFormat sft=new SimpleDateFormat("dd/MM/yyyy hh_mm_ss");
		String Time=sft.format(new Date());
		return Time;
	}






	public String getRandomName(int count) {
		String name="";
		for(int i=1; i<=count; i++) {
			int rnd=(int) (Math.random() * 52);
			Character base = (rnd < 26) ? 'A' : 'a' ;
			name =name+base.toString() + rnd%26;
		}
		return name;

	}



	public void OnHoldTime(int count) {
		try {
			Thread.sleep(count);
		}catch(InterruptedException e) {

		}
	}


	public void waitForElementVisibility(WebElement webEle, int timeoutseconds) {	
		WebDriverWait expWait=new WebDriverWait(driver, timeoutseconds);
		expWait.until(ExpectedConditions.visibilityOf(webEle));
	}




	public void waitForElementInvisibility(WebElement webEle, int timeoutseconds) {	
		WebDriverWait expWait=new WebDriverWait(driver, timeoutseconds);
		expWait.until(ExpectedConditions.invisibilityOf(webEle));
	}



	public void waitForElementEnable(WebElement webEle, int timeoutseconds) {	
		WebDriverWait expWait=new WebDriverWait(driver, timeoutseconds);
		expWait.until(ExpectedConditions.elementToBeClickable(webEle));
	}



	public void waitForElementText(WebElement webEle, int timeoutseconds ,String expectedtext) {	
		WebDriverWait expWait=new WebDriverWait(driver, timeoutseconds);
		expWait.until(ExpectedConditions.textToBePresentInElement(webEle ,expectedtext));
	}

}