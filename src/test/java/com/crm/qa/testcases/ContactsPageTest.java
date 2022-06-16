package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
  
  @BeforeMethod
  public void beforeMethod() {
	  initialization();
	  loginPage= new LoginPage();
	  homePage= loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	  contactsPage=homePage.clickOnContactsPage("Contacts");
	 
  }

  @Test
  public void contactsPageTitleTest() {
	  String title= contactsPage.verifyContactsPage();
	  Assert.assertEquals(title, "Address");
  }
  
  @Test
  public void selectContactsTest() {
	  contactsPage.selectContact("ramya gaddamidhi");
	  boolean selected =contactsPage.verifySelectedContact("ramya gaddamidhi");
	  Assert.assertEquals(selected, true);
  }
  
  @Test
  public void createContactTest() {
	  contactsPage.createContact("Tom","Peter","test@123");
  }
  
  @Test(dataProvider="getContactsData")
  public void createMultipleContacts(String fstname,String lstname,String em) {
	  contactsPage.createContact(fstname, lstname, em);
  }
  
  @DataProvider
  public Object[][] getContactsData() {
	  Object data[][]= TestUtil.getTestData("ContactsData");
	  return data;
  }
  
  @AfterMethod
  public void afterMethod() {
	 // driver.quit();
  }

}
