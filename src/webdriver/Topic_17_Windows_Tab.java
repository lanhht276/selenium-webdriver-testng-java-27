package webdriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_17_Windows_Tab {
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

	
	
	public void TC_01_Window() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		String basicFormWindowID  = driver.getWindowHandle();
		System.out.println("Parent page: " + basicFormWindowID);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(2);
		
		switchWindowById(basicFormWindowID);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");

		
		String googleWindowID = driver.getWindowHandle();
		
		switchWindowById(googleWindowID);
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
	}
	
	
	@Test
	public void TC_02_Switch_By_Title(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		String parentWindowId  = driver.getWindowHandle();
		
		System.out.println("Parent page: " + parentWindowId);
		
		driver.findElement(By.xpath("//a[text()='GOOGLE']")).click();
		sleepInSecond(2);
		
		switchWindowByPageTitle("Google");
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.google.com.vn/");
		
		switchWindowByPageTitle("SELENIUM WEBDRIVER FORM DEMO");
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
		driver.findElement(By.xpath("//a[text()='FACEBOOK']")).click();
		sleepInSecond(2);
		
		switchWindowByPageTitle("Facebook – log in or sign up");
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

		switchWindowByPageTitle("SELENIUM WEBDRIVER FORM DEMO");

		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");

		driver.findElement(By.xpath("//a[text()='TIKI']")).click();
		sleepInSecond(2);
		
		switchWindowByPageTitle("Tiki - Mua hàng online giá tốt, hàng chuẩn, ship nhanh");
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://tiki.vn/");

		switchWindowByPageTitle("SELENIUM WEBDRIVER FORM DEMO");

		Assert.assertEquals(driver.getCurrentUrl(), "https://automationfc.github.io/basic-form/index.html");
		
		
		closeAllWindowWithoutParent(parentWindowId);
		
	}
	

	@Test
	public void TC_03_Live_Guru()  {
		
		driver.get("http://live.techpanda.org/");
		
		String parentId = driver.getWindowHandle();
		
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		driver.findElement(By.xpath("//a[@title='Xperia']//following-sibling::div//div[@class='actions']//ul//li/a[text()='Add to Compare']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(), "The product Sony Xperia has been added to comparison list.");

		driver.findElement(By.xpath("//a[@title='Samsung Galaxy']//following-sibling::div//div[@class='actions']//ul//li/a[text()='Add to Compare']")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(), "The product Samsung Galaxy has been added to comparison list.");

		driver.findElement(By.xpath("//span[text()='Compare']")).click();
		
		switchWindowByPageTitle("Products Comparison List - Magento Commerce");
		
		Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Compare Products']")).isDisplayed());
		
		driver.findElement(By.xpath("//span[text()='Close Window']")).click();
		
		//switchWindowByPageTitle("Mobile");
		
		closeAllWindowWithoutParent(parentId);
		
		driver.findElement(By.xpath("//a[@title='IPhone']//following-sibling::div//div[@class='actions']//ul//li/a[text()='Add to Compare']")).click();

		Assert.assertEquals(driver.findElement(By.cssSelector("li.success-msg")).getText(), "The product IPhone has been added to comparison list.");
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
	//Dung dc duy nhat cho 2 window/tab
	public void switchWindowById(String otherWindowId ) {
		
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		
		for (String id : allWindowIDs) {
			
			if (!id.equals(otherWindowId)) {
				driver.switchTo().window(id);
				sleepInSecond(2);
			}
			
		}
	}
	
	public void switchWindowByPageTitle(String expectedTitle ) {
		
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			//switch tung ID truoc
			driver.switchTo().window(id);
			
			//Lay ra tile cua page nat
			String actualTitle = driver.getTitle();
			
			if (actualTitle.equals(expectedTitle)) {
				sleepInSecond(2);
				break;
				
			}	
		}
	}

	
	public void closeAllWindowWithoutParent(String parentWindowId ) {
		
		Set<String> allWindowIDs = driver.getWindowHandles();
		
		for (String id : allWindowIDs) {
			
			if (!id.equals(parentWindowId)) {
				driver.switchTo().window(id);
				driver.close();
				sleepInSecond(2);
				
			}
	
		}
		driver.switchTo().window(parentWindowId);
	}
}
			
		
