package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	  
	static WebDriverWait wait;
	public static void setTimeOut(WebDriver driver) {
		
		String timeoutString = PropertyUtil.getProperty("timeout").trim(); // Trim the string to remove leading and trailing spaces
		long timeout = Long.parseLong(timeoutString);
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	}
	
	public static void waitForElementClickable(WebElement webEelement) {
		 	wait.until(ExpectedConditions.elementToBeClickable(webEelement));
	}
	public static void waitForVisibilityOfElement(WebElement webElement) {
	 	wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
	
}
