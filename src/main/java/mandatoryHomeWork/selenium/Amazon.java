package week7.day4;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	/*
	 * 1.Load the URL https://www.amazon.in/ 2.search as oneplus 9 pro 3.Get the
	 * price of the first product 4. Print the number of customer ratings for the
	 * first displayed product 5. Click the first text link of the first image 6.
	 * Take a screen shot of the product displayed 7. Click 'Add to Cart' button 8.
	 * Get the cart subtotal and verify if it is correct. 9.close the browser
	 */
	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		RemoteWebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		driver.get("https://www.amazon.in/");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");

		driver.findElement(By.id("nav-search-submit-button")).click();

		String price = driver.findElement(By.className("a-price-whole")).getText();

		System.out.println(price);

		String rating = driver.findElement(By.xpath("//span[contains(@class,'a-size-base s-underline-text')]"))
				.getText();

		System.out.println(rating);

		driver.findElement(By.tagName("h2")).click();

		Set<String> winSet = driver.getWindowHandles();

		List<String> winList = new ArrayList<String>(winSet);

		driver.switchTo().window(winList.get(1));

		WebElement landingImg = driver.findElement(By.id("landingImage"));

		landingImg.click();
		Thread.sleep(2000);
		WebElement img = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ivStage div img")));
		
		File src = img.getScreenshotAs(OutputType.FILE);

		File dest = new File("./snaps/landingimg.png");

		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//button[@data-action='a-popover-close']")).click();
		
		driver.findElement(By.id("add-to-cart-button")).click();
		//Thread.sleep(5000);
		
		//String subTotal=driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		WebElement subTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attach-accessory-cart-subtotal")));
		String subT=subTotal.getText();
		System.out.println(Integer.parseInt(subT.split("₹")[1]));
		System.out.println("---");

		driver.quit();

	}

}
