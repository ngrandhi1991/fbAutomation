package com.fbmachine.qa.testcases;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.ui.FbMachineUIVerify;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.testng.annotations.Test;

import java.util.logging.Logger;

public class AdCreationPageTest extends TestBase {
    TestUtil.CommonMethod commonMethod = new TestUtil.CommonMethod();

    @Test(priority = 1)
    public void publishAds() throws InterruptedException {
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
        Thread.sleep(10000);

        Log.info(" Uploading Image and Video");
        FbMachineUIActions.imgUpload();
        //FbMachineUIActions.videoUpload();
        FbMachineUIActions.selectCampaign(prop.getProperty(Constants.IDENTIFIER.CAMPAIGNNAME));


        Log.info("Selecting Ad Sets template");
        FbMachineUIVerify.selectAdSetTemplateInAds(Constants.PropertiesFileConstants.ADSETTEMPLATE);

        Log.info("Selecting Ads template");
        FbMachineUIVerify.selectAdsTemplateInAds(Constants.PropertiesFileConstants.ADSTEMPLATE);

        Log.info("Publishing Ads");
        commonMethod.clickBtn(Constants.IDENTIFIER.PUBLISH);

        String expectedImgUploadMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDIMAGEUPLOADMSG);
        String actualImageUploadMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.IMAGEUPLOAD);

        Log.info("Validation message for Image Upload is :- " + actualImageUploadMsg);
        softAssert.assertEquals(actualImageUploadMsg,expectedImgUploadMsg,"Validation message is not as required");

        /*String expectedVidepUploadMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDVIDEOUPLOADMSG);
        String actualVideoUploadMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.VIDEOUPLOAD);

        Log.info("Validation message for Image Upload is :- " + actualImageUploadMsg);
        softAssert.assertEquals(actualVideoUploadMsg,expectedVidepUploadMsg,"Validation message is not as required");*/

        String expectedAdSetMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADSETCREATIONMSG);
        String actualAdSetMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADSETCREATION);

        Log.info("Validation message for Ad Set creation is :- " +actualAdSetMsg);
        softAssert.assertEquals(actualAdSetMsg,expectedAdSetMsg,"Ad Set is not created successfully");

        String expectedAdCreativeMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADCREATIVEMSG);
        String actualAdCreativeMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADCREATIVE);

        Log.info("Validation message for Ad Creative creation is :-" +actualAdCreativeMsg);
        softAssert.assertEquals(actualAdCreativeMsg,expectedAdCreativeMsg,"Ad Creative is not created successfully");

        String expectedAdsMsg = prop.getProperty(Constants.ASSERTIONCONSTANT.EXPECTEDADCRESTIONMSG);
        String actualAdsMsg = commonMethod.checkErrorAndValidationMsg(Constants.IDENTIFIER.ADCREATION);

        Log.info("User is trying to publish an Ads.Status is :- " + actualAdsMsg);

        softAssert.assertEquals(actualAdsMsg, expectedAdsMsg, "Ads is not created successfully");
        softAssert.assertAll();
    }

}
