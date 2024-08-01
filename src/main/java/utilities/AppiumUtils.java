package utilities;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.basePage.android.BasePageAndroid;

import io.appium.java_client.AppiumDriver;

//Common Action utility classes for both ios and Android

public class AppiumUtils {

	AppiumDriver driver;

	public AppiumUtils(AppiumDriver driver) {
		this.driver = driver;

	}

	public void waitforElementToAppear(WebElement ele) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains((ele), "text", "Cart"));

	}

}
