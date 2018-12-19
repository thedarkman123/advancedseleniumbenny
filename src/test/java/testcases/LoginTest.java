package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPageObject.LoginPage;

public class LoginTest extends BaseTest {

	@Test
	public void lg1_loginFailed() {
		LoginPage.login("standard_user", "111");	
		Assert.fail("Failed the first test");
	}
	
	@Test
	public void lg11_loginFailed() {
		LoginPage.login("standard_user", "333");
		Assert.fail("Failed The second test");
	}
	
	@Test
	public void lg2_loginSucced() {
		LoginPage.login("standard_user", "secret_sauce");
	}
}
