package tests;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.ExcelUtil;
import Utilities.ScreenshotUtil;
import Utilities.WebDriverUtil;
import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends WebDriverUtil {
	
	SoftAssert softAssert;
	LoginPage loginPage;
	
	
	@BeforeMethod
	public void setup() {
		driverSetUp("orangehrmlive");
		softAssert = new SoftAssert(); 
		loginPage = new LoginPage(driver);
	}
	
	@Test(dataProvider = "getLoginData")
	public void testInvalidLogin(String username, String password) throws InterruptedException {
		
	loginPage = new LoginPage(driver);
	loginPage.performLogin(username, password);
	softAssert.assertEquals(loginPage.getValidationMessage(), "Invalid credentials",
			"Invalid Login validation not proper)");
	softAssert.assertAll();
	}
	
	@DataProvider
	public  Object[][] getLoginData (Method method) {
		String name = method.getName();
		Object[][] obj = null;
		if(name.equals("testInvalidLogin")) {
		System.out.println("Method name: "+name);
		obj = ExcelUtil.getTestDataFromExcel("LoginTestData.xlsx","InvalidData");}
		if(name.equals("testValidLogin")) {
			
			System.out.println("Method name: "+name);
			obj = ExcelUtil.getTestDataFromExcel("LoginTestData.xlsx","ValidData");}
		return obj;
	}
	@Test(dataProvider = "getLoginData")
	public void testValidLogin(String username,String password) {
	
	loginPage = new LoginPage(driver);
	loginPage.performLogin(username,password);
	DashboardPage dashboardPage = new DashboardPage(driver);
	dashboardPage.waitForMenuToLoad();
	softAssert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", "URL after successfull login not proper");
	softAssert.assertAll();
 }
	@AfterMethod
	public void quit(ITestResult result){
		System.out.println("Test Pass? " + result.isSuccess());
		if(!result.isSuccess()) { 
		ScreenshotUtil.takescreenshot(driver, result.getName());
		}
		quitDriver();
		
	}

}
