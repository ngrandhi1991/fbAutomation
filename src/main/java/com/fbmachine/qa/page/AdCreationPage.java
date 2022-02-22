package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.ElementFetch;
import com.fbmachine.qa.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class AdCreationPage {
    ElementFetch elementFetch = new ElementFetch();

    public void selectAdSetTemplateInAds(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.SELECT_ADSET_TEMPLTE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();
        for (WebElement option : dropdown_list) {
            if (templateName.equals(option.getAttribute("label"))) {
                String value = option.getAttribute("value");
                list.selectByValue(value);
                break;
            }
        }
    }
    public void imgUpload(){
        WebElement imgUpload = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.AdsCreationPage.CHECK_UPLOADIMAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(imgUpload));
        if(imgUpload.isSelected()==false){
            imgUpload.click();
        }
    }

    public void videoUpload(){
        WebElement videoUpload = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.AdsCreationPage.CHECK_UPLOADVIDEO_BY_ID);
        //TestBase.wait.until(ExpectedConditions.visibilityOf(videoUpload));
        if(videoUpload.isDisplayed()){
            if(videoUpload.isSelected()==false){
                videoUpload.click();
            }
        }else{
            Log.info("Element not present");
        }
    }

    public void selectAdsTemplateInAds(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.AdsCreationPage.SELECT_ADS_TEMPLATE_BY_ID);
        // TestBase.wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        element.click();

        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            if (templateName.equals(option.getAttribute("label"))) {
                String value = option.getAttribute("value");
                list.selectByValue(value);
                break;
            }
        }
    }

    public void selectCampaign(String campaignName) {
        WebElement selCampaign = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.CAMPAIGNNAMEINPUT_BY_XPATH);
        TestBase.wait.until(ExpectedConditions.visibilityOf(selCampaign));

        if (selCampaign.isEnabled()) {
            selCampaign.sendKeys(campaignName);
        }
    }

}
