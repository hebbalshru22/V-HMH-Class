package com.qapitolHMH.HMHBase;

import com.qapitolHMH.Utility.ReadPropertyfile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;

    @BeforeClass
    public void openBrowser() throws IOException {
        driver = new ChromeDriver();
        driver.get(ReadPropertyfile.getObject("loginurl"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public void closeBrowser()
    {
        driver.close();
    }
}

