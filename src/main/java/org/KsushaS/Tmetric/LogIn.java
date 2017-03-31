package org.KsushaS.Tmetric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogIn extends LoginToTmetric {
    protected static final String START_WORK = "//div[contains(@class,'well')]";

    public LogIn(WebDriver driver) {
        super(driver);
    }

    public String getPageStartWork() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(START_WORK))).getText();
    }
}
