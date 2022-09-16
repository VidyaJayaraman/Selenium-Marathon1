package test.codes;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceContact {

	public static void main(String[] args) throws InterruptedException {
		
		// Chrome Setup and Disable Browser Notifications
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		
		// Launch SalesForce URL
		
		driver.get("https://login.salesforce.com");
	    driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Enter the Username and Password
		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
   
		//Click on Toggle button
		
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		driver.findElement(By.xpath("//button[text() ='View All']")).click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		//Click on Account tab
		
		WebElement findElement2 = driver.findElement(By.xpath("//a[@title='Accounts']"));
		driver.executeScript("arguments[0].click();", findElement2);
		
		//Click on New
		
		WebElement findElement3 = driver.findElement(By.xpath("//div[@title='New']"));
		driver.executeScript("arguments[0].click();", findElement3);
		
		// Enter Name
		
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Vidya");
		
		// Selecting OwnerShip
		
		WebElement findElement4 = driver.findElement(By.xpath("//button[@aria-label='Ownership, --None--']"));
		driver.executeScript("arguments[0].click();", findElement4);
		WebElement findElement5 = driver.findElement(By.xpath("//span[text() = 'Public']"));
		driver.executeScript("arguments[0].click();", findElement5);
		
		// Save the user account
		
		driver.findElement(By.xpath("//button[@class='slds-button slds-button_brand']")).click();
		
		
		// Success Message text
		
		String text = driver.findElement(By.xpath("//span[text()='Account']/a")).getAttribute("title");
	    System.out.println(text);
	    
	    if(text.contains("Vidya"))
	    {
	    	System.out.println("User Vidya Created");
	    }
	    else
	    {
	    	System.out.println("User vidya not created");
	    }
	    
	}

}
