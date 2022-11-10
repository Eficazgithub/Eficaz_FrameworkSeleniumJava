package com.Eficaz.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
	
WebDriver driver;
	
	public UserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
}
//==================================================================================================================================
	
//identify webelements
		
	@FindBy(xpath="//button[@class='redbtn']")
	@CacheLookup
	WebElement AddUserBtn;
	
	@FindBy(xpath="//input[@class='redbtn']")
	@CacheLookup
	WebElement ExportToXLSXBtnUser;
	
		
	@FindBy(xpath="//body[1]/div[1]/div[4]/div[2]/div[2]/table[1]/tbody[1]/tr[2]/td[1]")
	
	@CacheLookup
	WebElement UserSaveSuccessfullyText;
	
//=====================================================================================================================================

//identify actions to be performed on web elements
	
	public WebElement clickAddUserBtn()
	{
		AddUserBtn.click();
		return AddUserBtn;
	}
	
	public String getAddUserBtntext()
	{
		return(AddUserBtn.getText());
		
	}
	
	public WebElement clickExportToXLSXBtnUser()
	{
		ExportToXLSXBtnUser.click();
		return ExportToXLSXBtnUser;
	}
	
		
	public String getUserSaveSuccessfullyText( )
	{
		return(UserSaveSuccessfullyText.getText());
		
	}
}

	
  
	
