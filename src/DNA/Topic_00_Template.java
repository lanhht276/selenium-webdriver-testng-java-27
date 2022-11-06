package DNA;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_00_Template {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.edge.driver", projectPath + "\\browserDrivers\\msedgedriver.exe");
		driver = new EdgeDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_Login_GuardianQA() {
		driver.get("https://tho2@mantu.com:Minhthanh078@qaguardian.o2f-it.com");
		
		//driver.findElement(By.cssSelector("input#username")).sendKeys("tho2@mantu.com");
		//driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		//driver.findElement(By.cssSelector("input#password")).sendKeys("");
		//driver.findElement(By.xpath("//button[text()='Continue']")).click();

		//driver.findElement(By.xpath("//span[text()='Remember this device for 30 days']")).click();
		//driver.findElement(By.xpath("//button[text()='Continue']")).click();
		

	}
	@Test
	public void TC_02_Hiring_From_Smart(){
		
		driver.get("https://tho2@mantu.com:Minhthanh078@qaarp.mantu.com/SMARTX/Candidate/4697178");
		
		driver.findElement(By.cssSelector("input#username")).sendKeys("tho2@mantu.com");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		driver.findElement(By.cssSelector("input#password")).sendKeys("Minhthanh078");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		driver.findElement(By.xpath("//span[text()='Remember this device for 30 days']")).click();
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		
		
		driver.get("https://tho2@mantu.com:Minhthanh078@auth.mantu.com/u/mfa-webauthn-platform-challenge?state=hKFo2SBic1FWN3Z1bVJPMkRjcFFYdXI1N3luYXVmTUVWbDI0b6FusG1mYS1hdXRoZW50aWNhdGWjdGlk2SBRd2l0T28wOW9RYm5ZbHRjbDVEM3VqeXd5ZEVZTURKcaNjaWTZIGw1ZEd5MGI2SGhBQld2SFU0TFVsREtuQkdUUlRQdnNK");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		driver.get("https://tho2@mantu.com:Minhthanh078@auth.mantu.com/u/mfa-webauthn-platform-challenge?state=hKFo2SBic1FWN3Z1bVJPMkRjcFFYdXI1N3luYXVmTUVWbDI0b6FusG1mYS1hdXRoZW50aWNhdGWjdGlk2SBRd2l0T28wOW9RYm5ZbHRjbDVEM3VqeXd5ZEVZTURKcaNjaWTZIGw1ZEd5MGI2SGhBQld2SFU0TFVsREtuQkdUUlRQdnNK");
		
		driver.findElement(By.xpath("//button[text()='Try another method']")).click();
		driver.findElement(By.xpath("//button/span[text()='Recovery code']")).sendKeys(null);
		
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		driver.get("https://tho2@mantu.com:Minhthanh078@auth.mantu.com/u/mfa-webauthn-platform-challenge?state=hKFo2SBic1FWN3Z1bVJPMkRjcFFYdXI1N3luYXVmTUVWbDI0b6FusG1mYS1hdXRoZW50aWNhdGWjdGlk2SBRd2l0T28wOW9RYm5ZbHRjbDVEM3VqeXd5ZEVZTURKcaNjaWTZIGw1ZEd5MGI2SGhBQld2SFU0TFVsREtuQkdUUlRQdnNK");
		
		
		driver.findElement(By.cssSelector("button#speed-hiring")).click();
		driver.findElement(By.xpath("//button[contains(.,'Direct hiring')]")).click();
		
		sleepInSecond(4);
		
		driver.findElement(By.xpath("//button[contains(.,'Next')]")).click();
		driver.findElement(By.cssSelector("input.dp__input_focus")).click();
		driver.findElement(By.xpath("//div[@class='dp__calendar_row']/div/div[contains(.,'21')]")).click();
		driver.findElement(By.xpath("//span[contains(.,'Select')]")).click();
		
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