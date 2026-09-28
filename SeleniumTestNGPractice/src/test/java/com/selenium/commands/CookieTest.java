package com.selenium.commands;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CookieTest {
	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// driver.get("https://testautomationpractice.blogspot.com/");
		driver.get("https://medium.com/");
		Set<Cookie> cookieSet = driver.manage().getCookies();

		for (Cookie c : cookieSet) {
			System.out.println(c.getName() + " : " + c.getValue());
		}

		System.out.println(driver.manage().getCookieNamed("sid"));

		Thread.sleep(5000);
		driver.quit();

	}
}
