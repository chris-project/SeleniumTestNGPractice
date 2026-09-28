package com.selenium.commands;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElementCommands {

	@Test
	public void f() throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
		WebElement firstNameEle = driver.findElement(By.xpath("//input[@id='name']"));
		File srcFile = firstNameEle.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("./screenshots/element.png"));

		Dimension dimensions = firstNameEle.getSize();
		System.out
			.println("Element height is : " + dimensions.getHeight() + " and Width is : " + dimensions.getWidth());

		Point point = firstNameEle.getLocation();
		System.out.println("Element X cordinate is : " + point.x + " and Y cordinate is : " + point.y);

		System.out.println("Tag Name is : " + firstNameEle.getTagName());
		System.out.println("Is Displayed : " + firstNameEle.isDisplayed());
		System.out.println("Is Enabled : " + firstNameEle.isEnabled());

		// isSelected() only applies to checkboxes,option in a select and radio buttons
		System.out.println("Is Selected  : " + firstNameEle.isSelected());

		firstNameEle.sendKeys("John Christopher");
		String inputValue = firstNameEle.getAttribute("value");
		System.out.println("Input value is  : " + inputValue);

		Thread.sleep(2000);

		firstNameEle.clear();
		inputValue = firstNameEle.getAttribute("value");
		System.out.println("Input value after clearing  : " + inputValue);

		Thread.sleep(2000);
		firstNameEle.click();

		List<WebElement> elementList = driver.findElements(By.tagName("input"));
		for (WebElement element : elementList) {
			System.out.println("Element type is : " + element.getAttribute("type"));
		}
		System.out.println("Element size is : " + elementList.size());

		Thread.sleep(3000);
		driver.quit();
	}
}
