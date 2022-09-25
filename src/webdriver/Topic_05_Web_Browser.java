package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_05_Web_Browser {
	WebDriver driver;
	WebElement element;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}

	
	@Test
	public void TC_01_Browser() {
		//Các hàm tương tác với Browser sẽ thppng qua biến driver
		
		//Đóng 1 tab
		driver.close();
		
		//Đóng browser
		driver.quit();
		
		//Tìm ra 1 element đầu tiên
		driver.findElement(By.cssSelector(""));
		
		//Tìm ra nhiều element
		driver.findElements(By.cssSelector(""));
		
		//Mở ra cái url truyền vào
		driver.get("https://www.facebook.com/");
		
		//Trả về 1 url tại page đang đứng
		String gamePageurl = driver.getCurrentUrl();
		
		String gamePageTitle = driver.getTitle();
		
		//Source code của page hiện tại
		String gamePageSourceCode = driver.getPageSource();
		
		//Lấy ra ID của tab/window đang đứng/active
		driver.getWindowHandle(); //1
		driver.getWindowHandles();//tất cả
		
		driver.manage().getCookies();
		driver.manage().logs().getAvailableLogTypes();
		
		driver.manage().window().fullscreen();
		driver.manage().window().maximize();
		
		//chờ element được tìm thấy trong khoảng thời gian xx giấy
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		//chờ page load thành công sau xx giấy
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		//chờ cho các script được inject thành công vào browser/element sau xx giây (JavascriptExecutor)
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.navigate().to("");
	}
	
	@Test
	public void TC_02_Element(){
		//Các hàm tương tác với element sẽ thppng qua biến element
	}

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}