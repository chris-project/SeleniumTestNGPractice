package com.testng.practice;

import org.testng.annotations.Test;

import com.testng.retry.RetryAnalyzer1;

public class NewTest_5 {
	@Test
	public void f1() {
		System.out.println("Inside f1().");
	}

	@Test
	public void f2() {
		System.out.println("Inside f2().");
	}

	@Test
	public void f3() {
		System.out.println("Inside f3().");
	}

	@Test
	public void f4() {
		System.out.println("Inside f4().");
	}

	@Test(retryAnalyzer = RetryAnalyzer1.class)
	public void f5() throws Exception {
		System.out.println("Inside f5().");
		throw new Exception("This test case should fail,");
	}
}
