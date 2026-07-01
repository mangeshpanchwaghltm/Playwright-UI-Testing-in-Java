package com.pw.m3;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pw.Constants;

public class OtherLocators {

	@Test
	void outDatedLocators() {
		
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))){
			
			Page page = browser.newPage();
			page.navigate(Constants.BASE_WEB);
			
			page.check("#heard-about");
			page.fill("#textarea","Your Message");
		}
	}
}
