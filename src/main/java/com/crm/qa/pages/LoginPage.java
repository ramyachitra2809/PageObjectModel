package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory or ObjectRespository
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signBtn;
	
	@FindBy(xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement forgotLink;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage validateLogin(String un,String pswd) {
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pswd);
		loginBtn.click();
		return new HomePage();
	}
	
	public SignUpPage validateSignUpPage() {
		signBtn.click();
		return new SignUpPage();
	}
	
	public ForgotPasswordPage validateForgotPasswordLink() {
		forgotLink.click();
		return new ForgotPasswordPage();
	}
}
