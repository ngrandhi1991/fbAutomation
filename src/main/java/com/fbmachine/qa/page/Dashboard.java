package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Dashboard {
    ElementFetch elementFetch = new ElementFetch();

    public boolean isTabPresentAndClick(String identifierType, String identifierValue) throws InterruptedException {
        Thread.sleep(5000);
        WebElement tab = elementFetch.getWebElement(identifierType, identifierValue);
        TestBase.wait.until(ExpectedConditions.visibilityOf(tab));

        if (tab.isDisplayed()) {
            tab.click();
            return true;
        }
        return false;
    }

    public boolean isAccessToAdsCreated() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreatedPage.GO_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        if (element.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isTabEnabled(String identifierType, String identifierValue) throws InterruptedException {
        Thread.sleep(5000);
        WebElement tab = elementFetch.getWebElement(identifierType, identifierValue);
        TestBase.wait.until(ExpectedConditions.visibilityOf(tab));

        if (tab.isEnabled()) {
            return false;
        }
        return true;
    }
}
