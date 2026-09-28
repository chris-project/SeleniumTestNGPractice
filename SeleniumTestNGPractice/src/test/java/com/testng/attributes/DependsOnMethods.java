package com.testng.attributes;

import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test(priority = 1)
	public void f1() {
		System.out.println("Inside test method f1().");
	}

	@Test(priority = 0, dependsOnMethods = "f1")
	public void f2() {
		System.out.println("Inside test method f2().");
	}

	@Test(priority = -1, dependsOnMethods = { "f1", "f2" })
	public void f3() {
		System.out.println("Inside test method f3().");
	}
}
