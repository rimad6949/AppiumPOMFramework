package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

//Common Action utility classes for both ios and Android

public class AppiumUtils{

	public void waitforElementToAppear(AppiumDriver driver, WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));
	}
	
	
	public AppiumDriverLocalService service;
	
	//kepping the ipadress dynamic as the url can change 
	
	public AppiumDriverLocalService startAppiumServer(String ipaddress, int port) {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipaddress).usingPort(port).build();
		service.start();
		return service;
	}

	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;
	}
	
	public String getScreenshot(String testcaseName, AppiumDriver driver) throws IOException {
		
		File screenshotFile = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"/target/Screenshot"+testcaseName+".png";
		FileUtils.copyFile(screenshotFile, new File(destinationFile));
		return destinationFile;
	}
	
}
