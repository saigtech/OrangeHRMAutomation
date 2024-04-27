package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementUtil {	
	
	public static void clickElement(WebDriver driver, WebElement webElement) {
		WaitUtil.waitForElementClickable(webElement);
		webElement.click();
	}
	public static void enterText(WebDriver driver, WebElement webElement, String text) {
		webElement.sendKeys(Keys.CONTROL + "a");
		webElement.sendKeys(Keys.DELETE);
		webElement.sendKeys(text);
	}
	public static String getElementText(WebDriver driver, WebElement webElement) {
		WaitUtil.waitForVisibilityOfElement(webElement);
		return webElement.getText();
	}
	public static void clickOnTabKey(WebDriver driver, WebElement webElement) {
		webElement.sendKeys(Keys.TAB);
	}
	
	
}
