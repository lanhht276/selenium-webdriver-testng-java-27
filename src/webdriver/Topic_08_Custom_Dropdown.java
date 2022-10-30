package webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_08_Custom_Dropdown {
	WebDriver driver;
	WebDriverWait explicitWait;
	JavascriptExecutor jsExecutor;
	
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	
	Select select;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		
		driver = new FirefoxDriver();
		
		//Khoi tao jsExecutor sau khoi tao driver
		jsExecutor = (JavascriptExecutor) driver;
				
		explicitWait = new WebDriverWait(driver,30);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_JQuery() {
		
		driver.get("https://jqueryui.com/resources/demos/selectmenu/default.html");
		
		
		selectItemInCustomDropdown("span#number-button","ul#number-menu li" ,"19" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "19");
		
		selectItemInCustomDropdown("span#number-button","ul#number-menu li" ,"3" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#number-button>span.ui-selectmenu-text")).getText(), "3");
		
		selectItemInCustomDropdown("span#speed-button","ul#speed-menu li" ,"Faster" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Faster");
		
		selectItemInCustomDropdown("span#speed-button","ul#speed-menu li" ,"Slow" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#speed-button>span.ui-selectmenu-text")).getText(), "Slow");
		
		selectItemInCustomDropdown("span#files-button","ul#files-menu div" ,"Some unknown file" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(), "Some unknown file");

		
		selectItemInCustomDropdown("span#files-button","ul#files-menu div" ,"jQuery.js" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#files-button>span.ui-selectmenu-text")).getText(), "jQuery.js");

		selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu div" ,"Dr." );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Dr.");

		selectItemInCustomDropdown("span#salutation-button","ul#salutation-menu div" ,"Mrs." );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("span#salutation-button>span.ui-selectmenu-text")).getText(), "Mrs.");

		}
	
	public void TC_02_Honda() {
		
		driver.get("https://www.honda.com.vn/o-to/du-toan-chi-phi");
		
		srollToElement("div.carousel-item");
		sleepInSecond(3);
		
		selectItemInCustomDropdown("button#selectize-input","button#selectize-input+div>a" ,"CITY G" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "CITY G");

		
		selectItemInCustomDropdown("button#selectize-input","button#selectize-input+div>a" ,"CIVIC RS(Đen ánh/Xám phong cách)" );
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("button#selectize-input")).getText(), "CIVIC RS(Đen ánh/Xám phong cách)");


		srollToElement("div.container");
		sleepInSecond(3);
		
		select = new Select(driver.findElement(By.cssSelector("select[name='province']")));
		select.selectByVisibleText("An Giang");
		
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "An Giang");

		select = new Select(driver.findElement(By.cssSelector("select[name='registration_fee']")));
		select.selectByVisibleText("Khu vực II");
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "Khu vực II");

	}
		
	
	

	
	public void TC_03_ReactJS()  {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-selection/");
		
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Jenny Hess");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Jenny Hess");
		
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Christian");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Christian");
		
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Justen Kitsune");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(), "Justen Kitsune");

	}
	
	 
	public void TC_04_VueJS()  {
		driver.get("https://mikerodham.github.io/vue-dropdowns/");
		
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "First Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "First Option");
		
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Third Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Third Option");
		
		selectItemInCustomDropdown("li.dropdown-toggle", "ul.dropdown-menu a", "Second Option");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("li.dropdown-toggle")).getText(), "Second Option");

	}	
	
	@Test 
	public void TC_05_Selectable_VueJS()  {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
		
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Afghanistan");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Afghanistan");
		
		selectItemInCustomDropdown("div.dropdown", "div.menu span.text", "Belgium");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belgium");
	}
	
	@Test 
	public void TC_06_Editable_VueJS()  {
		driver.get("https://react.semantic-ui.com/maximize/dropdown-example-search-selection/");
	
		enterItemInCustomDropdown("input.search", "div.menu span.text", "Afghanistan");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Afghanistan");
	
		enterItemInCustomDropdown("input.search", "div.menu span.text", "Belize");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div.divider.text")).getText(),"Belize");
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	
	public void srollToElement(String cssLocator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector(cssLocator)));
		
	}
	
	public void selectItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem){
		
		
		driver.findElement(By.cssSelector(parentLocator)).click();
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List <WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : allItems) {
			
			String textActualItem = item.getText();
			if (textActualItem.equals(textExpectedItem))  {
				item.click();
				
				break;
				
			}
		}
	}
	public void enterItemInCustomDropdown(String parentLocator, String childLocator, String textExpectedItem){
		
		
		driver.findElement(By.cssSelector(parentLocator)).sendKeys(textExpectedItem);
		sleepInSecond(1);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childLocator)));
		List <WebElement> allItems = driver.findElements(By.cssSelector(childLocator));
		for (WebElement item : allItems) {
			
			String textActualItem = item.getText();
			if (textActualItem.equals(textExpectedItem))  {
				item.click();
				
				break;
				
			}
		}
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