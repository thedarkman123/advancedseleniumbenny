package pageobjects;

import org.testng.Reporter;

import utilities.PropertiesWrapper;
import utilities.WebDriverWrapper;

public class GenericPageObject {
	protected static WebDriverWrapper  driverWrapper;
	protected static PropertiesWrapper propertiesWrapper;

	public static void setWebDriver(WebDriverWrapper _driverWrapper) {
		driverWrapper = _driverWrapper;
	}
	
	public static void setProperties(PropertiesWrapper _propertiesWrapper) {
		propertiesWrapper = _propertiesWrapper;
	}
		
	public static void openUrl(String urlToOpen) {
		driverWrapper.openUrl(urlToOpen);
	}
}
