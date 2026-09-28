package com.selenium.commands;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	@Test(description = "Single select dropdown.")
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

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement selectElement = driver.findElement(By.id("country"));
		Select countrySelect = new Select(selectElement);

		List<WebElement> optionsElementList = countrySelect.getOptions();

		System.out.println("All dropdown options : ");
		for (WebElement optionElement : optionsElementList) {
			System.out.println(optionElement.getText().trim());
		}

		countrySelect.selectByIndex(2);
		Thread.sleep(2000);
		countrySelect.selectByValue("usa");
		Thread.sleep(2000);
		countrySelect.selectByVisibleText("Canada");

		System.out.println("Selected option is : " + countrySelect.getFirstSelectedOption().getText().trim());
		System.out.println("Is multiple : " + countrySelect.isMultiple());

		Thread.sleep(2000);
		driver.quit();

	}

	@Test(description = "Multi select dropdown.")
	public void f2() throws InterruptedException {
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

		driver.get("https://testautomationpractice.blogspot.com/");

		WebElement selectElement = driver.findElement(By.id("colors"));
		Select colorsSelect = new Select(selectElement);

		colorsSelect.selectByIndex(2);
		Thread.sleep(2000);
		colorsSelect.selectByValue("yellow");
		Thread.sleep(2000);
		colorsSelect.selectByVisibleText("Blue");

		System.out.println("First selected option is : " + colorsSelect.getFirstSelectedOption().getText().trim());
		System.out.println("All selected options : ");
		List<WebElement> selectedOptions = colorsSelect.getAllSelectedOptions();
		for (WebElement selectedOption : selectedOptions) {
			System.out.println(selectedOption.getText().trim());
		}

		colorsSelect.deselectAll();
		System.out.println("Numbers of color selected : " + colorsSelect.getAllSelectedOptions().size());

		Thread.sleep(3000);
		driver.quit();
	}

}
