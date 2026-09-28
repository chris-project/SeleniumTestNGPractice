package com.tests;

import java.io.File;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumCommand {

	private WebDriver driver = null;
	private WebDriverWait wait = null;

	@Test(description = "WebDriver commands.")
	public void f1() throws InterruptedException {

		String currentUrl = driver.getCurrentUrl();
		String title = driver.getTitle();
		String pageSource = driver.getPageSource();

		System.out.println("currentUrl : " + currentUrl);
		System.out.println("title : " + title);
		System.out.println("pageSource : " + pageSource);

		Point point = driver.manage().window().getPosition();
		Dimension dimension = driver.manage().window().getSize();

		System.out.println("Pont X : " + point.x + " Point Y : " + point.y);
		System.out.println("Width : " + dimension.getWidth() + " Height : " + dimension.getHeight());

		driver.manage().window().fullscreen();
		driver.manage().window().minimize();
		driver.manage().window().maximize();
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().window().setPosition(new Point(100, 100));

		Thread.sleep(3000);

	}

	@Test(description = "Alert Commands.")
	public void f2() {

		driver.findElement(By.xpath("//button[@id='btn-alert']")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		// Alert alert = driver.switchTo().alert();
		System.out.println("Alert text: " + alert.getText());
		alert.accept();

		driver.findElement(By.xpath("//button[@id='btn-confirm']")).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Confirm Alert text: " + alert.getText());
		alert.dismiss();

		driver.findElement(By.xpath("//button[@id='btn-prompt']")).click();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("Prompt Alert text: " + alert.getText());
		alert.sendKeys("John Christopher Sebastian");
		alert.dismiss();

	}

	@Test(description = "Checkbox Commands.")
	public void f3() throws InterruptedException {

		List<WebElement> elementList = driver.findElements(By.xpath("//input[@name='interests']"));
		System.out.println("No. of checkboxs : " + elementList.size());
		for (WebElement element : elementList) {
			if (element.isDisplayed() && element.isEnabled() && !element.isSelected()) {
				element.click();
			}
		}

		boolean flag = driver.findElement(By.xpath("//input[@id='chk-technology']")).isSelected();
		System.out.println("Is Checkbox Selected :" + flag);

		Thread.sleep(3000);
	}

	@Test(description = "Radio Button commands.")
	public void f4() throws InterruptedException {

		List<WebElement> elementList = driver.findElements(By.xpath("//input[@name='contact']"));
		System.out.println("No. of Radio Buttons : " + elementList.size());
		for (WebElement element : elementList) {
			if (element.isDisplayed() && element.isEnabled() && !element.isSelected()) {
				element.click();
			}
		}

		boolean flag = driver.findElement(By.xpath("//*[@id='radio-mail']")).isSelected();
		System.out.println("Is Radio Button Selected :" + flag);

		Thread.sleep(3000);
	}

	@Test(description = "Scroll to element commands.")
	public void f5() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath("//button[@id='trigger-delay']"));
		// JavaScript Executor with scrollIntoView() (most reliable)
		js.executeScript("arguments[0].scrollIntoView()", element);

		Thread.sleep(3000);

		element = driver.findElement(By.xpath("//input[@id='username']"));
		// Better version — centers the element and avoids it being hidden behind sticky
		// headers/footers:
		js.executeScript(
			"arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});",
			element);

		Thread.sleep(3000);

		element = driver.findElement(By.xpath("//button[@id='btn-alert']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

		Thread.sleep(3000);

	}

	@Test(description = "Single Select Dropdown.")
	public void f6() throws InterruptedException {

		WebElement selectElement = driver.findElement(By.xpath("//select[@id='country']"));
		Select countrySelect = new Select(selectElement);

		List<WebElement> optionsElementList = countrySelect.getOptions();
		System.out.println("No. of options : " + optionsElementList.size());
		System.out.println("All dropdown options : ");
		for (WebElement optionElement : optionsElementList) {
			System.out.println(optionElement.getText().trim());
		}

		countrySelect.selectByIndex(1);
		System.out.println("Selected option :" + countrySelect.getAllSelectedOptions().get(0).getText());
		countrySelect.selectByValue("usa");
		System.out.println("Selected option :" + countrySelect.getAllSelectedOptions().get(0).getText());
		countrySelect.selectByVisibleText("Canada");
		System.out.println("Selected option :" + countrySelect.getAllSelectedOptions().get(0).getText());
		countrySelect.selectByContainsVisibleText("Aus");
		System.out.println("Selected option :" + countrySelect.getAllSelectedOptions().get(0).getText());

		for (WebElement optionElement : optionsElementList) {
			if (optionElement.isSelected())
				System.out.println("Selected option :" + optionElement.getText().trim());
		}

		Thread.sleep(3000);
	}

	@Test(description = "Multi-Select Dropdown.")
	public void f7() throws InterruptedException {

		WebElement selectElement = driver.findElement(By.xpath("//select[@id='skills']"));
		Select countrySelect = new Select(selectElement);

		List<WebElement> optionsElementList = countrySelect.getOptions();
		System.out.println("No. of options : " + optionsElementList.size());
		System.out.println("All dropdown options : ");
		for (WebElement optionElement : optionsElementList) {
			System.out.println(optionElement.getText().trim());
		}

		countrySelect.selectByIndex(0);
		countrySelect.selectByValue("python");
		countrySelect.selectByVisibleText("JavaScript");
		countrySelect.selectByContainsVisibleText("Cyp");
		System.out.println("First selected option : " + countrySelect.getFirstSelectedOption().getText());

		System.out.println("All selected dropdown options : ");
		for (WebElement optionElement : optionsElementList) {
			if (optionElement.isSelected())
				System.out.println(optionElement.getText().trim());
		}

		countrySelect.deselectByIndex(0);
		countrySelect.deselectByValue("python");
		countrySelect.deselectByVisibleText("JavaScript");
		countrySelect.deSelectByContainsVisibleText("Cyp");
		System.out.println("No. of options selected : " + countrySelect.getAllSelectedOptions().size());

		countrySelect.selectByValue("python");
		countrySelect.selectByVisibleText("JavaScript");
		countrySelect.deselectAll();
		System.out.println("No. of options selected : " + countrySelect.getAllSelectedOptions().size());

		countrySelect.selectByValue("python");
		WebElement wrappedElement = countrySelect.getWrappedElement();// Prints 'select'
		System.out.println(wrappedElement.getTagName());

		Thread.sleep(3000);

//		https://www.selenium.dev/documentation/webdriver/support_features/select_lists/
//		Assert.expectThrows(UnsupportedOperationException.class, () -> {
//            select.selectByValue("disabled");
//        });

	}

	@Test(description = "Handling Shadow DOM.")
	public void f8() throws InterruptedException {

		// 1. Native getShadowRoot() (Selenium 4.x, recommended)
		WebElement shadowHostElement = driver.findElement(By.xpath("//div[@id='shadow-host']"));
		SearchContext shadowRoot = shadowHostElement.getShadowRoot();
		System.out.println(shadowRoot.toString());
		shadowRoot.findElement(By.cssSelector("#shadow-username")).sendKeys("John Christopher Sebastian");
		shadowRoot.findElement(By.cssSelector("#shadow-agree")).click();

		Thread.sleep(3000);

		// 2. JavaScriptExecutor (works across all versions, including pre-4.0)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		SearchContext root = (SearchContext) js.executeScript("return arguments[0].shadowRoot", shadowHostElement);
		shadowRoot.findElement(By.cssSelector("#shadow-email")).sendKeys("chris.jcs83@gmail.com");

		Thread.sleep(3000);

	}

	@Test(description = " Mouse Hover , Right Click, Double Click.")
	public void f9() throws InterruptedException {

		// Mouse Hover
		WebElement element = driver.findElement(By.cssSelector("#hover-btn"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
			"arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});",
			element);

		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();

		Thread.sleep(3000);

		// Right Click
		element = driver.findElement(By.cssSelector("#context-btn"));
		js.executeScript(
			"arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});",
			element);
		actions.contextClick(element).perform();

		Thread.sleep(3000);

		// Double Click
		element = driver.findElement(By.cssSelector("#dblclick-btn"));
		js.executeScript(
			"arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});",
			element);
		actions.doubleClick(element).perform();

		Thread.sleep(3000);

	}

	@Test(description = "Drag and Drop.")
	public void f10() throws InterruptedException {

		WebElement sourceElement1 = driver.findElement(By.cssSelector("#drag-item-1"));
		WebElement sourceElement2 = driver.findElement(By.cssSelector("#drag-item-4"));
		WebElement targetElement = driver.findElement(By.cssSelector("#target-list"));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(
			"arguments[0].scrollIntoView({block: 'center', inline: 'nearest', behavior: 'instant'});",
			sourceElement1);

		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement1, targetElement).perform();
		actions.dragAndDrop(sourceElement2, targetElement).perform();

		Thread.sleep(3000);

	}

	@Test(description = "Keyboard Interaction.")
	public void f11() throws InterruptedException {

		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']"));
		usernameElement.sendKeys("John Christopher Sebastian");
		usernameElement.sendKeys(Keys.chord(Keys.BACK_SPACE, Keys.BACK_SPACE));

		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		actions.keyDown(usernameElement, Keys.CONTROL)
			.sendKeys("a")
			.keyUp(usernameElement, Keys.CONTROL)
			.sendKeys(usernameElement, Keys.DELETE)
			.perform();

		Thread.sleep(3000);

	}

	@Test(description = "Handling single iframe")
	public void f12() throws InterruptedException {
		int noOfIframe = driver.findElements(By.tagName("iframe")).size();
		System.out.println("No. of iframe : " + noOfIframe);

		// Switch to iframe by index
		driver.switchTo().frame(0);
		driver.findElement(By.cssSelector("#single-name")).sendKeys("John");
		driver.switchTo().defaultContent();

		// Switch to iframe by id or name
		driver.switchTo().frame("single-iframe");
		driver.findElement(By.cssSelector("#single-name")).clear();
		driver.findElement(By.cssSelector("#single-name")).sendKeys("Christopher");
		driver.switchTo().defaultContent();

		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']"));
		usernameElement.sendKeys("John Christopher Sebastian");

		Thread.sleep(3000);
	}

	@Test(description = "Handling nested iframe")
	public void f13() throws InterruptedException {

		// Switch to nested-outer-iframe
		driver.switchTo().frame("nested-outer-iframe");
		// Switch to nested-inner-iframe
		driver.switchTo().frame("nested-inner-iframe");
		driver.findElement(By.cssSelector("#inner-email")).sendKeys("chris.jcs83@gmail.com");

		Thread.sleep(3000);

		driver.switchTo().parentFrame();
		driver.findElement(By.cssSelector("#outer-username")).sendKeys("Sebastian");

		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		WebElement usernameElement = driver.findElement(By.xpath("//input[@id='username']"));
		usernameElement.sendKeys("John Christopher Sebastian");

		Thread.sleep(3000);

		// Wait until iframe is available and switch
//		public static void switchToFrame(WebDriver driver, By locator) {
//		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		    wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
//		}

		// Usage:
//		switchToFrame(driver, By.id("myFrame"));
	}

	@Test(description = "New Tab and New Window")
	public void f14() throws InterruptedException {

		String parentWindowHandleId = driver.getWindowHandle();
		System.out.println("Parent Window Handle Id : " + parentWindowHandleId);

		driver.findElement(By.cssSelector("#link-new-tab")).click();

		Set<String> windowHandleIds = driver.getWindowHandles();
		System.out.println("Number of window handles : " + windowHandleIds.size());
		for (String windowHandleId : windowHandleIds) {
			if (!windowHandleId.equals(parentWindowHandleId)) {
				driver.switchTo().window(windowHandleId);
			}
		}

		System.out.println("Title after window switch : " + driver.getTitle());
		driver.close();
		driver.switchTo().window(parentWindowHandleId);
		System.out.println("Title after window switch : " + driver.getTitle());

		Thread.sleep(3000);

		driver.findElement(By.cssSelector("#link-new-tab")).click();
		driver.findElement(By.cssSelector("#link-new-window")).click();

		boolean flag = wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println("Number of window flag : " + flag);

		windowHandleIds = driver.getWindowHandles();
		System.out.println("Number of window handles : " + windowHandleIds.size());

		Thread.sleep(3000);

	}

	@Test(description = "Selenium 4 – New WindowType API")
	public void f15() throws InterruptedException {
		System.out.println("Parent window title : " + driver.getTitle());
		System.out.println("Parent window url : " + driver.getCurrentUrl());
		String parentHandle = driver.getWindowHandle();

		// Open a new TAB (Selenium 4 way)
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.selenium.dev");
		System.out.println("New tab title: " + driver.getTitle());

		Thread.sleep(3000);

		// Open a new WINDOW
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("https://the-internet.herokuapp.com/windows");
		System.out.println("New window title: " + driver.getTitle());

		Thread.sleep(3000);

		// Get all handles and switch back to parent
		Set<String> allHandles = driver.getWindowHandles();
		System.out.println("Total windows/tabs open: " + allHandles.size());

		// Switch back to original parent window
		driver.switchTo().window(parentHandle);
		System.out.println("Back to parent. Title: " + driver.getTitle());

		Thread.sleep(3000);
	}

	@Test(description = "")
	public void f16() throws InterruptedException {

		// Navigate to another page
		driver.navigate().to("https://www.selenium.dev/documentation/");
		wait.until(ExpectedConditions.urlContains("documentation"));

		// Go back
		driver.navigate().back();
		wait.until(ExpectedConditions.titleContains("Playground"));

		// Go forward
		driver.navigate().forward();

		// Refresh
		driver.navigate().refresh();

		// Current URL
		System.out.println("Current URL: " + driver.getCurrentUrl());

		Thread.sleep(3000);
	}

	@Test(description = "")
	public void f17() throws InterruptedException {

//		Map<String, String> env = System.getenv();
//		env.forEach((key, value) -> System.out.println(key + " = " + value));
//
//		String currentDir = System.getProperty("user.dir");
//		System.out.println("Current working directory: " + currentDir);

//		String path = "file:///" + System.getProperty("user.dir")
//			+ File.separator + "grok_1.html";
//
//		System.out.println("Platform-safe path: " + path);

		Thread.sleep(3000);
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		// useful in Headless environments or CI/CD pipelines like Jenkins.
		options.addArguments("start-maximized");
		// options.addArguments("kiosk");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		driver = new ChromeDriver(options);
		// driver.get("file:///C:/Users/jp/Desktop/john_work/vscode_workspace/playwright_api_practice_2/grok_1.html");
		String path = "file://" + System.getProperty("user.dir")
			+ File.separator + "grok_1.html";
		driver.get(path);

		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Thread.sleep(3000);

	}

	@AfterMethod
	public void afterMethod() {
		if (driver != null) {
			driver.quit();
		}

	}

}
