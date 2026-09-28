package com.selenium.commands;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://testautomationpractice.blogspot.com/");

		List<WebElement> daysCheckboxElementlList = driver
				.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

		for (WebElement checkboxElement : daysCheckboxElementlList) {
			if (checkboxElement.isDisplayed() && checkboxElement.isEnabled()) {
				checkboxElement.click();
			}
		}

		System.out.println("All selected checkbox text : ");
		for (WebElement checkboxElement : daysCheckboxElementlList) {
			if (checkboxElement.isSelected()) {
				WebElement labelElement = checkboxElement.findElement(By.xpath(".//following-sibling::label"));
				System.out.println(labelElement.getText().trim());
			}
		}

		Thread.sleep(3000);
		driver.quit();
	}
}
