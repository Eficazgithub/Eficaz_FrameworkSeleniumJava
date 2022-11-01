package com.Eficaz.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RolesPage {
	
WebDriver driver;
	
	public RolesPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	@FindBy(xpath="//button[normalize-space()='Add Role']")
	@CacheLookup
	WebElement AddRoleBtn;
	
	@FindBy(xpath="//input[@id='btnRoleExportToXLSX']")
	@CacheLookup
	WebElement RoleExportToXLSXBtn;
	
	@FindBy(xpath="//a[@id='Edit1']//img[@title='Edit']")
	@CacheLookup
	WebElement EditRole;
	
	@FindBy(xpath="//td[@class='logo']")
	@CacheLookup
	WebElement logoDisplayed;
	
	@FindBy(xpath="//td[@id='ASPxGridView1_tccell1_0']//a[@title='Delete'][normalize-space()='Delete']")
	@CacheLookup
	WebElement DeleteRole;
	
	@FindBy(xpath="//span[@id='lblSuccHeader']")
	@CacheLookup
	WebElement SavedSuccessfully;
	
//-----------------------------------------------------------------------------------------
	
	public WebElement AddRoleBtn()
	{
		return AddRoleBtn;
	}
	
	public WebElement RoleExportToXLSXBtn()
	{
		return RoleExportToXLSXBtn;
	}
	
	public WebElement EditRole()
	{
		return EditRole;
	}
	
	public WebElement DeleteRole()
	{
		return DeleteRole;
	}
	
	public String getSavedSuccessfully()
	{
		String text = SavedSuccessfully.getText();
		return text;
	}
}



