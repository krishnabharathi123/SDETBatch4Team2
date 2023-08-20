package pages.selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.aventstack.extentreports.ExtentTest;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import lib.selenium.PreAndPost;

public class LoginPageSF extends PreAndPost{
	private Properties prop;
	 
	@FindBy(id="user_name") 
	private WebElement eleUserName;	
	
	@FindBy(id="user_password")
	private WebElement elePassword;	
	
	@FindBy(how=How.ID,using="sysverb_login")
	private WebElement eleLogin;

	
	@Given("Enter username as (.*)$")
	private LoginPageSF typeUserName(String username) {	
		type(eleUserName, username);
		return this;
	}	

	@And("Enter password as (.*)$")
	private LoginPageSF typePassword(String password) {
		type(elePassword, password);
		return this;
	}	
	
	@Then("Click the Login")
	private HomePageSF clickLogIn() {
		click(eleLogin);
		return new HomePageSF(driver,test);		
	}
	
	public HomePageSF loginApp() {
		return 
		typeUserName(prop.getProperty("username"))
		.typePassword(prop.getProperty("password"))
		.clickLogIn();
	}
	
}
