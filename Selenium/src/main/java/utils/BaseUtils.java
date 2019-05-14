package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseUtils {
	
	
	public static String readProperties(String nameProperty) throws IOException {
		String userDir = System.getProperty("user.dir");
		String fileName =userDir+"/src/main/resources/Config.properties";
		FileInputStream file = new FileInputStream(fileName);
		Properties prop = new Properties();
		prop.load(file);
		String valueProperty = (String) prop.get(nameProperty);
		
		return valueProperty;
	}

}
