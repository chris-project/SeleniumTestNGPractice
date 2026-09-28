package com.selenium.commands;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabAndWindow {

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		WebDriverWait wdw = new WebDriverWait(driver, Duration.ofSeconds(30));

		driver.get("https://testautomationpractice.blogspot.com/");

		String parentWindowHandle = driver.getWindowHandle();
		System.out.println("Parent window handle is : " + parentWindowHandle);

		driver.findElement(By.xpath("//button[normalize-space()='New Tab']")).click();
		// driver.findElement(By.xpath("//button[@id='PopUp']")).click();

		Boolean windowFlag = wdw.until(ExpectedConditions.numberOfWindowsToBe(2));
		System.out.println(windowFlag.booleanValue());

		driver.switchTo().window(driver.getWindowHandles().toArray(String[]::new)[1]);
		System.out.println("New tab title : " + driver.getTitle());
		Thread.sleep(2000);
		driver.close();

		driver.switchTo().newWindow(WindowType.TAB);
		assertEquals("", driver.getTitle());
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		assertEquals("", driver.getTitle());

		windowFlag = wdw.until(ExpectedConditions.numberOfWindowsToBe(3));
		System.out.println(windowFlag.booleanValue());

		Thread.sleep(3000);
		driver.quit();

	}
}
