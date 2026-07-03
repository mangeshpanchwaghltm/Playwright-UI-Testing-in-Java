package com.pw.m5;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;
import com.pw.TestScriptBase;

@UsePlaywright
public class ClickingOptions extends TestScriptBase{

	@Test
	void clickingTest() {
		
		page.navigate(Constants.HOME_WEB);
		
		var button = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Register"));
		
		button.click();
		button.click();
		button.click();
		
		for(int i = 0;i< 5 ; i++) {
			button.click();
		}
		
		button.click(new Locator.ClickOptions().setClickCount(5));
		
		button.dblclick();
		
	}
}
