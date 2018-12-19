package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesWrapper {
		//location of properties folder
	    private String fis = System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\%%FILENAME%%.properties";
		private Properties properties = new Properties();
	    //private static String propertiesFile;
		//load file in constructor
		public PropertiesWrapper(String fileName) {
			fis = fis.replace("%%FILENAME%%", fileName);
			try {
				properties.load(new FileInputStream(fis));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error with file input/output");
				e.printStackTrace();
			}
		}
		
		public String getProp(String propName) {
			return properties.getProperty(propName);		
		}
				
}
