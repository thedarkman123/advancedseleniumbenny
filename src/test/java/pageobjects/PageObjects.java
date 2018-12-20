package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PageObjects {
	
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

	   public static class ProductsPage extends GenericPageObject{
	
			public static void addToCart(String name) {
				List<WebElement> list = 
						driverWrapper.getPresentElementsByCssSelector(propertiesWrapper.getProp("inventoryItem"));
				
				for (int i = 0; i < list.size(); i++) {
					WebElement titleEl = list.get(i).findElement(By.cssSelector(propertiesWrapper.getProp("inventoryItemName")));
					String title = titleEl.getText();
					if (name.equalsIgnoreCase(title)) {
						//click the button
						WebElement btnAdd = list.get(i).findElement(By.cssSelector(propertiesWrapper.getProp("addToCartBtn")));
						driverWrapper.clickElement(btnAdd);
					}
				}
			}
			
			public static void addToCart(int index) {
				List<WebElement> list = 
						driverWrapper.getPresentElementsByCssSelector(propertiesWrapper.getProp("inventoryItem"));		
				WebElement btnAdd = list.get(index).findElement(By.cssSelector(propertiesWrapper.getProp("addToCartBtn")));
				driverWrapper.clickElement(btnAdd);
			}
			
			public static void openCart() {
				driverWrapper.clickElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("shoppingCartLinkPath")));
			}
			
			public static int getNumberOfProductInCart() {
				int num = 0;
				String sNum = driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("cartBadge")).getText();
				num = Integer.parseInt(sNum);
				return num;
			}
	
	   }
	   
	   public static class YourCartPage extends GenericPageObject{
		   
		   public static void checkout() {
			   driverWrapper.clickElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("checkoutLink")));
		   }
		   
	   }
	   
	   public static class YourInfoPage extends GenericPageObject{
		   
		   public static void enterFirstName(String firstName) {
			   driverWrapper.typeInElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("firstName")),firstName);
		   }
		   
		   public static void enterLastName(String lastName) {
			   driverWrapper.typeInElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("lastName")),lastName);
		   }
		   
		   public static void enterPostal(String postal) {
			   driverWrapper.typeInElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("postal")),postal);
		   }
		   
		   public static void submit() {
			   driverWrapper.clickElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("checkout")));
		   }
		   
		   public static void addYourInfo(String firstName,String lastName,String zipCode) {
			   enterFirstName(firstName);
			   enterLastName(lastName);
			   enterPostal(zipCode);
			   submit();
		   }
		   
	   }
	   
	   public static class OverViewPage extends GenericPageObject{
		   public static void finish() {
			   driverWrapper.clickElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("cartCheckout")));
		   }
		   
		   public static void cancel() {
			   driverWrapper.clickElement(driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("cartCancel")));
		   }
	   }
	   
	   public static class CompletePage extends GenericPageObject{
		   
		   public static String getMessage() {
			   return driverWrapper.getPresentElementByCssSelector(propertiesWrapper.getProp("completeHeader")).getText();
		   }
		   
	   }
}
