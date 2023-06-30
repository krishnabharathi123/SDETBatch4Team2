package week6.day1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

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
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumScenarioAssignment_Jira {
/*
 * 1. Login to JIRA with Private/In Private mode.
2. Click on project and select your project
3. From the board move any issue from one status to other using drag and drop
4. Click on any Task
5. click on 'add a child issue' and create a sub task
6. Go to that sub task and do below actions
	a. add Description
	b. add assignee from your team
	c. add a label 
	d. add a comment
	e. click on add and validate the comment
7. Go to JIRA board and validate the sub task
8. Navigate to the Sub Task and add a attachment, and validate the same.
9. Delete the Parent task
10. Validate in JIRA board as Parent and Sub Task has been move out of board
 */
	public static void main(String[] args) throws InterruptedException, AWTException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--remote-allow-origins=*");
		
		options.addArguments("--incognito");
		
		//options.setAcceptInsecureCerts(true);
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		driver.get("https://comparecheck.atlassian.net/");
		
		driver.findElement(By.name("username")).sendKeys("bharathimanohar0696@gmail.com");
		
		driver.findElement(By.id("login-submit")).click();
		
		driver.findElement(By.id("password")).sendKeys("Bharathi@1996");
		
		driver.findElement(By.xpath("//span[text()='Log in']")).click();
		
		driver.findElement(By.xpath("//span[text()='Projects']")).click();
		
		driver.findElement(By.xpath("//span[text()='compare_Check (CC)']")).click();
		
		Thread.sleep(2000);
		//Drag and drop not working
		/*WebElement ele=driver.findElement(By.xpath("(//div[contains(@class,'1gar2hk')])[1]"));
		
		WebElement ele1=driver.findElement(By.xpath("(//div[contains(@class,'1gar2hk')])[4]"));
		
		Actions builder = new Actions(driver);
		
		builder.moveToElement(ele).clickAndHold().moveToElement(ele1).release().perform();*/
		//builder.dragAndDrop(ele, ele1).perform();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[contains(@id,'card')])[2]")).click();
		
		driver.findElement(By.xpath("//button[contains(@aria-label,'Add a child')]")).click();
		
		//Date date=new Date();
		
		//String ran=(String) (date.getDay()+":"+date.getHours());
		
		String currentTimeMillis = (String)(System.currentTimeMillis()+"");
		//String value="child issue"+ran;
		driver.findElement(By.id("childIssuesPanel")).sendKeys(currentTimeMillis);
		
		driver.findElement(By.xpath("//button[contains(@data-testid,'child')]//span[text()='Create']")).click();
		Thread.sleep(4000);
		WebElement el=driver.findElement(By.xpath("//span[text()='"+currentTimeMillis+"']"));
		Actions builder1 = new Actions(driver);
		builder1.click(el).perform();
		/*WebElement el=driver.findElement(By.xpath("//span[contains(text(),'child issue1')]/../../../.."));
		Actions builder1 = new Actions(driver);
		builder1.click().perform();*/
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Show:']")));
		WebElement des=driver.findElement(By.xpath("//span[contains(text(),'description')]"));
		des.click();
		Thread.sleep(2000);
		//WebElement el2=	driver.findElement(By.xpath("//span[@data-testid='placeholder-test-id']")).click();
		WebElement el1=driver.findElement(By.xpath("//span[@data-testid='placeholder-test-id']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", el1);

		driver.findElement(By.xpath("//p/br")).sendKeys("hello jira");
		
		WebElement assignee=driver.findElement(By.xpath("//span[text()='Unassigned']"));
		assignee.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hema Murugesan']")).click();
		
		driver.findElement(By.xpath("//button[@aria-label='None- edit Labels']/following::span")).click();
		
		
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//div[text()='test']"))));
		
		driver.findElement(By.xpath("//div[text()='test']")).click();
		
		WebElement comment=driver.findElement(By.xpath("//input[@placeholder='Add a comment…']"));
		comment.click();
		Thread.sleep(5000);
		String comments="adding Jira comments";
		//WebElement com=driver.findElement(By.cssSelector(".placeholder-decoration.ProseMirror-widget"))dding jira comments123");
		builder1.sendKeys(comments).perform();
		driver.findElement(By.xpath("//span[text()='Save']")).click();
		Thread.sleep(2000);
		String commentsAdded=driver.findElement(By.xpath("//p[@data-renderer-start-pos='1']")).getText();
		Assert.assertEquals(comments, commentsAdded);
		
		driver.findElement(By.xpath("//button[@aria-label='Close']")).click();
		
		driver.findElement(By.xpath("//span[text()='None']")).click();
		driver.findElement(By.xpath("//span[text()='Subtask']")).click();
		
		driver.findElement(By.xpath("//input[@name='search']")).sendKeys(currentTimeMillis);
		builder1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//mark[text()='1685546465131']")).click();
		driver.findElement(By.xpath("//div[@data-test-id='platform-board-kit.ui.card.card']")).click();
		
		WebElement attach=driver.findElement(By.xpath("//span[text()='Attach']"));
		attach.click();
		

		StringSelection stringSelection = new StringSelection("D:\\TestLeaf\\SdetCourse\\ClassNotes\\Class1");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        String attachmentFile=driver.findElement(By.id("titleBoxHeader")).getText();
        if(attachmentFile.contains("Class1")) {
        	System.out.println("correct file attached");
        }
        else {
        	System.out.println("file not attaced properly");
        }
        
        driver.findElement(By.xpath("//a[contains(@data-testid,'parent-issue.item')]")).click();
        
       String parentTask= driver.findElement(By.xpath("//a[contains(@data-testid,'current-issue.item')]/span")).getText();
       
       System.out.println(parentTask);
       driver.findElement(By.xpath("//button[contains(@data-testid,'trigger.button')]")).click();
       
       driver.findElement(By.xpath("//span[text()='Delete']")).click();
       
       driver.findElement(By.xpath("//button[contains(@data-testid,'delete-issue.confirm')]")).click();
       
       WebElement cancel = driver.findElement(By.xpath("//button[contains(@data-test-id,'clear-button')]"));
       wait.until(ExpectedConditions.visibilityOf(cancel));
       driver.navigate().refresh();
       //Thread.sleep(3000);
       //cancel.click();
      //WebElement srch= driver.findElement(By.xpath("//input[@data-test-id='searchfield']"));
      //srch.clear();
       WebElement drop = driver.findElement(By.xpath("//label[text()='Group by']/following::button"));
       drop.click();
       driver.findElement(By.xpath("//span[text()='None']")).click();
       //driver.findElement(By.xpath("//input[@data-test-id='searchfield']")).sendKeys(parentTask);
      
      // driver.findElement(By.xpath("//h2[contains(@data-test-id,'editable-title')]")).getText();
       
       
       
       
		//builder1.sendKeys("D:\\TestLeaf\\SdetCourse\\ClassNotes").perform();
		//d. add a comment
		//e. click on add and validate the comment
		//org.openqa.selenium.ElementNotInteractableException:
		/*js.executeScript("arguments[0].scrollIntoView(true);", comment);
		js.executeScript("arguments[0].click();", comment);
		//driver.findElement(By.xpath("//div[@data-testid='click-wrapper']")).click();
		driver.findElement(By.xpath("//div[@data-testid='click-wrapper']")).sendKeys("adding jira comments123");*/
		
        
        /* sathish code
         * //open attach
		String path = "\\src\\test\\java\\weekDayAssignment\\childIssueAttachment.txt";
		String dirPath = System.getProperty("user.dir");
		System.out.println(dirPath + " --***--- " + path);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text() = 'Attach']"))).click();
		act.sendKeys(dirPath+path).build().perform();
		Thread.sleep(2000);
		act.sendKeys(Keys.ENTER).perform();
		Thread.sleep(8000);
		WebElement atchmnt = wait.until(ExpectedCond
         */
		
	}

}
