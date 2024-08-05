package utilities;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
	
	static ExtentReports extent;
	
public static ExtentReports generateReports() {
		
		Date d = new Date();
		String filename = "Extent"+d.toString().replace(":", "_").replace(" ", "_");
		
		//Helps to change the configuration, means to modify the report with filename etc etc
		ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/target/ExtentReport/"+filename+".html");
		reporter.config().setReportName("Web Automation Result");
		
		//This creates the reports
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Rima");
		return extent;
	}

}
