package com.testng.attributes;

import org.testng.annotations.Test;

@Test
public class TestAnnotationClassLevel {

	public void f1() {
		System.out.println("Inside test method f1().");
	}

	public void f2() {
		System.out.println("Inside test method f2().");
	}
}
