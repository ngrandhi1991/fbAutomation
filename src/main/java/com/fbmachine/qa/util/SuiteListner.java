package com.fbmachine.qa.util;

import com.fbmachine.qa.base.TestBase;

import com.fbmachine.qa.constants.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class SuiteListner implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestStart(ITestResult iTestResult) {
        Log.info("=======================================================");
        Log.info(iTestResult.getTestClass().getName() + "#" + iTestResult.getMethod().getMethodName() + " Started");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Log.info(iTestResult.getTestClass().getName() + "#" + iTestResult.getMethod().getMethodName() + " Passed");
        Log.info("=======================================================");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String fileName = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + iTestResult.getMethod().getMethodName();
        File f = ((TakesScreenshot) TestBase.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(f, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.info(iTestResult.getTestClass().getName() + "#" + iTestResult.getMethod().getMethodName() + " Failure");
        Log.info("=======================================================");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("Skipped because of -" + iTestResult.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Log.info("============onStart ==========:-" + iTestContext.getName() + "==============");
        Log.info(TestBase.prop.getProperty(Constants.PropertiesFileConstants.ACCOUNT));
        Log.info(TestBase.prop.getProperty(Constants.PropertiesFileConstants.COUNTRY));
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Log.info("============onEnd ==========:-" + iTestContext.getName() + "==============");
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyser.class);
    }
}
