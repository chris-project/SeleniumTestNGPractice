package com.testng.annotations;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersOptional {
	
	@Test
	@Parameters({ "username", "password" })
	public void f(@Optional("John@123") String username, @Optional("Warlock@2202") String password) {
		System.out.println("Username : " + username + " / Password : " + password);
	}

}
