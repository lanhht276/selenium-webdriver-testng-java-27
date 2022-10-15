 package webdriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser_Element_P2 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}

		@Test
	public void TC_01_Current_Url() {
		
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		String loginPage = driver.getCurrentUrl();
		Assert.assertEquals("http://live.techpanda.org/index.php/customer/account/login/", loginPage);
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String registerPage = driver.getCurrentUrl();
		Assert.assertEquals(registerPage, "http://live.techpanda.org/index.php/customer/account/create/");
	}
	
	@Test
	public void TC_02_Page_Title(){
		
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Customer Login");
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
	}

	@Test
	public void TC_03_Navigation() {
		
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
				
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/create/");
		
		driver.navigate().back();
		
		Assert.assertEquals(driver.getCurrentUrl(),"http://live.techpanda.org/index.php/customer/account/login/");
		
		driver.navigate().forward();
		
		Assert.assertEquals(driver.getTitle(),"Create New Customer Account");
		
	}
	
	@Test
	public void TC_04_Page_Source () {
		
		driver.get("http://live.techpanda.org/");
		
		driver.findElement(By.xpath("//div[@class='footer']//a[@title='My Account']")).click();
		
		String loginPageSource = driver.getPageSource();
		
		Assert.assertTrue(loginPageSource.contains("Login or Create an Account"));
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		
		String registerPageSource = driver.getPageSource();
				
		Assert.assertTrue(registerPageSource.contains("Create an Account"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}