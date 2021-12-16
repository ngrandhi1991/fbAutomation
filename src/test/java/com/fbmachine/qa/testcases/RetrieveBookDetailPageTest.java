package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class RetrieveBookDetailPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void verifySearchById() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search tab");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is performing search book by Book Id");
        FbMachineUIActions.searchById(prop.getProperty(Constants.PropertiesFileConstants.SEARCHBYBOOKID));

        if (FbMachineUIVerify.isBookDetailPresent() == true) {
            String actualId = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.BOOKID);
            String expectedId = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDBOOKIDVALUE);
            Log.info(actualId);

            softAssert.assertEquals(actualId, expectedId, "No Books are fetched ");
        } else {
            String actualMessage = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.NOBOOK);
            String expectedMessage = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDNOBOOKMSG);

            softAssert.assertEquals(actualMessage, expectedMessage, "Books are fetched ");
        }

    }

    @Test(priority = 2)
    public void verifySearchByISBN() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search tab");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is performing search book by ISBN");
        FbMachineUIActions.searchByISBN(prop.getProperty(Constants.PropertiesFileConstants.SEARCHBYISBN));

        if (FbMachineUIVerify.isBookDetailPresent() == true) {
            String actualTitle = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.BOOKISBN);
            String expectedTitle = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDBOOKISBNVALUE);
            Log.info(actualTitle);

            softAssert.assertEquals(actualTitle, expectedTitle, "No Books are fetched ");
        } else {
            String actualMessgae = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.NOBOOK);
            String expectedMessage = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDNOBOOKMSG);

            softAssert.assertEquals(actualMessgae, expectedMessage, "Books are fetched ");
        }
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyIsCountryMandatory() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search tab");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is performing search book by Book Id");
        FbMachineUIActions.searchById(prop.getProperty(Constants.PropertiesFileConstants.SEARCHBYBOOKID));

        String actualMessage = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.SEARCH);
        String expectedMessage = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDSEARCHVALIDATIONMSG);

        Log.info("Validation message displayed is " + actualMessage);

        softAssert.assertEquals(actualMessage, expectedMessage, "Validation message is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyIsSearchCriteriaMandatory() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search tab");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is performing search book by Book Id");
        FbMachineUIActions.searchById(prop.getProperty(Constants.PropertiesFileConstants.SEARCHBYBOOKID1));

        String actualMessage = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.SEARCH);
        String expectedMessage = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDSEARCHVALIDATIONMSG1);

        Log.info("Validation message displayed is " + actualMessage);

        softAssert.assertEquals(actualMessage, expectedMessage, "Validation message is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void clickAndVerifyCreateAdsBtn() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search tab");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is performing search book by Book Id");
        FbMachineUIActions.searchById(prop.getProperty(Constants.PropertiesFileConstants.SEARCHBYBOOKID));

        Log.info("User clicked on Create Ads button");
        commonMethod.clickBtn(Constants.IDENTIFIER.CREATEADS);

        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADCREATIONLAUNCH);
        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADCREATIONTEXT);

        Log.info(actualText + " is launched ");

        softAssert.assertEquals(actualText, expectedText, "Ad creation does not launch");
        softAssert.assertAll();
    }
}
