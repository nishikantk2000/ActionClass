package testNGclass;



import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport 
{ 
	ExtentSparkReporter htmlReporter = new ExtentSparkReporter
			 (System.getProperty("user.dir")+"/src/test/resources"+"/ExtentReport");
	ExtentReports extent = new ExtentReports();
  @Test
  public void report()
  {
	  extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("VerifyTestForPayment","Verification of total payment");
		test1.assignAuthor("Sachin","Dhoni");
		test1.assignCategory("Smoke","Regression");
		
		test1.log(Status.INFO,"this is first step");
		test1.log(Status.INFO,"this is second step");
		test1.log(Status.INFO,"this is third step");
		test1.info("This is info line appeared in report");
		test1.pass("Sample pass test step1");
		test1.pass("Sample pass test step2");
		test1.pass("Sample pass test step3");
		test1.pass("Sample pass test step4");
		test1.fail("Sample FAILED test step");  
  



	  extent.flush(); 
  }

}
