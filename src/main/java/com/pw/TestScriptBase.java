package com.pw;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TestScriptBase {

	static Playwright pw;
	static Browser browser;
	protected Page page;				// Create fresh new page for each test
	
	// This is for all test. This will run before all the test cases in this class
		@BeforeAll
		static void setup() {
			pw = Playwright.create();
			browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
		}
		
		@BeforeEach
		void setupPage() {
			
			page = browser.newPage();
		}
		
		@AfterEach
		void cleanupPage() {
			page.close();
		}
		
		@AfterAll
		static void clean() {
			if(pw!=null) {
				pw.close();
			}
		}
}
