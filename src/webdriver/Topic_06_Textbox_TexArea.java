package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Textbox_TexArea {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	String firstName, lastName, employeeID, editFirstName, editLastName, passPortNumber, comments;
	
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		firstName = "Lanh";
		lastName = "Ho";
		editFirstName ="Louis";
		editLastName = "Pastor";
		passPortNumber = "111222";
		comments = "Lanh test comment\n12345678\n9999";
	}

	
	
	
	@Test
	public void TC_01_Handle_Textbox_TextAres(){
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		sleepInSecond(5);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
		
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(firstName);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(lastName);
		
		// Lưu giá trị của EmployeeID vào biến
		// Lấy ra giá trị + Gán vào biến
		employeeID = driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value");
		
		sleepInSecond(5);
		driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),firstName);
		System.out.println(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),lastName);
		System.out.println(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"));
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),employeeID);
		System.out.println(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"));
		sleepInSecond(7);
		
		/*driver.findElement(By.name("firstName")).click();
		sleepInSecond(5);
		driver.findElement(By.name("firstName")).clear();
		sleepInSecond(5);
		driver.findElement(By.name("firstName")).sendKeys(editFirstName);
		
		driver.findElement(By.xpath("//input[@name='lastName']")).click();
		sleepInSecond(5);
		driver.findElement(By.xpath("//input[@name='lastName']")).clear();
		sleepInSecond(5);
		driver.findElement(By.xpath("//input[@name='lastName']")).sendKeys(editLastName);
		
		driver.findElement(By.xpath("//form/div[5]/button")).click();
		sleepInSecond(5);
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='firstName']")).getAttribute("value"),editFirstName);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@name='lastName']")).getAttribute("value"),editLastName);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input")).getAttribute("value"),employeeID);
		*/
		
		driver.findElement(By.xpath("//a[text()='Immigration']")).click();
		
		driver.findElement(By.xpath("//h6[text()='Assigned Immigration Records']/following-sibling::button[contains(string(),'Add')]")).click();
	
		
		driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).sendKeys(passPortNumber);
		driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).sendKeys(comments);
		sleepInSecond(5);
		driver.findElement(By.xpath("//button[contains(string(),'Save')]")).click();
		sleepInSecond(5);
		
		driver.findElement(By.xpath("//button/i[@class='oxd-icon bi-pencil-fill']")).click();
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Number']/parent::div/following-sibling::div/input")).getAttribute("value"),passPortNumber);
		Assert.assertEquals(driver.findElement(By.xpath("//label[text()='Comments']/parent::div/following-sibling::div/textarea")).getAttribute("value"),comments);
	}
	

	@Test 
	public void TC_03_()  {
		
		sleepInSecond(3);
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