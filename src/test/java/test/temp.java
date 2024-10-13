package test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class temp {

	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.get("https://login.salesforce.com/?locale=in");
		
		WebElement frm = driver.findElement(By.xpath("//iframe[@id='marketing']"));
		driver.switchTo().frame(frm);
		WebElement freeTril = driver.findElement(By.xpath("//a[contains(@href,'https://www.salesforce.com/in/form/sign')]"));
				freeTril.click();
				
		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles()); 		
				driver.switchTo().window(addr.get(1));
				
		System.out.println("URL : " +driver.getCurrentUrl()); 		
		WebDriverWait wait = new WebDriverWait(driver,20);
			
		wait.until(ExpectedConditions.urlContains("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=7010M000002IWwj&internal=true"));	
		WebElement firstName = driver.findElement(By.xpath("//label[normalize-space(text())='First name']/preceding-sibling::input"));
		
		System.out.println(driver.findElement(By.xpath("//span[normalize-space(text())='Start your free trial.']")).getText());	
		firstName.sendKeys("kaido");
		
		WebElement jobTitle = driver.findElement(By.xpath("//option[text()='Job Title']/parent::select"));
		
		Select s = new Select(jobTitle);
		s.selectByVisibleText("IT Manager");
				
	}
}
