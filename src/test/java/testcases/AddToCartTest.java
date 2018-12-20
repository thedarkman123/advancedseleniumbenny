package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.PageObjects.*;

public class AddToCartTest extends BaseTest {
	
	@Test(priority=1)	
	public void addToCartCancel() {
		LoginPage.login("standard_user", "secret_sauce");
		
		ProductsPage.addToCart("Sauce Labs Bolt T-Shirt");
		ProductsPage.addToCart("Sauce Labs Fleece Jacket");
		ProductsPage.openCart();
		
		YourCartPage.checkout();
		
		YourInfoPage.addYourInfo("gal", "ester", "555");

		OverViewPage.cancel();

		System.out.println(ProductsPage.getNumberOfProductInCart());

		Assert.assertEquals(ProductsPage.getNumberOfProductInCart(), 2);
	}
	
	@Test(priority=2)
	public void addToCartSucceed() {
		ProductsPage.openCart();
		
		YourCartPage.checkout();
		
		YourInfoPage.addYourInfo("gal", "ester", "555");
		
		OverViewPage.finish();
		
		Assert.assertEquals(CompletePage.getMessage(), "THANK YOU FOR YOUR ORDER");
	}
}
