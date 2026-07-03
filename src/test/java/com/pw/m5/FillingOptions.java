package com.pw.m5;

import org.junit.jupiter.api.Test;
import org.xml.sax.ext.Locator2Impl;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;
import com.pw.TestScriptBase;

@UsePlaywright
public class FillingOptions extends TestScriptBase{

	@Test
	void fillingTest() {
		page.navigate(Constants.HOME_WEB);
		
		page.getByLabel("First Name").fill("Mangesh");
		
		//page.getByLabel("Date of Birth").fill("202-/10-28");
	}
	
	@Test
	void forcingTest(Playwright pw) {
		
		var page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)).newPage();
		
		page.navigate(Constants.HOME_WEB);
		
		var button = page.getByRole(AriaRole.BUTTON, new GetByRoleOptions().setName("Register"));
		var textArea = page.locator("#textarea");
		
		button.click(new Locator.ClickOptions().setForce(true));
		
		//page.check("#heard-about");
		textArea.fill("test",new Locator.FillOptions().setForce(true));
	}
}
