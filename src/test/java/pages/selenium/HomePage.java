package pages.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import lib.selenium.PreAndPost;

public class HomePage extends PreAndPost {

	public HomePage clickAppLauncherToggle() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		click(wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]/div"))));
		return this;
	}

	public AppLauncherPage clickViewAllLink() {
		click(locateElement("xpath", "//button[text()='View All']"));
		return new AppLauncherPage();
	}
}
