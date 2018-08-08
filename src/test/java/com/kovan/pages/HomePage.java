package com.kovan.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * This class includes functions related to home page, https://kovan.etherscan.io/
 */

public class HomePage extends AbstractPage {

    public static final Logger Log = Logger.getLogger(HomePage.class);
    @FindBy(id = "txtSearchInput")
    private WebElement inputField;
    @FindBy(className = "btn-u")
    private WebElement goBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.navigate().to("https://kovan.etherscan.io/");
        Log.info("Navigated to Home page");
    }

    public void enterTransactionHash(String transactionHash) throws InterruptedException {
        waitFor(3000);
        inputField.click();
        inputField.sendKeys(transactionHash);
        Log.info("Entered Transaction Hash: " + transactionHash);
    }

    public void clickGoBtn() throws InterruptedException {
        waitFor(3000);
        goBtn.click();
        Log.info("Clicked on Go Button");
    }

}