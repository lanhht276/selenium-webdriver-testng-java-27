package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		System.out.println("Alert content is:" + alert.getText());
		
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");
	}
	
	@Test
	public void TC_02_Confirm_Alert(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		System.out.println("Alert content is:" + alert.getText());
		
		alert.dismiss();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");
		
	}
	

	@Test 
	public void TC_03_Prompt_Alert()  {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		System.out.println("Alert content is:" + alert.getText());
		
		alert.sendKeys("Lanh superman");
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: "+ "Lanh superman");
	}
	@Test 
	public void TC_04_Authentication_Alert()  {
		
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	// Sleep cứng (static wait)
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}