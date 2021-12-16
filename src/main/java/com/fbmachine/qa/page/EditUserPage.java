package com.fbmachine.qa.page;

import com.fbmachine.qa.base.TestBase;
import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.ElementFetch;
import com.fbmachine.qa.util.Log;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.util.List;

public class EditUserPage {
    ElementFetch elementFetch = new ElementFetch();

    public void verifyColumnPresent(){
        List<WebElement> colElements = elementFetch.getListWebElements(Constants.IDENTIFIER.WEBELEMENTXPATH,Constants.EditUserPage.TABLE_COLUMN_BY_XPATH);
        int colCount = colElements.size();

        for (WebElement col: colElements) {
            Log.info(col.getText());
        }
    }
    public void verifyIsUsernameEditable(){
        List<WebElement> rowElements = elementFetch.getListWebElements(Constants.IDENTIFIER.WEBELEMENTXPATH,Constants.EditUserPage.TABLE_ROW_BY_XPATH);
        int rowCount = rowElements.size();
        for(int i=1;i<rowCount;i++)
        {
            WebElement element = TestBase.driver.findElement(By.id("username"+ i));
            if(element.getAttribute("value").equalsIgnoreCase("TestPromo4")){
                {
                    element.clear();
                    element.sendKeys("TestAuto");
                    element.clear();
                    element.sendKeys("TestPromo4");

                }
            }
        }
        WebElement saveUser = elementFetch.getWebElement(Constants.IDENTIFIER.WEBELEMENTID,Constants.EditUserPage.SAVEUSER_BY_ID);
        TestBase.wait.until(ExpectedConditions.visibilityOf(saveUser));
        saveUser.click();
    }
}
