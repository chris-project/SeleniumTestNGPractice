package com.testng.attributes;

import org.testng.annotations.Test;

public class Enabled {
	@Test(enabled = true)
	public void f1() {
		System.out.println("Inside test method f1() and is enable true.");
	}

	@Test(enabled = false)
	public void f2() {
		System.out.println("Inside test method f2() and is enable false.");
	}
}
