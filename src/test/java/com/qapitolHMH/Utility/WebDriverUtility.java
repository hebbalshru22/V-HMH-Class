package com.qapitolHMH.Utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class WebDriverUtility {
    public static Properties prop;

    public static void visibilityOfElemnt(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElements(element));
    }

    public static void elementToBeClickable(WebDriver driver, WebElement element, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void ActionUse(WebDriver driver) {
        Actions act = new Actions(driver);
        act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).perform();
    }

    public static void waitForTitle(WebDriver driver, int sec, String partialTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
        wait.until(ExpectedConditions.titleContains(partialTitle));
    }
    public static void scrollToElement(WebDriver driver, org.openqa.selenium.WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    public static void clickElementUsingJavaScript(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

}



