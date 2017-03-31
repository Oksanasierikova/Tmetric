package org.KsushaS.Tmetric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginToTmetric extends SignUpToTmetric {
    protected static final String LOGIN_TO_TMETRIC = "//h3[contains(@class,'login-form-title')]";
    protected static final String REMEMBER_ME = "//span[contains(text(),'Remember me')]";
    protected static final String NEVER_USED_TMETRIC_BEFORE = "//div[contains(text(),'Never used TMetric before?')]";

    public LoginToTmetric(WebDriver driver) {
        super(driver);
    }

    public String getPageLoginToTmetric() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LOGIN_TO_TMETRIC))).getText();
    }

    public String getRememberMe() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REMEMBER_ME))).getText();
    }

    public String getForgotPassword() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot your password?"))).getText();
    }

    public String getNeverUsedTmetricBefore() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(NEVER_USED_TMETRIC_BEFORE))).getText();
    }

    public SignUpToTmetric signUp() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign Up"))).click();
        return new SignUpToTmetric(driver);
    }

    public LogIn logIn(String email, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Username"))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password"))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rememberMe"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login"))).click();
        return new LogIn(driver);
    }

    public ForgotYourPassword forgotYourPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Forgot your password?"))).click();
        return new ForgotYourPassword(driver);
    }


}
