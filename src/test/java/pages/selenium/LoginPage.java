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

public class LoginPage extends PreAndPost{
	private Properties prop;
	
	public LoginPage enterUserName(String username) {
		type(locateElement("username"), username);
		return this;
	}
	
	public LoginPage enterpassword(String password) {
		type(locateElement("password"), password);
		return this;
	}
	
	public HomePage clickLoginBtn() {
		click(locateElement("Login"));
		return new HomePage();
	}
	
	
}
