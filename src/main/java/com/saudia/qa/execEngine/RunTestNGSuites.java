package com.saudia.qa.execEngine;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.testng.TestNG;

public class RunTestNGSuites {
public static void main(String[] args) {
	TestNG runner = new  TestNG();
	List <String> SuiteFile= new LinkedList<String>();
	SuiteFile.add(System.getProperty("user.dir")+File.separator+"src\\main\\resources\\Suites"+File.separator+"SmokeTesting.xml");
	SuiteFile.add(System.getProperty("user.dir")+File.separator+"src\\main\\resources\\Suites"+File.separator+"SanityTesting.xml");
	SuiteFile.add(System.getProperty("user.dir")+File.separator+"src\\main\\resources\\Suites"+File.separator+"RegressionTesting.xml");
	SuiteFile.add(System.getProperty("user.dir")+File.separator+"src\\main\\resources\\Suites"+File.separator+"FunctionalTesting.xml");
	runner.setTestSuites(SuiteFile);
	runner.run();
}
}
