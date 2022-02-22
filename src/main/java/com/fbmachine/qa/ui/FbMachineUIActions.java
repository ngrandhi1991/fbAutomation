package com.fbmachine.qa.ui;

import com.fbmachine.qa.page.*;

public class FbMachineUIActions {
    public static void getLoginUserCredentialsDetails(String un, String pwd, String captcha) {
        new LoginPage().getLoginUserCredentialsDetails(un, pwd, captcha);
    }

    public static void performLogout() {
        new LoginPage().performLogout();
    }

    public static void performChangePassword() {
        new LoginPage().performChangePassword();
    }

    public static void navigateToAdSet() throws InterruptedException {
        new AdSetPage().navigateToAdSet();
    }

    public static void selectAccount(String account) {
        new AdSetPage().selectAccount(account);
    }

    public static void selectCountry(String country) {
        new AdSetPage().selectCountry(country);
    }

    public static void createAdSetTemplate(String templateName, String value) throws InterruptedException {
        new AdSetPage().createAdSetTemplate(templateName, value);
    }

    public static void selectTemplate(String templateName) {
        new AdSetPage().selectTemplate(templateName);
    }

    public static void editAdSetsTemplate(String templateName, String value) throws InterruptedException {
        new AdSetPage().editAdSetsTemplate(templateName, value);
    }

    public static void deleteAdSetsTemplate(String templateName) {
        new AdSetPage().deleteAdSetsTemplate(templateName);
    }

    public static boolean isTemplatePresent(String templateName) {
        return new AdSetPage().isTemplatePresent(templateName);
    }

    public static void valueInDynamicCreativeInAdSet() {
        new AdSetPage().valueInDynamicCreativeInAdSet();
    }

    public static void navigateToAds() throws InterruptedException {
        new AdsPage().navigateToAds();
    }

    public static void valueOfDynamicCreativeInAds() {
        new AdsPage().valueOfDynamicCreativeInAds();
    }

    public static void valueOfOptimizeCreativeInAds() {
        new AdsPage().valueOfOptimizeCreativeInAds();
    }

    public static void createAdsTemplateWithDCNo(String templateName, String fp, String insta, String pt1, String hl, String cta) {
        new AdsPage().createAdsTemplateWithDCNo(templateName, fp, insta, pt1, hl, cta);
    }

    public static boolean isAdsTemplatePresent(String templateName) {
        return new AdsPage().isAdsTemplatePresent(templateName);
    }

    public static void deleteAdsTemp(String templateName) {
        new AdsPage().deleteAdsTemp(templateName);
    }

    public static void selectDynamicCreative(String dc) {
        new AdsPage().selectDynamicCreative(dc);
    }

    public static void editAdsTemplate(String templateName) {
        new AdsPage().editAdsTemplate(templateName);
    }

    public static void createAdsTemplateWithDCOn(String templateName, String fp, String insta, String pt1, String pt2, String hl, String h2, String des, String cta) {
        new AdsPage().createAdsTemplateWithDCOn(templateName, fp, insta, pt1, pt2, hl, h2, des, cta);
    }

    public static void navigateToAutoAds() throws InterruptedException {
        new AutoAdsPage().navigateToAutoAds();
    }

    public static void valueOfNightModeInAutoAds() {
        new AutoAdsPage().valueOfNightModeInAutoAds();
    }

    public static void valueOfFormatInAutoAds() throws InterruptedException {
        new AutoAdsPage().valueOfFormatInAutoAds();
    }

    public static void selectAdSetTemplateInAutoAds(String templateName) {
        new AutoAdsPage().selectAdSetTemplateInAutoAds(templateName);
    }

    public static void selectAdsTemplateInAutoAds(String templateName) {
        new AutoAdsPage().selectAdsTemplateInAutoAds(templateName);
    }

    public static void createAutoAdsTemplate(String templateName, String nm, String aadset, String aadsetSeq) throws InterruptedException {
        new AutoAdsPage().createAutoAdsTemplate(templateName, nm, aadset, aadsetSeq);
    }

    public static void activateAutoAdsTemp(String templateName) {
        new AutoAdsPage().activateAutoAdsTemp(templateName);
    }

    public static void deleteAutoAdsTemp(String templateName) {
        new AutoAdsPage().deleteAutoAdsTemp(templateName);
    }

    public static void editAutoAdsTemplate(String templateName, String aadset) {
        new AutoAdsPage().editAutoAdsTemplate(templateName, aadset);
    }

    public static void searchById(String id) {
        new RetrieveBookDetailPage().searchById(id);
    }

    public static void searchByISBN(String isbn) {
        new RetrieveBookDetailPage().searchByISBN(isbn);
    }

    public static boolean isTabPresentAndClick(String identifierType, String identifierValue) throws InterruptedException {
        return new Dashboard().isTabPresentAndClick(identifierType, identifierValue);
    }

    public static boolean isAccessToAdsCreated() {
        return new Dashboard().isAccessToAdsCreated();
    }

    public static boolean isTabEnabled(String identifierType, String identifierValue) throws InterruptedException {
        return new Dashboard().isTabEnabled(identifierType, identifierValue);
    }

    public static void createUser(String un, String em, String pw, String cpw) {
        new CreateUserPage().createUser(un, em, pw, cpw);
    }

    public static void imgUpload() {
        new AdCreationPage().imgUpload();
    }
    public static void videoUpload() {
        new AdCreationPage().videoUpload();
    }

    public static void uploadImageOrVideo() throws InterruptedException {
        new PromoadsPage().uploadImageOrVideo();
    }

    public static void uploadImage() throws InterruptedException {
        new PromoadsPage().uploadImage();
    }

    public static void addUrl(String url) {
        new PromoadsPage().addUrl(url);
    }


    public static void selectCampaign(String campaignName){new AdCreationPage().selectCampaign(campaignName);}
}
