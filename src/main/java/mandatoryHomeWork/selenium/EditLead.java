package leafTaps;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * 1. Launch URL 
"http://leaftaps.com/opentaps/control/login"
2. Enter UserName and Password Using Id Locator
3. Click on Login Button using Class Locator
4. Click on CRM/SFA Link
5. Click on Leads Button
6. Click on Create Lead 
7. Enter CompanyName Field Using id Locator
8. Enter FirstName Field Using id Locator
9. Enter LastName Field Using id Locator
10. Enter FirstName(Local) Field Using id Locator
11. Enter Department Field Using any Locator of Your 
Choice
12. Enter Description Field Using any Locator of your 
choice 
13. Enter your email in the E-mail address Field using 
the locator of your choice
14. Select State/Province as NewYork Using Visible Text
15. Click on Create Button
16. Click on edit button
17. Clear the Description Field using .clear()
18. Fill ImportantNote Field with Any text
19. Click on update button 
20. Validate the Title of Resulting Page
 */
public class EditLead {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("tcs123");
		
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("bhartahi");
		
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("manohar");
		
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("kb");
		
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("engineering");
		
		driver.findElement(By.id("createLeadForm_description")).sendKeys("creating a new lead for reference");
		
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("abcd@gmail.com");
		
		WebElement drop=driver.findElement(By.name("generalStateProvinceGeoId"));
		
		Select s1= new Select(drop);
		
		s1.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@value='Create Lead' and @name='submitButton']")).click();
		
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		
		driver.findElement(By.id("updateLeadForm_description")).clear();
		
		driver.findElement(By.name("importantNote")).sendKeys("This is an important note");
		
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="View Lead | opentaps CRM";
		Assert.assertEquals(actualTitle, expectedTitle);
		
		driver.close();

	}

}
