package baseTest;

import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pages.android.FormPageAndroid;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import utilities.AppiumUtils;

//Test Configurations for Android 

public class BaseTestAndroid extends AppiumUtils{

	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPageAndroid form;


	@BeforeMethod (alwaysRun = true)
	public void ConfigurationAppium() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/resources/data.properties");
		prop.load(fis);
		String ipaddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");

		service = startAppiumServer(ipaddress, Integer.parseInt(port));

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel3");
		options.setApp(System.getProperty("user.dir")+"/src/test/java/resources/General-Store.apk");

		driver = new AndroidDriver(service.getUrl(), options);
		form = new FormPageAndroid(driver);
	}

	@AfterMethod (alwaysRun = true)
	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
