package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverUtil {
	protected WebDriver driver;
	public void driverSetUp(String UrlName) {
		String browserName = PropertyUtil.getProperty("browser");
		if(browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		}else if((browserName.equalsIgnoreCase("Firefox"))){
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		WaitUtil.setTimeOut(driver);
		driver.manage().window().maximize();
		driver.get(ExcelUtil.getUrl(UrlName));	
		
	}
	public void quitDriver() {
		if(driver != null) {
		driver.quit();
		}
	}

}
