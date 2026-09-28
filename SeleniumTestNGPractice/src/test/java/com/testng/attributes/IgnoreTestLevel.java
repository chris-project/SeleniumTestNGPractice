package com.testng.attributes;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTestLevel {

	@Ignore
	@Test
	public void f1() {
		System.out.println("Inside test method f1().");
	}

	@Test
	public void f2() {
		System.out.println("Inside test method f2().");
	}
}
