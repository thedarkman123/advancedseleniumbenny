package testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageobjects.GenericPageObject;
import utilities.PropertiesWrapper;
import utilities.WebDriverWrapper;

public class BaseTest {
	protected static WebDriverWrapper dw;
	protected PropertiesWrapper or; //object repository
	Logger log = Logger.getLogger("appLogger");
	
	//initializations goes here
	@BeforeClass
	@Parameters("browser")
	public void setup(String browser) {
		//a wrapper for properties, or stands for OBJECT REPOSITORY 
		or = new PropertiesWrapper("OR");
		//a wrapper for the webdriver
		dw = new WebDriverWrapper();
		//here we can add the propery for the browser we initiate the test OR using annotation
		dw.init(browser); 
		//set the instance of the wrapper into generic page object for further use
		GenericPageObject.setWebDriver(dw);
		GenericPageObject.setProperties(or);//the only needed properties file
		//set implicit wait
		dw.setImplicitWait(10);
		//open url
		dw.openUrl(or.getProp("webUrl"));
		log.debug("opening url " + or.getProp("webUrl"));
		//make window max size
		dw.maximizeView();
	}
	
	@AfterClass
	public void teardown() {
		dw.quit(); //close the browser		
	}
}
