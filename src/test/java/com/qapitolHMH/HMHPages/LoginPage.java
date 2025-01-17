package com.qapitolHMH.HMHPages;
import com.qapitolHMH.HMHBase.BaseClass;
import com.qapitolHMH.Utility.AssertionUtils;
import com.qapitolHMH.Utility.BrokenLinksUtility;
import com.qapitolHMH.Utility.ReadPropertyfile;
import com.qapitolHMH.Utility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BaseClass {

    WebDriver driver;
    public static Properties prop;
    BrokenLinksUtility broken;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(css = "[data-testid='loginCountrySelect']")
    WebElement countryDropdown;

    @FindBy(xpath = "(//*[@data-testid='ArrowDropDownIcon'])[2]")
    WebElement statedrop;

    @FindBy(css = "[data-testid='loginOrgSelect']")
    WebElement districtdrop;

    @FindBy(xpath = "//div[@data-testid='loginOrgSelect']/descendant::input[@data-testid='input-aria-field']")
    WebElement distid;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement submit;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//*[@type=\"submit\"]")
    WebElement signin;

    By getCountryOptionLocator(String country) {
        return By.xpath("//ul[@id='1val-autocomplete-listbox']/li[text()='" + country + "']");
    }

    By getStateOptionLocator(String state) {
        return By.xpath("//li[text()='" + state + "']");
    }

    By getDistrictOptionLocator(String district) {
        return By.xpath("//li//div[text()='" + district + "']");
    }

    public void logincountry(String country, String state, String district) throws InterruptedException, IOException {

        //Country selection
        WebDriverUtility.elementToBeClickable(driver, countryDropdown, 10);
        countryDropdown.click();
        WebElement countryOption = driver.findElement(getCountryOptionLocator(country));
        WebDriverUtility.elementToBeClickable(driver, countryOption, 30);
        countryOption.click();

        //SateSelection
        WebDriverUtility.elementToBeClickable(driver, statedrop, 10);
        statedrop.click();
        WebElement stateOption = driver.findElement(getStateOptionLocator(state));
        WebDriverUtility.elementToBeClickable(driver, stateOption, 30);
        stateOption.click();

        //District Selection
        districtdrop.click();
        distid.sendKeys(district);
        WebElement districtoption = driver.findElement(getDistrictOptionLocator(district));
        WebDriverUtility.elementToBeClickable(driver, districtoption, 30);
        districtoption.click();
        submit.click();

        //Enter Username and password
        username.sendKeys(ReadPropertyfile.getObject("username"));
        password.sendKeys(ReadPropertyfile.getObject("password"));
        signin.click();

        //Wait for title
        WebDriverUtility.waitForTitle(driver, 60, "Dashboard");

        //Broken links
        broken = new BrokenLinksUtility(driver);
        String urlToCheck = ReadPropertyfile.getObject("brokLogin");
        broken.checkBrokenLinks(urlToCheck);

        //Assertion for title
        String expectedTitle = "Dashboard - HMH Ed";
        AssertionUtils.assertPageTitle(driver, expectedTitle, "Page title doesn't match expected title");

    }
}
