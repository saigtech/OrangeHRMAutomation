package tests;

import java.awt.AWTException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.ScreenshotUtil;
import Utilities.WebDriverUtil;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

public class UpdateUserTest extends WebDriverUtil{
	SoftAssert softAssert;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	MyInfoPage myInfoPage;
	
	
	@BeforeMethod
	public void setup() {
		driverSetUp("orangehrmlive");
		softAssert = new SoftAssert(); 
		loginPage = new LoginPage(driver);
		loginPage.performLogin("Admin", "admin123");
		myInfoPage = new MyInfoPage(driver);
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
	public void testUpdateUser() {
		myInfoPage.updatePersonalDetails();
		softAssert.assertEquals(myInfoPage.getSuccessMsg(), "Successfully Updated");
		softAssert.assertAll();
	}
	@Test
	public void testUpdateCustomDetails() {
		myInfoPage.updateCustomDetails();
		softAssert.assertEquals(myInfoPage.getSuccessMsg(), "Successfully Saved");
		softAssert.assertAll();
	}
	@Test
	public void testAddAttachment() throws AWTException {
		myInfoPage.addAttachment();
		softAssert.assertEquals(myInfoPage.getSuccessMsg(), "Successfully Saved");
		softAssert.assertAll();
	}
	
}
