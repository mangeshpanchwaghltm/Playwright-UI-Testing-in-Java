package com.pw.m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;

@UsePlaywright
public class Exercise {
	
	@Test
	void before() {
		try(Playwright playwright  = Playwright.create()){
			BrowserType browserType = playwright.chromium();
			
			try(Browser browser = browserType.launch()){
				Page page = browser.newPage();
				page.navigate(Constants.HOME_WEB);
				
				page.fill("#firstName", "Mangesh");
				Assertions.assertFalse(page.getByText("Valid first name is required").isVisible());
			}
			
		}
	}
	
	@Test
	void after(Page page) {
		page.navigate(Constants.HOME_WEB);
		
		page.getByLabel("First Name").fill("Mangesh");
		
		page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Register")).click();
		
		//Assertions.assertTrue(page.getByText("Valid first name is required")).not().isVisible();
	}
	
}
