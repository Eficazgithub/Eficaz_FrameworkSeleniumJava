package com.Eficaz.PageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	WebDriver driver;
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//===============================================================================================================================
	
//identify webelements
	
	@FindBy(xpath="//input[@id='txtUser']")
	@CacheLookup
	WebElement UserNameField;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	@CacheLookup
	WebElement PasswordField;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	@CacheLookup
	WebElement loginButton;
	
//========================================================================================================================
	
//identify actions to be performed on web elements
	
	public WebElement enterUserNameField(String uname)
	{
		UserNameField.sendKeys(uname);
		return UserNameField;
	}
	
	public WebElement enterPasswordField(String pwd )
	{
		PasswordField.sendKeys(pwd);
		return PasswordField;
	}
	

	public WebElement clickloginButton()
	{
		loginButton.click();
		return loginButton;
	}
	
}
