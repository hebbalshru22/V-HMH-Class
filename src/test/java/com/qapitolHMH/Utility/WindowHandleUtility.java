package com.qapitolHMH.Utility;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class WindowHandleUtility {
    // Method to switch to a new window (other than the main window)
    public static void switchToNewWindow(WebDriver driver, String mainWindowHandle) {
        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
    }

    // Method to switch back to the main window
    public static void switchToMainWindow(WebDriver driver, String mainWindowHandle) {
        driver.switchTo().window(mainWindowHandle);
    }
}
