package com.Eficaz.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Eficaz.Base.BaseClass;
import com.Eficaz.PageObject.AddUserPage;
import com.Eficaz.PageObject.HomePage;

import com.Eficaz.PageObject.UserPage;

public class TC_AddUser_003 extends BaseClass
{
	@Test(enabled = false)
public void Adduser()
{
	
//Create the HomePage Object to call mtd
	HomePage hp=new HomePage(driver);
	hp.AdminElement().click();
	
//Click to the Users
	hp.UsersElement().click();
    System.out.println("UserElement got clicked");
    
//Create the UserPage Object to call mtd
	UserPage up = new UserPage(driver);
	 
	up.AddUserBtn().click();
	System.out.println("AddUser got clicked");

	AddUserPage aup= new AddUserPage(driver);
	aup.UserRoledropdown();
    System.out.println("role selected");
    
    aup.UserAvailableRolesDropDown();
    System.out.println("TESTER selected");
    
    aup.Users_UserName().sendKeys("ANNA");
    System.out.println("Username Entered");
    
    aup.Users_UserEmail().sendKeys("anna@lera.us");
    System.out.println("UserEmail Entered");
    
    aup.Users_UserFullName().sendKeys("Anna Annawade");
    System.out.println("UserFullName Entered");
    
    aup.Users_UserPassword().sendKeys("Anna@1231231234");
    System.out.println("UserPassword Entered");
    
    aup.Users_SaveBtn();
    System.out.println("SaveBtn clicked");
    
 // Verify Test case
	Assert.assertTrue(up.RoleSaveSuccessfullyText().isDisplayed());
	System.out.println("Verify TC_03 Successfully");
}
}
