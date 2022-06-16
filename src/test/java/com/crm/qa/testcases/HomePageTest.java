package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	
	public HomePageTest() {
		super();
	}
	

  @BeforeMethod
  public void beforeMethod() {
	  initialization();
	  loginPage=new LoginPage();
	  homePage=loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	  
	  
  }
  
  
  @Test(priority=1)
  public void validateHomePageTitleTest() {
	 String homePageTitle= homePage.homePageTitle();
	 Assert.assertEquals(homePageTitle, "Cogmento CRM");
  }
  
  @Test(priority=2)
  public void validateUserDisplayNameTest() {
	  String displayName = homePage.UserDisplayName();
	  Assert.assertEquals(displayName, "ramya chitra");
  }
  
  @Test(priority=3)
  public void validateContactsPageLinkTest() {
	  contactsPage=  homePage.clickOnContactsPage("Contacts");
  }
  
  @Test(priority=4)
  public void validateDealsPageLinkTest() {
	  dealsPage= homePage.clickOnDealsPage("Deals");
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
