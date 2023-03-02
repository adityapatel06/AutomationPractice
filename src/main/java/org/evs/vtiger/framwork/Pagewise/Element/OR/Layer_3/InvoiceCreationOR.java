package org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoiceCreationOR {
	@FindBy(xpath = "//input[@name='account_id']//following-sibling::img[@alt='Select']")
	protected WebElement locCreateInvoiceplusBT;	
	@FindBy(xpath = "//input[@id='search_txt']")
	protected WebElement locSearchTexBOX;
	@FindBy(xpath = "//input[@name='search']")
	protected WebElement locSearchText;
	@FindBy(xpath = "//a[text()='a0A1A21A23A7A15A1A13A4a2']")
	protected WebElement locAccountLK;

}
