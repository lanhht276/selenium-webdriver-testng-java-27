package tiki.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Shopper_02_Manage_Card {
	 WebDriver driver;
	 String projectPath = System.getProperty("user.dir");
	
	@BeforeTest(alwaysRun = true)
	public void initBrowser() {
		System.out.println("-----Open browser and driver----");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
	
	}
	@Test(groups = "card", description = "card 01 _ 7078")
	public void Card_01_Create_Product(){
		
	}
	@Test(groups = "card")
	public void Card_02_View_Visa(){
		
	}
	@Test(groups = "card")
	public void Card_03_Update_Visa(){
		
	}
	@Test(groups = "card")
	public void Card_04_Delete_Visa(){
		
	}
	@AfterTest(alwaysRun = true)
	public void cleanBrowser() {
		System.out.println("-----Close browser and driver----");
		driver.quit();
	}
	
	}

