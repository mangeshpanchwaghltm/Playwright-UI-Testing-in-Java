package com.pw.m2;

import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserSupport {

	@Test
	void browserSupport() {
		
		try(var pw = Playwright.create()){
			
			List<BrowserType> browserType = List.of(pw.chromium(), pw.firefox(), pw.webkit());	// or Arrays.asList() 
			
			for(var type: browserType) {
				
				Page page = type.launch().newPage();		// Skip try-with resources
				page.navigate("https://playwright.dev/java/");
				page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(type.name() + ".png")));
				
			}
		}
	}
}
