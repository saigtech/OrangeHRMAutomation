package Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtil {
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest extentTest;
		
	public static void setupExtentReporter() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + File.separatorChar +"ExtentReport" + File.separatorChar + "index.html");
		extent.attachReporter(spark);
		}
	
	public static void createExtentTest(String testName){
		
		extentTest = extent.createTest(testName);
	}
		
	public static void extentLogger(Status status, String message) {
			extentTest.log(status, message);
		}
	public static void extentLogger(Status status, Throwable t, String fileName) {
		//extentTest.log(status, t);
		extentTest.log(status, t, MediaEntityBuilder.createScreenCaptureFromPath("." + File.separatorChar +"screenshots" +
		File.separatorChar + fileName + ".png").build());
	}
	public static void flushExtentReport() {
		 	
		extent.flush();
		
	}
	}


