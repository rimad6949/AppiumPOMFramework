package utilities;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.basePage.android.BasePageAndroid;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

//Action utility classes for both Android

public class AndroidGestures extends BasePageAndroid {


	public AndroidGestures(AndroidDriver driver) {
		super(driver);
	}

	public void scrollToText(String text) {

		driver.findElement(AppiumBy
				.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));

	}

	public void longPressGesture(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile: longClickGuesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));

	}

	public void doubleClickGesture(WebElement element) {

		((JavascriptExecutor) driver).executeScript("mobile:doubleClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId()));

	}

	public void swipeGesture(WebElement element) {
		((JavascriptExecutor) driver).executeScript("mobile:swipeGesture", ImmutableMap.of("left", 100, "top", 100,
				"width", 200, "height", 200, "direction", "left", "percent", 0.75));

	}

	public void rotateToLandscape() {
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
	}

}
