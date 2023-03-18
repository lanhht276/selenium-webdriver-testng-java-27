package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_21_FindElement_FindElements {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("http://live.techpanda.org/index.php/customer/account/login/");
	}

	
	@Test
	public void TC_01_FindElement() {
		// Tìm thấy duy nhất 1 element/node
		// Tìm thấy và thao tác trực tiếp lên node đó
		// Vì nó tìm thấy nên ko cần chờ timeout 15s
		driver.findElement(By.cssSelector("input#email"));
		
		// Tìm thấy nhiều hơn 1 element/node
		// Nó sẽ thao tác với node đầu tiên
		// Nó ko quan tâm các node còn lại
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("lanh@gmail.com");
		
		// Ko tim thay element/node nao
		// Có cơ chế tìm lại = 0.5d sẽ tìm lại 1 lần
		// Nếu trg thời gian tìm lại mà tìm thấy thì thỏa đk - pass
		// Nếu hết time mà vẫn ko tìm thấy element thì:
		// + Đánh fail TC
		// + Throw exception: NoSuchElement
		
		driver.findElement(By.cssSelector("input[type='check']"));
	}
	
	@Test
	public void TC_02_FindElements(){
		// Tìm thấy duy nhất 1 element/node
		//  Tìm thấy và lưu nó vào 1 list = 1 element
		// Vì nó ko tìm thấy nên nó cần chờ hết timeout
		List <WebElement> elements = driver.findElements(By.cssSelector("input#email"));
		System.out.println("List element number = " + elements.size());
		
		// Tìm thấy nhiều hơn 1 element/node
		elements = driver.findElements(By.cssSelector("input"));
		System.out.println("List element number = " + elements.size());
		
		// Ko tim thay element/node nao
		
	}



	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	
}