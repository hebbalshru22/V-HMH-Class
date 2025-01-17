package com.qapitolHMH.Utility;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionUtils {

    // Assert if the URL of the current page matches the expected URL
    public static void assertCurrentURL(WebDriver driver, String expectedURL, String errorMessage) {
        try {
            String actualURL = driver.getCurrentUrl();
            Assert.assertEquals(actualURL, expectedURL, errorMessage);
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    // Assert if the page title matches the expected title
    public static void assertPageTitle(WebDriver driver, String expectedTitle, String errorMessage) {
        try {
            String actualTitle = driver.getTitle();
            Assert.assertEquals(actualTitle, expectedTitle, errorMessage);
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

   }
