package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_02_Selenium_By {
	
	//Khai báo 1 biến để đại diện cho Selenium WebBrowser
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
	}


	@Test
	public void TC_01_ValidateCurrentUrl() {
		// Login Page Url matching
		
		//input name="email"  
		
		 
		//input[@name="login[username]"] 
		
		//input[@id="email"] 
		 
		//input[@title="Email Address"]
		
		//ID - Email textbox
		driver.findElement(By.id("email"));
		
		//Class - New user form
		driver.findElement(By.className("new-users"));
		
		//Name - Email textbox
		driver.findElement(By.name("login[username]"));
		
		//Tagname - tìm xem có bao nhiêu element/page
		driver.findElements(By.tagName("a"));
		
		//Linktext - Text tuyệt đối
		driver.findElement(By.linkText("SEARCH TERMS"));
		
		
		//Partial Linktext - text tương đối/tuyệt đối
		driver.findElement(By.partialLinkText("SEARCH"));
		driver.findElement(By.partialLinkText("TERMS"));
		
		
		//Css - cover đc hầu hết 6 loại trên
		driver.findElement(By.cssSelector("input[name='login[username]']")); 
		driver.findElement(By.cssSelector("input[id='email']")); 
		driver.findElement(By.cssSelector("input[title='Email Address']"));
		
		
		//Xpath
		driver.findElement(By.xpath("//input[@name='login[username]']")); 
		driver.findElement(By.xpath("//input[@id='email']")); 
		driver.findElement(By.xpath("//input[@title='Email Address']")); 
	}
	
		
	


	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}