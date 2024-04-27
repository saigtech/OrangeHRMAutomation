package tests;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Utilities.ScreenshotUtil;
import Utilities.WebDriverUtil;
import pages.LoginPage;

public class ForgotPasswordTest extends WebDriverUtil{
	
	LoginPage loginPage;
	SoftAssert softAssert;
	
	@BeforeMethod
	public void setup() {
		driverSetUp("orangehrmlive");
		loginPage = new LoginPage(driver);
		softAssert = new SoftAssert();
	}
	
	@AfterMethod
	public void quit(ITestResult result){
		System.out.println("Test Pass? " + result.isSuccess());
		if(!result.isSuccess()) { 
		ScreenshotUtil.takescreenshot(driver, result.getName());
		}
		quitDriver();
	}
	
	@Test
	public void cancelForgotPassword() {
	loginPage.performCancelForgotPassword();
	softAssert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	softAssert.assertAll();
	
	}
	
	@Test
	public void resetForgotPassword() {
		
		loginPage.performResetForgotPassword();
		softAssert.assertEquals(loginPage.getresetValidationText(), "Reset Password link sent successfully");
		softAssert.assertAll();

	}	

}

