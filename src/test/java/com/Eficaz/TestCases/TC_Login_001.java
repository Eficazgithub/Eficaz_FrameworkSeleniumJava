package com.Eficaz.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Eficaz.Base.BaseClass;
import com.Eficaz.PageObject.HomePage;
import com.Eficaz.PageObject.LogInPage;

public class TC_Login_001 extends BaseClass
{
	
	
	//@Test(enabled = false)
	@Test
	public void VefifyLogin() throws InterruptedException, IOException
	{
		// Enter URL
    	driver.get(prop.getProperty("url"));
    	logger.info("URL is opened");
		
// Create Login page Object to call mtds   
    	LogInPage lp=new LogInPage(driver);

    	logger.info("***************TestCase_001: Verify Login starts*****************"); 
// Enter username	 
        lp.enterUserNameField(prop.getProperty("username"));
        logger.info("Entered username");
    	
// Enter password		    	
    	lp.enterPasswordField(prop.getProperty("password"));
        logger.info("Entered password");
        Thread.sleep(1000);
        
// Click Login Button	        
    	lp.clickloginButton();
    	logger.info("Login Button Clicked");   
    	
// Navigate Back to Login Page
    	driver.navigate().back();
    	lp.clickloginButton();
    	logger.info("clicked login button Second time");  
    	
// verify the login successful or not
    	HomePage hp=new HomePage(driver);
    	String ChangePassText=hp.getChangePasswordText();
    	if(ChangePassText.equals("Change password"))
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Verify Login - Passed");
	    	logger.info("***************TestCase_001: Verify Login ends*****************"); 
	    	logger.info("=========================================================================="); 
	    }
	    else
	    {
	    	logger.info("Verify Login - Failed");
	    	captureScreenShot(driver, "VefifyLogin");
	    	Assert.assertTrue(false);
	    }
	}
	

}
