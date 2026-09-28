package com.testng.attributes;

import org.testng.annotations.Test;

public class AlwaysRun {
	@Test
	public void f1() throws Exception {
		System.out.println("Inside test method f1().");
		throw new Exception("Making it fail.");
	}

	@Test(dependsOnMethods = "f1", alwaysRun = true)
	public void f2() {
		System.out.println("Inside test method f2().");
	}
}
