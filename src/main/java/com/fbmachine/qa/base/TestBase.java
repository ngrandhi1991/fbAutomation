package com.fbmachine.qa.base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com.fbmachine.qa.constants.Constants;
import com.fbmachine.qa.util.Log;
import com.fbmachine.qa.util.TestUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest log;
    public static SoftAssert softAssert;


    public TestBase() {
        PageFactory.initElements(driver, this);
        String defaultPropertyFilePrefix = "de_config";
        String vmOptionsPropertyFilePrefix = System.getProperty("propertyfile");
        try {
            prop = new Properties();
            if (vmOptionsPropertyFilePrefix == null) {
                vmOptionsPropertyFilePrefix = defaultPropertyFilePrefix;
            }
            FileInputStream ip = new FileInputStream("src/test/resources/" + vmOptionsPropertyFilePrefix + ".properties");
            prop.load(ip);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialization(String browserName) {
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "./driver" + "/chromedriver.exe");
            driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, TestUtil.EXPLICIT_WAIT);
        softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty(Constants.PropertiesFileConstants.URL));

    }

    @BeforeTest
    public void beforeTestMethod() {
        htmlReporter = new ExtentHtmlReporter("./reports" + "/AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Nishi");

    }

    @BeforeMethod
    public void beforeMethodMethod(Method testMethod) {
        log = extent.createTest(testMethod.getName());
        initialization(prop.getProperty(Constants.PropertiesFileConstants.BROWSER));
    }

    @AfterMethod
    public void afterMethodMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case:" + methodName + "Passed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            log.log(Status.PASS, m);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case:" + methodName + "Failed";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
            log.log(Status.FAIL, m);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case:" + methodName + "Skiped";
            Markup m = MarkupHelper.createLabel(logText, ExtentColor.BLUE);
            log.log(Status.SKIP, m);
        }
        driver.quit();
    }

    @AfterTest
    public void afterTestMethod() {
        extent.flush();
    }
}