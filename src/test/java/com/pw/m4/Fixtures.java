package com.pw.m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.pw.Constants;

@UsePlaywright
public class Fixtures {

	@Test
	void testWithPageFixture(Page page) {
		page.navigate(Constants.HOME_WEB);
		Assertions.assertEquals("Credit Association", page.title());
	}
	
	@Test
	void testWithBrowserFixture(Browser browser) {
		var context = browser.newContext(new Browser.NewContextOptions().setLocale("...").setBaseURL(Constants.HOME_WEB));
		var page = context.newPage();
		
		page.navigate("");
	}
}
