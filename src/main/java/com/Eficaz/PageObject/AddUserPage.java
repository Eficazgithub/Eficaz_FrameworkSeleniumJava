package com.Eficaz.PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddUserPage {

WebDriver driver;
	
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
}
	@FindBy(xpath="//select[@id='ddlUserType']")
	@CacheLookup
	WebElement UserRoledropdown;	
	
	@FindBy(xpath="//select[@id='ddlRoleName']")
	@CacheLookup
	WebElement UserAvailableRolesDropDown;
	
	@FindBy(xpath="(//input[@id='txtUserName'])[1]")
	@CacheLookup
	WebElement Users_UserName;
	
	@FindBy(xpath="(//input[@id='txtEmail'])[1]")
	@CacheLookup
	WebElement Users_UserEmail;
	
	@FindBy(xpath="(//input[@id='txtFullName'])[1]")
	@CacheLookup
	WebElement Users_UserFullName;
	
	@FindBy(xpath="(//input[@id='txtPassword'])[1]")
	@CacheLookup
	WebElement Users_UserPassword;
	
	@FindBy(xpath="(//input[@id='btnSaveInfo'])[1]")
	@CacheLookup
	WebElement Users_SaveBtn;
	
	@FindBy(xpath="(//input[@id='btnRoleCancel'])[1]")
	@CacheLookup
	WebElement Users_CancelBtn;
	
	
//----------------------------------------------------------------------------------------------------------------	
	
	
	public WebElement UserRoledropdown()
	{
		Select role=new Select(UserRoledropdown);
		role.selectByIndex(0);
		return UserRoledropdown;
	}
	
	public WebElement UserAvailableRolesDropDown()
	{
		Select dropdown= new Select(UserAvailableRolesDropDown);
		List<WebElement> option= dropdown.getOptions();
		for (WebElement particularoption : option) {
			if(particularoption.getText().equals("TESTER"))
			{
				particularoption.click();
			}}
		return UserAvailableRolesDropDown;
	}
		
		public WebElement Users_UserName()
		{
		
			return Users_UserName;
		}
		
		public WebElement Users_UserEmail()
		{
			return Users_UserEmail;
		}
		
		public WebElement Users_UserFullName()
		{
		    return Users_UserFullName;
		}
		
		public WebElement Users_UserPassword()
		{
			return Users_UserPassword;
		}
		
		public WebElement Users_SaveBtn()
		{
	//Java Script
			JavascriptExecutor JS = (JavascriptExecutor)driver;
			JS.executeScript("arguments[0].click();", Users_SaveBtn);
			return Users_SaveBtn;
		}
		
		public WebElement Users_CancelBtn()
		{
			return Users_CancelBtn;
		}
	
		
				
						
	}

