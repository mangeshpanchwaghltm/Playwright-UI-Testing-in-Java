package com.pw.m5;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.pw.Constants;
import com.pw.TestScriptBase;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
//import static com.pw.Constants.HOME_WEB;

@UsePlaywright
public class NavigationOptions extends TestScriptBase{

//    @Test
//    void navigationTest(Page page) {
//        page.navigate(HOME_WEB,new Page.NavigateOptions().setTimeout(30));
//
//        assertThat(page).hasTitle("Credit Association");
//
//        page.reload();
//        page.goBack();
//        page.goForward();
//        
//        page.reload(new Page.ReloadOptions().setTimeout(20));
//        page.goBack(new Page.GoBackOptions().setTimeout(20));
//        page.goForward(new Page.GoForwardOptions().setTimeout(20));
//    }

    @Test
    void challengeTest(Page page) {
        page.navigate(Constants.HOME_WEB);
        
        // click register
        
        //page.getByRole(AriaRole.BUTTON,new Page.GetByRoleOptions().setName("Register")).click();;

        page.locator("//form//button[2]").click();
    }
}
