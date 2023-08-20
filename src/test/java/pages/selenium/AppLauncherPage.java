package pages.selenium;

import lib.selenium.PreAndPost;

public class AppLauncherPage extends PreAndPost{

	/*
	 * driver.findElement(By.xpath("//input[contains(@id,'input')]")).sendKeys("Marketing");
		driver.findElement(By.xpath("//mark[text()='Marketing']")).click();
	 */
	
	public AppLauncherPage typeSearch(String value){
		type(locateElement("xpath","//input[contains(@id,'input')]"), value);
		return this;
	}
	
	public MarketingPage clickLink(String linkVal) {
		click(locateElement("xpath","//mark[text()='"+linkVal+"']"));
		return new MarketingPage();
	}


}
