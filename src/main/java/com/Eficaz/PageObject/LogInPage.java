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
	
	@FindBy(xpath="//input[@id='txtUser']")
	@CacheLookup
	WebElement UserNameField;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	@CacheLookup
	WebElement PasswordField;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	@CacheLookup
	WebElement loginButton;
	

	
	
	
	public WebElement UserNameField()
	{
		return UserNameField;
	}
	
	public WebElement PasswordField()
	{
		return PasswordField;
	}
	

	public WebElement loginButton()
	{
		return loginButton;
	}
	
}
