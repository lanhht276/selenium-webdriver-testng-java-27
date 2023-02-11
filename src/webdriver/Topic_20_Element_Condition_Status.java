package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_20_Element_Condition_Status {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait expliciWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		expliciWait = new WebDriverWait(driver, 15);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Visible_Displayed_Visibility() {
		driver.get("https://www.facebook.com/");
		
		//Element hiển thị trên UI & có trong DOM
		
		//Wait cho element Email hiển thị trong vòng10s
	
		expliciWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		
		driver.findElement(By.id("email")).sendKeys("automation@gmail.net");
		
	}
	
	
	public void TC_02_Invisible_Undisplayed_Invisibility_I(){
		driver.get("https://www.facebook.com/");
		
		//Element ko hiển thị trên UI & có trong DOM
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Wait cho element comfirmEmail ko  hiển thị trong vòng10s
		
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}

	public void TC_02_Invisible_Undisplayed_Invisibility_II(){
		driver.get("https://www.facebook.com/");
		
		//Element ko hiển thị trên UI & có trong DOM
		
		
		//Wait cho element comfirmEmail ko  hiển thị trong vòng10s
		
		expliciWait.until(ExpectedConditions.invisibilityOfElementLocated(By.name("reg_email_confirmation__")));
		
	}


	public void TC_03_Presence_I()  {
		driver.get("https://www.facebook.com/");
		
		//Element có hiển thị trên UI & có trong HTML (bắt buộc)
		//chờ Element email address presence trong HTML trong vòng 10s (ko quan tâm hiển thị hay ko)
		
		expliciWait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
	}

	 
	public void TC_03_Presence_II()  {
		
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Element ko có hiển thị trên UI & có trong HTML (bắt buộc)
		//chờ Element email address presence trong HTML trong vòng 10s (ko quan tâm hiển thị hay ko)
		
		expliciWait.until(ExpectedConditions.presenceOfElementLocated(By.name("reg_email_confirmation__")));
	}
	
	@Test 
	public void TC_04_Staleness()  {
		//Element ko có hiển thị trên UI (bắt buộc) & ko có trong DOM 
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		//Phase1: element có trong cây HTML 
		
		WebElement reEnterEmailAddressTextbox = driver.findElement((By.name("reg_email_confirmation__")));
	
		//Thao tác vs element khác làm cho element reEnter ko hiển thị trong DOM nữa
		//...
		
		//Close popup 
		
		driver.findElement(By.cssSelector("img._8idr")).click();
		
		expliciWait.until(ExpectedConditions.stalenessOf(reEnterEmailAddressTextbox));
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
	
}