package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

public class CreateUserTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void createAndVerifyCreateUser() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Create User");
        FbMachineUIActions.isTabPresentAndClick("XPATH", Constants.DashboardPage.CREATUSER_BY_XPATH);

        Log.info("User is trying to create a new user");
        FbMachineUIActions.createUser(
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERUSERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.EMAIL),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERPASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERCONFIRMPASSWORD));
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.CREATEUSER);
        if (actualText.equalsIgnoreCase("User created successfully!")) {
            Log.info(" Message displayed is " + actualText);
        } else {
            Log.info("Message displayed is " + actualText);
        }
    }

    @Test(priority = 2)
    public void verifyCreationOfDuplicateUser() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Create User");
        FbMachineUIActions.isTabPresentAndClick("XPATH", Constants.DashboardPage.CREATUSER_BY_XPATH);

        Log.info("User is trying to create a new user");
        FbMachineUIActions.createUser(
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERUSERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.EMAIL),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERPASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERCONFIRMPASSWORD));

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDTEXTFORDUPLICATEUSERNAME);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.CREATEUSER);

        Log.info("User is trying to create an user. Status is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Same user can be created multiple time");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyValidationMessageWithDuplicateUsername() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Create User");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.CREATUSER_BY_XPATH);

        Log.info("User is trying to create a new user");
        FbMachineUIActions.createUser(
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERUSERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.EMAIL),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERPASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERCONFIRMPASSWORD));

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDTEXTFORDUPLICATEUSERNAME);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.CREATEUSER);

        Log.info("User is trying to create an user. Status is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation message is not as expected");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyValidationMessageWithDuplicateEmail() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Create User");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.CREATUSER_BY_XPATH);

        Log.info("User is trying to create a new user");
        FbMachineUIActions.createUser(
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERUSERNAME1),
                prop.getProperty(Constants.PropertiesFileConstants.EMAIL),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERPASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERCONFIRMPASSWORD));

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDTEXTFORDUPLICATEEMAIL);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.CREATEUSER);

        Log.info("User is trying to create an user. Status is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation message is not as expected");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void verifyValidationMessageWithPasswordMismatch() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Create User");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.CREATUSER_BY_XPATH);

        Log.info("User is trying to create a user");
        FbMachineUIActions.createUser(
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERUSERNAME1),
                prop.getProperty(Constants.PropertiesFileConstants.EMAIL1),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERPASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CREATEUSERCONFIRMPASSWORD1));

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDTEXTFORPASSWORDMISMATCH);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.CREATEUSER);

        Log.info("User is trying to create an user. Status is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation message is not as required");
        softAssert.assertAll();
    }

}
