package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.ScreenshotUtil;
import Utilities.WebDriverUtil;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class AddUserTest extends WebDriverUtil{
	
	SoftAssert softAssert;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MyInfoPage myInfoPage;
	AdminPage adminPage;
	
	
	@BeforeMethod
	public void setup() {
		driverSetUp("orangehrmlive");
		softAssert = new SoftAssert(); 
		loginPage = new LoginPage(driver);
		myInfoPage = new MyInfoPage(driver);
		adminPage = new AdminPage(driver);
		loginPage.performLogin("Admin", "admin123"); //performingLogin
		
	}
	@AfterMethod
	public void quit(ITestResult result){
		System.out.println("Test Pass? " + result.isSuccess());
		if(!result.isSuccess()) { 
		ScreenshotUtil.takescreenshot(driver, result.getName());
		}
		//quitDriver();	
	}
	

	@Test
	public void testAddUser(){
		myInfoPage.updatePersonalDetails();
		adminPage.addUser();
		softAssert.assertEquals(adminPage.getSuccessMsg(), "Successfully Saved");
		softAssert.assertAll();
	}
	@Test
	public void testCancelAddUser() {
		adminPage.cancelAddUser();
		softAssert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		softAssert.assertAll();
	}


}
