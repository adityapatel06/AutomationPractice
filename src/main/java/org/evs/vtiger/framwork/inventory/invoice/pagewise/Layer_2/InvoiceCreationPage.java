package org.evs.vtiger.framwork.inventory.invoice.pagewise.Layer_2;

import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.InvoiceCreationOR;
import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.InvoiceLandingOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceCreationPage extends InvoiceCreationOR {

	private WebUtil wu;

	public InvoiceCreationPage(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), InvoiceDetailsPage.class);
		wu=genObj;

	}


	public void openinvoicePlus() {
		wu.click(locCreateInvoiceplusBT, "click on invoice plus third button");
		wu.getWindoHandleUrl("http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific=", "new window open sccessfully");
		wu.sendKeys(locSearchTexBOX, "a0A1A21A23A7A15A1A13A4a2", "input Data on serch Box");
		wu.click(locSearchText, "click on Search button");
		wu.click(locAccountLK, "click on Account Data Link");
		wu.getAllertmsg("Accept alert massage");

	}

}
