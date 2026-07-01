package com.pw.m3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;

public class HandlingMultipleMatches {

	@Test
	void multipleMatchesFails() {
		
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))){
			
			Page page = browser.newPage();
			page.navigate(Constants.BASE_WEB);
			
			//page.getByRole(AriaRole.LINK).click();	// Error : Strict mode viololation
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Savings")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Loans")).click();
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Register")).click();
		}
	}
	
	@Test
	void multipleMatchesFirstLastNth() {
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch()){
			
			Page page = browser.newPage();
			page.navigate(Constants.HOME_WEB);
			
			Locator buttons = page.getByRole(AriaRole.BUTTON);	// Single Object may contains may locators
			
			System.out.println(buttons.first().textContent());
			System.out.println(buttons.last().textContent());
			System.out.println(buttons.nth(1).textContent());
			
			
		}
	}
	
	@Test
	void multipleMatchesCountOrIterate() {
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch()){
			
			Page page = browser.newPage();
			page.navigate(Constants.HOME_WEB);
			
			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register")).click();
			
			var warnings = page.locator(".invalid-feedback");
			
			Assertions.assertEquals(warnings.count(),3);	// count element present in HTML
			
			for(var message : warnings.all()) {
				
				Assertions.assertTrue(message.isVisible());
			}
		}
		
		
		
	}
}
