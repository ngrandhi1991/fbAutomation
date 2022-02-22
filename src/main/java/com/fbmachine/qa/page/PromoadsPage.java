package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.ui.FbMachineUIActions;
import com.fbmachine.qa.util.ElementFetch;
import com.fbmachine.qa.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;

public class PromoadsPage {
    ElementFetch elementFetch = new ElementFetch();

    public boolean isPageLoaded() throws InterruptedException {
        Thread.sleep(5000);
        WebElement chooseFileBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.CHOOSEFILEBTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(chooseFileBtn));

        if (chooseFileBtn.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void uploadImageOrVideo() throws InterruptedException {
        WebElement chooseFile = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.CHOOSEFILEBTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(chooseFile));
        File file = new File("src/test/resources/10067512_1623676798.mp4");
        if (file.exists()) {
            Actions act = new Actions(TestBase.driver);
            act.moveToElement(chooseFile).perform();
            chooseFile.sendKeys(file.getAbsolutePath());
        } else {
            Log.info("File does not exist");
        }
    }

    public void uploadImage() throws InterruptedException {
        WebElement chooseFile = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.PromoPage.CHOOSEFILEBTN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(chooseFile));
        File file = new File("src/test/resources/9789174830804.jpg");
        if (file.exists()) {
            Actions act = new Actions(TestBase.driver);
            act.moveToElement(chooseFile).perform();
            chooseFile.sendKeys(file.getAbsolutePath());
        } else {
            Log.info("File does not exist");
        }
    }

    public void addUrl(String url) {
        WebElement addUrl = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH, Constants.PromoPage.ADDURL_BY_XPATH);
        TestBase.wait.until(ExpectedConditions.visibilityOf(addUrl));
        addUrl.clear();
        addUrl.sendKeys(url);
    }
}
