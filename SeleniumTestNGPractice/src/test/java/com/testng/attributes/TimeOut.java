package com.testng.attributes;

import org.testng.annotations.Test;

public class TimeOut {

	@Test(timeOut = 1000)
	public void f1() throws InterruptedException {
		System.out.println("Inside test method f1().");
		Thread.sleep(2000);
	}

	@Test()
	public void f2() {
		System.out.println("Inside test method f2().");
	}
}
