package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
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
		
		//Alert/ Frame (Iframe)/ Window (Tab)
		driver.switchTo().alert();
		
		driver.switchTo().frame(0);
		
		driver.switchTo().window("");
	}
	
	@Test
	public void TC_02_Element(){
		driver.get("https://www.facebook.com/");
		//Các hàm tương tác với element sẽ thông qua class WebElement (biến nào đó)
		
		// 2 cách để mình thao tác
		
		//Khai báo biến và dùng lại
		// Dùng đi dùng lại nhiều lần, ít nhất là 2 lần thì mới cần khai báo biến
		
		//Khai báo biến cùng vs kiểu dữ liệu trả về của hàm
		WebElement emailAddressTextbox = driver.findElement(By.id("email"));
		
		//Dùng trực tiếp - dùng có 1 lân
		
		//Xóa dữ liệu vào field dạng editable
		element.sendKeys("lanh@gmail.com");
		element.sendKeys(Keys.ENTER);
		
		// Trả về giá trị nằm trong atribute của element
		element.getAttribute("placeholder");
		// Email address ỏ phone number
		
		driver.findElement(By.id("firstname")).getAttribute("value");
		 
		// Trả về thuộc tính CSS: font size, color
		
		// Trả về màu nền của element
		element.getCssValue("background-color");
		
		// Trả về font size của element
		element.getCssValue("font-size");
		
		// Test GUI: point/ rectaglr/ size
		element.getLocation();
		element.getRect();
		element.getSize();
		  
		//CHụp hình và attach vào HTML Report
		element.getScreenshotAs(OutputType.FILE);
		
		// Trả về thẻ HTML của element
		WebElement emailAddressTextbox = driver.findElement(By.xpath("//*[@id='email']"));
		emailAddressTextbox = driver.findElement(By.cssSelector("#email"));
		emailAddressTextbox.getTagName();
		//input
		
		element.getText();
		
		// Trả về giá trị đúng hoặc sai của 1 element có hiển thị hoặc ko
		element.isDisplayed(); 
		
		element.isEnabled();
		
		//Checkbox/ Radio
		element.isSelected();
		
		// Dropdown: có 1 thư viện riêng để xử lý selected
		
		// chỉ làm việc được với form
		element.submit();
	}
	

	@Test
	public void TC_03_() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}