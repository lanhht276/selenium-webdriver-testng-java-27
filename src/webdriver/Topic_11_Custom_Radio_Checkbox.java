package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_11_Custom_Radio_Checkbox {
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

	public void TC_01_Custom_CheckBox() {
		driver.get("https://material.angular.io/components/checkbox/examples");
		By checkedCheckBox = By.xpath("//span[text()='Checked']/preceding-sibling::span/input");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedCheckBox));
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(checkedCheckBox).isSelected());
		
		
		By checkedIndeterminate = By.xpath("//span[text()='Indeterminate']/preceding-sibling::span/input");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedIndeterminate));
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(checkedIndeterminate).isSelected());
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedCheckBox));
		sleepInSecond(2);
		Assert.assertFalse(driver.findElement(checkedCheckBox).isSelected());
		
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedIndeterminate));
		sleepInSecond(2);
		Assert.assertFalse(driver.findElement(checkedIndeterminate).isSelected());
		
		
		
		
	}
	
	
	public void TC_02_Custom_Radio(){
		driver.get("https://material.angular.io/components/radio/examples");
		By checkedRadio = By.xpath("//span[contains(.,'Summer')]/preceding-sibling::span/input");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(checkedRadio));
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(checkedRadio).isSelected());


	}

	 
	public void TC_03_VNDirect()  {
		driver.get("https://account-v2.vndirect.com.vn/");
		By termCheckBox = By.xpath("//input[@name='acceptTerms']");
		jsExecutor.executeScript("arguments[0].click();", driver.findElement(termCheckBox));
		sleepInSecond(2);
		Assert.assertTrue(driver.findElement(termCheckBox).isSelected());
		
	}
	
	@Test 
	public void TC_04_Google_Radio() {
		driver.get("https://docs.google.com/forms/d/e/1FAIpQLSfiypnd69zhuDkjKgqvpID9kwO29UCzeCVrGGtbNPZXQok0jA/viewform");
		sleepInSecond(2);
		
		By canThoRadio = By.xpath("//div[@data-value ='Cần Thơ']");
		
		Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "false");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value ='Cần Thơ' and @aria-checked = 'false']")).isDisplayed());
		
		driver.findElement(canThoRadio).click();
		
		Assert.assertEquals(driver.findElement(canThoRadio).getAttribute("aria-checked"), "true");
		Assert.assertTrue(driver.findElement(By.xpath("//div[@data-value ='Cần Thơ' and @aria-checked = 'true']")).isDisplayed());
		
		By itemStartWithQuang = By.xpath("//span[text()='Hãy chọn các tỉnh bắt đầu vs tiền tố là Quảng']/ancestor::div[@class='geS5n']//div[starts-with(@aria-label,'Quảng')]");
		
		List <WebElement> allItemStartQuang = driver.findElements(By.xpath("//span[text()='Hãy chọn các tỉnh bắt đầu vs tiền tố là Quảng']/ancestor::div[@class='geS5n']//div[starts-with(@aria-label,'Quảng')]"));
		
		for (WebElement itemStartQuang : allItemStartQuang) {
		//driver.findElement(By.xpath("//span[text()='Hãy chọn các tỉnh bắt đầu vs tiền tố là Quảng']/ancestor::div[@class='geS5n']//div[starts-with(@aria-label,'Quảng')]")).click();
		checkToCheckBox(itemStartQuang);
		System.out.println("Item starts with Quang is: " + itemStartQuang.getAttribute("aria-label"));
		}
		
		for (WebElement itemStartQuang : allItemStartQuang) {
			Assert.assertEquals(itemStartQuang.getAttribute("aria-checked"),"true");
		}	
		}
		
		
		//Assert.assertEquals(driver.findElement(itemStartWithQuang).getAttribute("aria-checked"), "true");
				
		
	

	public void checkToCheckBox(WebElement element){
		
		//driver.findElement(By.xpath("//span[text()='Hãy chọn các tỉnh bắt đầu vs tiền tố là Quảng']/ancestor::div[@class='geS5n']//div[starts-with(@aria-label,'Quảng')]"));
	
		if (!element.isSelected()) {
			element.click();
		}
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