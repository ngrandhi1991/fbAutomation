package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

public class PromoAdsPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void validateAndVerifyDefaultFileStatus() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        String actualValue = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.SELECTFILE);
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDFILESTATUSTEXT);
        Log.info("Default file upload status is " + actualValue);

        softAssert.assertEquals(actualValue, expectedValue, "Default file upload status is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyValidationMsgForVideoTimeLimit() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        Log.info("User is uploading video");
        FbMachineUIActions.uploadImageOrVideo();

        String actualAlertMsg = commonMethod.handleModalAndGetMsg(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALTEXT_BY_XPATH);
        commonMethod.handleModalAndPerformAction(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALBTN_BY_XPATH);

        String expectedAlertMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCHOOSEFILEMSG);
        Log.info("Message displayed is " + actualAlertMsg);

        softAssert.assertEquals(actualAlertMsg, expectedAlertMsg, "Message displayed is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyImageOrVideoUpload() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        Log.info("User is uploading video");
        FbMachineUIActions.uploadImage();

        String actualValue = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.SELECTFILE);
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDFILESTATUSTEXT1);
        Log.info("file upload status is " + actualValue);

        softAssert.assertEquals(actualValue, expectedValue, "file upload status is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void getCampaignOfPromoUser() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        Log.info("User is trying to fetch Campaign Name");
        String actualCampaignName = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.CAMPAIGNNAME);

        if (actualCampaignName.isEmpty()) {
            Log.info("There is no selected campaign. It might be drop down for campaign is present ");
        } else {
            Log.info("Campaign used for Promo user is :- " + actualCampaignName);
        }
    }

    @Test(priority = 5)
    public void verifyValidationMsgForImageOrVideoUpload() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        Log.info("Selecting Ad Sets template");
        FbMachineUIVerify.selectAdSetTemplateInAds(Constants.PropertiesFileConstants.ADSETTEMPLATE);

        Log.info("Selecting Ads template");
        FbMachineUIVerify.selectAdsTemplateInAds(Constants.PropertiesFileConstants.PROMOADSTEMPLATE);

        Log.info("User is publish a Promo Ads");
        commonMethod.clickBtn(Constants.IDENTIFIER.PUBLISHPROMO);

        String actualAlertMsg = commonMethod.handleModalAndGetMsg(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALTEXT_BY_XPATH);
        commonMethod.handleModalAndPerformAction(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALBTN_BY_XPATH);

        String expectedAlertMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDFILESTATUSTEXT2);
        Log.info("Message displayed is :- " + actualAlertMsg);

        softAssert.assertEquals(actualAlertMsg, expectedAlertMsg, "Message displayed is not as required");
        softAssert.assertAll();

    }

    @Test(priority = 6)
    public void verifyValidationMsgForValidUrl() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        Log.info("User is uploading video");
        FbMachineUIActions.uploadImage();

        Log.info("Selecting Ad Sets template");
        FbMachineUIVerify.selectAdSetTemplateInAds(Constants.PropertiesFileConstants.ADSETTEMPLATE);

        Log.info("Selecting Ads template");
        FbMachineUIVerify.selectAdsTemplateInAds(Constants.PropertiesFileConstants.PROMOADSTEMPLATE);

        Log.info("Providing an URL");
        FbMachineUIActions.addUrl(prop.getProperty(Constants.PropertiesFileConstants.URL1));

        Log.info("User is publish a Promo Ads");
        commonMethod.clickBtn(Constants.IDENTIFIER.PUBLISHPROMO);

        String actualAlertMsg = commonMethod.handleModalAndGetMsg(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALTEXT_BY_XPATH);
        commonMethod.handleModalAndPerformAction(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALBTN_BY_XPATH);

        String expectedAlertMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDVALIDATIONMSGFORPROMO);
        Log.info("Message displayed is :- " + actualAlertMsg);

        softAssert.assertEquals(actualAlertMsg, expectedAlertMsg, "Message displayed is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void createPromoAds() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIVerify.isPageLoaded();

        Log.info("User is uploading video");
        FbMachineUIActions.uploadImage();

        Log.info("Selecting Ad Sets template");
        FbMachineUIVerify.selectAdSetTemplateInAds(Constants.PropertiesFileConstants.ADSETTEMPLATE);

        Log.info("Selecting Ads template");
        FbMachineUIVerify.selectAdsTemplateInAds(Constants.PropertiesFileConstants.PROMOADSTEMPLATE);

        Log.info("Providing an URL");
        FbMachineUIActions.addUrl(prop.getProperty(Constants.PropertiesFileConstants.URL2));

        Log.info("User is publish a Promo Ads");
        commonMethod.clickBtn(Constants.IDENTIFIER.PUBLISHPROMO);

        String expectedImgUploadMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDIMGUPLOADMSGPROMO);
        String actualImageUploadMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.IMAGEUPLOAD);
        Log.info("Validation message for Image Upload is :- " + actualImageUploadMsg);
        softAssert.assertEquals(actualImageUploadMsg,expectedImgUploadMsg,"Validation message is not as required");

        String expectedVidepUploadMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDVIDEOUPLOADMSGPROMO);
        String actualVideoUploadMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.VIDEOUPLOAD);
        Log.info("Validation message for Image Upload is :- " + actualImageUploadMsg);
        softAssert.assertEquals(actualVideoUploadMsg,expectedVidepUploadMsg,"Validation message is not as required");

        String expectedAdSetMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETCREATIONMSG);
        String actualAdSetMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.PROMOADSETCREATION);
        Log.info("Validation message for Ad Set creation is :-" + actualAdSetMsg);
        softAssert.assertEquals(actualAdSetMsg, expectedAdSetMsg, "Ad Set is not created successfully");

        /*String expectedAdCreativeMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADCREATIVEMSG);
        String actualAdCreativeMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADCREATIVE);
        Log.info("Validation message for Ad Creative creation is :-" +actualAdCreativeMsg);
        softAssert.assertEquals(actualAdCreativeMsg,expectedAdCreativeMsg,"Ad Creative is not created successfully");*/

        String expectedAdsMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADCRESTIONMSG);
        String actualAdsMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADCREATION);
        Log.info("User is trying to publish an Ads.Status is :- " + actualAdsMsg);
        softAssert.assertEquals(actualAdsMsg, expectedAdsMsg, "Ads is not created successfully");

        String actualAlertMsg = commonMethod.handleModalAndGetMsg(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.MODALTEXT_BY_XPATH);
        String expectedAlertMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDVALIDATIONMSGFORPROMO1);
        Log.info("Message displayed is :- " + actualAlertMsg);
        softAssert.assertEquals(actualAlertMsg, expectedAlertMsg, "Message displayed is not as required");

        softAssert.assertAll();
    }
}
