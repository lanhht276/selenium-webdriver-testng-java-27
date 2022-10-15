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

public class Topic_05_Web_Element_P3 {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_isDisplayed() {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
		if (emailTextbox.isDisplayed()) {
			emailTextbox.click();
			emailTextbox.sendKeys("Automation Testing");
			System.out.println("Email is displayed");
			
		} else {
			System.out.println("Email is not displayed");

		}
		
		//Age
		WebElement ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
		
		if (ageUnder18.isDisplayed()) {
			ageUnder18.click();
			System.out.println("Age Under 18 is displayed");
			
		} else {
			System.out.println("Age Under 18 is not  displayed");

		}
		
		//Education
		WebElement educationTextArea = driver.findElement(By.cssSelector("textarea#edu"));
		if (educationTextArea.isDisplayed()) {
			educationTextArea.sendKeys("Automation Testing");
			System.out.println("Education is displayed");
			
		} else {
			System.out.println("Education is not displayed");

		}
		
		//Image5
		WebElement image5 = driver.findElement(By.xpath("//h5[text()='Name: User5']"));
		if (image5.isDisplayed()) {
			System.out.println("Image 5 is displayed");
			
		} else {
			System.out.println("Image 5 is not displayed");

		}
		
		}
	
	@Test
	public void TC_02_isEnabled(){
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		//Email
		WebElement emailTextbox = driver.findElement(By.cssSelector("input#mail"));
		if (emailTextbox.isEnabled()) {
			
			System.out.println("Element is enable");
			
		} else {
			System.out.println("Element is disable");

		}
		
		//Age
		WebElement ageUnder18 = driver.findElement(By.cssSelector("input#under_18"));
		
		if (ageUnder18.isEnabled()) {
			
			System.out.println("Element is enable");
			
		} else {
			System.out.println("Element is disable");

		}
		
		//Education
		WebElement educationTextArea = driver.findElement(By.cssSelector("textarea#edu"));
		if (educationTextArea.isEnabled()) {
			
			System.out.println("Element is enable");
			
		} else {
			System.out.println("Element is disable");

		}
		

		//Job1
		WebElement jobRole1 = driver.findElement(By.cssSelector("select#job1"));
		if (jobRole1.isEnabled()) {
			
			System.out.println("Element is enable");
			
		} else {
			System.out.println("Element is disable");

		}
		
		//Job2
		WebElement jobRole2 = driver.findElement(By.cssSelector("select#job2"));
		if (jobRole2.isEnabled()) {
			
			System.out.println("Element is enable");
			
		} else {
			System.out.println("Element is disable");

		}
		//Development checkbox
		WebElement developmentCheckbox = driver.findElement(By.cssSelector("input#development"));
		if (developmentCheckbox.isEnabled()) {
			
			System.out.println("Element is enable");
			
		} else {
			System.out.println("Element is disable");

		}
		//slider 1
		WebElement slider1 = driver.findElement(By.cssSelector("input#slider-1"));
		if (slider1.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		//password 
		WebElement password = driver.findElement(By.cssSelector("input#disable_password"));
		if (password.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		
		//age disable radio
		WebElement disableRadio = driver.findElement(By.cssSelector("input#radio-disabled"));
		if (disableRadio.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		
		//bio 
		WebElement bio = driver.findElement(By.cssSelector("textarea#bio"));
		if (bio.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		
		//jobrole3 
		WebElement jobRole3 = driver.findElement(By.cssSelector("select#job3"));
		if (jobRole3.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		
		//disabledCheckbox 
		WebElement disabledCheckbox = driver.findElement(By.cssSelector("input#check-disbaled"));
		if (disabledCheckbox.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		
		//slider2 
		WebElement slider2 = driver.findElement(By.cssSelector("input#slider-2"));
		if (slider2.isEnabled()) {
					
			System.out.println("Element is enable");
					
		} else {
			System.out.println("Element is disable");

		}
		
		
	}

	@Test
	public void TC_03_isSelected() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		WebElement under18Radio = driver.findElement(By.cssSelector("input#under_18"));
		
		under18Radio.click();
		
		WebElement javaCheckbox = driver.findElement(By.cssSelector("input#java"));
		
		javaCheckbox.click();
		
		if (under18Radio.isSelected()) {
			System.out.println("Element is selected");
			
		} else {
			System.out.println("Element is de-selected");

		}
		if (javaCheckbox.isSelected()) {
			System.out.println("Element is selected");
			
		} else {
			System.out.println("Element is de-selected");

		}
		
		javaCheckbox.click();
		
		if (javaCheckbox.isSelected()) {
			System.out.println("Element is selected");
			
		} else {
			System.out.println("Element is de-selected");
 
		}
	}
		
		
	@Test
		public void TC_04_MailChimp(){
		
			driver.get("https://login.mailchimp.com/signup/");
			
			
			driver.findElement(By.cssSelector("input#email")).sendKeys("automationfc@mail.net");
			sleepInSecond(3);
			
			WebElement passwordTextbox = driver.findElement(By.cssSelector("input#new_password"));
			
			passwordTextbox.sendKeys("aaa");
			sleepInSecond(2);
			
			Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
			passwordTextbox.clear();
			passwordTextbox.sendKeys("AAA");
			sleepInSecond(2);
			
			Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
			passwordTextbox.clear();
			passwordTextbox.sendKeys("123");
			sleepInSecond(2);
			
			Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
			passwordTextbox.clear();
			passwordTextbox.sendKeys("!@#$%");
			sleepInSecond(2);
			
			Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char not-completed']")).isDisplayed());
			
			passwordTextbox.clear(); 
			passwordTextbox.sendKeys("12345678");
			sleepInSecond(2);
			
			Assert.assertTrue(driver.findElement(By.cssSelector("li.lowercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.uppercase-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.number-char.completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.cssSelector("li.special-char.not-completed")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//li[@class='8-char completed']")).isDisplayed());
		
			passwordTextbox.clear(); 
			passwordTextbox.sendKeys("Abc1234@@s");
			//sleepInSecond(2);
			
			Assert.assertTrue(driver.findElement(By.xpath("//input[@class='av-password success-check']")).isDisplayed());
			
		}
		
	

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000 );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
	
	