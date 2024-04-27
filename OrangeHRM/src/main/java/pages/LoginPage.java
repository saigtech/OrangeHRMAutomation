package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtil;
import Utilities.WaitUtil;

	public class LoginPage {
		
		WebDriver driver;
		
		@FindBy(xpath = "//input[@name='username']")
		private WebElement txtUsername;
		
		@FindBy(xpath = "//input[@name='password']")
		private WebElement txtPassword;
		
		@FindBy(xpath = "//button[@type='submit']")
		private WebElement btnLogin;
		
		@FindBy(xpath = "//p[contains(@class,'alert-content-text')]")
		private WebElement lblValidationMsg;
		
		@FindBy(className =  "orangehrm-login-forgot")
		private WebElement forgotYourPassword;
		
		@FindBy(xpath =  "//button[@type='submit']//ancestor::div[1]//button[1]")
		private WebElement cancelBtn;
		
		@FindBy(xpath =  "//button[@type='submit']")
		private WebElement resetBtn;
		
		@FindBy(xpath =  "//h6[contains(@class,'forgot-password')]")
		private WebElement resetValidationText;
		
		
		public LoginPage(WebDriver driver){
			this.driver=driver;
			PageFactory.initElements(driver, this);		
		}
		
		public void performLogin(String userName,String password) {
			
		enterUsername(userName);
		enterPassword(password);
		clickLogin();
			
		}
		public void performCancelForgotPassword() {
			clickOnForgotPassword();
			enterUsername("admin");
			clickOnCancel();	
		}
		public void performResetForgotPassword() {
			clickOnForgotPassword();
			enterUsername("admin");
			clickOnReset();
		}
		
		public void enterUsername(String userName) {
			WaitUtil.waitForVisibilityOfElement(txtUsername);
			ElementUtil.enterText(driver, txtUsername, userName);
		}

		public void enterPassword(String password) {
			WaitUtil.waitForVisibilityOfElement(txtPassword);
			ElementUtil.enterText(driver, txtPassword, password);
			
		}
		public void clickLogin() {

			ElementUtil.clickElement(driver, btnLogin);
		}
		public String getValidationMessage() {
			return ElementUtil.getElementText(driver, lblValidationMsg);
			
		}
		public void clickOnForgotPassword() {
			ElementUtil.clickElement(driver, forgotYourPassword);
		}
		public void clickOnCancel() {
			ElementUtil.clickElement(driver, cancelBtn);
		}
		public void clickOnReset() {
			ElementUtil.clickElement(driver, resetBtn);
		}
		public String getresetValidationText() {
			return ElementUtil.getElementText(driver, resetValidationText);
		}
		
		
	}


