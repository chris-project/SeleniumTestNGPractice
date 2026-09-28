package com.testng.practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest_2 {

	String className = this.getClass().getName();

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Inside beforeMethod(). - " + className);
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("Inside afterMethod(). - " + className);
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("Inside beforeClass(). - " + className);
	}

	@AfterClass
	public void afterClass() {
		System.out.println("Inside afterClass(). - " + className);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Inside beforeTest(). - " + className);
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Inside afterTest(). - " + className);
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Inside beforeSuite(). - " + className);
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Inside afterSuite(). - " + className);
	}

	@Test
	public void f() {
		String className = this.getClass().getName();
		String threadName = Thread.currentThread().getName();
		System.out.println(className + " / " + threadName);
	}

}
