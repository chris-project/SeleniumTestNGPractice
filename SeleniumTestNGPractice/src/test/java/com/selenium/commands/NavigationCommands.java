package com.selenium.commands;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommands {

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://demoqa.com/browser-windows/");
		driver.navigate().to("https://demoqa.com/text-box");

		driver.navigate().back();
		System.out.println("Page title is : " + driver.getCurrentUrl());

		driver.navigate().forward();
		System.out.println("Page title is : " + driver.getCurrentUrl());

		driver.navigate().refresh();
		System.out.println("Page title is : " + driver.getCurrentUrl());

		Thread.sleep(5000);
		driver.quit();

	}
}
