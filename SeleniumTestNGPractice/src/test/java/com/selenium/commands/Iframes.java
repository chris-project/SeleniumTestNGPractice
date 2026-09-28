package com.selenium.commands;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Iframes {

	@Test(description = "Simple iframe.")
	public void f1() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		WebDriver driver = new ChromeDriver(options);
		// driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.tutorialspoint.com/selenium/practice/frames.php");

		// Approach 1.
		int numberOfIframes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of iframe : " + numberOfIframes);

		// Approach 2.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		numberOfIframes = Integer.parseInt(js.executeScript("return window.length").toString());
		System.out.println("Number of iframe : " + numberOfIframes);

		driver.switchTo().frame(0);
		String iframeH1Text = driver.findElement(By.xpath("//h1[normalize-space()='New Tab']")).getText();
		System.out.println("iframe[0] header text : " + iframeH1Text);
//		String mainH1Text = driver.findElement(By.xpath("//h1[normalize-space()='Frames']")).getText();
//		System.out.println("Main document header text : " + mainH1Text);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().defaultContent();

		Thread.sleep(3000);
		driver.quit();

//		driver.switchTo().frame(int index)
//		driver.switchTo().frame(String nameOrId)
//		driver.switchTo().frame(WebElement frameElement)
//		driver.switchTo().defaultContent()
//		driver.switchTo().parentFrame();
//		driver.switchTo().activeElement()

	}

	@Test(description = "Nested iframe.")
	public void f2() {

	}

}
