package com.qapitolHMH.Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksUtility {
    private WebDriver driver;

    public BrokenLinksUtility(WebDriver driver) {
        this.driver = driver;
    }

    // Method to check if the link is broken
    public void checkBrokenLinks(String url) {
        driver.get(url);

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            String linkUrl = link.getAttribute("href");
            if (linkUrl != null && !linkUrl.isEmpty()) {
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(linkUrl).openConnection();
                    httpURLConnection.setRequestMethod("HEAD");
                    httpURLConnection.connect();
                    int responseCode = httpURLConnection.getResponseCode();

                    if (responseCode != 200) {
                        System.out.println("Broken Link: " + linkUrl + " Response Code: " + responseCode);
                    } else {
                        System.out.println("Valid Link: " + linkUrl + " Response Code: " + responseCode);
                    }
                } catch (Exception e) {
                    System.out.println("Exception for link: " + linkUrl + " - " + e.getMessage());
                }
            }
        }
    }
}
