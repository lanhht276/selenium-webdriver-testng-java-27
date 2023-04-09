package webdriver;

import static org.testng.Assert.assertEquals;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_27_Page_Ready {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	WebDriverWait explicitWait;
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		
		explicitWait = new WebDriverWait(driver, 30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		action = new Actions(driver);
		
	}

	
	public void TC_01_OrangeHRM() {
		
		driver.get("https://opensource-demo.orangehrmlive.com");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		Assert.assertTrue(driver.findElement(By.cssSelector("span.oxd-text.oxd-text--span.orangehrm-attendance-card-fulltime")).getText().contains("Today"));
	}
	
	
	public void TC_02_NopCommerce(){
		
		driver.get("https://admin-demo.nopcommerce.com");
		
		driver.findElement(By.cssSelector("input#Email")).clear();
		driver.findElement(By.cssSelector("input#Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.cssSelector("input#Password")).clear();
		driver.findElement(By.cssSelector("input#Password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Assert.assertTrue(waitForAjaxBusyLoadingInvisible());
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Assert.assertTrue(waitForAjaxBusyLoadingInvisible());
		
		Assert.assertEquals(driver.getTitle(),"Your store. Login");
	
	}
	
	@Test
	public void TC_03_()  {
		
		driver.get("https://blog.testproject.io/");
		
		
		action.moveToElement(driver.findElement(By.cssSelector("h1.main-heading"))).perform();
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		String keyword = "Selenium";
		
		driver.findElement(By.cssSelector("section#search-2 input.search-field")).sendKeys(keyword);
		action.sendKeys(Keys.ENTER).perform();
		//driver.findElement(By.cssSelector("section#search-2 span.glass")).click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='main-heading' and text()='Search Results']")));
		
		Assert.assertTrue(isPageLoadedSuccess());
		
		List<WebElement> postAricles = driver.findElements(By.cssSelector("h3.post-title>a"));
		
		for (WebElement article : postAricles) {
			Assert.assertTrue(article.getText().contains(keyword));
			
		}
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public boolean isPageLoadedSuccess() {
		explicitWait = new WebDriverWait(driver, 50);
		
		
		  ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		  public Boolean apply(WebDriver driver) { // TODO Auto-generated method stub
		  return (Boolean)jsExecutor.
		  executeScript("return (window.jQuery != null) && (jQuery.active === 0);"); }
		  };
		 
		
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
			};
			
		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
				
		};
		
	
		public boolean waitForAjaxBusyLoadingInvisible() {
			return explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div#ajaxBusy")));
			
		}
	
}