package com.qapitolHMH.Utility;

import org.openqa.selenium.WebDriver;
import java.util.Set;

public class WindowHandleUtility {
    public static void switchToNewWindow(WebDriver driver, String mainWindowHandle) {
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }}}

    public static void switchToMainWindow(WebDriver driver, String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }
}
