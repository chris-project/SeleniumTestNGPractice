package com.testng.attributes;

import org.testng.annotations.Test;

public class PriorityDescription {

	@Test(priority = 1, description = "Test method f1().")
	public void f1() {
		System.out.println("Test method f1() with priority 1.");
	}

	@Test(priority = -1, description = "Test method f2().")
	public void f2() {
		System.out.println("Test method with priority -1.");
	}

	@Test(priority = 0, description = "Test method f3().")
	public void f3() {
		System.out.println("Test method with priority 0.");
	}

	@Test(priority = 1, description = "Test method a4().")
	public void a4() {
		System.out.println("Test method a4() with priority 1.");
	}

}
