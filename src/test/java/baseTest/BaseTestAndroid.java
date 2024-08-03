package baseTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.pages.android.FormPageAndroid;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import utilities.AppiumUtils;

//Test Configurations for Android 

public class BaseTestAndroid extends AppiumUtils{

	public static AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPageAndroid form;

	@BeforeMethod
	public void ConfigurationAppium() throws MalformedURLException {

		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();

		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Pixel3");
		options.setApp("/Users/rimadas/eclipse-workspace/AppiumPOMFramework/src/test/java/resources/General-Store.apk");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		form = new FormPageAndroid(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		service.stop();

	}

}
