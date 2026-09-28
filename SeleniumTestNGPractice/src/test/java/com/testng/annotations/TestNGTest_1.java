package com.testng.annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGTest_1 {
	@Test(dataProvider = "dp")
	public void f(Integer n, String s) {
		System.out.println("n : " + n + " s : " + s);
		System.out.println(Thread.currentThread().getName());
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside beforeMethod().");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside afterMethod().");
	}

	/*
	 * @DataProvider annotation is used to run the same test logic multiple times
	 * with different data sets
	 */
	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside beforeClass().");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Inside afterClass().");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside beforeTest().");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Inside afterTest().");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside beforeSuite().");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside afterSuite().");
	}

}
