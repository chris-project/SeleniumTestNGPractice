package com.selenium.commands;

import java.util.Collections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		// useful in Headless environments or CI/CD pipelines like Jenkins.
		options.addArguments("start-maximized");
		// options.addArguments("kiosk");
		options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		options.setExperimentalOption("useAutomationExtension", false);

		WebDriver driver = new ChromeDriver(options);
		// driver.manage().window().maximize();
		// driver.manage().window().setSize(new Dimension(1920, 1080));

		// driver.get("https://www.selenium.dev/selenium/web/web-form.html");
		driver.get("https://demoqa.com/browser-windows/");

		System.out.println("Page title is : " + driver.getTitle());
		System.out.println("Page url is : " + driver.getCurrentUrl());
		System.out.println("Page source is : " + driver.getPageSource());

		Thread.sleep(5000);
		// driver.close(); // Closes only the currently focused window or tab.
		driver.quit();

	}

}
