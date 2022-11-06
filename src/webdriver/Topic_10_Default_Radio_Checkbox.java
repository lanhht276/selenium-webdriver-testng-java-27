package webdriver;

import java.util.List;
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

public class Topic_10_Default_Radio_Checkbox {
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

	
	
	public void TC_01_JotForm() {
	driver.get("https://automationfc.github.io/multiple-fields/");
		
	checkToCheckBoxOrRadio("//input[@value='Emotional Disorder']");
	checkToCheckBoxOrRadio("//input[@value='Hepatitis']");
	
	/*
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Emotional Disorder']")).isSelected());
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='Hepatitis']")).isSelected());
	*/
	
	Assert.assertTrue(isElementSelected("//input[@value='Emotional Disorder']"));
	Assert.assertTrue(isElementSelected("//input[@value='Hepatitis']"));
	
	checkToCheckBoxOrRadio("//input[@value='5+ days']");
	checkToCheckBoxOrRadio("//input[@value='1-2 cups/day']");
	
	/*
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='5+ days']")).isSelected());
	Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1-2 cups/day']")).isSelected());
	*/
	Assert.assertTrue(isElementSelected("//input[@value='5+ days']"));
	Assert.assertTrue(isElementSelected("//input[@value='1-2 cups/day']"));

	unCheckToCheckBoxOrRadio("//input[@value='Emotional Disorder']");
	unCheckToCheckBoxOrRadio("//input[@value='Hepatitis']");
	
	/*
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Emotional Disorder']")).isSelected());
	Assert.assertFalse(driver.findElement(By.xpath("//input[@value='Hepatitis']")).isSelected());
	*/
	
	Assert.assertFalse(isElementSelected("//input[@value='Emotional Disorder']"));
	Assert.assertFalse(isElementSelected("//input[@value='Hepatitis']"));
	
	
	unCheckToCheckBoxOrRadio("//input[@value='5+ days']");
	unCheckToCheckBoxOrRadio("//input[@value='1-2 cups/day']");
	
	Assert.assertTrue(isElementSelected("//input[@value='5+ days']"));
	Assert.assertTrue(isElementSelected("//input[@value='1-2 cups/day']"));
	}
	
	
	public void TC_02_JotForm_SelectAll(){
		
		driver.get("https://automationfc.github.io/multiple-fields/");
		
		List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
			
		//Dùng vòng lặp để duyệt qua và click chọn
		
		for (WebElement checkbox : allCheckBoxes) {
			checkToCheckBoxOrRadio(checkbox);
			
				
			}			
		
		//Dùng vòng lặp để duyệt qua và kiểm tra
		
		for (WebElement checkbox : allCheckBoxes) {
			Assert.assertTrue(checkbox.isSelected());
		}
		
		//Bo chon het
		for (WebElement checkbox : allCheckBoxes) {
			unCheckToCheckBoxOrRadio(checkbox);
				
		}		
		
		//Dùng vòng lặp để duyệt qua và kiểm tra
		
		for (WebElement checkbox : allCheckBoxes) {
			Assert.assertFalse(checkbox.isSelected());
		}

		
	}

	
	public void TC_03_Select_All() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInSecond(5);
		
		srollToElement("div.demo-section");
		List<WebElement> allCheckBoxes = driver.findElements(By.xpath("//div[@id='example']//input[@type='checkbox']"));
		
		//Dùng vòng lặp để duyệt qua ,click chọn và verify luôn
		
		for (WebElement checkbox : allCheckBoxes) {
			checkToCheckBoxOrRadio(checkbox);
			
		}			
		
	}
	
	@Test 
	public void TC_04_Default() {
		driver.get("https://demos.telerik.com/kendo-ui/checkbox/index");
		sleepInSecond(5);
		
		srollToElement("div.demo-section");
		
		checkToCheckBoxOrRadio("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
		Assert.assertTrue(isElementSelected("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));
		
		unCheckToCheckBoxOrRadio("//label[text()='Dual-zone air conditioning']/preceding-sibling::input");
		Assert.assertFalse(isElementSelected("//label[text()='Dual-zone air conditioning']/preceding-sibling::input"));

		driver.get("https://demos.telerik.com/kendo-ui/radiobutton/index");
		sleepInSecond(5);
		
		srollToElement("div.demo-section");
		
		checkToCheckBoxOrRadio("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input");
		Assert.assertTrue(isElementSelected("//label[text()='2.0 Petrol, 147kW']/preceding-sibling::input"));
		
		
	}
		

	public void checkToCheckBoxOrRadio(String xpathLocator) {
		if (!driver.findElement(By.xpath(xpathLocator)).isSelected()){
			driver.findElement(By.xpath(xpathLocator)).click();
			
		}
	}
	public void checkToCheckBoxOrRadio(WebElement element) {
		if (!element.isSelected() && element.isEnabled()){
			element.click();
			System.out.println("Click to element: "+ element);
			Assert.assertTrue(isElementSelected(element));
			
		}
	}
	
	public void unCheckToCheckBoxOrRadio(String xpathLocator) {
		if (driver.findElement(By.xpath(xpathLocator)).isSelected()){
			driver.findElement(By.xpath(xpathLocator)).click();
			
		}
	}
	public void unCheckToCheckBoxOrRadio(WebElement checkbox) {
		if (checkbox.isSelected()){
			checkbox.click();
			
		}
	}
	public boolean isElementSelected (String xpathLocator) {
		return driver.findElement(By.xpath(xpathLocator)).isSelected(); 
	}
	public boolean isElementSelected (WebElement element) {
		return element.isSelected(); 
	}
	
	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public void srollToElement(String cssLocator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
		
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