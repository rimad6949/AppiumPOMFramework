package baseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestiOS {
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigurationAppium() throws MalformedURLException {
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15 Pro");
		options.setApp("/Users/rimadas/eclipse-workspace/AppiumPOMFramework/src/test/java/resources/UIKitCatalog.app");
		options.setPlatformName("17.2");
		options.setWdaLaunchTimeout(Duration.ofSeconds(10));
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		service.stop();

	}
	

}
