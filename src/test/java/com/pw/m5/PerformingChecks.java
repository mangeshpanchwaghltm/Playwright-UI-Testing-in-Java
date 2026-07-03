package com.pw.m5;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions.HasTextOptions;
import com.microsoft.playwright.assertions.LocatorAssertions.IsVisibleOptions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;
import com.pw.TestScriptBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class PerformingChecks{

	@Test
	void performingChecks(Page page) {
		
		page.navigate(Constants.HOME_WEB);
		
		//page.check("#heard-about");
		
		var textarea = page.locator("#textarea");
		
		assertThat(textarea).isVisible(new IsVisibleOptions().setTimeout(500));
		assertThat(textarea).not().isEditable();
		assertThat(textarea).isInViewport();
		
		assertThat(textarea).hasText("",new HasTextOptions().setIgnoreCase(true));
	
		assertThat(textarea).hasValue("");	// for what you typed in
		assertThat(textarea).hasText("");	// for what is between tags
		
		var msg = "msg";
		page.getByRole(AriaRole.CHECKBOX).check();
		textarea.fill(msg);
		
		assertThat(textarea).hasValue(msg);
	//	assertThat(textarea).hasText(msg);		// fails 
	}
}
