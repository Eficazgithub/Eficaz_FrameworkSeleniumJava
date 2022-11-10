package com.Eficaz.PageObject;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddRolePage {
	
WebDriver driver;
	
	public AddRolePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
//=====================================================================================================================
	
//identify webelements
	
	@FindBy(xpath="//input[@name='txtEmail']")
	@CacheLookup
	WebElement RoleField;
	
	@FindBy(xpath="//select[@id='ddlRoleName']")
	@CacheLookup
	WebElement AvailableRolesDropDown;
	
	@FindBy(xpath="//input[@id='txtRoleName']")
	@CacheLookup
	WebElement RoleNameField;
	
	@FindBy(xpath="(//input[@id='View'])[1]")
	@CacheLookup
	WebElement AllViewCheckbox;
	
	@FindBy(xpath="(//input[@id='Add'])[1]")
	@CacheLookup
	WebElement AllAddChechbox;
	
	@FindBy(xpath="(//input[@id='38'])[1]")
	@CacheLookup
	WebElement RoleEditCheckbox;
	
	@FindBy(xpath="(//input[@id='btnSaveInfo'])[1]")
	@CacheLookup
	WebElement RoleSaveBtn;
	
	@FindBy(xpath="(//input[@id='btnRoleCancel'])[1]")
	@CacheLookup
	WebElement RoleCancelBtn;
	
//=========================================================================================================================
	
  //Methods of WebElements
	
	public WebElement SelectRoleField()
	{
		return RoleField;
	}
	public WebElement SelectAvailableRolesDropDown()
	{
		Select dropdown= new Select(AvailableRolesDropDown);
		List<WebElement> option= dropdown.getOptions();
		for (WebElement particularoption : option) {
			if(particularoption.getText().equals("TESTER"))
			{
				particularoption.click();
			}
		}
		
		return AvailableRolesDropDown;
	}
	
	public WebElement RoleNameField()
	{
		return RoleNameField;
	}
	
	public WebElement SelectAllViewCheckbox()
	{
		AllViewCheckbox.click();
		return AllViewCheckbox;
	}
	
	public WebElement SelectAllAddChechbox()
	{
		AllAddChechbox.click();
		return AllAddChechbox;
		
	}
	
	public WebElement clickRoleEditCheckbox()
	{
		//RoleEditCheckbox.click();
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", RoleEditCheckbox);
		return RoleEditCheckbox;
		
	}
	public WebElement clickRoleSaveBtn()
	{
         //Java Script
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		JS.executeScript("arguments[0].click();", RoleSaveBtn);
		
		return RoleSaveBtn;
	}
	
	public WebElement clickRoleCancelBtn()
	{
		RoleCancelBtn.click();
		return RoleCancelBtn;
	}

}




		
		
				
				