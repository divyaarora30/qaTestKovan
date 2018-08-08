package com.kovan.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * This class includes functions related to search result page
 */

public class SearchResultPage extends AbstractPage {

    public static final Logger Log = Logger.getLogger(SearchResultPage.class);
    @FindBy(id = "tx")
    private WebElement txHash;
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_maintable']/div[8]/a")
    private WebElement fromLink;
    @FindBy(xpath = "//*[@id='ContentPlaceHolder1_maintable']/div[10]/a")
    private WebElement toLink;
    @FindBy(xpath = "//span[@title='No of Blocks Mined Since']")
    private List<WebElement> blockConfirmations;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void verifySearchResult(String expectedTxHash) throws InterruptedException {
        waitFor(3000);
        String txHashtext = txHash.getText();
        Assert.assertEquals("Transaction not found", txHashtext, expectedTxHash);
        Log.info("Search Result page shows");
    }

    public void clickFromLink() throws InterruptedException {
        fromLink.click();
        Log.info("Clicked on From Link");
    }

    public void verifyFromLinkNotBroken() throws IOException {
        URL fromUrl = new URL(driver.getCurrentUrl());
        HttpsURLConnection fromConnection = (HttpsURLConnection) fromUrl.openConnection();
        fromConnection.setRequestMethod("GET");
        fromConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
        fromConnection.connect();
        int fromResponse = fromConnection.getResponseCode();
        Assert.assertEquals("Broken URL", 200, fromResponse);
        Log.info("From Link is not broken and status code is: " + fromResponse);
    }

    public void clickBrowserBackBtn() {
        driver.navigate().back();
        Log.info("Back to search result page");
    }

    public void clickToLink() throws InterruptedException {
        waitFor(3000);
        toLink.click();
        Log.info("Clicked on To Link");
    }

    public void verifyToLinkNotBroken() throws IOException {
        URL toUrl = new URL(driver.getCurrentUrl());
        HttpsURLConnection toConnection = (HttpsURLConnection) toUrl.openConnection();
        toConnection.setRequestMethod("GET");
        toConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.84 Safari/537.36");
        toConnection.connect();
        int toResponse = toConnection.getResponseCode();
        Assert.assertEquals("Broken URL", 200, toResponse);
        Log.info("To Link is not broken and status code is: " + toResponse);
    }

    public void verifyTransactionConfirmed() {
        String blockConfirmationsText = blockConfirmations.get(0).getText();
        String blocksConfirmed = blockConfirmationsText.replaceAll("[^0-9]+", "");
        if (!(Integer.parseInt(blocksConfirmed) <= 10))
            Log.info("Transaction is confirmed. Number of block confirmations: " + blocksConfirmed);
        else
            Log.info("Transaction NOT confirmed. Number of block confirmations: " + blocksConfirmed);
    }

}
