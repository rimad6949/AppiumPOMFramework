package testcases;

import org.testng.annotations.Test;

import com.pages.ios.iOSAppTest;

import baseTest.BaseTestiOS;

public class AppTestiOS extends BaseTestiOS{
	
	@Test
	public void appTest() throws InterruptedException{
		
		iOSAppTest uikit = new iOSAppTest(driver);
		Thread.sleep(2000);
		uikit.alertViewFlow();
		
	}

}
