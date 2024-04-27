package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	public static String getProperty(String property) {
	String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties";
	File file = new File(filePath);
	FileInputStream fis = null;
	Properties properties = null;
	try {
		fis = new FileInputStream(file);
		properties = new Properties();
		properties.load(fis);
		fis.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return properties.getProperty(property);
	}
	
}
