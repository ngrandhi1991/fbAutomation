package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AutoAdsPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void validateAndVerifyValueInNightMode() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAutoAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIActions.valueOfNightModeInAutoAds();
    }


   /* @Test(priority = 2)
    public void validateAndVerifyValueInFormat() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAutoAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIActions.valueOfFormatInAutoAds();
    }*/

    @Test(priority = 3)
    public void createAndVerifyAutoAdsTemplate() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAutoAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        if (FbMachineUIVerify.isAutoAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1))) {
            FbMachineUIVerify.selectAutoAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));
            FbMachineUIActions.deleteAutoAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));
        }

        Log.info("User is creating an Auto Ads Template");
        FbMachineUIActions.createAutoAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1),
                prop.getProperty(Constants.PropertiesFileConstants.NIGHTMODE),
                prop.getProperty(Constants.PropertiesFileConstants.ACTIVEADSET),
                prop.getProperty(Constants.PropertiesFileConstants.ACTIVEADSETSEQ));

        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.AUTOADSTEMPLATE);
        if (actualText.equals(prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG))) {
            Log.info("Message displayed is :" + actualText);
        } else {
            Log.info("Message displayed is :" + actualText);
        }
    }

    @Test(priority = 4)
    public void editAndVerifyExistingAutoAdsTemplate() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAutoAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        if (FbMachineUIVerify.isAutoAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1))) {
            FbMachineUIVerify.selectAutoAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));
            FbMachineUIActions.editAutoAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1),
                    prop.getProperty(Constants.PropertiesFileConstants.ACTIVEADSET1));

            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.AUTOADSTEMPLATE);
            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);

            Log.info("Status of template is " + actualText);

            softAssert.assertEquals(actualText, expectedText, "Template is not edited successfully");
        } else {
            Log.info("Template does not exist");
        }
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void activateAndVerifyAutoAdsTemplate() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Auto Ads");
        FbMachineUIActions.navigateToAutoAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        if (FbMachineUIVerify.isAutoAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1))) {
            FbMachineUIVerify.selectAutoAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));
            FbMachineUIActions.activateAutoAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.AUTOADSTEMPLATE);
            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDVALIDATIONFORAUTOADS);
            Log.info("Validation message displayed is as follow " + actualText);

            softAssert.assertEquals(actualText, expectedText, "There were already an active Auto Ads template");
        } else{
            Log.info("Template does not exist");
        }
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void deleteAndVerifyAutoAdsTemplate() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to Ads");
        FbMachineUIActions.navigateToAutoAds();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        if (FbMachineUIVerify.isAutoAdsTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1))) {
            FbMachineUIVerify.selectAutoAdsTemplate(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));
            FbMachineUIActions.deleteAutoAdsTemp(prop.getProperty(Constants.PropertiesFileConstants.AUTOADSTEMPLATE1));

            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.AUTOADSTEMPLATE);
            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETDELETIONMSG);

            Log.info("Validation message displayed is " + actualText);
            softAssert.assertEquals(actualText, expectedText, "Template is not deleted successfully");
        }
        Log.info("Template does not exist");
        softAssert.assertAll();
    }

}




