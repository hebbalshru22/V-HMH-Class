package com.qapitolHMH.HMHPages;

import com.qapitolHMH.Utility.WebDriverUtility;
import com.qapitolHMH.Utility.WindowHandleUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SessionOverviewPage {
    WebDriver driver;
    WebDriverUtility webDriverUtility;

    public SessionOverviewPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//span[text()='Session 1: Interpret Picture Graphs']/ancestor::div[@class='MuiCardContent-root mui-1ggyife-SessionCard-overrideBody']/descendant::button[text()='Preview and Edit']")
    WebElement preview;

    @FindBy(xpath = "//span[text()=\"Session 1: Interpret Picture Graphs\"]/ancestor::div[@class='MuiCardContent-root mui-1ggyife-SessionCard-overrideBody']/descendant::button[text()=\"View Overview\"]")
    WebElement overview;

    @FindBy(xpath = "//button[@aria-label='Show Standards']")
    WebElement showstandard;

    @FindBy(xpath = "//span[text()=\"OH.Math.1.MD.4\"]")
    WebElement standards;

    @FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-colorPrimary MuiIconButton-sizeSmall mui-1n2hj9v\"]")
    WebElement closestd;

    @FindBy(xpath="//button[text()=\"Exit\"]")
    WebElement exitPreview;

    @FindBy(xpath="//button[@data-testid=\"byt-button\"]")
    WebElement viewBeforeTeach;

    @FindBy(xpath="//*[text()=\"clicking this link.\"]")
    WebElement resourcelink;

    @FindBy(xpath="//span[text()=\"Back to Session Organizer\"]")
    WebElement backTosessionOrganizer;

    public void sessionOverview()
    {
        overview.click();
        showstandard.click();
        standards.click();
        closestd.click();
        WebDriverUtility.clickElementUsingJavaScript(driver, viewBeforeTeach);
        //viewBeforeTeach.click();
        String mainWindowHandle = driver.getWindowHandle();
        // Switch to the new window
        WindowHandleUtility.switchToNewWindow(driver, mainWindowHandle);
        // Perform actions in the new window
        System.out.println("Current window title: " + driver.getTitle());
        backTosessionOrganizer.click();
        //Switch back to the main window
        WindowHandleUtility.switchToMainWindow(driver, mainWindowHandle);
        // Print the title of the main window
        System.out.println("Back to main window title: " + driver.getTitle());
        preview.click();
        String mainWindowHandle1 = driver.getWindowHandle();
        // Switch to the new window
        WindowHandleUtility.switchToNewWindow(driver, mainWindowHandle1);
        // Perform actions in the new window
        System.out.println("Current window title: " + driver.getTitle());
        exitPreview.click();
        // Switch back to the main window
        WindowHandleUtility.switchToMainWindow(driver, mainWindowHandle1);
        // Print the title of the main window
        System.out.println("Back to main window title: " + driver.getTitle());
    }
}
