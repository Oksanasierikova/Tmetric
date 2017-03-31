package org.KsushaS.Tmetric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ForgotYourPassword extends LoginToTmetric {
    protected static final String FORGOT_YOUR_PASSWORD = "//h3[text()='Forgot your password?']";
    protected static final String ENTER_YOUR_EMAIL = "//p[contains(text(),'Enter your email')]";
    //protected static final String EMAIL = "//input[@id='Email']";
    protected static final String SUBMIT ="//input[@type='submit']";

    public ForgotYourPassword(WebDriver driver) {
        super(driver);
    }

    public String getForgotYourPassword() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FORGOT_YOUR_PASSWORD))).getText();
    }

    public String getEnterYourEmail() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ENTER_YOUR_EMAIL))).getText();
    }

    public String getBackToLogin() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to Login"))).getText();
    }

    public LoginToTmetric backToLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Back to Login"))).click();
        return new LoginToTmetric(driver);
    }

    public PasswResetLinkSent passwResetLinkSent(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SUBMIT))).click();
        return new PasswResetLinkSent(driver);
    }
}
