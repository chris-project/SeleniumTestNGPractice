package com.selenium.commands;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	@Test
	public void f() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement femaleRadioButtonElement = driver.findElement(By.xpath("//input[@id='female']"));

		if (femaleRadioButtonElement.isDisplayed() && femaleRadioButtonElement.isEnabled()) {
			femaleRadioButtonElement.click();
		}

		List<WebElement> genderRadioButtonList = driver
				.findElements(By.xpath("//input[@name='gender' and @type='radio']"));

		System.out.println("Selected radio button text : ");
		for (WebElement genderElement : genderRadioButtonList) {
			if (genderElement.isSelected()) {
				System.out.println(genderElement.findElement(By.xpath(".//following-sibling::label")).getText().trim());
			}
		}

		Thread.sleep(3000);
		driver.quit();

	}
}
