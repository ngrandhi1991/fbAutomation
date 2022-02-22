package com.fbmachine.qa.ui;

import com.fbmachine.qa.page.*;

public class FbMachineUIVerify {

    public static void validateValueInFacebookPage() {
        new AdsPage().validateValueInFacebookPage();
    }

    public static void validateValueInInstaPage() {
        new AdsPage().validateValueInInstaPage();
    }

    public static String validateValueInConversionWindow(String cw) {
        return new AdSetPage().validateValueInConversionWindow(cw);
    }

    public static boolean isAutoAdsTemplatePresent(String templateName) {
        return new AutoAdsPage().isAutoAdsTemplatePresent(templateName);
    }

    public static void selectAutoAdsTemplate(String templateName) {
        new AutoAdsPage().selectAutoAdsTemplate(templateName);
    }

    public static boolean isBookDetailPresent() throws InterruptedException {
        return new RetrieveBookDetailPage().isBookDetailPresent();
    }

    public static void validateValueInTimePeriod() {
        new AdSetPage().valueInTimePeriod();
    }


    public static void verifyColumnPresent() {
        new EditUserPage().verifyColumnPresent();
    }

    public static void verifyIsUsernameEditable() {
        new EditUserPage().verifyIsUsernameEditable();
    }

    public static void selectAdSetTemplateInAds(String templateName) {
        new AdCreationPage().selectAdSetTemplateInAds(templateName);
    }

    public static void selectAdsTemplateInAds(String templateName) {
        new AdCreationPage().selectAdsTemplateInAds(templateName);
    }

    public static boolean isPageLoaded() throws InterruptedException {
        return new PromoadsPage().isPageLoaded();
    }

}
