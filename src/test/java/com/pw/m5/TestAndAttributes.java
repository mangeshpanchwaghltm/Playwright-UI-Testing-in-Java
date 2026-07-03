package com.pw.m5;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.pw.Constants;

@UsePlaywright
public class TestAndAttributes {

	@Test
	void testAndAttributes(Page page) {
		
		page.navigate(Constants.SAVINGS_WEB);
		
		var form = page.locator(".needs-validation");
		
		System.out.println("======= Inner HTML =======");
		System.out.println(form.innerHTML());		// include HTML Page
		
		System.out.println("======= Text Content =======");
		System.out.println(form.textContent());		// includes white spaces
		
		System.out.println("======= Inner Text =======");
		System.out.println(form.innerText());		// whitespace trimmed
		
	}
}
