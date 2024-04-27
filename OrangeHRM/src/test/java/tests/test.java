package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import Utilities.WebDriverUtil;
import pages.LoginPage;

public class test extends WebDriverUtil{
	
	
		@Test
		public void per() throws InterruptedException {
		driverSetUp("orangehrmlive");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin("Admin", "admin123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='My Info']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("firstName")).sendKeys(Keys.CONTROL + "a");
		driver.findElement(By.name("firstName")).sendKeys(Keys.DELETE);
		driver.findElement(By.name("firstName")).sendKeys("TestingSainath");
		driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']/following::i[2]")).click();
		driver.findElement(By.xpath("//div[@class='oxd-select-option']//span[text()='Algerian']")).click();
		
		}

	}


