package baseTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utilities.AppiumUtils;


//Test Configurations for ios

public class BaseTestiOS extends AppiumUtils{
	
	public IOSDriver driver;
	public AppiumDriverLocalService service;
	
	
	@BeforeMethod
	public void ConfigurationAppium() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("/Users/rimadas/eclipse-workspace/AppiumPOMFramework/src/main/java/resources/data.properties");
		prop.load(fis);
		
		String ipaddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		service = startAppiumServer(ipaddress, Integer.parseInt(port));

		
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 15 Pro");
		options.setApp("/Users/rimadas/Library/Developer/Xcode/DerivedData/UIKitCatalog-bymhztiytbkmtbgmdyxgwhqkacyq/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
		options.setPlatformName("17.2");
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		
		driver = new IOSDriver(service.getUrl(), options);
			
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		service.stop();

	}
	

}
