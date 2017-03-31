package org.KsushaS.Tmetric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TmetricHome {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private long DEFAULT_TIMEOUT = 1;

    private static final String SITE_URL = "https://tmetric.com/";
    private static final String START_TRACKING = "//a[@role='button'][.//text()='Start Tracking']";

    public TmetricHome(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
        this.driver.get(SITE_URL);
    }

    public TmetricHome navigate(){
        driver.get(SITE_URL);
        return this;
    }
public SignUpToTmetric startTracking(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_TRACKING))).click();
        return new SignUpToTmetric(driver);
}

}
