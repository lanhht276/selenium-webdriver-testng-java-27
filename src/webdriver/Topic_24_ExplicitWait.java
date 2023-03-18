package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_24_ExplicitWait {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	
	String beachFileName = "Beach.jpg";
	String noelFileName = "Noel.jpg";
	String hillFileName = "Hill.jpg";
	
	String beachFilePath = projectPath + "\\uploadFiles\\" + beachFileName;
	String noelFilePath = projectPath + "\\uploadFiles\\" + noelFileName;
	String hillFilePath = projectPath + "\\uploadFiles\\" + hillFileName;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	public void TC_01_Visible() {
				
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}
	
	
	public void TC_02_Invisible(){
		
		
		driver.get("https://automationfc.github.io/dynamic-loading/");
		
		explicitWait = new WebDriverWait(driver, 5);
		
		driver.findElement(By.cssSelector("div#start>button")).click();
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#loading")));
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#finish>h4")));
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#finish>h4")).getText(), "Hello World!");
	}

	
	public void TC_03_Ajax_Loading(){
		
		driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
		
		explicitWait = new WebDriverWait(driver, 3);
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.calendarContainer")));
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span.label")).getText(), "No Selected Dates to display.");
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='13']")));
		
		driver.findElement(By.xpath("//a[text()='13']")).click();
		
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div[id*='RadCalendar1']>div.raDiv")));
	
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//td[contains(@class,'rcSelected')]/a[text()='13']")));
	
		Assert.assertEquals(driver.findElement(By.cssSelector("span.label")).getText(), "Monday, March 13, 2023");
	}
	
	@Test
	public void TC_04_Upload_File(){
		
		driver.get("https://gofile.io/uploadFiles");
		
		//driver.findElement(By.cssSelector("button.filesUpload button")).click();
		
		explicitWait = new WebDriverWait(driver, 60);
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div#filesUpload button.filesUploadButton")));
				
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(beachFilePath + "\n" + noelFilePath + "\n" + hillFilePath );		
		
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("div.mainUploadFilesList div.progress")));
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'mainUploadSuccess')]//div[text()='Your files have been successfully uploaded']")));
				
		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'mainUploadSuccess')]//div[text()='Your files have been successfully uploaded']")).isDisplayed());
		
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'https://gofile.io/')]"))).click();
	
		//explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + beachFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Download']")));
		
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + beachFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + noelFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + hillFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Download']"))).isDisplayed());
		
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + beachFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Play']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + noelFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Play']"))).isDisplayed());
		Assert.assertTrue(explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + hillFileName + "']/parent::a/ancestor::div[contains(@class,'contentId')]//span[text()='Play']"))).isDisplayed());
	
	
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