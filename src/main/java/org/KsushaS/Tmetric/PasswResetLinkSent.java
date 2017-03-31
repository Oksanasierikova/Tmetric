package org.KsushaS.Tmetric;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PasswResetLinkSent extends ForgotYourPassword {
    protected  static final String PASSW_RESET_LINK_SENT ="//h3[text()='Password Reset Link Sent']";
    protected  static final String MESSAGE_PASSW_RESET ="//p[contains(text(), 'sent you')]";

    public PasswResetLinkSent(WebDriver driver) {
        super(driver);
    }

    public String passwResetLinkSentMain(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(PASSW_RESET_LINK_SENT))).getText();
    }

    public String messagePasswResetLink(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE_PASSW_RESET))).getText();
    }
}
