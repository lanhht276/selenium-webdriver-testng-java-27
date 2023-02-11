package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_19_Upload_File {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	
		
	String beachFileName = "Beach.jpg";
	String noelFileName = "Noel.jpg";
	String hillFileName = "Hill.jpg";
	
	String beachFilePath = projectPath + "\\uploadFiles\\" + beachFileName;
	String noelFilePath = projectPath + "\\uploadFiles\\" + noelFileName;
	String hillFilePath = projectPath + "\\uploadFiles\\" + hillFileName;
	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_Upload1File_Per_Time() {
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(beachFilePath);
		sleepInSecond(1);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(noelFilePath);
		sleepInSecond(1);
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(hillFilePath);
		sleepInSecond(1);
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text() = '" + beachFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text() = '" + noelFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text() = '" + hillFileName + "']")).isDisplayed());
		
		List<WebElement> startBtn = driver.findElements(By.cssSelector("table button.start"));
		
		for (WebElement webElement : startBtn) {
			webElement.click();
			sleepInSecond(2);
			
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + beachFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + noelFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hillFileName + "']")).isDisplayed());
		
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'" + beachFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'" + noelFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'" + hillFileName + "')]")).isDisplayed());
	}
	
	@Test
	public void TC_02_Upload_Multiple_File(){
		
		driver.get("https://blueimp.github.io/jQuery-File-Upload/");
		
		driver.findElement(By.cssSelector("input[type='file']")).sendKeys(beachFilePath + "\n" + noelFilePath + "\n" + hillFilePath  );
		sleepInSecond(1);
		
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text() = '" + beachFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text() = '" + noelFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name' and text() = '" + hillFileName + "']")).isDisplayed());
		
		List<WebElement> startBtn = driver.findElements(By.cssSelector("table button.start"));
		
		for (WebElement webElement : startBtn) {
			webElement.click();
			sleepInSecond(3);
			
		}
		
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + beachFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + noelFileName + "']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[@class='name']/a[@title='" + hillFileName + "']")).isDisplayed());
		
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'" + beachFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'" + noelFileName + "')]")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//img[contains(@src,'" + hillFileName + "')]")).isDisplayed());
	}
	

	@Test 
	public void TC_03_()  {
		
		
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