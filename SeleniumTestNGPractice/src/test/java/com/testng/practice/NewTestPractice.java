package com.testng.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTestPractice {
	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html");

		WebElement webElement = driver
			.findElement(By.xpath("/html/body/div[1]/div/main/div/h1"));
		System.out.println(webElement.getCssValue("color"));
		System.out.println(webElement.getAccessibleName());
		System.out.println(webElement.getAriaRole());

		Thread.sleep(3000);
		driver.quit();
	}

}
