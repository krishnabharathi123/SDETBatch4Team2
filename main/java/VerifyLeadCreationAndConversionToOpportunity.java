import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLeadCreationAndConversionToOpportunity {

	public static void main(String[] args) throws InterruptedException {
	/*/
	 * 1. Step: Launch the browser (Chrome / Edge / Firefox / Safari).
		Expected Result: User should see the respective browser getting launched.
	 */
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		
		/*
		 * 2. Step: Load the specified URL (https://login.salesforce.com/).
		Expected Result: The Salesforce application’s login window should appear.
		 */
		
		driver.get("https://google-bf-dev-ed.develop.my.salesforce.com/");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Login | Salesforce");
		/*
		 * 3. Step: Enter the Username, Password and click on the Login button.
			Expected Result: The user should be logged into Salesforce CRM
		 */
		driver.findElement(By.id("username")).sendKeys("muthusubramanian91@sdet.testleaf.com");
		driver.findElement(By.id("password")).sendKeys("TestLeaf@1012");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(2000);
		String homePage = driver.getTitle();
		//Assert.assertEquals(homePage, "Home | Salesforce");
		
		/*
		 * 4. Step: Click on the ‘App Launcher’ toggle button.
			Expected Result: A list of apps should appear.
		 */
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement until = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'salesforceIdentityAppLauncherHeader')]/div")));
		until.click();
		
		WebElement app = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'al-menu-dropdown')]")));
		boolean displayed = app.isDisplayed();
		System.out.println(displayed);
		
		
		/*
		 * 5. Step: Click on the ‘View All’ link.
			Expected Result: The link should direct the user to the App Launcher pop up window.
		 */
		
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement appLauncher = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='App Launcher']")));
		String text = appLauncher.getText();
		Assert.assertEquals(text, "App Launcher");
		
		/*
		 * 6. Step: Type ‘Marketing’ in the search box and click on the ‘Marketing’ link.
			Expected Result: The link should direct the user to Marketing dashboard page.
		 */
		
		driver.findElement(By.xpath("//input[contains(@id,'input')]")).sendKeys("Marketing");
		driver.findElement(By.xpath("//mark[text()='Marketing']")).click();
		/*
		 * 7. Step: Navigate to the 'Leads' tab from the Marketing dashboard.
Expected Result: User should see a list of existing leads (if any) and options to create a
new lead.*/

		WebElement Leads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Leads']")));
		driver.executeScript("arguments[0].click()", Leads);
		
		WebElement newLeads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='New']")));
		
		Assert.assertTrue(newLeads.isDisplayed());
	
/*8. Step: Click on the 'New' button to create a lead.
Expected Result: A form to input details for the new lead should appear.*/

		newLeads.click();
		WebElement newleadsForm = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[text()='New Lead']")));
		
		Assert.assertTrue(newleadsForm.isDisplayed());
		
/*9. Step: Fill in all the mandatory fields (Salutation, First Name, Last Name, Company) with
valid data.
Expected Result: All details should be filled in without any errors.

		 */
		driver.findElement(By.xpath("//button[@name='salutation']")).click();
		
		WebElement salutaionMs = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Ms.']")));
		salutaionMs.click();
		Thread.sleep(2000);
		WebElement lastNm = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		driver.executeScript("arguments[0].scrollIntoView();", lastNm);
		lastNm.sendKeys("bharathi");
		
		driver.findElement(By.xpath("//input[@name='Company']")).sendKeys("Volante");
		
		driver.findElement(By.xpath("//label[text()='Lead Status']/following::button[1]")).click();
		
		//driver.findElement(By.xpath("//span[text()='Working - Contacted'")).click();
		
		
		
		/*
		 * 10. Step: Click on the 'Save' button.
Expected Result: A new lead should be created and user should be redirected to the
detailed view of the newly created lead. A confirmation message should also be displayed
and verified.
		 */
		WebElement saveBtn = driver.findElement(By.xpath("//button[text()='Save']"));
		driver.executeScript("arguments[0].click()", saveBtn);
		//div[contains(@id,'toastDescription')]/span
		//WebElement confirmMsg = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("div[contains(@id,'toastDescription')]/span")));
		//Assert.assertTrue(confirmMsg.isDisplayed());
		
		/*
		 * 11. Step: In the newly created Lead page, locate the dropdown near ‘Submit for Approval’
button and click on the ‘Convert’ link.
Expected Result: The 'Convert' link should be visible and clickable and a new dialog
should appear asking for details about converting the lead to an opportunity, contact, and
an account.
		 */
		/*12. Step: Click on the ‘Opportunity Name’ input field, clear and enter a new opportunity
		name.
		Expected Result: The entered value should appear.
		13. Step: Click on the 'Convert' button.
		Expected Result: The lead should be successfully converted. A confirmation message
		‘Your lead has been converted’ should be displayed and verified.*/
		
		WebElement approvalDrop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Submit for Approval']/following::li[1]")));
		approvalDrop.click();
		
		driver.findElement(By.xpath("//span[text()='Convert']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[text()='Convert']")).click();
		
		/*
		 * 14. Step: Click on the ‘Go to Leads’ button.
	Expected Result: It should redirect the user to Leads page.
		 */
		
		driver.findElement(By.xpath("//button[text()='Go to Leads']")).click();
		/*
		 * 15. Step: Search the verified lead name in the Search box and verify the text ‘No items to
display’.
Expected Result: The lead should not be displayed as it has been converted to
Opportunity and should display the confirmation message.

		 */
	}

}
