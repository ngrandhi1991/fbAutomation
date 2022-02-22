package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    ElementFetch elementFetch = new ElementFetch();

    public void getLoginUserCredentialsDetails(String un, String pwd, String captcha) {
        elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTNAME, Constants.LoginPage.USERNAME_BY_NAME).sendKeys(un);
        elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTNAME, Constants.LoginPage.PASSWORD_BY_NAME).sendKeys(pwd);
        elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTNAME, Constants.LoginPage.CAPTCHA_BY_NAME).sendKeys(captcha);

        elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.LoginPage.LOGIN_BTN_BY_ID).click();
    }
    public void performLogout() {
        Actions actions = new Actions(TestBase.driver);

        WebElement profileIcon = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.LoginPage.PROFILEICON_BY_ID);
        actions.moveToElement(profileIcon).click().perform();
        TestBase.wait.until(ExpectedConditions.visibilityOf(profileIcon));

        WebElement logout = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.LoginPage.LOGOUT_BY_XPATH);
        TestBase.wait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
    }
    public void performChangePassword() {
        Actions actions = new Actions(TestBase.driver);

        WebElement profileIcon = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.LoginPage.PROFILEICON_BY_ID);
        actions.moveToElement(profileIcon).click().perform();
        TestBase.wait.until(ExpectedConditions.visibilityOf(profileIcon));


        WebElement changePassword = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.LoginPage.CHANGEPASSWORD_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(changePassword));
        changePassword.click();

    }
}


