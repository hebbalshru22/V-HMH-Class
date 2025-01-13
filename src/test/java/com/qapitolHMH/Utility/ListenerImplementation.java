package com.qapitolHMH.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.*;

public class ListenerImplementation implements ISuiteListener, ITestListener {
    public ExtentReports extent;
    public ExtentSparkReporter htmlReporter;
    public ExtentTest test;

    // This will be called before the Suite starts
    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting suite: " + suite.getName());

        // Initialize ExtentReports and HtmlReporter
        htmlReporter = new ExtentSparkReporter("ExtentReport.html"); // specify the report path
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", "Windows");
        extent.setSystemInfo("Environment", "QA");
    }

    // This will be called after the Suite finishes
    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finishing suite: " + suite.getName());

        // Flush the report
        extent.flush();
    }

    // This will be called before any Test method is invoked
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started: " + result.getName());

        // Create a new test entry in the report
        test = extent.createTest(result.getMethod().getMethodName());
    }

    // This will be called when a Test method succeeds
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed: " + result.getName());

        // Log success to the report
        test.pass("Test passed successfully");
    }

    // This will be called when a Test method fails
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed: " + result.getName());

        // Log failure to the report and add exception details
        test.fail(result.getThrowable());
    }

    // This will be called when a Test method is skipped
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped: " + result.getName());

        // Log skip to the report
        test.skip("Test skipped");
    }

    // This will be called when a Test method fails but is within success percentage
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test partially succeeded: " + result.getName());
    }

    // This will be called before any Test method in a Test context starts
    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting test context: " + context.getName());
    }

    // This will be called after all the Test methods in a Test context have run
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Finishing test context: " + context.getName());
    }
}