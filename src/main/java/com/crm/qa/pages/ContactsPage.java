package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage  extends TestBase {
	Actions action= new Actions(driver);
	
	@FindBy(xpath="//th[contains(text(),'Address')]")
	WebElement address;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//input[@name='value']")
	WebElement email;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String verifyContactsPage() {
		return address.getText();
	}
	
	public void selectContact(String username) {
		action.moveToElement(address).build().perform();
		driver.findElement(By.xpath("//a[text()='"+username+"']//parent::td//preceding-sibling::td//input[@name='id']")).click();
		
	}
	
	public boolean verifySelectedContact(String username) {
		return driver.findElement(By.xpath("//a[text()='"+username+"']//parent::td//preceding-sibling::td//input[@name='id']")).isSelected();
	}
	
	public void createContact(String fstname,String lstname,String em) {
		driver.findElement(By.xpath("//button[contains(text(),'Create')]")).click();
		firstname.clear();
		firstname.sendKeys(fstname);
		lastname.clear();
		lastname.sendKeys(lstname);
		email.clear();
		email.sendKeys(em);
		saveBtn.click();
	}
}
