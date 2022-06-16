package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase {
	TestUtil testUtil =new TestUtil();
	
	
	@FindBy(xpath="//span[contains(text(),'ramya chitra')]")
	WebElement userDisplayName;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String homePageTitle() {
		return driver.getTitle();
	}
	
	public String UserDisplayName() {
	 return	userDisplayName.getText();
	}
	
	public ContactsPage clickOnContactsPage(String pageName) {
		testUtil.homePageNavigation(pageName);
		return new ContactsPage();
	}

	public DealsPage clickOnDealsPage(String pageName) {
		testUtil.homePageNavigation(pageName);
		return new DealsPage();
	}
}
