package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateUserPage {
    ElementFetch elementFetch = new ElementFetch();

    public void createUser(String un, String em, String pw, String cpw) {
        WebElement username = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.USERNAME_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(un);

        WebElement email = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.EMAILID_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(email));
        email.sendKeys(em);

        WebElement password = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.PASSWORD_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(pw);

        WebElement confirmPwd = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.CONFIRMPWD_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(confirmPwd));
        confirmPwd.sendKeys(cpw);

        WebElement promoCheckbox = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.USERPROMO_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(promoCheckbox));
        if (promoCheckbox.isSelected() == false) {
            promoCheckbox.click();
        }

        WebElement createUserBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.CREATEUSER_BTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(createUserBtn));
        createUserBtn.click();
    }

}
