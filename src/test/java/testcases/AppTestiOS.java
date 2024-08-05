package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pages.ios.HomePageiOS;

import baseTest.BaseTestiOS;

public class AppTestiOS extends BaseTestiOS{
	
	@Test
	public void appTest() throws InterruptedException{
		
		HomePageiOS uikit = new HomePageiOS(driver);
		Thread.sleep(2000);
		uikit.alertViewFlow();
		
	}

}
