package webdriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_12_Alert {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Alert alert;
	String firefoxAuthenAutoIT = projectPath + "\\autoITscripts\\" + "authen_firefox.exe";
	String chromeAuthenAutoIT = projectPath + "\\autoITscripts\\" + "authen_chrome.exe";
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Accept_Alert() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS Alert");
		System.out.println("Alert content is:" + alert.getText());
		
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked an alert successfully");
	}
	
	
	public void TC_02_Confirm_Alert(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		
		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
		
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS Confirm");
		System.out.println("Alert content is:" + alert.getText());
		
		alert.dismiss();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You clicked: Cancel");
		
	}
	

	 
	public void TC_03_Prompt_Alert()  {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		sleepInSecond(2);
		
		String keyword = "Lanh & Automation";
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		
		sleepInSecond(2);
		
		alert = driver.switchTo().alert();
		
		Assert.assertEquals(alert.getText(), "I am a JS prompt");
		System.out.println("Alert content is:" + alert.getText());
		
		alert.sendKeys(keyword);
		alert.accept();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("p#result")).getText(),"You entered: "+ keyword);
	}
	
	 
	public void TC_04_Authentication_Alert_1()  {
		
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']/p")).getText().contains("Congratulations! You must have the proper credentials."));
		
		
	}
	 
	public void TC_05_Authentication_Alert_2()  {
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		String basicAuthenUrl = driver.findElement(By.xpath("//a[text()='Basic Auth']")).getAttribute("href");
		
		driver.get(getAuthenticationUrl(basicAuthenUrl, "admin", "admin"));
		sleepInSecond(3);
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']/p")).getText().contains("Congratulations! You must have the proper credentials."));
		
		
	}
	@Test
	public void TC_06_Authentication_Alert_Auto_IT() throws IOException  {
		//Bật script của AutoIT trước rồi mở cái site chứa Authentication
		//Thực thi 1 file exe trong code Java
		
		Runtime.getRuntime().exec(new String[] {firefoxAuthenAutoIT, "admin", "admin" });
		driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		sleepInSecond(5);
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='example']/p")).getText().contains("Congratulations! You must have the proper credentials."));

	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
	
	public String getAuthenticationUrl(String basicAuthenUrl, String userName, String password) {
		String[] authenUrlArray = basicAuthenUrl.split("//");
		basicAuthenUrl = authenUrlArray[0] + "//" + userName + ":" + password + "@" + authenUrlArray[1];
		return basicAuthenUrl;
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