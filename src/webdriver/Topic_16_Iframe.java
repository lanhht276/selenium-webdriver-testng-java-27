package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_16_Iframe {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Iframe() {
		
		driver.get("https://skills.kynaenglish.vn/");
		
		Assert.assertTrue(driver.findElement(By.xpath("//iframe[contains(@src, 'kyna.vn')]")).isDisplayed());
	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'kyna.vn')]")));
		
		String facebookLike = driver.findElement(By.xpath("//a[text()='Kyna.vn']/parent::div/following-sibling::div")).getText();
		System.out.println(facebookLike);
		
		Assert.assertEquals(facebookLike, "165K likes");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("cs_chat_iframe");
		
		driver.findElement(By.cssSelector("div.button_bar")).click();
		
		driver.findElement(By.cssSelector("input.input_name")).sendKeys("Lanh test");
		driver.findElement(By.cssSelector("input.input_phone")).sendKeys("0987654321");
		
		select = new Select(driver.findElement(By.cssSelector("select#serviceSelect")));
		select.selectByVisibleText("TƯ VẤN TUYỂN SINH");
		
		driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Java Bootcamp");
		driver.findElement(By.cssSelector("input.submit")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.cssSelector("input#live-search-bar")).sendKeys("Excel");
		driver.findElement(By.cssSelector("button.search-button")).click();
		
		List<WebElement> searchTitle = driver.findElements(By.xpath("//a[@class='card-popup']/parent::li//h4"));
		
		for (WebElement webElement : searchTitle) {
			Assert.assertTrue(webElement.getText().contains("Excel"));
		}
		
	}
	
	@Test
	public void TC_02_Frame(){
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame("login_page");
		
		driver.findElement(By.cssSelector("input.form-control")).sendKeys("John1234");
		driver.findElement(By.cssSelector("a.login-btn")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("input#fldPasswordDispId")).isDisplayed());
		
		driver.findElement(By.cssSelector("input#fldPasswordDispId")).sendKeys("john20202023");
	}

	@Test 
	public void TC_03_()  {
		
		
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