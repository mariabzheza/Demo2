package com.eleks.Demo2.tests;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer  { 
	private int countOfRetry = 0; 
	private int maxRetry = 3;
 
    @Override
    public boolean retry(ITestResult result) { 
            if(countOfRetry < maxRetry) {                     
                countOfRetry++;                                    
                return true; 
            } 
            return false; 
    }
}
