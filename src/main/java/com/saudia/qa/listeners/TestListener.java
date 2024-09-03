package com.saudia.qa.listeners;

import org.testng.IExecutionListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.saudia.qa.base.TestBase;

public class TestListener extends TestBase implements ITestListener, IExecutionListener {

	@Override
	public void onExecutionStart() {
		long jobStartTime = System.currentTimeMillis();
		Reporter.log("Suite Strat time is ....." + jobStartTime, true);

	}

	@Override
	public void onExecutionFinish() {
		long jobEndTime = System.currentTimeMillis();
		Reporter.log("Suite Finish time is ....." + jobEndTime, true);

	}

	@Override
	public void onTestStart(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------- on strt - "
						+ testName);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------  on success - "
						+ testName);
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String testName = result.getMethod().getMethodName();
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------- on on fail"
						+ testName);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String testName = result.getMethod().getMethodName();
		System.out.println(
				"--------------------------------------------------------------------------------------------------------------------  on on skip"
						+ testName);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
