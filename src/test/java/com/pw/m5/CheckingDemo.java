package com.pw.m5;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class CheckingDemo {

	@Test
	void checkingTest(Page page) {
		
		page.navigate(Constants.HOME_WEB);
		
		String message = "msg";
		
		var checkbox = page.getByRole(AriaRole.CHECKBOX);
		var textarea = page.locator("#textarea");
		
		checkbox.check();
		textarea.fill(message);
		
		assertThat(textarea).hasValue(message);
		
	}
}
