package org.KsushaS.Tmetric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpToTmetric {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private long DEFAULT_TIMEOUT = 1;

    protected static final String EMAIL = "Email";
    protected static final String PASSWORD = "Password";
    protected static final String CONFIRMPASSWORD = "ConfirmPassword";
    protected static final String AGREE = "AgreeToTerms";
    protected static final String REGISTER = "//input[@type='submit']";
    protected static final String LOGIN = "Login";
    protected static final String SIGN_UP_TO_TMETRIC = "//h3[contains(@class,'login-form-title')]";
    protected static final String AGREE_TO = "//span[text()='Agree to']";
    protected static final String TERMS_OF_SERVICE ="//a[text()='Terms of Service']";
    protected static final String AND = "//span[text()='and']";
    protected static final String PRIVACY_POLICY = "//a[text()='Privacy Policy']";
    protected static final String ALREADY_USE_TMETRIC = "//div[contains(@class,'auth-bottom-text')]";

    public SignUpToTmetric(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, DEFAULT_TIMEOUT);
    }

    public String getPageSignUpToTmetric() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(SIGN_UP_TO_TMETRIC))).getText();
    }

    public String getAgreeTo(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AGREE_TO))).getText();
    }

    public String getTermsOfService(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TERMS_OF_SERVICE))).getText();
    }

    public String getAnd(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(AND))).getText();
    }

    public String getPrivacyPolicy(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PRIVACY_POLICY))).getText();
    }

    public String getAlreadyUseTmetric(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ALREADY_USE_TMETRIC))).getText();
    }

    public Register register(String email, String password, String confirmPassword) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(EMAIL))).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(PASSWORD))).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(CONFIRMPASSWORD))).sendKeys(confirmPassword);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(AGREE))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(REGISTER))).click();
        return new Register(driver);
    }

    public LoginToTmetric loginToTmetric() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(LOGIN))).click();
        return new LoginToTmetric(driver);
    }


}
