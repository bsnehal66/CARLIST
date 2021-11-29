
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import graphql.Assert;

import org.openqa.selenium.WebElement;

public class CarPurchase
{
@SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver","C:\\BrowserDriver\\chromedriver.exe");

		
  ChromeDriver driver = new ChromeDriver();
	driver.get("http://carlist.my");
	
	//To maximise the browser
			driver.manage().window().maximize();
			
			//To delete all cookies
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//To invoke URL
			driver.get("http://carlist.my");

			

	//Locating dropDown and click
	WebElement type = driver.findElement(By.xpath("//input[@type='text']"));
	
	
	type.click();
	//Select 'Used' type
	type.sendKeys(Keys.ENTER);
	
	
	//Click on search button
	WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
	
	searchButton.click();
	

	
	WebElement firstCar = driver.findElement(By.xpath("(//h2[@class='listing__title  epsilon  flush']/a)[1]"));						
    firstCar.click();    		
  
 
    String price= (driver.findElement(By.xpath("//h3[contains(text(),'RM')]")).getText().split(" "))[1].replace(",","");
   
    int priceNum = Integer.parseInt(price);
    
    Assert.assertTrue(priceNum>1000);
    
    System.out.println("Price of the car is: "+ priceNum+" which is greater than RM 1000");
    
    driver.quit();
    
}

}
