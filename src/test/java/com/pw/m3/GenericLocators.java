package com.pw.m3;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pw.Constants;

public class GenericLocators {

	@Test
	void cssAndXpathDemo() {
		
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))){
			Page page = browser.newPage();
			page.navigate(Constants.HOME_WEB);
			
			page.locator(".needs-validation label[for='firstName']").fill("Mangesh");
			
			page.locator("//form//button[2]").click();
			
			//assertTrue(page.getByText("Valid last name is required").isVisible());
			
		}
				
	}
}
