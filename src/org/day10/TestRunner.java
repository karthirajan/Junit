package org.day10;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@Suite.SuiteClasses({Flipkart.class,Amazon.class})

public class TestRunner {
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(Flipkart.class,Amazon.class);
		
		List<Failure> failures = result.getFailures();
		for (Failure failure : failures) {
			System.out.println(failure);
		}
		
		System.out.println("Total Run count is :"+result.getRunCount());
		System.out.println("Total ignore count is :"+result.getIgnoreCount());
		System.out.println("Total Run Time is :"+result.getRunTime());
		
		
		
	}

}
