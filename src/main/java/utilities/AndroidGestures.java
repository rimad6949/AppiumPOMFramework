package utilities;

import com.basePage.android.BasePage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidGestures extends BasePage{
	
	public AndroidGestures(AndroidDriver driver) {
		super(driver);
	}
	
	public void scrollToText(String text) {
		
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
		
	}
	
	
	

}
