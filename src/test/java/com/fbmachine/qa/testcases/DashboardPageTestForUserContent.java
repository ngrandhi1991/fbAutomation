package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import com.fbmachine.qa.util.XLSReader;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class DashboardPageTestForUserContent extends TestBase {
    XLSReader reader = new XLSReader(Constants.PropertiesFileConstants.XLSREADERPATH);
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void verifyLoginWithUserContent() {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        String expectedURL1 = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDLOGINTURL);
        String actualURL1 = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL1);
        softAssert.assertEquals(actualURL1, expectedURL1, "User is not able to login to the system");

        String expectedWelcomMessage = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDWELCOMETEXT2);
        String actualWelcomMessage = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.WELCOMEMSG);
        Log.info("Current welcome message is " + actualWelcomMessage);
        softAssert.assertEquals(actualWelcomMessage, expectedWelcomMessage, "This user is not Content user");

        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verifyAndValidateSearchTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        String expectedURL1 = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDSEARCHURL);
        String actualURL1 = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL1);

        softAssert.assertEquals(actualURL1, expectedURL1, "Content user do not have access to Search ");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verifyAndValidateCreateUserTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Create User");
        boolean expectedStatus = false;
        boolean actualStatus = FbMachineUIActions.isTabEnabled(Constants.IDENTIFIER.WEBELEMENTXPATH,Constants.DashboardPage.CREATUSER_BY_XPATH);

        if(actualStatus == false){
            Log.info("Is content User have an access to Create User :- "+ actualStatus);
        }

        softAssert.assertEquals(actualStatus, expectedStatus, "Content user  have access to Create User");
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void verifyAndValidateEditUserTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Edit User");
        boolean expectedStatus = false;
        boolean actualStatus = FbMachineUIActions.isTabEnabled(Constants.IDENTIFIER.WEBELEMENTXPATH,Constants.DashboardPage.EDITUSER_BY_XPATH);

        if(actualStatus == false){
            Log.info("Is Content user have an access to Edit User :- " + actualStatus);
        }

        softAssert.assertEquals(actualStatus, expectedStatus, "Content user have access to Edit User");
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void verifyAndValidateAdsCreatedTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Ads Created");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.ADSCREATED_BY_XPATH);

        boolean expectedStatus = true;
        boolean actualStatus = FbMachineUIActions.isAccessToAdsCreated();
        Log.info("Is Content User have an access to Ads Created :- " + actualStatus);

        softAssert.assertEquals(actualStatus, expectedStatus, "Content user do not have access to view created ads");
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void verifyAndValidateTemplateTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Templates");
        boolean expectedStatus = false;
        boolean actualStatus = FbMachineUIActions.isTabEnabled(Constants.IDENTIFIER.WEBELEMENTXPATH,Constants.DashboardPage.TEMPLATES_BY_XPATH);

        if(actualStatus == false){
            Log.info("Is Content User have an access to Template :- " + actualStatus);
        }

        softAssert.assertEquals(actualStatus, expectedStatus, "Content user  have access to Created Ads");
        softAssert.assertAll();
    }

    @Test(priority = 7)
    public void verifyAndValidatePromoDashTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating Promo Dashboard");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMODASH_BY_XPATH);

        boolean expectedStatus = true;
        boolean actualStatus = FbMachineUIActions.isAccessToAdsCreated();
        Log.info("Is Content User have an access to Promo Dashboard :- " + actualStatus);

        softAssert.assertEquals(actualStatus, expectedStatus, "Content user do not have access to Promo Dashboard");
        softAssert.assertAll();
    }

    @Test(priority = 8)
    public void verifyAndValidatePromoTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Promo");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.PROMOS_BY_XPATH);

        String expectedURL1 = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDPROMOURL);
        String actualURL1 = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL1);

        softAssert.assertEquals(actualURL1, expectedURL1, "Content user do not have access to Promo ads");
        softAssert.assertAll();
    }


    @Test(priority = 9)
    public void verifyAndValidateResourcesTab() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Resources");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.RESOURCES_BY_XPATH);

        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();
        String actualUrl1 = null ;
        while (iterator.hasNext()) {
            String ChildWindow = iterator.next();
            if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
                driver.switchTo().window(ChildWindow);
                actualUrl1 = driver.getCurrentUrl();
            }
        }
        Log.info("Current URL is " +actualUrl1);
        String expectedUrl1 = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDRESOURCEURL);

        softAssert.assertEquals(actualUrl1,expectedUrl1,"Content user do not have access to Resources");
        softAssert.assertAll();
    }
    @Test(priority = 10)
    public void getCampaignforSearch() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search");
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.SEARCH_BY_XPATH);

        Log.info("User is selecting an Account");
        FbMachineUIActions.selectAccount(prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));

        Log.info("User is selecting the Country");
        FbMachineUIActions.selectCountry(prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));

        Log.info("User is performing search book by Book Id");
        FbMachineUIActions.searchById(prop.getProperty(Constants.PropertiesFileConstants.SEARCHBYBOOKID));

        Log.info("User clicked on Create Ads button");
        commonMethod.clickBtn(Constants.IDENTIFIER.CREATEADS);

        Log.info("User is trying to fetch Campaign Name");
        String actualCampaignName = commonMethod.checkAndValidateValue(Constants.IDENTIFIER.CAMPAIGNNAME);

        if (actualCampaignName.isEmpty()) {
            Log.info("There is no selected campaign. It might be drop down for campaign is present ");
        } else {
            Log.info("Campaign used is :- " + actualCampaignName);
        }
    }

    @Test(priority = 11)
    public void getCampaignforPromo() throws InterruptedException {
        Log.info("User is trying to login to the system");
        String userName = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.USERNAME);
        String password = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.PASSWORD);
        String captcha = reader.getCellData(Constants.EXCEL.SHEETNAME, 4, Constants.EXCEL.CAPTCHA);
        FbMachineUIActions.getLoginUserCredentialsDetails(userName, password, captcha);

        String actualURL = driver.getCurrentUrl();
        Log.info("Current URL is " + actualURL);
        Log.info("User login into the system successfully");

        Log.info("User is navigating to Search");
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
            Log.info("Campaign used is :- " + actualCampaignName);
        }
    }

}
