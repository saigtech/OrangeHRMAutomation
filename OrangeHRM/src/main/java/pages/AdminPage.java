package pages;

import java.util.Arrays;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtil;
import Utilities.WaitUtil;

public class AdminPage {
	
	WebDriver driver;
	JavascriptExecutor  js;
	
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement adminNavOption;
	
	@FindBy(xpath = "//div[@class='orangehrm-header-container']//button[@type='button']")
	private WebElement addBtn;
	
	@FindBy(xpath = "//div[@class='oxd-form-row']/descendant::div[text()='-- Select --'][1]")
	private WebElement userRoleField;
	
	
	@FindBy(xpath = "//div[@class='oxd-select-option']//span")
	private WebElement userNameOption;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement txtEmpName;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-option']//span")
	private WebElement empNameOption;
	
	@FindBy(xpath = "//div[@class='oxd-form-row']/descendant::div[@class='oxd-select-text-input'][2]")
	private WebElement statusField;
	
	@FindBy(xpath = "//span[text()='Enabled']")
	private WebElement statusOption;
	
	@FindBy(xpath = "//div[contains(@class,'user-password-row')]/preceding::input[1]")
	private WebElement txtUsername;
	
	@FindBy(xpath = "//p[contains(@class,'password-hint')]/preceding::input[@type='password']")
	private WebElement txtPassword;
	
	@FindBy(xpath = "//p[contains(@class,'password-hint')]/following::input[@type='password']")
	private WebElement txtConfirmPass;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//button[text()=' Cancel ']")
	private WebElement cancelBtn;
	
	//SucessMessage
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	private WebElement successMsg;
	
	
	@FindBy(xpath = "//div[@class='oxd-form-row']//following::input[@class='oxd-input oxd-input--active']")
	private WebElement txtFilterUsername;
	
	@FindBy(xpath = "//div[@class='oxd-form-row']//following::div[text()='-- Select --']/following::i[1]")
	private WebElement filterUserRole;
	
	@FindBy(xpath = "//div[@role='option']//span[text()='Admin']")
	private WebElement filterUserRoleOption;
	
	@FindBy(xpath = "//div[@class='oxd-form-row']//following::input[@placeholder='Type for hints...']")
	private WebElement filterEmpName;
	
	@FindBy(xpath = "//div[@class='oxd-autocomplete-dropdown --positon-bottom']//div//span")
	private WebElement filterEmpNameOption;
	
	@FindBy(xpath = "//div[@class='oxd-form-row']//following::div[text()='-- Select --']/following::div[1]//i")
	private WebElement filterStatus;
	
	
	@FindBy(xpath = "//div[@role='option']//span[text()='Enabled']")
	private WebElement filterStatusOption;
	
	@FindBy(xpath = "//button [@type='submit']")
	private WebElement filterSearchBtn;
	
	@FindBy(xpath = "//div[@class='oxd-table-body']/descendant::div[@class='oxd-table-row oxd-table-row--with-border']//div[2]//div")
	private WebElement lblUsername;
	
	@FindBy(xpath = "//div[@class='oxd-table-body']/descendant::div[@class='oxd-table-row oxd-table-row--with-border']//div[3]//div")
	private WebElement lblUserRole;
	
	@FindBy(xpath = "//div[@class='oxd-table-body']/descendant::div[@class='oxd-table-row oxd-table-row--with-border']//div[4]//div")
	private WebElement lblEmpName;
	
	@FindBy(xpath = "//div[@class='oxd-table-body']/descendant::div[@class='oxd-table-row oxd-table-row--with-border']//div[5]//div")
	private WebElement lblStatus;
	
	public AdminPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor)driver;
	}
	public void addUser(){
		clickOnAdminNav();
		clickOnAddButton();
		clickOnUserRoleField();
		selectUserRole();
		enterEmployeeName();
		clickOnStatusField();
		selectStatus();
		enterUsername();
		enterPassword();
		enterConfirmPassword();
		clickOnSaveButton();
	}
	public void cancelAddUser() {
		clickOnAdminNav();
		clickOnAddButton();
		clickOnCancelButton();
	}
	public void performFilterUser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enterFilterUsername();
		selectFilterUserRole();
		enterFilterEmpName();
		selectFilterStatus();
		clickOnFilterSearchButton();	
	}
	public String getFilterData() {
		WaitUtil.waitForVisibilityOfElement(lblUsername);
		String[] obj = new String[]{getUsernameText(),getUserRoleText(), getEmployeeNameText(), getStatusText()};
		return Arrays.toString(obj);
	}
	
	public void clickOnAddButton(){
		ElementUtil.clickElement(driver, addBtn);
	}
	public void clickOnUserRoleField(){
		
		ElementUtil.clickElement(driver, userRoleField);

	}
	public void selectUserRole(){
		ElementUtil.clickElement(driver, userNameOption);
	}
	public void enterEmployeeName(){
		ElementUtil.enterText(driver, txtEmpName, "Sven Magnus Carlsen");
		WaitUtil.waitForVisibilityOfElement(empNameOption);
		ElementUtil.clickElement(driver, empNameOption);
	}
	public void clickOnStatusField(){
		ElementUtil.clickElement(driver, statusField);
	}
	public void selectStatus() {
		ElementUtil.clickElement(driver, statusOption);
	}
	public void enterUsername() {
		ElementUtil.enterText(driver, txtUsername, "TestUserTesting");
	}
	public void enterPassword() {
		ElementUtil.enterText(driver, txtPassword, "Pass@123");
	}
	public void enterConfirmPassword() {
		ElementUtil.enterText(driver, txtConfirmPass, "Pass@123");
	}
	public void clickOnSaveButton() {
		ElementUtil.clickElement(driver, saveBtn);
	}
	public void clickOnCancelButton() {
		ElementUtil.clickElement(driver, cancelBtn);
	}
	
	public void enterFilterUsername() {
		WaitUtil.waitForVisibilityOfElement(txtFilterUsername);
		js.executeScript("arguments[0].value='TestUserTesting';", txtFilterUsername);

	}
	public void selectFilterUserRole() {
		ElementUtil.clickElement(driver, filterUserRole);
		WaitUtil.waitForVisibilityOfElement(filterUserRoleOption);
		ElementUtil.clickElement(driver, filterUserRoleOption);
	}
	public void enterFilterEmpName() {
		
		ElementUtil.enterText(driver, filterEmpName, "Sven Magnus");
		WaitUtil.waitForVisibilityOfElement(filterEmpNameOption);
		ElementUtil.clickElement(driver, filterEmpNameOption);
		
	}
	public void selectFilterStatus() {
		
		ElementUtil.clickElement(driver, filterStatus);
		ElementUtil.clickElement(driver, filterStatusOption);
	}
	public void clickOnFilterSearchButton() {
		ElementUtil.clickElement(driver, filterSearchBtn);
	}
	public String getUsernameText() {
		return ElementUtil.getElementText(driver, lblUsername);
	}
	public String getUserRoleText() {
		return ElementUtil.getElementText(driver, lblUserRole);
	}
	public String getEmployeeNameText() {
		return ElementUtil.getElementText(driver, lblEmpName);
	}
	public String getStatusText() {
		return ElementUtil.getElementText(driver, lblStatus);
	}
	public void clickOnAdminNav() {
		ElementUtil.clickElement(driver, adminNavOption);
	}
	public String getSuccessMsg() {
		WaitUtil.waitForVisibilityOfElement(successMsg);
		return ElementUtil.getElementText(driver, successMsg);
	}
}
