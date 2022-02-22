package com.fbmachine.qa.util;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.constants.Constants.IDENTIFIER;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementFetch {

    public WebElement getWebElement(String identifierType, String identifierValue) {
        switch (identifierType) {
            case IDENTIFIER.WEBELEMENTID:
                return TestBase.driver.findElement(By.id(identifierValue));
            case IDENTIFIER.WEBELEMENTTAGNAME:
                return TestBase.driver.findElement(By.tagName(identifierValue));
            case IDENTIFIER.WEBELEMENTXPATH:
                return TestBase.driver.findElement(By.xpath(identifierValue));
            case IDENTIFIER.WEBELEMENTNAME:
                return TestBase.driver.findElement(By.name(identifierValue));
            case IDENTIFIER.WEBELEMENTCLASS:
                return TestBase.driver.findElement(By.className(identifierValue));
            default:
                return null;
        }
    }

    public List<WebElement> getListWebElements(String identifierType, String identifierValue) {
        switch (identifierType) {
            case "ID":
                return TestBase.driver.findElements(By.id(identifierValue));
            case "TAGNAME":
                return TestBase.driver.findElements(By.tagName(identifierValue));
            case "XPATH":
                return TestBase.driver.findElements(By.xpath(identifierValue));
            case "NAME":
                return TestBase.driver.findElements((By.name(identifierValue)));
            case "CLASS":
                return TestBase.driver.findElements(By.className(identifierValue));
            default:
                return null;
        }
    }
}
