package com.Eficaz.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
      WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
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
		
//--------------------------------------------------------------------------------------------------------------------
		
		public WebElement logoDisplayed()
		{
			return logoDisplayed;
		}
		
		public WebElement AdminElement()
		{
			return AdminElement;
		}
		
		public WebElement ConnectionsElement()
		{
			return ConnectionsElement;
		}
		
		public WebElement BatchETLElement()
		{
			return BatchETLElement;
		}
		
		public WebElement RunningExtractionsElement()
		{
			return RunningExtractionsElement;
		}
		public WebElement ChangePassElement()
		{
			return ChangePassElement;
		}
		public WebElement userguide()
		{
			return userguide;
		}
		public WebElement Signout()
		{
			return Signout;
		}
		public WebElement HomeButton()
		{
			return HomeButton;
			
		}
		public WebElement serviceStatus()
		{
			return serviceStatus;
		}
		public WebElement RolesElement()
		{
			return RolesElement;
		}
		
		public WebElement UsersElement()
		{
			return UsersElement;
		}
}





