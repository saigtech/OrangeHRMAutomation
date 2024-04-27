package Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {
	
	public static void takescreenshot(WebDriver driver, String fileName) {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		String filePath = System.getProperty("user.dir") + File.separatorChar +"ExtentReport" +File.separatorChar + "screenshots" + File.separatorChar + fileName + ".png";
		//String filePath = System.getProperty("user.dir") + File.separatorChar +"ExtentReport" +File.separatorChar + "screenshots" + File.separatorChar + fileName + ".png";
		File destFile = new File(filePath);
		
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
