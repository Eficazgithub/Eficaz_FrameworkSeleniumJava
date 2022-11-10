package com.Eficaz.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Eficaz.Base.BaseClass;
import com.Eficaz.PageObject.AddRolePage;
import com.Eficaz.PageObject.HomePage;
import com.Eficaz.PageObject.LogInPage;
import com.Eficaz.PageObject.RolesPage;


public class TC_AddRole_002 extends BaseClass
{
	
	
	//@Test(enabled = false)
	@Test 
    public void VerifyAddRole() throws IOException, InterruptedException 
   {
    	
    	logger.info("***************TestCase_002: Verify AddRole starts*****************");
    	
 //===========================================================================================================================   	
    	
    	// Enter URL
    	driver.get(prop.getProperty("url"));
    	logger.info("URL is opened");
		
// Create Login page Object to call mtds   
    	LogInPage lp=new LogInPage(driver);

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
    	
    	
//============================================================================================================================
 
        //Create the HomePage Object to call mtd
    	HomePage hp=new HomePage(driver);
    	hp.clickAdminElement();
        logger.info("Clicked on AdminElement");
    	
        //Click to the Roles
    	hp.clickRolesElement();
    	logger.info("Clicked on RolesElement");
    	
        //Create the RolesPage Object to call mtd
        RolesPage rp = new RolesPage(driver);
    	rp.clickAddRoleBtn();
    	logger.info("Clicked on AddRoleBtn");
    	
        //Create the AddRole Object to call mtd
    	AddRolePage arp = new AddRolePage(driver);
        arp.SelectAvailableRolesDropDown();
    	logger.info("Selected TESTER From Dropdown");
   
    	arp.SelectAllViewCheckbox();
    	arp.SelectAllAddChechbox();
    	logger.info("Clicked on Checkbox");
        //Thread.sleep(3000);
    	
        // Save the Role
    	arp.clickRoleSaveBtn();
    	logger.info("Clicked on Save Button");
    	
//===========================================================================================
    	
 // Verify Test case
    	//Assert.assertTrue(rp.RoleSaveSuccessfullyText().isDisplayed());
    	//System.out.println("Verify TC_02 Successfully");
    	
    	String RoleSuccessText = rp.getRoleSavedSuccessfullyText();
    	//Assert.assertEquals("Saved Successfully", RoleSuccessText);
	    if(RoleSuccessText.equals("Saved Successfully"))
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Verify AddRole - Passed");
	    	logger.info("***************TestCase_002: Verify AddRole ends*****************"); 
	    	logger.info("=========================================================================="); 
	    }
	    else
	    {
	    	logger.info("Verify AddRole - Failed");
	    	logger.info("=========================================================================="); 
	    	captureScreenShot(driver,"VerifyAddRole");
	    	Assert.assertTrue(false);
	    	
	    }
//================================================================================================================	    
   }

	
	}
    