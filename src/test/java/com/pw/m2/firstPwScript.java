package com.pw.m2;

import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class firstPwScript {

    @Test
    void firstScript() {

        // Playwright > BrowserType > Browser > Page

        try (Playwright playwright = Playwright.create()) {

            BrowserType type = playwright.chromium();

            try (Browser browser = type.launch()) {

                Page page = browser.newPage();

                page.navigate("https://playwright.dev/java/");

                System.out.println(page.title());
            }
        }
//        
//    	try (Playwright playwright = Playwright.create()) {
//		      //Browser browser = playwright.webkit().launch();
//			Browser browser = playwright.chromium().launch(
//					new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000)
//					);
//		      Page page = browser.newPage();
//		      page.navigate("https://playwright.dev/");
//		      System.out.println(page.title());
//		      page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("example.png")));
//		    }
        		
         
    }
    
    @Test
    void firstScriptRefactored() {

        // Playwright > BrowserType > Browser > Page

    	try(var pw = Playwright.create(); 
    		var browser = pw.chromium().launch())
    	{	
    		Page page = browser.newPage();
    		page.navigate("https://playwright.dev/java/");
    		System.out.println("Page Title for refactored : " + page.title());
    	}
    }
}