package com.kovan.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * This class enables the ability to run the same test on FF and Chrome or any other browser of choice.
 * Currently if no browser is provided as parameter, chrome driver is taken as default driver.
 * Any other browser configurations can be added by adding else if statements for more browsers.
 */
public class BrowserSetup {

    public WebDriver setup(String browser) {
        WebDriver driver;
        String currentDir = System.getProperty("user.dir");

        if (browser.equalsIgnoreCase("firefox")) {
            String FirefoxDriverLocation = currentDir + "/src/resource/fireFoxDriver";
            System.setProperty("webdriver.gecko.driver", FirefoxDriverLocation);
            driver = new FirefoxDriver();
            driver.switchTo().window(driver.getWindowHandle());
            driver.manage().window().maximize();
            return driver;
        } else if (browser.equalsIgnoreCase("chrome")) {
            String chromeDriverLocation = currentDir + "/src/resource/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
            driver = new ChromeDriver();
            driver.switchTo().window(driver.getWindowHandle());
            driver.manage().window().maximize();
            return driver;
        } else { //default browser is chrome if not given any parameter
            String chromeDriverLocation = currentDir + "/src/resource/chromedriver";
            System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
            driver = new ChromeDriver();
            driver.switchTo().window(driver.getWindowHandle());
            driver.manage().window().maximize();
            return driver;
        }
    }

}
