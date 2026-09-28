package com.testng.attributes;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

@Ignore
public class IgnoreClassLevel {
	@Test
	public void f1() {
		System.out.println("Inside test method f1().");
	}
}
