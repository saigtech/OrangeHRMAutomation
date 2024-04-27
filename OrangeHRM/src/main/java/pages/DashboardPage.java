package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.ElementUtil;
import Utilities.WaitUtil;

public class DashboardPage {
	WebDriver driver;
	
	@FindBy(className = "oxd-main-menu")
	private WebElement menuItems;
	
	@FindBy(xpath = "//span[text()='Admin']")
	private WebElement admin;
	
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
		}

	public void waitForMenuToLoad() {
		WaitUtil.waitForVisibilityOfElement(menuItems);
		
		}
	
	public void clickOnAdmin() {
		ElementUtil.clickElement(driver, admin);
	}
		
		
	
	}


