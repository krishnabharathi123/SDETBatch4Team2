package week8.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JiraNewSprint_Project {
	/*
	 * Create a New Sprint and Project
1. Log in to JIRA
2. Click on the menu icon on the left top corner and 
3. Verify the Jira Software is present in the menu and click it.
4. Verify the icon present in the page and text as "You don't have any software projects" and 
click on Create Project, before clicking verify the button is enabled.
5. Click on the Scrum option and select use template in next page
6. Give the project details and create a new project, now verify project Key and 3 Types of JIRA 
status pane present (To Do, In-progress, Done).
7. Now star the project using the top right corner icon and verify it is starred.
8. Now Click on Backlog and Verify there is No Sprit have started.
9. Now click on Add date in the sprint 1(Default sprint pane) and click add dates, verify add 
dates text before clicking.
10. In the Displaying pop up, Update the sprint name as Project_Name - Sprint_1_2W and 
Select Duration as 2 Weeks, start date as Current time + 45 Mins and Click on Update ---> doubt
button.
11. Verify Create sprint button is disabled.
12. Click on Add issue and Add 2 Story and 2 Bugs, after adding verify the project name with bug 
id, JIRA status as Todo and Assignee as Unassigned. ---> pending
13. Click on Start Sprint and Verify Start button is present and enabled and click it
14. Verify the Sprint Started dialog at the left bottom and close it.
15. Verify the Days remaining.
16. Mouse hover the Days remaining and Verify start and End date (date alone) of the sprint
	 */
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--remote-allow-origins=*");

		RemoteWebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		//driver.get("https://start.atlassian.com/");
		driver.get("https://comparecheck.atlassian.net/");	
		
		driver.findElement(By.name("username")).sendKeys("bharathimanohar0696@gmail.com");
		
		driver.findElement(By.id("login-submit")).click();
		
		driver.findElement(By.id("password")).sendKeys("Bharathi@1996");
		
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//span[@aria-label='Appswitcher Icon']")).click();
		
		List<WebElement> icons = driver.findElements(By.xpath("//a[contains(@data-testid,'switcher-item')]//span[2]/span"));
		
		for(WebElement i:icons){
			if(i.getText().equals("Jira Software")) {
				
				System.out.println("Jira software available in menu");
				Thread.sleep(2000);
				i.click();
				break;
			}
		}
		System.out.println("out of loop");
		/*String expectedTxt="You currently have no projects";
		
		wait.until(ExpectedConditions.textToBe(By.tagName("h4"), expectedTxt));
		String projectTxt=driver.findElement(By.tagName("h4")).getText();
		
		Assert.assertEquals(projectTxt, expectedTxt);*/
		
		WebElement btn=driver.findElement(By.xpath("//span[text()='Create project']"));
		if(btn.isEnabled()) {
			btn.click();
		}
		
		driver.findElement(By.xpath("//span[@class='css-1gskvga']/following::span")).click();
		driver.findElement(By.xpath("//button[@aria-label='Scrum']")).click();
		driver.findElement(By.xpath("(//span[text()='Use template'])[2]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'team-managed')]")).click();
		//double ran=Math.random();
		long currentTimeMillis = System.currentTimeMillis();
		String ProjectName="VPT Project"+currentTimeMillis;
		driver.findElement(By.xpath("//input[contains(@id,'project-create')]")).sendKeys(ProjectName);
		Thread.sleep(2000);
		String keyValue=driver.findElement(By.xpath("//input[contains(@id,'key-field.input')]")).getAttribute("value");
		System.out.println(keyValue);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Actions builder=new Actions(driver);
		
		
		driver.findElement(By.xpath("//span[text()='Go to project']")).click();
		//WebElement dismiss=driver.findElement(By.xpath("//span[@aria-label='Dismiss']"));
		//builder.click(btn).perform();
		Thread.sleep(7000);
		WebElement key = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));
		
		String[] key1=key.getText().split(" ");
		System.out.println(key1[0]);
		List<String> expectedPanes= Arrays.asList("TO DO","IN PROGRESS","DONE");
		List<String> actualPanes=new ArrayList<String>();
		List<WebElement> pane=driver.findElements(By.xpath("//h2[contains(@data-test-id,'board-kit')]/div"));
		for(WebElement i:pane) {
			//Thread.sleep(4000);
			actualPanes.add(i.getText());
		}
		if(expectedPanes.equals(actualPanes)) {
			System.out.println("Valid pane values");
		}
		try {
		driver.findElement(By.xpath("//span[contains(@class,'icon-close')]")).click();
		}
		catch(NoSuchElementException e){
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		driver.findElement(By.xpath("//button[@aria-label='Add to Starred']")).click();
		String isFav=driver.findElement(By.xpath("//div[@data-test-id='favourite-button']/span")).getAttribute("data-is-favourite");
		if(isFav.equals("true")) {
			System.out.println("Project is starred");
		}
		else System.out.println("Project is not starred");
		
		driver.findElement(By.xpath("//span[text()='Backlog']")).click();
		driver.findElement(By.xpath("//span[text()='Add dates']")).click();
		WebElement sprintName = driver.findElement(By.xpath("//input[contains(@id,'sprintName-uid')]"));
		sprintName.sendKeys(Keys.CONTROL,"a");
		Thread.sleep(2000);
		sprintName.sendKeys(key1[0]+"Sprint_1_2W");
		driver.findElement(By.xpath("//div[contains(@id,'sprintDuration')]")).click();
		driver.findElement(By.xpath("//div[text()='2 weeks']")).click();
		
		driver.findElement(By.xpath("//div[contains(@data-testid,'startDate--timepicker')]")).click();
		driver.findElement(By.xpath("//div[contains(@id,'option-0')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Update']")).click();
		
		System.out.println(driver.findElement(By.xpath("//button[contains(@data-testid,'start-sprint')]")).isEnabled());
		driver.findElement(By.xpath("//div[text()='Create issue']")).click();
		driver.findElement(By.xpath("//button[contains(@data-testid,'type-select')]")).click();
		driver.findElement(By.xpath("//span[text()='Bug']")).click();
		builder.sendKeys("bug123").sendKeys(Keys.ENTER).perform();
		builder.sendKeys("bug234").sendKeys(Keys.ENTER).perform();
		driver.findElement(By.xpath("//button[contains(@data-testid,'type-select')]")).click();
		driver.findElement(By.xpath("//span[text()='Task']")).click();
		builder.sendKeys("task123").sendKeys(Keys.ENTER).perform();
		builder.sendKeys("task234").sendKeys(Keys.ENTER).perform();
		
		driver.findElement(By.xpath("//span[text()='Start sprint']")).click();
		WebElement startBtn = driver.findElement(By.xpath("//span[text()='Start']"));
		if(startBtn.isEnabled()) startBtn.click();
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Sprint started']")));
		WebElement dis=driver.findElement(By.xpath("//button[contains(@data-testid,'flag-v2-dismiss')]/span"));
		builder.click(dis).perform();
		driver.executeScript("arguments[0].click();", dis);
		WebElement remDay1=driver.findElement(By.xpath("//span[contains(@aria-label,'remaining')]"));
		String remDays=remDay1.getAttribute("aria-label");
		System.out.println(remDays);
		//mouse hover
		builder.moveToElement(remDay1).perform();
		String startDate=driver.findElement(By.xpath("//dt[1]/following-sibling::dd")).getText().split(" ")[0];
		String endDate=driver.findElement(By.xpath("//dt[2]/following-sibling::dd")).getText().split(" ")[0];
		System.out.println("startDate: "+startDate);
		System.out.println("endDate: "+endDate);
	}
}
