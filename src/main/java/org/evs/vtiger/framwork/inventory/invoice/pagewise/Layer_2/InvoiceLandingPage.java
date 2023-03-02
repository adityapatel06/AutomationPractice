package org.evs.vtiger.framwork.inventory.invoice.pagewise.Layer_2;

import org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3.InvoiceLandingOR;
import org.evs.vtiger.framwork.genericMethods.Layer_1.WebUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoiceLandingPage extends InvoiceLandingOR {

	private WebUtil wu;

	public InvoiceLandingPage(WebUtil genObj) {
		PageFactory.initElements(genObj.getDriver(), this);
		wu=genObj;

		wu.click(locInvoiceLK, "click on invoice plus button");

	}



	public void openCreationInvoice() {


	}



}
