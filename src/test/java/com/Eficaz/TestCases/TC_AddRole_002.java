package com.Eficaz.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Eficaz.Base.BaseClass;
import com.Eficaz.PageObject.AddRolePage;
import com.Eficaz.PageObject.HomePage;
import com.Eficaz.PageObject.LogInPage;
import com.Eficaz.PageObject.RolesPage;

//import java.io.IOException;


public class TC_AddRole_002 extends BaseClass
{
	
	
    @Test
  
    
    public void VerifyAddRole() throws IOException, InterruptedException 
   {
    	
    	logger.info("***************TestCase Verify AddRole starts*****************");    
 //Create the HomePage Object to call mtd
    	HomePage hp=new HomePage(driver);
    	hp.AdminElement().click();
        logger.info("Clicked on AdminElement");
    	
 //Click to the Roles
    	hp.RolesElement().click();
    	System.out.println("RolesElement got clicked");
    	logger.info("Clicked on RolesElement");
 //Create the RolesPage Object to call mtd
    	
    	RolesPage rp = new RolesPage(driver);
    	rp.AddRoleBtn().click();
    	System.out.println("AddRoleBtn got clicked");
    	logger.info("Clicked on AddRoleBtn");
    	
//Create the AddRole Object to call mtd
    	AddRolePage arp = new AddRolePage(driver);
        arp.AvailableRolesDropDown();
    	System.out.println("Tester got selected");
    	logger.info("Selected TESTER From Dropdown");
    
    	arp.AllViewCheckbox().click();
    	arp.AllAddChechbox().click();
    	System.out.println("Click Checkbox");
    	logger.info("Clicked on Checkbox");
      //Thread.sleep(3000);
// Save the Role
    	arp.SaveBtn();
    	System.out.println("Save Button Cliked");
    	logger.info("Clicked on Save Button");
    	
 // Verify Test case
    	//Assert.assertTrue(rp.RoleSaveSuccessfullyText().isDisplayed());
    	System.out.println("Verify TC_02 Successfully");
    	
    	String savedSuccessfully = rp.getSavedSuccessfully();
    	Assert.assertEquals("Saved Successfully", savedSuccessfully);
	    if(savedSuccessfully.equals("Saved Successfully"))
	    {
	    	Assert.assertTrue(true);
	    	logger.info("Verify Login - Passed");
	    	logger.info("***************TestCase Verify AddRole ends*****************"); 
	    }
	    else
	    {
	    	logger.info("Verify Login - Failed");
	    	captureScreenShot(driver,"TC_AddRole_002");
	    	Assert.assertTrue(false);
	    }
	    
   }

	
	}
    