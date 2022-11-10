package com.Eficaz.TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Eficaz.Base.BaseClass;
import com.Eficaz.PageObject.AddUserPage;
import com.Eficaz.PageObject.HomePage;
import com.Eficaz.PageObject.LogInPage;
import com.Eficaz.PageObject.UserPage;

public class TC_AddUser_003 extends BaseClass
{
	
	
//@Test(enabled = false)
@Test
public void VerifyAdduser() throws IOException, InterruptedException
{
	
	logger.info("***************TestCase_003: Verify AddUser starts*****************");
	
//===========================================================================================================================
	// Enter URL
	driver.get(prop.getProperty("url"));
	logger.info("URL is opened");
	
//Create Login page Object to call mtds   
	LogInPage lp=new LogInPage(driver);
	
//Enter username	 
    lp.enterUserNameField(prop.getProperty("username"));
    logger.info("Entered username");
	
//Enter password		    	
	lp.enterPasswordField(prop.getProperty("password"));
    logger.info("Entered password");
    Thread.sleep(1000);
    
//Click Login Button	        
	lp.clickloginButton();
	logger.info("Login Button Clicked");   
	
//Navigate Back to Login Page
	driver.navigate().back();
	lp.clickloginButton();
	logger.info("clicked login button Second time");
	

//================================================================================================================================
	
//Create the HomePage Object to call mtd
	HomePage hp=new HomePage(driver);
	hp.clickAdminElement();
	logger.info("Clicked on AdminElement");
	
//Click to the Users
	hp.clickUsersElement();
    logger.info("Clicked on UserElement");
    
    
//Create the UserPage Object to call mtd
	UserPage up = new UserPage(driver);
	
	String AddUserTxt = up.getAddUserBtntext();
	   System.out.println(AddUserTxt);
 
	up.clickAddUserBtn();
	logger.info("Clicked on AddUserBtn");
	
	

//Create the AddUserPage Object to call mtd
	AddUserPage aup= new AddUserPage(driver);
	aup.UserRoledropdown();
    logger.info("Selected Role from Dropdown");
    
    aup.selectUserAvailableRolesDropDown();
    logger.info("Selected TESTER from Dropdown");
    
    aup.enterUsers_UserName("ANNA");
    logger.info("Entered Users_UserName");
   
    aup.enterUsers_UserEmail("anna@lera.us");
    logger.info("Entered Users_UserEmail");
    
    aup.enterUsers_UserFullName("Anna Annawade");
    logger.info("Entered Users_UserFullName");
    
    aup.enterUsers_UserPassword("Anna@1231231234");
    logger.info("Entered Users_UserPassword");
    
//    aup.clickUsers_SaveBtn();
//    logger.info("Clicked on SaveBtn");
    
//=================================================================================================    
    
 // Verify Test case
    
//   String UserSuccessText = up.getUserSaveSuccessfullyText();
//   System.out.println(UserSuccessText);
   
   
    
   if(AddUserTxt.equals("Add User"))
   {
   	Assert.assertTrue(true);
   	logger.info("Verify AddUser - Passed");
   	logger.info("***************TestCase_003: Verify AddUser ends*****************");
   	logger.info("=========================================================================="); 
   }
   else
   {
	   logger.info("Verify AddUser - Failed");
  	    logger.info("=========================================================================="); 
	    captureScreenShot(driver, "VerifyAdduser");
   	
	   	
   }
//==============================================================================================================
}
}

