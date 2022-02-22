package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.ElementFetch;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RetrieveBookDetailPage {
    ElementFetch elementFetch = new ElementFetch();

    public boolean isBookDetailPresent() throws InterruptedException {
        WebElement bookElement = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTXPATH,Constants.SearchPage.FIRSTBOOK_BY_XPATH);
        TestBase.wait.until(ExpectedConditions.visibilityOf(bookElement));
        Thread.sleep(10000);

        boolean status = false;
        if(bookElement.isDisplayed() == true){
            status = true;
        }
        return status;
    }
    public void searchById(String id){
        WebElement searchById = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.SearchPage.SEARCHBOOKID_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(searchById));
        searchById.sendKeys(id);

        WebElement searchBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.SearchPage.SEARCH_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(searchBtn));
        searchBtn.click();
    }
    public void searchByISBN(String isbn){
        WebElement searchById = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID, Constants.SearchPage.SEARCHISBN_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(searchById));
        searchById.sendKeys(isbn);

        WebElement searchBtn = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.SearchPage.SEARCH_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(searchBtn));
        searchBtn.click();
    }
}
