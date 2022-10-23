package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
				
		explicitWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	@Test
	public void TC_01_JQuery() {
		
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		selectItemInCustomDropdown("span#number-button","ul#number-menu li" ,"19" );
		sleepInSecond(3);
		
		selectItemInCustomDropdown("span#number-button","ul#number-menu li" ,"3" );
		sleepInSecond(3);
		
		selectItemInCustomDropdown("span#speed-button","ul#speed-menu li" ,"Faster" );
		sleepInSecond(3);
		
		selectItemInCustomDropdown("span#speed-button","ul#speed-menu li" ,"Slow" );
		sleepInSecond(3);
			
		selectItemInCustomDropdown("span#files-button","ul#files-menu div" ,"Some unknown file" );
		sleepInSecond(3);
		
		selectItemInCustomDropdown("span#files-button","ul#files-menu div" ,"jQuery.js" );
		sleepInSecond(3);
		
		selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu div" ,"Dr." );
		sleepInSecond(3);
		
		selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu div" ,"Mrs." );
		sleepInSecond(3);
		
		
		
		}
		
	
	
	
	public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem){
		
	
		driver.findElement(By.cssSelector(parentLocator)).click();
		
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		
		List <WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
		
		for (WebElement item : allItems) {
			
			String textActualItem = item.getText();
			if (textActualItem.equals(textExpectedItem))  {
				item.click();
				
			}
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