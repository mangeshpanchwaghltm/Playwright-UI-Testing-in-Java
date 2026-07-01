package com.pw.m3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;

public class RecommendedLocators {

	@Test
	void recommendedLocators() {
		
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))){
			
			Page page = browser.newPage();
			page.navigate(Constants.HOME_WEB);
			
			// By Label
			Locator name = page.getByLabel("First Name");	// not interactionyet
			name.fill("Mangesh");
			name.clear();
			
			page.getByLabel("First Name").fill("Andrejs");
			
			// By Label
//			page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions()
//						.setName("Register").setExact(true))
//						.click();
			
			//page.getByRole(AriaRole.BUTTON,name("Register").setExact(true)).click();
			
			page.getByRole(AriaRole.BUTTON,name("Register")).click();
			
			var warningLastName = page.getByText("Valid last name is required");
			Assertions.assertTrue(warningLastName.isVisible()); // possible but not recommended
			
			var warningfirstName = page.getByText("Valid first name is required");
			Assertions.assertFalse(warningfirstName.isVisible());
			
			var warningEmail = page.getByText("Please enter a valid email address");
			Assertions.assertTrue(warningEmail.isVisible());
			
			
		}
		
	}

	public static BrowserType.LaunchOptions headlessSlow(int delay){
		return null;
	}
	
	private static Page.GetByRoleOptions name(String name) {
		return new Page.GetByRoleOptions()
				.setName(name);
	}
}
