package webdriver;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_Default_Dropdown {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Select select;
	Random rand;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		rand = new Random();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	}

	
	@Test
	public void TC_01_Default_Dropdown() {
		driver.get("https://demo.nopcommerce.com");
		
		driver.findElement(By.cssSelector("a.ico-register")).click();
	
		
		driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Lanh");
		driver.findElement(By.cssSelector("input#LastName")).sendKeys("Ho");
		
		//Khởi tạo select để thao tác với Day dropdown
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		select.selectByVisibleText("27");
		
		Assert.assertEquals(32, select.getOptions().size());
						
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		select.selectByVisibleText("June");
		
		Assert.assertEquals(13, select.getOptions().size());
				
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		select.selectByVisibleText("1992");
		
		Assert.assertEquals(112, select.getOptions().size());
		
		String emailAddress = "lanhho" + rand.nextInt(9999)+ "@hotmail.com";
		
		driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
		driver.findElement(By.cssSelector("input#Company")).sendKeys("Test company");
		driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
		driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
		
		driver.findElement(By.cssSelector("button#register-button")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
		
		driver.findElement(By.cssSelector("a.ico-account")).click();
		
		//Verify
		Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getAttribute("value"),"Lanh" );
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getAttribute("value"),"Ho" );
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthDay']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "27");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthMonth']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "June");
		
		select = new Select(driver.findElement(By.cssSelector("select[name='DateOfBirthYear']")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1992");
		
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getAttribute("value"),emailAddress );
		Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getAttribute("value"),"Test company" );
		
	}
	
	@Test
	public void TC_02_Default_Dropdown(){
		
		driver.get("https://rode.com/en/support/where-to-buy");
		
		select = new Select(driver.findElement(By.cssSelector("select#country")));
		Assert.assertFalse(select.isMultiple(),"Not support multiple select");
		
		select.selectByVisibleText("Vietnam");
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(),"Vietnam" );
		
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		List<WebElement> dealers = driver.findElements(By.cssSelector("div#map h4"));
		
		for (WebElement element : dealers) {
			System.out.println(element.getText());
		}
	}

	@Test 
	public void TC_03_()  {
		
		sleepInSecond(3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
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