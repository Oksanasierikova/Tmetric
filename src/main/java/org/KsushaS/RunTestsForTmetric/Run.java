package org.KsushaS.RunTestsForTmetric;

import org.KsushaS.BaseWebDriverTest;
import org.KsushaS.Tmetric.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Run extends BaseWebDriverTest {

    @Test(enabled = true)
    public void openSignUpToTmetricPage() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking();
        softAssert.assertTrue(tmetric.getPageSignUpToTmetric().contains("Sign Up to TMetric"));
        softAssert.assertTrue(tmetric.getAgreeTo().contentEquals("Agree to"));
        softAssert.assertTrue(tmetric.getTermsOfService().contentEquals("Terms of Service"));
        softAssert.assertTrue(tmetric.getAnd().contentEquals("and"));
        softAssert.assertTrue(tmetric.getPrivacyPolicy().contentEquals("Privacy Policy"));
        softAssert.assertTrue(tmetric.getAlreadyUseTmetric().contains("Already use TMetric? "));
    }

    @DataProvider(name = "signUp")
    public Object[][] signUp() {
        return new Object[][]{
                {"test11@mail.ru", "test11test", "test11test"},
                {"test12@mail.ru", "test12test", "test12test"}
        };
    }

    @Test(enabled = true, dataProvider = "signUp")
    public void checkRegister(String email, String password, String confirmPassword) {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking();
        tmetric.register(email, password, confirmPassword);
        Register register = new Register(driver);
        softAssert.assertTrue(register.getPageStartWork().contains("No work time is recorded for this day."));
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void clickLinkLogin() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking();
        tmetric.loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver);
        softAssert.assertTrue(loginToTmetric.getPageLoginToTmetric().contains("Login to TMetric"));
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void openLoginToTmetricPage() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking().loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver);
        softAssert.assertTrue(loginToTmetric.getRememberMe().contains("Remember me"));
        softAssert.assertTrue(loginToTmetric.getForgotPassword().contains("Forgot your password?"));
        softAssert.assertTrue(loginToTmetric.getNeverUsedTmetricBefore().contains("Never used TMetric before?"));
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void checkLogin() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking().loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver);
        loginToTmetric.logIn("test11@mail.ru", "test11test");
        LogIn logIn = new LogIn(driver);
        softAssert.assertTrue(logIn.getPageStartWork().contains("No work time is recorded for this day."));
        softAssert.assertAll();

    }

    @Test(enabled = true)
    public void clickSignUpFromLoginToTmetricPage() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking().loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver);
        loginToTmetric.signUp();
        softAssert.assertTrue(tmetric.getPageSignUpToTmetric().contains("Sign Up to TMetric"));
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void clickForgotYourPassword() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking().loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver);
        loginToTmetric.forgotYourPassword();
        ForgotYourPassword forgotYourPassword = new ForgotYourPassword(driver);
        softAssert.assertTrue(forgotYourPassword.getForgotYourPassword().contains("Forgot your password?"));
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void checkForgotYourPasswordPage() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking().loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver);
        loginToTmetric.forgotYourPassword();
        ForgotYourPassword forgotYourPassword = new ForgotYourPassword(driver);
        softAssert.assertTrue(forgotYourPassword.getForgotYourPassword().contains("Forgot your password?"));
        softAssert.assertTrue(forgotYourPassword.getEnterYourEmail().contains("Enter your email and we'll send you a reset link."));
        softAssert.assertTrue(forgotYourPassword.getBackToLogin().contains("Back to Login"));
        forgotYourPassword.backToLogin();
        softAssert.assertTrue(loginToTmetric.getPageLoginToTmetric().contains("Login to TMetric"));
        softAssert.assertAll();
    }

    @Test(enabled = true)
    public void checkForgotYourPasswordPageSentResetLink() {
        SignUpToTmetric tmetric = new TmetricHome(driver).navigate().startTracking().loginToTmetric();
        LoginToTmetric loginToTmetric = new LoginToTmetric(driver).forgotYourPassword();
        ForgotYourPassword forgotYourPassword = new ForgotYourPassword(driver).passwResetLinkSent("test11@mail.ru");;
        PasswResetLinkSent passwResetLinkSent = new PasswResetLinkSent(driver);
        softAssert.assertTrue(passwResetLinkSent.passwResetLinkSentMain().contains("Password Reset Link Sent"));
        softAssert.assertTrue(passwResetLinkSent.messagePasswResetLink().contains("We've sent you a password reset link. Please check your inbox and reset your password."));
        softAssert.assertAll();
    }


}
