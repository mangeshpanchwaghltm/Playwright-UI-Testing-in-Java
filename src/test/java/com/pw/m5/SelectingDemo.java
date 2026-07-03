package com.pw.m5;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.SelectOption;
import com.pw.Constants;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

@UsePlaywright
public class SelectingDemo {

	@Test
	void selectingTest(Page page) {
		
		page.navigate(Constants.SAVINGS_WEB);
		
		var deposit = page.getByTestId("deposit");
		var period = page.getByTestId("period");
		var result = page.getByTestId("result");
		
		deposit.fill("1000");
		
		period.selectOption("6 Months");
		assertThat(result).hasText("After 6 Months you will earn $20.00 on your deposit");
		
		period.selectOption(new SelectOption().setLabel("1 year"));
		assertThat(result).hasText("After 1 Year you will earn $50.00 on your deposit");
	}
}
