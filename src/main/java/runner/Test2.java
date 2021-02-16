package runner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.Set;
	
public class Test2 {
		
	   String pattern = "^[a-zA-Z]$";
	   boolean ans;	
	   ExtentReports report;
	   ExtentTest test;
	   
	 @BeforeClass
	 public void setup() {
			report = ExtentFactory.getInstance();
			test = report.startTest("Test2");
		}
	
   	@Test
	public void test1() {
		String mainstr = "india";
		System.out.println(mainstr);
		test.log(LogStatus.INFO, "Printed the string");
			
	}
	@AfterClass
    public void tearDown() {
     report.endTest(test);
   	 report.flush();
   	 
    }
}	

