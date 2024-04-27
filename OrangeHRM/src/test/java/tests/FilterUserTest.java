package tests;

import java.util.Arrays;

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

public class FilterUserTest extends WebDriverUtil{
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
		myInfoPage.updatePersonalDetails(); 
		adminPage.addUser();

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
	public void testFilterUser(){
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
		adminPage.performFilterUser();
		softAssert.assertEquals(adminPage.getFilterData(), "[Admin, Admin, Sven Carlsen, Enabled]");
		softAssert.assertAll();
	}

}
