package com.fbmachine.qa.testcases;

import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

import java.util.logging.Logger;

import com.fbmachine.qa.base.TestBase;

public class AdsPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void validateAndVerifyValueInFacebookPage() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("Facebook Page id present in the system are :");
        FbMachineUIVerify.validateValueInFacebookPage();
    }

    @Test(priority = 2)
    public void validateAndVerifyValueInInstaPage() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("Instagram Page id present in the system are :");
        FbMachineUIVerify.validateValueInInstaPage();
    }

    @Test(priority = 3)
    public void verifyValueInDynamicCreative() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("Option for Dynamic Creative is");
        FbMachineUIActions.valueOfDynamicCreativeInAds();
    }

    @Test(priority = 4)
    public void verifyAndValidateValueInOptimizeCreative() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("Option for Optimize Creative is");
        FbMachineUIActions.valueOfOptimizeCreativeInAds();
    }

    @Test(priority = 5)
    public void validateAndVerifyConversionTracking() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is verifying value of Conversion Tracking");
        String actualValue = commonMethod.checkAndValidateValue("CONVERSIONTRACKING");
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCONVERSIONTRACKING);

        Log.info("Value of Conversion Tracking is " + actualValue);

        softAssert.assertEquals(actualValue, expectedValue, "Conversion tracking value is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void createAndVerifyAdsTemplateWithDCOff() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE2));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1));
        }

        FbMachineUIActions.createAdsTemplateWithDCNo(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("User is trying to create an Ad Set template. Status of template is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Template is not created successfully");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void verifyAndValidateMessageForCallToActionWithDCOff() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE2));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCNo(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION2)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCALLTOACTIONMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation message for Call To Action is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation message for Call To Action is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void verifyAndValidatePrimaryTextWithDcOff() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE2));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCNo(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDPRIMARYTEXTMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation for at least one Primary Text is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation for atleast one Primary Text is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void verifyAndValidateHeadlineWithDCOff() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE2));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCNo(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDHEADLINEMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation for at least one Headline is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation for atleast one Headline is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void editExistingAdsTemplateWithDCOff() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE2));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1));
            FbMachineUIActions.editAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1));

            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

            Log.info("User is trying to edit Ads template.Status of template is " + actualText);

            softAssert.assertEquals(actualText, expectedText, "Template is not edited successfully");
        } else {
            Log.info("Template doesn't exist");
        }
        softAssert.assertAll();
    }


    @Test(priority = 11)
    public void deleteAndVerifyAdsWithDCOff() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE2));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME1));

            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETDELETIONMSG);
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

            Log.info("User is trying to delete an Ads template.Status of template is " + actualText);

            softAssert.assertEquals(actualText, expectedText, "Template is not deleted successfully");
        } else {
            Log.info("Template doesn't exist");
        }
        softAssert.assertAll();
    }

    @Test(priority = 12)
    public void createAndVerifyAdsTemplateWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3));
        }

        FbMachineUIActions.createAdsTemplateWithDCOn(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT2),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE2),
                prop.getProperty(Constants.PropertiesFileConstants.DESCRIPTION),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("User is trying to create an Ad Set template. Status of template is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Template is not created successfully");
        softAssert.assertAll();
    }

    @Test(priority = 13)
    public void verifyAndValidateMessageForCallToActionWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCOn(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT2),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE2),
                prop.getProperty(Constants.PropertiesFileConstants.DESCRIPTION),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION2)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCALLTOACTIONMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation message for Call To Action is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation message for Call To Action is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 14)
    public void verifyAndValidatePrimaryTextWithDcOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCOn(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE2),
                prop.getProperty(Constants.PropertiesFileConstants.DESCRIPTION),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDPRIMARYTEXTMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation for at least one Primary Text is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation for atleast one Primary Text is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 15)
    public void verifyAndValidateHeadlineWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCOn(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT2),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE),
                prop.getProperty(Constants.PropertiesFileConstants.DESCRIPTION),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDHEADLINEMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation for at least one Headline is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation for atleast one Headline is not as required");
        softAssert.assertAll();
    }


    @Test(priority = 16)
    public void verifyAndValidateUniquePrimaryTextValueWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCOn(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE2),
                prop.getProperty(Constants.PropertiesFileConstants.DESCRIPTION),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDUNIQUEPRIMARYTEXT);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation for at least one PrimaryText is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation for atleast one Headline is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 17)
    public void verifyAndValidateUniqueHeadlineValueWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2));
        }

        FbMachineUIActions.createAdsTemplateWithDCOn(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.FACEBOOKPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.INSTAPAGE),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT1),
                prop.getProperty(Constants.PropertiesFileConstants.PRIMARYTEXT2),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.HEADLINE1),
                prop.getProperty(Constants.PropertiesFileConstants.DESCRIPTION),
                prop.getProperty(Constants.PropertiesFileConstants.CALLTOACTION1)
        );

        String expectedText =prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDUNIQUEHEADLINETEXT);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

        Log.info("Validation for at least one Headline is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation for atleast one Headline is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 18)
    public void editExistingAdsTemplateWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3));
            FbMachineUIActions.editAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3));

            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

            Log.info("User is trying to edit Ads template.Status of template is " + actualText);

            softAssert.assertEquals(actualText, expectedText, "Template is not edited successfully");
        } else {
            Log.info("Template doesn't exist");
        }
        softAssert.assertAll();
    }


    @Test(priority = 19)
    public void deleteAndVerifyAdsWithDCOn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting value for Dynamic Creative");
        FbMachineUIActions.selectDynamicCreative(prop.getProperty(Constants.PropertiesFileConstants.DYNAMICCREATIVE1));

        if (FbMachineUIActions.isAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3));
            FbMachineUIActions.deleteAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.ADSNAME3));

            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETDELETIONMSG);
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSTEMPLATE);

            Log.info("User is trying to delete an Ads template.Status of template is " + actualText);

            softAssert.assertEquals(actualText, expectedText, "Template is not deleted successfully");
        } else {
            Log.info("Template doesn't exist");
        }
        softAssert.assertAll();
    }

}
