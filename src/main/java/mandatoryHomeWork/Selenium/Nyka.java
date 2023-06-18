package week7.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * 1. Go to https://www.nykaa.com/
2. Mouseover on Brands and Search L'Oreal Paris
3. Click L'Oreal Paris
4. Check the title contains L'Oreal Paris
5. Click sort By and select customer top rated
6. Click Category and click Hair->Click haircare-
>Shampoo
7. Click->Concern->Color Protection
8.check whether the Filter is applied with 
Shampo
9. Click on L'Oreal Paris Colour Protect Shampoo
10. GO to the new window and select size as 
175ml
11. Print the MRP of the product
12. Click on ADD to BAG
13. Go to Shopping Bag 
14. Print the Grand Total amount
15. Click Proceed
16. Click on Continue as Guest
17. Check if this grand total is the same in step 14
18. Close all windows
 */
public class Nyka {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://www.nykaa.com/");

		Actions builder = new Actions(driver);

		WebElement outline = driver.findElement(By.xpath("//div[@class='outline-wrapper']"));

		builder.moveToElement(outline).click().perform();
		builder.moveToElement(driver.findElement(By.xpath("//a[text()='brands']"))).perform();

		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris", Keys.ENTER);

		driver.findElement(By.linkText("L'Oreal Paris")).click();

		System.out.println(driver.getTitle());

		Thread.sleep(3000);

		driver.findElement(By.xpath("//span[contains(@class,'sort-name')]")).click();

		driver.findElement(By.xpath("//span[text()='customer top rated']/following::div")).click();

		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		WebElement hair = driver.findElement(By.xpath("//span[text()='Hair']"));
		//wait.until(ExpectedConditions.stalenessOf(hair));
		hair.click();

		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();

		driver.findElement(By.xpath("//span[text()='Shampoo']/following::div[1]")).click();

		driver.findElement(By.xpath("//span[text()='Concern']")).click();

		driver.findElement(By.xpath("//span[text()='Color Protection']/following::div")).click();

		List<WebElement> filter = driver.findElements(By.className("filter-value"));
		List<String> filterValues = new ArrayList<String>();
		for (WebElement i : filter) {

			filterValues.add(i.getText());
		}

		if (filterValues.contains("Shampoo")) {
			System.out.println("filter contains shampoo");
		} else {
			System.out.println("filter doesn't have shampoo");
		}
		Thread.sleep(2000);
		WebElement colorProtect = driver.findElement(By.xpath("//div[contains(text(),'Paris Colour Protect')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", colorProtect);

		// .click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> winList = new ArrayList<String>(windowHandles);

		driver.switchTo().window(winList.get(1));

		driver.findElement(By.xpath("//span[text()='180ml']")).click();

		String mrp = driver.findElement(By.xpath("//span[text()='MRP:']/following-sibling::span")).getText();

		System.out.println("MRP: is" + mrp);

		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();

		driver.findElement(By.xpath("//*[name()='svg']/following-sibling::*[name()='span' and @class='cart-count']"))
				.click();
		// wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Grand
		// Total']/preceding::span[1]"))));
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.className("css-acpm4k")));

		String grandTotal = driver.findElement(By.xpath("//span[text()='Grand Total']/preceding::span[1]")).getText();

		System.out.println("Grand Total is:" + grandTotal);

		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		
		driver.findElement(By.xpath("//img[contains(@src,'Clear')]")).click();
		
		String priceDetails=driver.findElement(By.xpath("(//img[contains(@src,'down')]/preceding::p[1])[2]")).getText();
		
		System.out.println(priceDetails);
		
		if(grandTotal.equals(priceDetails)) {
			System.out.println("Grand Total is same as Price Details");
		}
		
		driver.quit();
	}

}
