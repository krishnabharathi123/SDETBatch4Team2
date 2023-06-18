package jirapackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Login to JIRA in incognito
	Click on Projects
Click 'View All projects'
Enter and invalid Project name and validate the text
Enter valid project Name
Click the project
Collect the list of issues in the board
Open a new tab and Create a new issues
Refresh and validate does the board has newly created issue
Create a bug with blocked by newly created issue
Change the status as Done for the newly created bug and validate the status in the board
 */
public class Scenario1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		options.addArguments("--incognito");
		
		//options.setAcceptInsecureCerts(true);
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
		
		driver.get("https://comparecheck.atlassian.net/");	
		
		driver.findElement(By.name("username")).sendKeys("bharathimanohar0696@gmail.com");
		
		driver.findElement(By.id("login-submit")).click();
		
		driver.findElement(By.id("password")).sendKeys("Bharathi@1996");
		
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//span[text()='Projects']")).click();
		
		driver.findElement(By.xpath("//span[text()='View all projects']")).click();
		
		driver.findElement(By.id("keyword")).sendKeys("test",Keys.ENTER);
		
		String expectedText="No projects were found that match your search";
		
		String actualText=driver.findElement(By.tagName("h4")).getText();
		
		if(actualText.equals(expectedText)) System.out.println("Error messae is valid: "+actualText);
		
		WebElement search=driver.findElement(By.id("keyword"));
		search.sendKeys(Keys.CONTROL, "a");
		//driver.findElement(By.id("keyword")).clear();
		//Thread.sleep(1000);
		
		search.sendKeys("compare_Check",Keys.ENTER);
		
		driver.findElement(By.xpath("//span[text()='compare_Check']")).click();
		
		List<WebElement> noOfJira = driver.findElements(By.xpath("//div[contains(@data-testid,'software-board.board-container')]/div"));
		
		System.out.println(noOfJira.size());
		
		for (WebElement jiras : noOfJira) {
			System.out.println(jiras.getText());
		}
		
		String currUrl=driver.getCurrentUrl();
		/*Thread.sleep(3000);
		driver.switchTo().newWindow(WindowType.TAB);
		//driver.get(currUrl);
		
		Robot rb = new Robot();
		// Press control keyboard key
		rb.keyPress(KeyEvent.VK_CONTROL);
		// Press T keyboard key
		rb.keyPress(KeyEvent.VK_T);
		// Release control keyboard key
		rb.keyRelease(KeyEvent.VK_CONTROL);
		// Release T keyboard key
		rb.keyRelease(KeyEvent.VK_T);
		
		
		Set<String> winId = driver.getWindowHandles();
		
		List<String> winIdL=new ArrayList<String>(winId);
		
		driver.switchTo().window(winIdL.get(1));
		
		driver.get(currUrl);*/
		
		driver.findElement(By.xpath("//span[text()='Create']")).click();
		
		WebElement drop=driver.findElement(By.xpath("//label[text()='Issue type']/following::div[contains(@class,'hpUCVg')]"));
		drop.click();
		Thread.sleep(2000);
		Actions buider=new Actions(driver);
		buider.sendKeys("task", Keys.ENTER).perform();
		//driver.executeScript("arguments[0].click();", type);
		
		//List<WebElement> issuetype = driver.findElements(By.xpath("//div[contains(@class,'dqHBji')]/div"));
		
		/*for (WebElement i : issuetype) {
			String type=i.getText();
			
			if(type.equals("bug")) {
				i.click();
				break;
			}
			
		}*/

		driver.findElement(By.id("summary-field")).sendKeys("Bharathi Creating test jira");
		
		
		
		WebElement assignee=driver.findElement(By.xpath("//span[text()='Automatic']"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);", assignee);
		
		assignee.click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(@class,'fabric-user-picker__menu')]//div/div/span/div[2]//span[text()='Karupasami']")).click();
		
		WebElement sprint=driver.findElement(By.xpath("//div[text()='Select sprint']"));
		
		driver.executeScript("arguments[0].scrollIntoView(true);", sprint);
		sprint.click();
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='CC Sprint 1']")).click();		
		//sprint.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("(//span[text()='Create'])[2]")).click();
		Thread.sleep(2000);
		WebElement alert=driver.findElement(By.className("css-f1lcxl"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3000));
		wait.until(ExpectedConditions.visibilityOf(alert));
		String jiraId=alert.getText();
		System.out.println(jiraId);
		System.out.println(jiraId.split("\"")[1]);
		
		//driver.navigate().refresh();
		
		//String jiraTask=driver.findElement(By.xpath("//div[contains(@class,'hrbrnk')]//a/span")).getText();
		
		//System.out.println(jiraTask);
		
		
		
		//driver.close();
	}

}
