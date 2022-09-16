package test.codes;

import java.awt.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceOpportunity {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
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
				Thread.sleep(1000);
				driver.findElement(By.xpath("//button[text() ='View All']")).click();
				driver.findElement(By.xpath("//p[text()='Sales']")).click();
				
				
				//Click on Opportunities tab
				
				WebElement findElement1 = driver.findElement(By.xpath("//a[@title='Opportunities']"));
				driver.executeScript("arguments[0].click();", findElement1);
				
				//Click on New
				
				WebElement findElement2 = driver.findElement(By.xpath("//a[@title='New']"));
				driver.executeScript("arguments[0].click();", findElement2);
				
				// Enter the Name
				
				driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Vidya");
				
				//Enter the date
				
				driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
				driver.findElement(By.xpath("//input[@name='CloseDate']")).sendKeys("9/16/2022");
	            
				// Enter the stage
				
				WebElement findElement3 = driver.findElement(By.xpath("//button[contains(@class,'slds-combobox__input')]"));
				driver.executeScript("arguments[0].click();", findElement3);
				WebElement findElement4 = driver.findElement(By.xpath("//span[@title = 'Value Proposition']"));
				driver.executeScript("arguments[0].click();", findElement4);
				
		        // Click Save
				
				driver.findElement(By.xpath("//button[text()='Save']")).click();
				
			    // Verify Success Message
				
				String successText = driver.findElement(By.xpath("(//a[@class='forceActionLink'])[2]")).getAttribute("title");
				
				if(successText.contains("Vidya")) {
					System.out.println("Opportunity for User Vidya Created");
				}
				else
				{
					System.out.println("Opportunity for User Vidya not Created");
				}
				
				
	}                            

}
