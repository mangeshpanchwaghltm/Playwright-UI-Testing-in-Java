package com.pw.m4;

import org.junit.jupiter.api.Test;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.pw.Constants;

public class PlaywrightWithoutTryStatement {

    @Test
    void playwrightWithoutTry() {

    	var pw = Playwright.create();

    	Page page = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false)).newPage();
    	
    	page.navigate(Constants.BASE_WEB);
    	
    	
    	pw.close();
    	
    }
    
    
}
