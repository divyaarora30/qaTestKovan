package com.kovan.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class AbstractPage {

    protected final WebDriver driver;
    protected JavascriptExecutor executor;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        executor = (JavascriptExecutor) driver;
        // Initialise Elements
        PageFactory.initElements(driver, this);
    }

    public void waitFor(long timeInMillis) throws InterruptedException {
        Thread.sleep(timeInMillis);
    }

}
