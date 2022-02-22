package com.fbmachine.qa.util;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 420;
    public static long IMPLICIT_WAIT = 420;
    public static long EXPLICIT_WAIT = 420;

    public static class CommonMethod {
        ElementFetch elementFetch = new ElementFetch();

        public String checkErrorAndValidationMsg(String identifierType) {
            switch (identifierType) {
                case "LOGIN":
                    WebElement loginErrorElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.LoginPage.LOGINERROR_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(loginErrorElement));
                    return loginErrorElement.getText();
                case "WELCOMEMSG":
                    Actions actions = new Actions(TestBase.driver);
                    WebElement profileIcon = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.LoginPage.PROFILEICON_BY_ID);
                    actions.moveToElement(profileIcon).click().perform();
                    TestBase.wait.until(ExpectedConditions.visibilityOf(profileIcon));
                    return profileIcon.getAttribute("alt");
                case "CREATEUSER":
                    WebElement createUserErrorElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.CreateUserPage.ERRORMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(createUserErrorElement));
                    return createUserErrorElement.getText();
                case "EDITUSER":
                    WebElement editUserErrorElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.EditUserPage.ERRORMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(editUserErrorElement));
                    return editUserErrorElement.getText();
                case "ADSETTEMPLATE":
                    WebElement adSetTemplateCreationElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTCLASS, Constants.TemplateAdSetPage.TEMPLATENMSG_BY_CLASSNAME);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(adSetTemplateCreationElement));
                    return adSetTemplateCreationElement.getText();
                case "ADSTEMPLATE":
                    WebElement adsTemplateCreationElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTCLASS, Constants.TemplateAdsPage.MESSAGE_BY_CLASS);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(adsTemplateCreationElement));
                    return adsTemplateCreationElement.getText();
                case "AUTOADSTEMPLATE":
                    WebElement autoAdsTemplateCreationElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTCLASS, Constants.TemplateAutoAdsPage.MESSAGE_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(autoAdsTemplateCreationElement));
                    return autoAdsTemplateCreationElement.getText();
                case "IMAGEUPLOAD":
                    WebElement imgUploadMsgElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.IMAGEMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(imgUploadMsgElement));
                    return imgUploadMsgElement.getText();
                case "VIDEOUPLOAD":
                    WebElement videoUploadMsgElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.VIDEOMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(videoUploadMsgElement));
                    return videoUploadMsgElement.getText();
                case "ADSETCREATION":
                    WebElement adSetCreationMsgElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.ADSETMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(adSetCreationMsgElement));
                    return adSetCreationMsgElement.getText();
                case "ADCREATION":
                    WebElement adsCreationMsgElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.ADSMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(adsCreationMsgElement));
                    return adsCreationMsgElement.getText();
                case "ADCREATIVE":
                    WebElement adCreativeMsgElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.AdsCreationPage.ADCREATIVEMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(adCreativeMsgElement));
                    return adCreativeMsgElement.getText();
                case "NOBOOK":
                    WebElement noBook = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.SearchPage.NOBOOKMSG_BY_XPATH);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(noBook));
                    return noBook.getText();
                case "SEARCH":
                    WebElement searchElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.SearchPage.VALIDMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(searchElement));
                    return searchElement.getText();
                case "ADCREATIONLAUNCH":
                    WebElement adCreationWindow = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.SearchPage.ADCREATIONWINDOW_BY_XPATH);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(adCreationWindow));
                    return adCreationWindow.getText();
                case "ADSETPROMO":
                    WebElement promoAdSetMsg = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.ADSETMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(promoAdSetMsg));
                    return promoAdSetMsg.getText();
                case "ADPROMO":
                    WebElement promoAdMsg = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.ADMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(promoAdMsg));
                    return promoAdMsg.getText();
                case "ADCREATIVEPROMO":
                    WebElement promoAdCreativeMsg = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.ADCREATIVEMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(promoAdCreativeMsg));
                    if (promoAdCreativeMsg.getText().isEmpty()) {
                        Log.info("No message to display in Ad creative");
                    }
                    return promoAdCreativeMsg.getText();
                case "IMGPROMO":
                    WebElement imgMsg = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.PromoPage.IMGMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(imgMsg));
                    return imgMsg.getText();
                case "VIDEOPROMO":
                    WebElement videoMsg = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.PromoPage.VIDEOMSG_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(videoMsg));
                    return videoMsg.getText();
                default:
                    return null;
            }
        }

        public String checkAndValidateValue(String identifierType) {
            switch (identifierType) {
                case "CONVERSIONSETTING":
                    WebElement conversionSetting = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.CONVERSION_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(conversionSetting));
                    return conversionSetting.getAttribute("value");
                case "PLACEMENT":
                    WebElement placement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.PLACEMENT_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(placement));
                    return placement.getAttribute("value");
                case "OPTIMIZATION":
                    WebElement optimization = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.OPTIMIZATION_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(optimization));
                    return optimization.getAttribute("value");
                case "CONVERSIONTRACKING":
                    WebElement conversionTracking = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.CONVERSION_TRACKING_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(conversionTracking));
                    return conversionTracking.getAttribute("value");
                case "BOOKID":
                    WebElement bookId = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.SearchPage.BOOKID_BY_XPATH);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(bookId));
                    return bookId.getText();
                case "BOOKISBN":
                    WebElement bookIsbn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.SearchPage.BOOKISBN_BY_XPATH);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(bookIsbn));
                    return bookIsbn.getText();
                case "SELECTFILE":
                    WebElement selectFileText = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.FILESTATUS_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(selectFileText));
                    return selectFileText.getText();
                case "CAMPAIGNNAME":
                    WebElement campaignName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.CAMPAIGNNAMEINPUT_BY_XPATH);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(campaignName));
                    return campaignName.getAttribute("value");
                default:
                    return null;
            }
        }

        public void clickBtn(String identifierType) {
            switch (identifierType) {
                case "CREATEADS":
                    WebElement createAds = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.SearchPage.CREATEAD_BY_XPATH);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(createAds));
                    createAds.click();
                    break;
                case "PUBLISH":
                    WebElement publishBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.PUBLISH_BTN_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(publishBtn));
                    publishBtn.click();
                    break;
                case "PUBLISHPROMO":
                    WebElement publishPromoBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.PUBLISHBTN_BY_ID);
                    TestBase.wait.until(ExpectedConditions.visibilityOf(publishPromoBtn));
                    publishPromoBtn.click();
                default:

            }
        }

        public String handleModalAndGetMsg(String identifiertype, String identifierValue) {
            WebElement modalText = elementFetch.getWebElement(identifiertype, identifierValue);
            TestBase.wait.until(ExpectedConditions.visibilityOf(modalText));
            return modalText.getText();
        }

        public String handleModalAndPerformAction(String identifiertype, String identifierValue) {
            WebElement modalBtn = elementFetch.getWebElement(identifiertype, identifierValue);
            TestBase.wait.until(ExpectedConditions.visibilityOf(modalBtn));
            return modalBtn.getText();
        }
    }
}


