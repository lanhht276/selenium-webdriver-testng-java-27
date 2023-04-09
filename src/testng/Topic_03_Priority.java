package testng;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_03_Priority {
	 WebDriver driver;
	 
	@Test(groups = "01", enabled = true, description = "G1 - enabled")
	public void TC_01() {
		System.out.println("Group 01 - TC_01");
		
	}
	
	 
		@Test(groups = "01",  enabled = true, description = "G1 - disabled")
		public void TC_02() {
			System.out.println("Group 01 - TC_02");
			
		}
		
		 
		@Test(groups = "03",  enabled = true, description = "G3 - enabled")
		public void TC_03() {
			System.out.println("Group 03 - TC_03");
			
		}
		@BeforeClass(alwaysRun = true)
		  public void beforeClass() {
			  System.out.println("Before Class");
		  }

		@AfterClass(alwaysRun = true)
		  public void afterClass() { 
			  System.out.println("After Class");
		  }
}
