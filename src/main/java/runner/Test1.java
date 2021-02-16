package runner;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.Screenshots;

@Listeners
public class Test1 {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void setup() {
		// report = new ExtentReports("C:\\Users\\Sahana
		// Rangarajan\\eclipse-workspace\\Udemy\\UdemyExercise\\test-output\\ExtentReports\\login.html");
		// Instead of initializing the report everytime(to generate a single report
		// across test cases)
		//our report gets the instance of the extent report
		report = ExtentFactory.getInstance();
		test = report.startTest("Verify Google Page");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sahana Rangarajan\\Documents\\Arthee\\chromedriver.exe");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser started");
		driver.navigate().to("https://google.com");
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser maximised");
	}

	@Test
	public void login() {

		String title = driver.getTitle();
		Assert.assertEquals("title", "Google");
		test.log(LogStatus.PASS, "Verified Title");

	}

	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {

			Screenshots.takeScreenshot(driver, result.getName());
		}

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		 report.endTest(test);
	   	 report.flush();

	}

}
