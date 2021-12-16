package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;


public class AdSetPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void validateAndVerifyConversionSetting() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        String actualValue = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.CONVERSIONSETTING);
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCONVERIONSETTINGVALUE);
        Log.info("Default value of Conversion Setting is " + actualValue);

        softAssert.assertEquals(actualValue, expectedValue, "Default value of Conversion setting is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 2)
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
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log .info("Option for Dynamic Creative is");
        FbMachineUIActions.valueInDynamicCreativeInAdSet();
    }

    @Test(priority = 3)
    public void validateAndVerifyPlacement() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        String actualValue = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.PLACEMENT);
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDPLACEMENTVALUE);

        Log.info("Default value of Placements is " + actualValue);

        softAssert.assertEquals(actualValue, expectedValue, "Default value of Placements is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void validateAndVerifyOptimization() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        String actualValue = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.OPTIMIZATION);
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDOPTIMIZATIONVALUE);

        Log.info("Default value of Placements is " + actualValue);

        softAssert.assertEquals(expectedValue, actualValue, "Default value of Optimization is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void validateAndVerifyValueInConversionWindow() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        String actualValue = FbMachineUIVerify.validateValueInConversionWindow(prop.getProperty(Constants.PropertiesFileConstants.CONVERSIONWINDOW));
        String expectedValue = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCONVERIONWINDOWVALUE);

        Log.info("Default value of Conversion Window is " + actualValue);

        softAssert.assertEquals(expectedValue, actualValue, "Default value of Conversion Window is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void validateAndVerifyValueInTimePeriod() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("Time Period for Life Time Budget Campaign can be to any of this values");
         FbMachineUIVerify.validateValueInTimePeriod();

    }

    @Test(priority = 7)
    public void createAndVerifyAdSet() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        if (FbMachineUIActions.isTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1));
            FbMachineUIActions.deleteAdSetsTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1));
        }
        FbMachineUIActions.createAdSetTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1),
                prop.getProperty(Constants.PropertiesFileConstants.VALUE1));

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSETTEMPLATE);

        Log.info("User is trying to create an Ad Set template. Status of template is :- " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Template is not created successfully");
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void verifyCostControlValidateMessage() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        FbMachineUIActions.createAdSetTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME2),
                prop.getProperty(Constants.PropertiesFileConstants.VALUE2));

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCOSTCONTROLMSG);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSETTEMPLATE);

        Log.info("User is trying to create an Ad Set template.Status of template is :- " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Template is not created successfully");
        softAssert.assertAll();
    }

    @Test(priority = 9)
    public void editExistingAdSetTemplateAndVerify() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting an Template");
        if (FbMachineUIActions.isTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1))) {
            FbMachineUIActions.selectTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1));
            FbMachineUIActions.editAdSetsTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1),
                    prop.getProperty(Constants.PropertiesFileConstants.VALUE3));
            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETMSG);
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSETTEMPLATE);

            Log.info("User is trying to edit an Ad Set template.Status of template is :- " + actualText);
            softAssert.assertEquals(actualText, expectedText, "Template is not edited successfully");
        } else {
            Log.info("Template doesn't exist");
        }
        softAssert.assertAll();
    }

    @Test(priority = 10)
    public void deleteAndVerifyAdSetTemplate() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigate to AdSet");
        FbMachineUIActions.navigateToAdSet();

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is selecting an Template");
        if (FbMachineUIActions.isTemplatePresent(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1))) {
            FbMachineUIActions.deleteAdSetsTemplate(prop.getProperty(Constants.PropertiesFileConstants.ADSETNAME1));

            String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETDELETIONMSG);
            String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSETTEMPLATE);

            Log.info("User is trying to delete an Ad Set template.Status of template is " + actualText);

            softAssert.assertEquals(actualText, expectedText, "Template is not deleted successfully");
        } else {
            Log.info("Template doesn't exist");
        }
        softAssert.assertAll();
    }
}
