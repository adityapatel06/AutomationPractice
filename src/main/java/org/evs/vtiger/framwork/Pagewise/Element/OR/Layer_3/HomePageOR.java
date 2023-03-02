package org.evs.vtiger.framwork.Pagewise.Element.OR.Layer_3;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageOR {
	@FindBy(xpath="//a[text()='Marketing']")	
	protected WebElement locMarketinLK;

	@FindBy(xpath="//div[@id=\"Marketing_sub\"]//a[text()='Campaigns']")
	protected WebElement locMarkCompaingsLk;

	@FindBy(xpath="//div[@id=\"Marketing_sub\"]//a[text()='Accounts']")
	protected WebElement locMarkAccountsLK;

	@FindBy(xpath="//div[@id=\"Marketing_sub\"]//a[text()='Contacts']")
	protected WebElement locMarkContactsLK;

	@FindBy(xpath="//div[@id=\"Marketing_sub\"]//a[text()='Leads']")     
	protected WebElement locMarkLeadsLK;

	@FindBy(xpath="//td[@class='moduleName']")
	protected WebElement locHomePageHeader;

	@FindBy(xpath="//td[contains(@onmouseout,\"fnHideDrop\")]//a[text()='Inventory']")
	protected WebElement locInvenInvoiceLK;

	@FindBy(xpath="//div[@id=\"Inventory_sub\"]//a[text()='Invoice']")
	protected WebElement locInvoiceLK;

}
