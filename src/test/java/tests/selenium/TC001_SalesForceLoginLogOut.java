package tests.selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;
import pages.selenium.LoginPage;

public class TC001_SalesForceLoginLogOut extends PreAndPost{

	@BeforeTest
	public void setValues() {

		testCaseName = "loginLogout";
		testDescription = "login and logout with valid credentials";
		nodes = "Login Page";
		authors = "Bharathi";
		category = "UI";
		dataSheetName = "TC001";

	}

	@Test
	private void loginLogOut() {
		
		new LoginPage()
		.enterUserName("muthusubramanian91@sdet.testleaf.com")
		.enterpassword("TestLeaf@1012")
		.clickLoginBtn()
		.clickAppLauncherToggle()
		.clickViewAllLink()
		.typeSearch("Marketing")
		.clickLink("Marketing");
		
	}
}
