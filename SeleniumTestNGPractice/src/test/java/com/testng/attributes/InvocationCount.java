package com.testng.attributes;

import org.testng.annotations.Test;

public class InvocationCount {
	@Test(invocationCount = 3)
	public void f1() {
		System.out.println("Inside test method f1().");
	}
}
