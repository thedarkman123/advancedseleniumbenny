package pageobjects;

import org.openqa.selenium.WebElement;

public class LoginPageObject {

	public static class LoginPage extends GenericPageObject{
		
		public static void enterUserName(String userName) {
			driverWrapper.typeInElement(driverWrapper
					.getPresentElementByCssSelector(propertiesWrapper.getProp("username")),
					userName);
		}
		
		public static void enterPassword(String password) {
			driverWrapper.typeInElement(driverWrapper
					.getPresentElementByCssSelector(propertiesWrapper.getProp("password")), 
					password);
		}
		
		public static void pressLogin() {
			driverWrapper.clickElement(driverWrapper
					.getPresentElementByCssSelector(propertiesWrapper.getProp("loginbtn")));
		}
		
		public static void login(String userName,String password) {
			enterUserName(userName);
			enterPassword(password);
			pressLogin();
		}
	}
}
