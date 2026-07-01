package com.pw.m4;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pw.Constants;
import com.pw.TestScriptBase;

public class PlaywrightWithoutTryStatement2 extends TestScriptBase{

	@Test
	void testOne() {
		
		//var pw = Playwright.create();
		
		//Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate(Constants.BASE_WEB);
		System.out.println("Test 1 : " + page.title());
		
	
	}
	
	@Test
	void testTwo() {
		
		//var pw = Playwright.create();
		
		//Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
		
		page.navigate(Constants.HOME_WEB);
		
		System.out.println("Test 2 : " + page.title());
		
	
	}
}
