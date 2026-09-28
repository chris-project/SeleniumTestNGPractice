package com.selenium.commands;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertPrompt {

	WebDriver driver;
	WebDriverWait wdw;

	@Test(description = "Simple alert.")
	public void f1() {
		driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Alert alert = wdw.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert text: " + alert.getText());
		alert.accept();

	}

	@Test(description = "Confirmation alert.")
	public void f2() throws InterruptedException {

		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		Alert alert = wdw.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert text: " + alert.getText());
		alert.accept();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		alert = wdw.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert text: " + alert.getText());
		alert.dismiss();
	}

	@Test(description = "Prompt alert.")
	public void f3() throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		Alert alert = wdw.until(ExpectedConditions.alertIsPresent());
		System.out.println("Alert text: " + alert.getText());
		alert.sendKeys("John Christopher.");
		Thread.sleep(3000);
		alert.accept();
	}

	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		System.out.println("// 1. Window Management.");
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.manage().window().fullscreen();
		driver.manage().window().setSize(new Dimension(1024, 768));

		System.out.println("// 3. Cookies");
		Cookie myCookie = new Cookie("key", "value");
		driver.manage().addCookie(myCookie);

		Set<Cookie> cookieSet = driver.manage().getCookies();
		System.out.println(cookieSet);
		Cookie myCookie1 = driver.manage().getCookieNamed("sessionID");
		System.out.println(myCookie1);

		driver.manage().deleteCookieNamed("name"); // Delete by name
		driver.manage().deleteAllCookies(); // Clear all

		System.out.println("// 2. Timeouts.");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(20));

		driver.get("https://testautomationpractice.blogspot.com/");

		wdw = new WebDriverWait(driver, Duration.ofSeconds(30));

	}

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		Thread.sleep(3000);
		driver.quit();
	}

}
