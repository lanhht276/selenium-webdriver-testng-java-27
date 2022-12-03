package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_15_Random_Popup {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_RandomPopUp_Javacode() {
		
		driver.get("https://www.javacodegeeks.com/");
		sleepInSecond(15);
		WebElement popup = driver.findElement(By.cssSelector("div.lepopup-popup-container>div:not([style*='display:none'])"));
		
		if (popup.isDisplayed()) {
			driver.findElement(By.xpath("//input[@class='lepopup-ta-left ']")).sendKeys(getRandomEmail());
			System.out.println(getRandomEmail());
			driver.findElement(By.xpath("//a[@data-label='Get the Books']")).click();
		}
		sleepInSecond(10);
		driver.findElement(By.cssSelector("input#s")).sendKeys("Agile Testing Explained");
		sleepInSecond(5);
		driver.findElement(By.cssSelector("button.search-button")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//h2/a[@title='Permalink to Agile Testing Explained']")).getText(),"Agile Testing Explained" );
		
		
	}
	
	
	public void TC_02_KMPlayer(){
		

		driver.get("https://kmplayer.com/home");
		sleepInSecond(8);
		
		WebElement popup = driver.findElement(By.cssSelector("div#layer2"));
		
		if (popup.isDisplayed()) {
			
			jsExecutor.executeScript("arguments[0].click()", driver.findElement(By.cssSelector("area#btn-r")));
			
		} else {
			System.out.println("Move to next step");
		}
		
		driver.findElement(By.xpath("//header//a[text()='PC 64X']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='KMPlayer 64X']")).isDisplayed());
		
	}

	@Test 
	public void TC_03_DeHieu_Not_In_DOM()  {
		
		driver.get("https://dehieu.vn/");
		sleepInSecond(8);
		
		List<WebElement> popup = driver.findElements(By.cssSelector("div.popup-content"));
		
		if (popup.size() > 0 && popup.get(0).isDisplayed()) {
			System.out.println("Popup is displayed");
			driver.findElement(By.cssSelector("input#popup-name")).sendKeys("John Wick");
			driver.findElement(By.cssSelector("input#popup-email")).sendKeys(getRandomEmail());
			driver.findElement(By.cssSelector("input#popup-phone")).sendKeys("0903300888");
			
			driver.findElement(By.cssSelector("button#close-popup")).click();
			
			
		} else {
			System.out.println("Move to next step");
		}
		//Next step
			driver.findElement(By.xpath("//a[text()='Tất cả khóa học']")).click();
			driver.findElement(By.cssSelector("input#search-courses")).sendKeys("Khóa học Thiết kế tủ điện");
			driver.findElement(By.cssSelector("i.fa.fa-search")).click();
			
			Assert.assertEquals(driver.findElement(By.cssSelector("h4.name-course")).getText(), "Khóa học Thiết kế tủ điện");

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
	
	public String getRandomEmail() {
		Random rand = new Random();
		
		return "kenny" + rand.nextInt(9999) + "@gmail.com";
		
		
	}
	
}