package webdriver;

import static java.awt.event.InputEvent.BUTTON1_MASK;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class Topic_13_Actions {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");
	Actions action;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
				
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Hover_Element() {
		
		driver.get("https://automationfc.github.io/jquery-tooltip/");
		action.moveToElement(driver.findElement(By.cssSelector("input#age"))).perform();
		sleepInSecond(3);
		
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div.ui-tooltip-content")).getText(), "We ask for your age only for statistical purposes.");
		
	}
	
	
	public void TC_02_Hover(){
		
		driver.get("https://www.myntra.com/");
		action.moveToElement(driver.findElement(By.xpath("//header[@id='desktop-header-cnt']//a[text()='Kids']"))).perform();
		sleepInSecond(3);
		
		driver.findElement(By.xpath("//a[text()='Home & Bath']")).click();
		
		Assert.assertEquals(driver.findElement(By.cssSelector("span.breadcrumbs-crumb")).getText(), "Kids Home Bath");
	}

	 
	public void TC_03_Hover()  {
		
		driver.get("https://www.fahasa.com/");
		action.moveToElement(driver.findElement(By.cssSelector("span.icon_menu"))).perform();
		sleepInSecond(3);
			
		driver.findElement(By.xpath("//div[@class='fhs_column_stretch']//a[text()='Kỹ Năng Sống']")).click();
		
		//Hàm getText sẽ get text trên UI mà user nhìn thấy
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='ves-breadcrumbs']//strong")).getText(), "KỸ NĂNG SỐNG");

		//Hàm isDisplay sẽ dùng text ở dưới HTML
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='ves-breadcrumbs']//strong[text()='Kỹ năng sống']")).isDisplayed());
		
		/*
		 * driver.switchTo().frame("viewport"); sleepInSecond(2);
		 * 
		 * driver.findElement(By.cssSelector("button#close-icon>img")).click();
		 */
	}

	
	public void TC_04_Click_and_Hold()  {
		
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List <WebElement> listNumbers = driver.findElements(By.cssSelector("ol li"));
		System.out.println("Tổng số lượng số:" + listNumbers.size());
		
		action.clickAndHold(listNumbers.get(0)).moveToElement(listNumbers.get(3)).release().perform();
		sleepInSecond(3);
		
		List <WebElement> listNumbersSelected = driver.findElements(By.cssSelector("ol li.ui-selected"));
		System.out.println("Tổng số lượng số đã chọn:" + listNumbersSelected.size());

		Assert.assertEquals(listNumbersSelected.size(), 4);
		
	}
	
	
	public void TC_05_Click_Random()  {
		
		driver.get("https://automationfc.github.io/jquery-selectable/");
		
		List <WebElement> listNumbers = driver.findElements(By.cssSelector("ol li"));
		System.out.println("Tổng số lượng số:" + listNumbers.size());
		
		//Nhấn Ctrl xuống
		action.keyDown(Keys.CONTROL).perform();
		
		action.click(listNumbers.get(0))
				.click(listNumbers.get(2))
				.click(listNumbers.get(5))
				.click(listNumbers.get(10)).perform();
		
		//Nha Ctrl ra
		action.keyDown(Keys.CONTROL).perform();
		
		List <WebElement> listNumbersSelected = driver.findElements(By.cssSelector("ol li.ui-selected"));
		System.out.println("Tổng số lượng số đã chọn:" + listNumbersSelected.size());

		Assert.assertEquals(listNumbersSelected.size(), 4);
				
	
	}
	
	 
	public void TC_06_Double_Click()  {
		
		driver.get("https://automationfc.github.io/basic-form/index.html");
		
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//legend[text()='Double Click']")));
		
		action.doubleClick(driver.findElement(By.xpath("//button[text()='Double click me']"))).perform();
	
		Assert.assertEquals(driver.findElement(By.cssSelector("p#demo")).getText(), "Hello Automation Guys!");
	}
		
	
	public void TC_07_Right_Click()  {
		
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rightClickBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		
		action.contextClick(rightClickBtn).perform();
	
		WebElement quitButton = driver.findElement(By.xpath("//span[text()='Quit']"));
		
		action.moveToElement(quitButton).perform();
		
		Assert.assertTrue(driver.findElement(By.cssSelector("li.context-menu-icon-quit.context-menu-visible.context-menu-hover")).isDisplayed());
	
		action.click(quitButton).perform();
		
		driver.switchTo().alert().accept();
		
		Assert.assertFalse(driver.findElement(By.cssSelector("li.context-menu-icon-quit")).isDisplayed());
		
	}	
	
	 
	public void TC_08_Drag_Drop_HMTL4()  {
		
		driver.get("https://automationfc.github.io/kendo-drag-drop/");
		
		WebElement DragSource = driver.findElement(By.cssSelector("div#draggable"));
		WebElement DragTarget = driver.findElement(By.cssSelector("div#droptarget"));
		
		action.dragAndDrop(DragSource, DragTarget).perform();
		
		Assert.assertEquals(DragTarget.getText(), "You did great!");
		
		String rgbaColor = DragTarget.getCssValue("background-color");
		
		System.out.println("rgbaColor =" + rgbaColor);
		
		String hexaColor = Color.fromString(rgbaColor).asHex().toUpperCase();
		
		System.out.println("Hexa color = " + hexaColor);
				
		Assert.assertEquals(hexaColor,"#03A9F4");
		
	}
	

	
	public void TC_09_Drag_Drop_HMTL5() throws IOException  {
		
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		
		
		
		String jsContentFile = getContentFile(projectPath + "\\DragandDrop\\drag_and_drop_helper.js");
	
		jsExecutor.executeScript(jsContentFile + "$('div#column-a').simulateDragDrop({dropTarget: 'div#column-b'});");
		sleepInSecond(3);
		
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a header")).getText(), "B");
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b header")).getText(), "A");
	}
	
	@Test
	public void TC_10_Drag_Drop_HMTL5_CSS_Xpath() throws IOException, AWTException  {
		
		driver.get("https://automationfc.github.io/drag-drop-html5/");
		sleepInSecond(3);
		
		dragAndDropHTML5ByCss("div#column-a", "div#column-b");
		sleepInSecond(3);
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-a>header")).getText(), "B");
		Assert.assertEquals(driver.findElement(By.cssSelector("div#column-b>header")).getText(), "A");
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
	
	public String getContentFile(String filePath) throws IOException {
		Charset cs = Charset.forName("UTF-8");
		FileInputStream stream = new FileInputStream(filePath);
		try {
			Reader reader = new BufferedReader(new InputStreamReader(stream, cs));
			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[8192];
			int read;
			while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
				builder.append(buffer, 0, read);
			}
			return builder.toString();
		} finally {
			stream.close();
		}
	}
	
	
	
	public void dragAndDropHTML5ByCss(String sourceLocator, String targetLocator) throws AWTException {

		WebElement source = driver.findElement(By.cssSelector(sourceLocator));
		WebElement target = driver.findElement(By.cssSelector(targetLocator));

		// Setup robot
		Robot robot = new Robot();
		robot.setAutoDelay(500);

		// Get size of elements
		Dimension sourceSize = source.getSize();
		Dimension targetSize = target.getSize();

		// Get center distance
		int xCentreSource = sourceSize.width / 2;
		int yCentreSource = sourceSize.height / 2;
		int xCentreTarget = targetSize.width / 2;
		int yCentreTarget = targetSize.height / 2;

		Point sourceLocation = source.getLocation();
		Point targetLocation = target.getLocation();
		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Make Mouse coordinate center of element
		sourceLocation.x += 20 + xCentreSource;
		sourceLocation.y += 110 + yCentreSource;
		targetLocation.x += 20 + xCentreTarget;
		targetLocation.y += 110 + yCentreTarget;

		System.out.println(sourceLocation.toString());
		System.out.println(targetLocation.toString());

		// Move mouse to drag from location
		robot.mouseMove(sourceLocation.x, sourceLocation.y);

		// Click and drag
		robot.mousePress(BUTTON1_MASK);
		robot.mousePress(BUTTON1_MASK);
		robot.mouseMove(((sourceLocation.x - targetLocation.x) / 2) + targetLocation.x, ((sourceLocation.y - targetLocation.y) / 2) + targetLocation.y);

		// Move to final position
		robot.mouseMove(targetLocation.x, targetLocation.y);

		// Drop
		robot.mouseRelease(BUTTON1_MASK);
	}

	
	
}