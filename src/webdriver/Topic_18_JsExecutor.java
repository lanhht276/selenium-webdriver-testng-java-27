package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_18_JsExecutor {
	WebDriver driver;
	JavascriptExecutor jsExecutor;
	String projectPath = System.getProperty("user.dir");
	String osName = System.getProperty("os.name");

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		jsExecutor = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	
	
	public void TC_01_Tech_Panda() {
		
		navigateToUrlByJS("http://live.techpanda.org/");
		
		getDomainName();
		sleepInSecond(1);
		
		Assert.assertEquals(getDomainName(), "live.techpanda.org");
		
		getUrl();

		Assert.assertEquals(getUrl(), "http://live.techpanda.org/");

		hightlightElement("//a[text()='Mobile']");
		clickToElementByJS("//a[text()='Mobile']");
		sleepInSecond(2);
		
		clickToElementByJS("//a[@title='Samsung Galaxy']//following-sibling::div//div[@class='actions']//span[text()='Add to Cart']");
		sleepInSecond(3);
		
		
		Assert.assertTrue(getInnerText().contains("Samsung Galaxy was added to your shopping cart."));
		
		clickToElementByJS("//a[text()='Customer Service']");
		sleepInSecond(3);
		
		getTitle();
		
		Assert.assertEquals(getTitle(), "Customer Service");
		sleepInSecond(3);
		
		scrollToBottomPage();
		
		hightlightElement("//input[@id='newsletter']");
		sendkeyToElementByJS("//input[@id='newsletter']","automationfc" + getRandomNumber() + "@gmail.com");
		sleepInSecond(3);
		
		clickToElementByJS("//span[text()='Subscribe']");
		sleepInSecond(3);
		
		Assert.assertTrue(getInnerText().contains("Thank you for your subscription."));
		sleepInSecond(3);
		
		navigateToUrlByJS("https://demo.guru99.com/v4/");
		sleepInSecond(3);
		
		getDomainName();
		sleepInSecond(3);
		
		Assert.assertEquals(getDomainName(), "demo.guru99.com");
		sleepInSecond(3);
	}
	
	@Test
	public void TC_02_HTML5_Validation_Message(){
		
		driver.get("https://warranty.rode.com/");
		
		
		String registerButton = "//button[contains(text(), 'Register')]";
		String firstName = "//input[@id='firstname']";
		String surname = "//input[@id='surname']";
		String email = "//div[contains(text(), 'Register')]/following-sibling::div//input[@id='email']";
		String password = "//div[contains(text(), 'Register')]/following-sibling::div//input[@id='password']";
		String confirmpassword = "//input[@id='password-confirm']";
		
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(firstName),"Please fill out this field.");
		
		sendkeyToElementByJS(firstName, "Lanh");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(surname),"Please fill out this field.");
		
		sendkeyToElementByJS(surname, "Thi");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(email),"Please fill out this field.");
		
		sendkeyToElementByJS(email, "lanhtest" + getRandomNumber() + "@gmail.com");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(password),"Please fill out this field.");
		
		
		sendkeyToElementByJS(password, "Test@1234");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getElementValidationMessage(confirmpassword),"Please fill out this field.");
		
		
		sendkeyToElementByJS(confirmpassword, "Test@1234");
		clickToElementByJS(registerButton);
		sleepInSecond(2);
		
		Assert.assertEquals(getTitle(),"RODE Warranty Registration");
		
		

	}

	@Test 
	public void TC_03_()  {
		
		
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
	
	
	public  int getRandomNumber() {
		return new Random().nextInt(999);
	}
	
	public String getDomainName() {
		return (String) jsExecutor.executeScript("return document.domain");
				
	}
	public String getUrl() {
		return (String) jsExecutor.executeScript("return document.URL");
		
	}
	public String getTitle() {
		return (String) jsExecutor.executeScript("return document.title");
		
	}
	
	public Object executeForBrowser(String javaScript) {
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText() {
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(String textExpected) {
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage() {
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(String url) {
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void hightlightElement(String locator) {
		WebElement element = getElement(locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(String locator) {
		jsExecutor.executeScript("arguments[0].click();", getElement(locator));
	}

	public void scrollToElementOnTop(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getElement(locator));
	}

	public void scrollToElementOnDown(String locator) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(false);", getElement(locator));
	}

	public void sendkeyToElementByJS(String locator, String value) {
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", getElement(locator));
	}

	public void removeAttributeInDOM(String locator, String attributeRemove) {
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getElement(locator));
	}

	public String getElementValidationMessage(String locator) {
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getElement(locator));
	}

	public boolean isImageLoaded(String locator) {
		boolean status = (boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getElement(locator));
		return status;
	}

	public WebElement getElement(String locator) {
		return driver.findElement(By.xpath(locator));
	}
	
}