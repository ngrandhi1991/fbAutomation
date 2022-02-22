package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import com.fbmachine.qa.util.XLSReader;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


public class LoginPageTest extends TestBase {
    XLSReader reader = new XLSReader(Constants.PropertiesFileConstants.XLSREADERPATH);
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void verifyLoginWithValidCredential() {
        Log.info("User is trying to login to the system with valid credential");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String expectedURL = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGINTURL);
        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        softAssert.assertEquals(actualURL, expectedURL, "User is not able to login to the system");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyLoginWithInvalidCredential() {
        Log.info("User is trying to login to the system with invalid credential");
        String userName = reader.getCellData("LoginTestData", 1, "username");
        String password = reader.getCellData("LoginTestData", 1, "password");
        String captcha = reader.getCellData("LoginTestData", 1, "captcha");
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String expectedText = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGINTEXT);
        String actualText = commonMethod.checkErrorAndValidationMsg("LOGIN");

        Log.info("Message displayed is " + actualText);
        Log.info("User is not allowed to login in the system with invalid credential");

        softAssert.assertEquals(actualText, expectedText, "User is able to login with invalid credential");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyWelcomeMessage() {
        Log.info("User is trying to login to the system with valid credential");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String expectedURL = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGINTURL);
        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        String expectedWelcomMessage = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDWELCOMETEXT);
        String actualWelcomMessage = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.WELCOMEMSG);

        Log.info("Current welcome message is " + actualWelcomMessage);

        softAssert.assertEquals(actualWelcomMessage, expectedWelcomMessage, "User is not able to login to the system or Welcome message is not as required");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyLogout() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String expectedURL = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGINTURL);
        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");
        FbMachineUIActions.performLogout();

        Thread.sleep(1000);

        String expectedURL1 = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGOUTURL);
        String actualURL1 = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL1);

        if (actualURL1.equalsIgnoreCase(prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGOUTURL))) {
            Log.info("User logout of the system successfully");
        }
        softAssert.assertEquals(actualURL1, expectedURL1, "User is not able to log out of the system");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void verifyChangePasswordPage() throws InterruptedException {
        Log.info("User is trying to login to the system");
        FbMachineUIActions.getLoginUserCredentialsDetails(
                prop.getProperty(Constants.PropertiesFileConstants.USERNAME),
                prop.getProperty(Constants.PropertiesFileConstants.PASSWORD),
                prop.getProperty(Constants.PropertiesFileConstants.CAPTCHA));

        String expectedURL = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGINTURL);
        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        FbMachineUIActions.performChangePassword();
        Thread.sleep(1000);
        String expectedURL1 = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCHANGEPASSWORDURL);
        String actualURL1 = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL1);

        if (actualURL1.equalsIgnoreCase(prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDCHANGEPASSWORDURL))) {
            Log.info("User can navigate to Change Password and can change password successfully");
        }
        softAssert.assertEquals(actualURL1, expectedURL1, "Navigate to Change Password is failed");
        softAssert.assertAll();
    }

}
