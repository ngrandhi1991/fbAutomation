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

public class AdSetPage {
    ElementFetch elementFetch = new ElementFetch();

    public void navigateToAdSet() throws InterruptedException {
        FbMachineUIActions.isTabPresentAndClick(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.DashboardPage.TEMPLATES_BY_XPATH);

        WebElement adSetBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplatesPage.ADSET_BTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(adSetBtn));
        adSetBtn.click();
    }

    public void selectAccount(String account) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplatesPage.ACCOUNT_SELECT_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        Select values = new Select(element);
        values.selectByVisibleText(account);
    }

    public void selectCountry(String country) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplatesPage.COUNTRY_SELECT_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        Select values = new Select(element);
        values.selectByValue(country);
    }

    public void createAdSetTemplate(String templateName, String value) throws InterruptedException {
        WebElement addTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.ADD_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(addTemplate));
        addTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.NEWNAME_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement createTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.CREATE_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(createTemplate));
        createTemplate.click();

        WebElement costControl = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.BIDAMOUNT_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(costControl));
        costControl.clear();
        costControl.sendKeys(value);

        WebElement saveButton = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.SAVE_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void selectTemplate(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.SELECT_TEMPLATE_BY_ID);
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

    public void editAdSetsTemplate(String templateName, String value) throws InterruptedException {
        WebElement editTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.EDIT_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(editTemplate));
        editTemplate.click();

        WebElement newName = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.EDITINPUT_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(newName));
        newName.sendKeys(templateName);

        WebElement editSaveTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.EDITSAVE_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(editSaveTemplate));
        editSaveTemplate.click();

        WebElement costControl = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.BIDAMOUNT_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(costControl));
        costControl.clear();
        costControl.sendKeys(value);

        WebElement saveButton = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.SAVE_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveButton));
        saveButton.click();
    }

    public void deleteAdSetsTemplate(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.SELECT_TEMPLATE_BY_ID);
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
        WebElement deleteTemplate = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.DELETE_TEMPLATE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(deleteTemplate));
        deleteTemplate.click();
    }

    public boolean isTemplatePresent(String templateName) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.SELECT_TEMPLATE_BY_ID);
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

    public void valueInDynamicCreativeInAdSet() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.SELECT_DYNAMICCREATIVE_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }

    public String validateValueInConversionWindow(String cw) {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.CONVERSIONWINDOW_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));

        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            if (cw.equals(option.getAttribute("value"))) {
                return option.getAttribute("value");
            }
        }
        return null;
    }

    public void valueInTimePeriod() {
        WebElement element = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.TemplateAdSetPage.TIMEPERIOD_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(element));
        Select list = new Select(element);
        List<WebElement> dropdown_list = list.getOptions();

        for (WebElement option : dropdown_list) {
            Log.info(option.getText());
        }
    }
}







