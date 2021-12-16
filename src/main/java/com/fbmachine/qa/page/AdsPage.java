package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.util.ElementFetch;
import com.fbmachine.qa.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AdsPage {
    ElementFetch elementFetch = new ElementFetch();

    public void navigateToAds() throws InterruptedException {
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.TEMPLATES_BY_XPATH);
        Thread.sleep(2000);
        WebElement adBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplatesPage.ADS_BTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(adBtn));
        adBtn.click();
    }

    public void validateValueInFacebookPage() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_FBPAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }

    public void validateValueInInstaPage() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_INSTAPAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }

    public void valueOfDynamicCreativeInAds() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_CREATIVE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }

    public void valueOfOptimizeCreativeInAds() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_OPTCREATIVE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }

    public void selectDynamicCreative(String dc) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_CREATIVE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            if (dc.equals(option.getAttribute("value"))) {
                String value = option.getAttribute("value");
                list.selectByValue(value);
                break;
            }
        }
    }

    public void createAdsTemplateWithDCNo(String templateName, String fp, String insta, String pt1, String hl, String cta) {
        WebElement addTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.ADD_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(addTemplate));
        addTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.NEWNAME_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement createTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.CREATE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(createTemplate));
        createTemplate.click();

        WebElement facebookPage = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_FBPAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(facebookPage));

        Select facebookPageValue = new Select(facebookPage);
        facebookPageValue.selectByValue(fp);

        WebElement instaPage = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_INSTAPAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(instaPage));

        Select instaPageValue = new Select(instaPage);
        instaPageValue.selectByValue(insta);

        WebElement primaryText1 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.PRIMARYTEXT1_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(primaryText1));
        primaryText1.sendKeys(pt1);

        WebElement headline1 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.HEADLINE1_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(headline1));
        headline1.sendKeys(hl);

        WebElement callToAction = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_ACTION_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(callToAction));

        Select value = new Select(callToAction);
        value.selectByValue(cta);

        WebElement saveButton = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SAVE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public boolean isAdsTemplatePresent(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        boolean status = false;
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            if (templateName.equals(option.getAttribute("label"))) {
                status = true;
            }
        }
        return status;
    }

    public void deleteAdsTemp(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_ADS_TEMPLATE_BY_ID);
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

        WebElement deleteTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.DELETE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(deleteTemplate));
        deleteTemplate.click();
    }

    public void editAdsTemplate(String templateName) {
        WebElement editTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.EDIT_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(editTemplate));
        editTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.EDITINPUT_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement editSaveTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.EDITSAVE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(editSaveTemplate));
        editSaveTemplate.click();

        WebElement primaryText1 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.PRIMARYTEXT1_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(primaryText1));
        primaryText1.sendKeys("Have edited the Primary Text");

        WebElement saveButton = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SAVE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void createAdsTemplateWithDCOn(String templateName, String fp, String insta, String pt1, String pt2, String hl, String h2, String des, String cta) {
        WebElement addTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.ADD_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(addTemplate));
        addTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.NEWNAME_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement createTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.CREATE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(createTemplate));
        createTemplate.click();

        WebElement facebookPage = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_FBPAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(facebookPage));

        Select facebookPageValue = new Select(facebookPage);
        facebookPageValue.selectByValue(fp);

        WebElement instaPage = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_INSTAPAGE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(instaPage));

        Select instaPageValue = new Select(instaPage);
        instaPageValue.selectByValue(insta);

        WebElement primaryText1 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.PRIMARYTEXT1_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(primaryText1));
        primaryText1.sendKeys(pt1);

        WebElement navigateToPrimaryText2 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.NAVIGATETOPM2_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(navigateToPrimaryText2));
        navigateToPrimaryText2.click();

        WebElement primaryText2 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.PRIMARYTEXT2_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(primaryText2));
        primaryText2.sendKeys(pt2);

        WebElement headline1 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.HEADLINE1_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(headline1));
        headline1.sendKeys(hl);

        WebElement headline2 = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.HEADLINE2_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(headline1));
        headline2.sendKeys(h2);

        WebElement description = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.DESCRIPTION_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(description));
        description.sendKeys(des);

        WebElement callToAction = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SELECT_ACTION_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(callToAction));

        Select value = new Select(callToAction);
        value.selectByValue(cta);

        WebElement saveButton = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SAVE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }
}
