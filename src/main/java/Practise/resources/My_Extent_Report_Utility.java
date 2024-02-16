package Practise.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class My_Extent_Report_Utility {
	
	public static ExtentReports report()
	{
		String path=System.getProperty("user.dir")+"\\reports\\"+"index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Automation Test Results");
		reporter.config().setReportName("TEST");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("TESTER", "TEAM");
		return extent;
				
	}

}
