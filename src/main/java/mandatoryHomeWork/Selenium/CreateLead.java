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

public class CreateLead {

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
		
		String title="View Lead | opentaps CRM";
		
		String title1=driver.getTitle();
		
		Assert.assertEquals(title, title1);
		
	}

}
