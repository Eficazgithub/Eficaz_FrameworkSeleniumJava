package com.Eficaz.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
//1. create object of webdriver
      WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//======================================================================================================================
	
	//identify webelements
	
		@FindBy(xpath="//td[@class='logo']")
		@CacheLookup
		WebElement logoDisplayed;
		
		@FindBy(xpath="//li[@id='idDatabase']/following-sibling :: *")
		@CacheLookup
		WebElement AdminElement;
		
		@FindBy(xpath="//a[normalize-space()='Connections']")
		@CacheLookup
		WebElement ConnectionsElement;
		
		@FindBy(xpath="//a[normalize-space()='Batch ETL']")
		@CacheLookup
		WebElement BatchETLElement;
		
		@FindBy(xpath="//a[normalize-space()='Running Extractions']")
		@CacheLookup
		WebElement RunningExtractionsElement;
		
		@FindBy(xpath="//a[contains(text(),'Change')]")
		@CacheLookup
		WebElement ChangePassElement;
		
		@FindBy(xpath="//a[@id='userguide']")
		@CacheLookup
		WebElement userguide;
		
		@FindBy(xpath="//a[normalize-space()='Signout']")
		@CacheLookup
		WebElement Signout;
		
		@FindBy(xpath="//a[normalize-space()='Home']")
		@CacheLookup
		WebElement HomeButton;
		
		@FindBy(xpath="//img[@id='NotifyImg']")
		@CacheLookup
		WebElement serviceStatus;
		
		@FindBy(xpath="//a[normalize-space()='Roles']")
		@CacheLookup
		WebElement RolesElement;
		
		@FindBy(xpath="//a[normalize-space()='Users']")
		@CacheLookup
		WebElement UsersElement;
		
		@FindBy(xpath="//a[contains(text(),'Change')]")
		@CacheLookup
		WebElement ChangePasswordText;
		
//=============================================================================================================================
//identify action on webelement
		
		public WebElement logoDisplayed()
		{
			return logoDisplayed;
		}
		
		public WebElement clickAdminElement()
		{
			AdminElement.click();
			return AdminElement;
		}
		
		public WebElement clickConnectionsElement()
		{
			ConnectionsElement.click();
			return ConnectionsElement;
		}
		
		public WebElement clickBatchETLElement()
		{
			BatchETLElement.click();
			return BatchETLElement;
		}
		
		public WebElement clickRunningExtractionsElement()
		{
			RunningExtractionsElement.click();
			return RunningExtractionsElement;
		}
		public WebElement clickChangePassElement()
		{
			ChangePassElement.click();
			return ChangePassElement;
		}
		public WebElement clickuserguide()
		{
			userguide.click();
			return userguide;
		}
		public WebElement clickSignout()
		{
			Signout.click();
			return Signout;
		}
		public WebElement clickHomeButton()
		{
			HomeButton.click();
			return HomeButton;
			
		}
		public WebElement getserviceStatus()
		{
			return serviceStatus;
		}
		public WebElement clickRolesElement()
		{
			RolesElement.click();
			return RolesElement;
		}
		
		public WebElement clickUsersElement()
		{
			UsersElement.click();
			return UsersElement;
		}
		
		public String getChangePasswordText( )
		{
			return(ChangePasswordText.getText());
			
		}
}





