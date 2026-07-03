package com.pw.m5;

import com.microsoft.playwright.APIRequestContext;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Clock;
import com.microsoft.playwright.ConsoleMessage;
import com.microsoft.playwright.Dialog;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.FileChooser;
import com.microsoft.playwright.Frame;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.JSHandle;
import com.microsoft.playwright.Keyboard;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Mouse;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Request;
import com.microsoft.playwright.Response;
import com.microsoft.playwright.Route;
import com.microsoft.playwright.Touchscreen;
import com.microsoft.playwright.Video;
import com.microsoft.playwright.WebSocket;
import com.microsoft.playwright.WebSocketRoute;
import com.microsoft.playwright.Worker;
import com.microsoft.playwright.Page.AddLocatorHandlerOptions;
import com.microsoft.playwright.Page.AddScriptTagOptions;
import com.microsoft.playwright.Page.AddStyleTagOptions;
import com.microsoft.playwright.Page.CheckOptions;
import com.microsoft.playwright.Page.ClickOptions;
import com.microsoft.playwright.Page.CloseOptions;
import com.microsoft.playwright.Page.DblclickOptions;
import com.microsoft.playwright.Page.DispatchEventOptions;
import com.microsoft.playwright.Page.DragAndDropOptions;
import com.microsoft.playwright.Page.EmulateMediaOptions;
import com.microsoft.playwright.Page.EvalOnSelectorOptions;
import com.microsoft.playwright.Page.ExposeBindingOptions;
import com.microsoft.playwright.Page.FillOptions;
import com.microsoft.playwright.Page.FocusOptions;
import com.microsoft.playwright.Page.GetAttributeOptions;
import com.microsoft.playwright.Page.GetByAltTextOptions;
import com.microsoft.playwright.Page.GetByLabelOptions;
import com.microsoft.playwright.Page.GetByPlaceholderOptions;
import com.microsoft.playwright.Page.GetByRoleOptions;
import com.microsoft.playwright.Page.GetByTextOptions;
import com.microsoft.playwright.Page.GetByTitleOptions;
import com.microsoft.playwright.Page.GoBackOptions;
import com.microsoft.playwright.Page.GoForwardOptions;
import com.microsoft.playwright.Page.HoverOptions;
import com.microsoft.playwright.Page.InnerHTMLOptions;
import com.microsoft.playwright.Page.InnerTextOptions;
import com.microsoft.playwright.Page.InputValueOptions;
import com.microsoft.playwright.Page.IsCheckedOptions;
import com.microsoft.playwright.Page.IsDisabledOptions;
import com.microsoft.playwright.Page.IsEditableOptions;
import com.microsoft.playwright.Page.IsEnabledOptions;
import com.microsoft.playwright.Page.IsHiddenOptions;
import com.microsoft.playwright.Page.IsVisibleOptions;
import com.microsoft.playwright.Page.LocatorOptions;
import com.microsoft.playwright.Page.NavigateOptions;
import com.microsoft.playwright.Page.PdfOptions;
import com.microsoft.playwright.Page.PressOptions;
import com.microsoft.playwright.Page.QuerySelectorOptions;
import com.microsoft.playwright.Page.ReloadOptions;
import com.microsoft.playwright.Page.RouteFromHAROptions;
import com.microsoft.playwright.Page.RouteOptions;
import com.microsoft.playwright.Page.ScreenshotOptions;
import com.microsoft.playwright.Page.SelectOptionOptions;
import com.microsoft.playwright.Page.SetCheckedOptions;
import com.microsoft.playwright.Page.SetContentOptions;
import com.microsoft.playwright.Page.SetInputFilesOptions;
import com.microsoft.playwright.Page.TapOptions;
import com.microsoft.playwright.Page.TextContentOptions;
import com.microsoft.playwright.Page.TypeOptions;
import com.microsoft.playwright.Page.UncheckOptions;
import com.microsoft.playwright.Page.WaitForCloseOptions;
import com.microsoft.playwright.Page.WaitForConditionOptions;
import com.microsoft.playwright.Page.WaitForConsoleMessageOptions;
import com.microsoft.playwright.Page.WaitForDownloadOptions;
import com.microsoft.playwright.Page.WaitForFileChooserOptions;
import com.microsoft.playwright.Page.WaitForFunctionOptions;
import com.microsoft.playwright.Page.WaitForLoadStateOptions;
import com.microsoft.playwright.Page.WaitForNavigationOptions;
import com.microsoft.playwright.Page.WaitForPopupOptions;
import com.microsoft.playwright.Page.WaitForRequestFinishedOptions;
import com.microsoft.playwright.Page.WaitForRequestOptions;
import com.microsoft.playwright.Page.WaitForResponseOptions;
import com.microsoft.playwright.Page.WaitForSelectorOptions;
import com.microsoft.playwright.Page.WaitForURLOptions;
import com.microsoft.playwright.Page.WaitForWebSocketOptions;
import com.microsoft.playwright.Page.WaitForWorkerOptions;
import com.microsoft.playwright.junit.UsePlaywright;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.BindingCallback;
import com.microsoft.playwright.options.FilePayload;
import com.microsoft.playwright.options.FunctionCallback;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.ViewportSize;

import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static com.microsoft.playwright.options.AriaRole.BUTTON;
import static com.microsoft.playwright.options.AriaRole.CHECKBOX;
import static com.pw.Constants.HOME_WEB;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@UsePlaywright
public class CodingChallenge {

    @Test
    void codingChallenge(Playwright pw) {
        var browser = pw.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        var page = browser.newPage();
        page.navigate(HOME_WEB);

        String message = "msg";
        var checkbox = page.getByRole(CHECKBOX);
        var textarea = page.locator("#textarea");

        // check the checkbox
        var check = page.locator("#heard-about");
        check.click();
        
        
        // fill in text area
        
        //textarea.fill("My Message");
        textarea.fill(message,new Locator.FillOptions().setForce(true));

        // click "Save Input"
        var button = page.getByRole(BUTTON,new Page.GetByRoleOptions().setName("Save input"));
        button.click();

        // reload
        page.reload();


        // assert that the checkbox remains checked and textarea filled in
        assertThat(check).isChecked();
        assertThat(textarea).hasValue(message);
    }
}
