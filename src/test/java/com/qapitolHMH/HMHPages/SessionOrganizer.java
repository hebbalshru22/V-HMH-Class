package com.qapitolHMH.HMHPages;
import com.qapitolHMH.Utility.AssertionUtils;
import com.qapitolHMH.Utility.BrokenLinksUtility;
import com.qapitolHMH.Utility.ReadPropertyfile;
import com.qapitolHMH.Utility.WebDriverUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SessionOrganizer {
    WebDriver driver;
    BrokenLinksUtility broken;


    public SessionOrganizer(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(xpath = "//*[@data-test-id=\"myClasses\"]")
    WebElement myclass;

    @FindBy(xpath = "//*[text()=\"Demo Teacher\"]/ancestor::div[@class='MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation3 MuiCard-root mui-ufdcw-ClassCard-classCard']/descendant::button[text()=\"View Class\"]")
    WebElement viewclass;

    @FindBy(xpath = "//*[@class=\"MuiBox-root mui-1isemmb\"]")
    WebElement viewmore;

    @FindBy(id = "moduleDropdown")
    WebElement modules;

    @FindBy(xpath = "//*[@data-value='edddce96-b66a-4f18-8ac8-f3614bcfa0f2']")
    WebElement selectmodule;

    @FindBy(xpath = "//span[text()=\"Session 1: Interpret Picture Graphs\"]/ancestor::div[@class='MuiGrid-root MuiGrid-container mui-oal083']/descendant::input[@id='doneCheckbox']")
    WebElement donecheckbox;

    @FindBy(xpath = "//span[text()=\"Session 1: Interpret Picture Graphs\"]/ancestor::div[@class='MuiGrid-root MuiGrid-container MuiGrid-wrap-xs-nowrap cardbody-row mui-zqx9fs-CardBody-row']/descendant::button[@data-testid='overflow-menu-icon-button']")
    WebElement ellipsis;

    @FindBy(xpath = "//li[text()='Teach']")
    WebElement teachbutton;

    @FindBy(xpath = "//*[text()=\"Session 1: Interpret Picture Graphs\"]/ancestor::div[@class='MuiGrid-root MuiGrid-container MuiGrid-wrap-xs-nowrap cardbody-row mui-zqx9fs-CardBody-row']/descendant::button[text()=\"Resume\"]")
    WebElement resumebutton;

    @FindBy(xpath = "//*[@class=\"mui-1x8xk0u-SessionModal-modalBody\"]")
    WebElement donepopup;

    @FindBy(xpath = "//*[@data-testid='modalCancelButton']")
    WebElement cancelpopup;

    @FindBy(xpath = "//*[@data-testid='modalActionButton']")
    WebElement markasdone;

    @FindBy(xpath="//h4[text()=\"Upcoming Sessions\"]")
    WebElement upcomingsession;

    @FindBy(xpath="//span[text()=\"Lesson 1: Interpret Picture Graphs\"]")
    WebElement lesson;


    public void SessionOrganizerMethod() throws IOException {
        myclass.click();
        String expectedURL = "https://cert.hmhco.com/ui/#/my-classes";
        AssertionUtils.assertCurrentURL(driver, expectedURL, "The current URL doesn't match the expected URL");

        //Broken links
        broken= new BrokenLinksUtility(driver);
        String url = ReadPropertyfile.getObject("brokenlinksMyclass") ;
        broken.checkBrokenLinks(url);

        WebDriverUtility.scrollToElement(driver,viewclass);
        WebDriverUtility.clickElementUsingJavaScript(driver, viewclass);
        WebDriverUtility.elementToBeClickable(driver,viewmore,30);
        WebDriverUtility.scrollToElement(driver,upcomingsession);
        viewmore.click();

        //Wait for title
        WebDriverUtility.waitForTitle(driver,60, "Session Organizer");


        //Assertion for title
        String expectedTitle = "Session Organizer - HMH Ed";
        AssertionUtils.assertPageTitle(driver, expectedTitle, "Page title doesn't match expected title");

        //Broken links
        broken= new BrokenLinksUtility(driver);
        String urlToCheck1 = ReadPropertyfile.getObject("brokenSessionorganizer") ;
        broken.checkBrokenLinks(urlToCheck1);

        WebDriverUtility.elementToBeClickable(driver,modules,30);
        modules.click();
        WebDriverUtility.scrollToElement(driver,lesson);
        selectmodule.click();
        if (donecheckbox.isSelected())
        {
            System.out.println("The ellipsis displayed=" + ellipsis.isDisplayed());
        }
        else
        {
            System.out.println("The buttonis displayed=" + resumebutton.isDisplayed());
            donecheckbox.click();
            String text = donepopup.getText();
            System.out.println(text);
            cancelpopup.click();
            donecheckbox.click();
            markasdone.click();
        }
     }
}







