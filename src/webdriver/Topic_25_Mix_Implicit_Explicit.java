package webdriver;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_25_Mix_Implicit_Explicit {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Element_Found() {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 14);
		
		driver.get("https://www.facebook.com/");
		
		System.out.println("Start time of Implicit Wait: " + getTimestamp());
		driver.findElement(By.cssSelector("input#email"));
		System.out.println("End time of Implicit Wait: " + getTimestamp());
		
		System.out.println("Start time of Explicit Wait: " + getTimestamp());
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#email"))).isDisplayed();
		System.out.println("End time of Explicit Wait: " + getTimestamp());
	}
	
	
	public void TC_02_Element_Not_Found_Implicit(){
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		
		System.out.println("Start time of Implicit Wait: " + getTimestamp());
		try {
			driver.findElement(By.cssSelector("input#selenium"));
		} catch (Exception e) {
			System.out.println("End time of Implicit Wait: " + getTimestamp());
		}
		
	}

	 
	public void TC_03_Element_Not_Found_Implicit_Explicit()  {
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
				
		System.out.println("Start time of Explicit Wait: " + getTimestamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium"))).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("End time of Explicit Wait: " + getTimestamp());
			e.printStackTrace();
		}
	}
	@Test 
	public void TC_04_Element_Not_Found_Explicit_By()  {
		
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.get("https://www.facebook.com/");
		
				
		System.out.println("Start time of Explicit Wait: " + getTimestamp());
		try {
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input#selenium"))).isDisplayed();
			
		} catch (Exception e) {
			System.out.println("End time of Explicit Wait: " + getTimestamp());
			e.printStackTrace();
		}
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	// Sleep cứng (static wait)
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getTimestamp() {
		Date date = new Date();
		return date.toString();
		
	}
	
}