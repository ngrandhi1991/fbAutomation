package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.util.ElementFetch;
import com.fbmachine.qa.util.Log;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AutoAdsPage {

    ElementFetch elementFetch = new ElementFetch();
    JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;

    public void navigateToAutoAds() throws InterruptedException {
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.TEMPLATES_BY_XPATH);
        Thread.sleep(2000);
        WebElement adBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplatesPage.AUTO_BTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(adBtn));
        adBtn.click();
    }

    public void valueOfNightModeInAutoAds() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_NIGHTMODE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }

    public void valueOfFormatInAutoAds() throws InterruptedException {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_FORMAT_BY_ID);
        //TestBase.wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(element)));
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getAttribute("value"));
        }
    }

    public void createAutoAdsTemplate(String templateName, String nm, String aadset, String aadsetSeq) {
        WebElement addTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.ADD_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(addTemplate));
        addTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.NEWNAME_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement createTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.CREATE_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(createTemplate));
        createTemplate.click();

        WebElement nightMode = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_NIGHTMODE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(nightMode));
        nightMode.sendKeys(nm);


        WebElement startDate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_STARTDATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(startDate));
        startDate.sendKeys(Constants.PropertiesFileConstants.STARTDATE);


        WebElement endDate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_ENDDATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(startDate));
        endDate.sendKeys(Constants.PropertiesFileConstants.EndDate);

        WebElement activeAdSet = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.ACTIVEADSET_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(activeAdSet));
        activeAdSet.clear();
        activeAdSet.sendKeys(aadset);

        FbMachineUIActions.selectAdSetTemplateInAutoAds(Constants.PropertiesFileConstants.ADSETTEMPLATE);
        FbMachineUIActions.selectAdsTemplateInAutoAds(Constants.PropertiesFileConstants.ADSTEMPLATE);

        WebElement activeAdSetSequence = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.CAMPAIGNSEQUENCE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(activeAdSetSequence));
        activeAdSetSequence.sendKeys(aadsetSeq);

        WebElement saveAutoAds = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SAVE_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveAutoAds));
        saveAutoAds.click();
    }

    public void selectAdSetTemplateInAutoAds(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_ADSETTEMPLATE_BY_ID);
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

    public void selectAdsTemplateInAutoAds(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_ADSTEMPLATE_BY_ID);
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

    public void editAutoAdsTemplate(String templateName, String aadset) {
        WebElement editTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.EDIT_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(editTemplate));
        editTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.EDITINPUT_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement editSaveTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.EDITSAVE_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(editSaveTemplate));
        editSaveTemplate.click();

        WebElement activeAdSet = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.ACTIVEADSET_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(activeAdSet));
        activeAdSet.clear();
        activeAdSet.sendKeys(aadset);

        WebElement saveButton = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdsPage.SAVE_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void selectAutoAdsTemplate(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_AUTO_ADS_TEMPLATE_BY_ID);
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

    public boolean isAutoAdsTemplatePresent(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_AUTO_ADS_TEMPLATE_BY_ID);
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

    public void deleteAutoAdsTemp(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_AUTO_ADS_TEMPLATE_BY_ID);
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

        WebElement deleteTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.DELETE_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(deleteTemplate));
        deleteTemplate.click();
    }

    public void activateAutoAdsTemp(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.SELECT_AUTO_ADS_TEMPLATE_BY_ID);
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

        WebElement activateTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAutoAdsPage.ACTIVATE_AUTO_ADS_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(activateTemplate));
        activateTemplate.click();
    }
}
