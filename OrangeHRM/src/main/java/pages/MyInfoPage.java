package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtil;
import Utilities.WaitUtil;

public class MyInfoPage {
	
	WebDriver driver;
	Actions actions;
	
	//Personal Details
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement myInfoMenuItem;
	
	@FindBy(xpath="//input[@name='firstName']")
	private WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@name='middleName']")
	private WebElement txtMiddleName;
	
	@FindBy(xpath = "//input[@name='lastName']")
	private WebElement txtLastName;
	
	@FindBy(xpath = "//label[text()='Employee Id']/following::div[1]//input")
	private WebElement txtEmpID;
	
	@FindBy(xpath = "//label[text()='Other Id']/following::div[1]//input")
	private WebElement txtOtherID;
	
	@FindBy(xpath = "//label[contains(text(),'License Number')]/following::input[1]")
	private WebElement txtLicenseNum;
	
	@FindBy(xpath = "//label[text()='License Expiry Date']/following::input[1]")
	private WebElement txtLicenseExpDate;
	
	@FindBy(xpath = "//div[@class='orangehrm-edit-employee-content']/descendant::div[@class='oxd-select-text-input'][1]")
	private WebElement defaultNationality;
	
	@FindBy(xpath = "//label[text()='License Expiry Date']/following::input[1]")
	private WebElement nationalityDropdown;
	
	@FindBy(xpath = "//label[text()='License Expiry Date']/following::input[1]")
	private WebElement countryOption;
	
	@FindBy(xpath = "//label[text()='Marital Status']/following::div[@class='oxd-select-text-input'][1]/following::i[1]")
	private WebElement maritalStatusDropdown;
	
	@FindBy(xpath = "//span[text()='Other']")
	private WebElement maritalStatusOption;
	
	@FindBy(xpath = "//label[text()='Date of Birth']/following::input[1]")
	private WebElement dobDropdown;
	
	@FindBy(xpath = "//label[text()='Female']/child::span")
	private WebElement genderOption;
	
	@FindBy(xpath = "//p[text()=' * Required']/following-sibling::button")
	private WebElement personalDetailsSaveBtn;
	
	//SucessMessage
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	private WebElement successMsg;		
	
	//Custom Fields
	@FindBy(xpath = "//label[text()='Blood Type']//following::div[@class='oxd-select-text-input']")
	private WebElement bloodTypeDropdown;
	
	@FindBy(xpath = "//span[text()='O+']")
	private WebElement bloodTypeOption;
	
	@FindBy(xpath = "//label[text()='Test_Field']/following::input[1]")
	private WebElement txtField;
	
	@FindBy(xpath = "//div[@class='orangehrm-attachment']/preceding::button[1]")
	private WebElement customFieldsSaveBtn;
	
	//Attachments
	@FindBy(xpath = "//button[text()=' Add ']")
	private WebElement addBtn;
	
	@FindBy(xpath = "//div[text()='Browse']")
	private WebElement browseBtn;
	
	@FindBy(xpath = "//textarea[@placeholder='Type comment here']")
	private WebElement txtComment;
	
	@FindBy(xpath = "//textarea/following::button[@type='submit']")
	private WebElement attachmentsSaveBtn;
	
	public  MyInfoPage(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);		
		actions = new Actions(driver);
		}
	
	public void updatePersonalDetails() {
		clickOnMyInfo();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		enterFirstName("Sven");
		enterMiddleName("Magnus");
		enterLastName("Carlsen");
		enterEmpId("EMP-3000");
		enterOtherId("FP-3000");
		enterLicenseNum("330303");
		enterLicenseExpDate("2025-03-02"); 
		selectNationality();
		selectMaritalStatus();
		enterDOB("1998-02-03");
		clickOnGenderOption();
		clickOnPersonalDetailsSave();
		
	}
	public void updateCustomDetails() {
		clickOnMyInfo();
		selectBloodType();
		enterText("tesing");
		clickOnCustomFieldsSave();
	}
	
	public void addAttachment() throws AWTException{
		clickOnMyInfo();
		clickOnAddButton();
		clickOnBrowse();
		selectAttachment();
		enterComment();
		clickOnAttachmentSave();
	}
	
	public void clickOnMyInfo() {
		 WaitUtil.waitForVisibilityOfElement(myInfoMenuItem);
		 ElementUtil.clickElement(driver, myInfoMenuItem);
	}
	public void enterFirstName(String userName) {
		WaitUtil.waitForVisibilityOfElement(txtFirstName);
		ElementUtil.enterText(driver, txtFirstName, userName);
	}
	public void enterMiddleName(String middleName) {
		ElementUtil.enterText(driver, txtMiddleName, middleName);
	}
	public void enterLastName(String lastName) {
		ElementUtil.enterText(driver, txtLastName, lastName);

	}
	public void enterEmpId(String empID) {
		ElementUtil.enterText(driver, txtEmpID, empID);
	}
	public void enterOtherId(String otherId) {
		ElementUtil.enterText(driver, txtOtherID, otherId);
	}
	public void enterLicenseNum(String licenseNum) {
		ElementUtil.enterText(driver, txtLicenseNum, licenseNum);
	}
	public void enterLicenseExpDate(String licenseExpDate) {
		ElementUtil.enterText(driver, txtLicenseExpDate, licenseExpDate); //yyyy-mm-dd
	}
	public void selectNationality(){
		String defaultNationSelected = ElementUtil.getElementText(driver, defaultNationality).trim();
		if(!defaultNationSelected.equalsIgnoreCase("American")) {
		ElementUtil.clickElement(driver, nationalityDropdown);
		ElementUtil.clickElement(driver, countryOption);
		}
	}
	public void selectMaritalStatus() {
		ElementUtil.clickElement(driver, maritalStatusDropdown);
		ElementUtil.clickElement(driver, maritalStatusOption);
	}
	public void enterDOB(String dob) {
		ElementUtil.enterText(driver, dobDropdown, dob); //yyyy-mm-dd
	}
	public void clickOnGenderOption() {
		ElementUtil.clickElement(driver, genderOption);
	}
	public void clickOnPersonalDetailsSave() {
		ElementUtil.clickElement(driver, personalDetailsSaveBtn);
	}
	public String getSuccessMsg() {
		WaitUtil.waitForVisibilityOfElement(successMsg);
		return ElementUtil.getElementText(driver, successMsg);
	}
	public void selectBloodType() {
		ElementUtil.clickElement(driver, bloodTypeDropdown);
		ElementUtil.clickElement(driver, bloodTypeOption);
	}
	public void enterText(String text) {
		ElementUtil.enterText(driver, txtField, text);
	}
	public void clickOnCustomFieldsSave() {
		ElementUtil.clickElement(driver, customFieldsSaveBtn);
	}
	public void clickOnAddButton() {
		ElementUtil.clickElement(driver, addBtn);
	}
	public void clickOnBrowse() {
		actions.moveToElement(browseBtn).click().perform();
	}
	public void selectAttachment() throws AWTException {
		
		StringSelection obj = new StringSelection("C:\\Users\\gundu\\eclipse-workspace\\OrangeHRM\\src\\main\\resources\\image.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_V);
		robot.delay(1000);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(1000);

		robot.keyRelease(KeyEvent.VK_V);
		robot.delay(1000);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(1000);

		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(1000);
		
	}
	public void enterComment() {
		ElementUtil.enterText(driver, txtComment, "testing comment");
	}
	public void clickOnAttachmentSave() {
		ElementUtil.clickElement(driver, attachmentsSaveBtn);
	}
}
