package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class EditUserPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void verifyColumnInEditUser() throws InterruptedException{
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Edit User");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.EDITUSER_BY_XPATH);

        Log.info("Column present in Edit User are:");
        FbMachineUIVerify.verifyColumnPresent();
    }

    @Test(priority = 2)
    public void verifyIsUsernameEditable() throws InterruptedException{
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Edit User");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.EDITUSER_BY_XPATH);

        Log.info("Super Admin is trying to edit User");
        FbMachineUIVerify.verifyIsUsernameEditable();

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDTEXTFOREDITUSER);
        String actualText = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.EDITUSER);
        Log.info("Validation message is " + actualText);

        softAssert.assertEquals(actualText, expectedText, "Validation message is not as required");
        softAssert.assertAll();
    }

}
