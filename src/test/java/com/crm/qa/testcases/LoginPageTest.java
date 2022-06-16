package com.crm.qa.testcases;

import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ForgotPasswordPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;

import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homepage;
	SignUpPage signUpPage;
	ForgotPasswordPage forgotPasswordPage;
	
	public LoginPageTest() {
		super();
	}
	
  @Test(priority=1)
  public void LoginPageTitleTest() {
	  String title=loginPage.validateLoginPageTitle();
	  Assert.assertEquals(title, "Cogmento CRM");
  }
  
  @Test(priority=2)
  public void loginTest() {
	 homepage= loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
  }
  
  @Test(priority=3)
  public void signUpButtonTest() {
	  signUpPage= loginPage.validateSignUpPage();
  }
  
  @Test(priority=4)
  public void forgotPasswordLinkTest() {
	  forgotPasswordPage= loginPage.validateForgotPasswordLink();
  }
  
  @BeforeMethod
  public void setUp() {
	  initialization();
	  loginPage=new LoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
