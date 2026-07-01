package com.pw.m3;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;

public class FilteringDemo {

	@Test
	void fileter() {
		
		try(var pw = Playwright.create();
			var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000))){
			
			Page page = browser.newPage();
			page.navigate(Constants.SAVINGS_WEB);
			
			var rows = page.getByRole(AriaRole.ROW);
			System.out.println(rows.count());
			
//			var row = rows.filter(new Locator.FilterOptions()
//								.setHasText("Competition"));
			
			var row = rows.filter(text("Competition"));
			
			System.out.println(row.textContent());
		}
	}
	
	public static Locator.FilterOptions text(String text){
		
		return new Locator.FilterOptions()
					.setHasText(text);
	}
}
