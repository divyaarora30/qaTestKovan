package com.kovan.testcases;

import com.kovan.pages.BrowserSetup;
import com.kovan.pages.HomePage;
import com.kovan.pages.SearchResultPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Test case: Go to Homepage > Search for transaction > verify Blocks confirmed is Not less than or equal to 10
 * Expected Result: Transaction is confirmed
 */

public class TestCaseTwo extends BrowserSetup {
    @Parameters("browser")
    @Test
    public void executeSecondTestCase(@Optional("") String browser) throws Exception {
        BrowserSetup browserSetup = new BrowserSetup();

        WebDriver driver = browserSetup.setup(browser);

        HomePage homePage = new HomePage(driver);
        SearchResultPage searchResultPage = new SearchResultPage(driver);

        homePage.goToHomePage();
        homePage.enterTransactionHash("0x962fee22265e3945a2b497cc5afc0b1cab18f6212eca6d00136c6e3be4fb95f6");
        homePage.clickGoBtn();

        searchResultPage.verifySearchResult("0x962fee22265e3945a2b497cc5afc0b1cab18f6212eca6d00136c6e3be4fb95f6");
        searchResultPage.verifyTransactionConfirmed();

        driver.quit();
    }

}


