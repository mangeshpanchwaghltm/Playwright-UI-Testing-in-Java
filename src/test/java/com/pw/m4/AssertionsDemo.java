package com.pw.m4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.PlaywrightAssertions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;

@UsePlaywright
public class AssertionsDemo {
	
	@Test
	void testWithPlaywrightAssertions(Page page) {
		
		page.navigate(Constants.HOME_WEB);
		
		// Click  Register
		var button = page.getByRole(AriaRole.BUTTON);
		button.click();
		
		var feedback = page.locator(".invalid-feedback");
		
		// JUnit assertions
		Assertions.assertEquals("Credit Association",page.title());
		Assertions.assertTrue(feedback.isVisible());
		
		// Playwright assertions
		PlaywrightAssertions.assertThat(page).not().hasTitle("abcd");
		PlaywrightAssertions.assertThat(feedback).isVisible();
		
	}
}
