package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_14_Popup {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Fixed_Popup() {
		
		driver.get("https://ngoaingu24h.vn/");
		
		By loginPopup = By.xpath("//div[@id='modal-login-v1'][1]");
		
		Assert.assertFalse(driver.findElement(loginPopup).isDisplayed());
		
		driver.findElement(By.cssSelector("button.login_")).click();
		
		Assert.assertTrue(driver.findElement(loginPopup).isDisplayed());
		
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#account-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] input#password-input")).sendKeys("automationfc");
		driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] button.btn-v1.btn-login-v1")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div[id='modal-login-v1'][style] div.row.error-login-panel")).getText(), "Tài khoản không tồn tại!");
		
		
	}
	
	
	public void TC_02_Fixed_Popup(){

		driver.get("https://skills.kynaenglish.vn/");
		
		driver.findElement(By.cssSelector("a.login-btn")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("h4.modal-title")).isDisplayed());
		
		driver.findElement(By.cssSelector("input#user-login")).sendKeys("automationfc@gmail.com");
		driver.findElement(By.cssSelector("input#user-password")).sendKeys("123456");
		driver.findElement(By.cssSelector("button#btn-submit-login")).click();
		
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div#password-form-login-message")).getText(), "Sai tên đăng nhập hoặc mật khẩu");
		sleepInSecond(3);
		driver.findElement(By.cssSelector("button.k-popup-account-close.close")).click();

		Assert.assertFalse(driver.findElement(By.cssSelector("h4.modal-title")).isDisplayed());
	}

	
	public void TC_03_Tiki()  {
		driver.get("https://tiki.vn/");
		//Luc mở ra là chưa có popup xuất hiện
		sleepInSecond(3);
		Assert.assertEquals(driver.findElements(By.cssSelector("div[role='dialog']")).size(), 0);
		
		
		driver.findElement(By.xpath("//span[text()='Đăng Nhập / Đăng Ký']")).click();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("div[role='dialog']")).isDisplayed());
		Assert.assertEquals(driver.findElements(By.cssSelector("div[role='dialog']")).size(), 1);
		
		driver.findElement(By.cssSelector("p.login-with-email")).click();
		driver.findElement(By.xpath("//button[text()='Đăng nhập']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Email không được để trống']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//span[@class='error-mess' and text()='Mật khẩu không được để trống']")).isDisplayed());

		driver.findElement(By.cssSelector("img.close-img")).click();

		Assert.assertEquals(driver.findElements(By.cssSelector("div[role='dialog']")).size(), 0);

	}
	
	@Test
	public void TC_04_Facebook()  {
		driver.get("https://www.facebook.com/");
		
		driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).isDisplayed());
		
		driver.findElement(By.xpath("//div[text()='Sign Up']/parent::div/parent::div/img")).click();
		
		Assert.assertEquals(driver.findElements(By.xpath("//div[text()='Sign Up']/parent::div/parent::div")).size(), 0);
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