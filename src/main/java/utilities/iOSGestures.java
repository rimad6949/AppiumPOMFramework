package utilities;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.basePage.ios.BasePageiOS;

import io.appium.java_client.ios.IOSDriver;

//Action utility classes for both ios

public class iOSGestures extends BasePageiOS{

	public iOSGestures(IOSDriver driver) {
		super(driver);
	}
	
	//Single click guesture
	public void click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap();
		params.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile:tap", params);
		
	}
	
	//Double click guesture
	public void doubleClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String,Object> params = new HashMap();
		params.put("element", ((RemoteWebElement) element).getId());
		js.executeScript("mobile:doubleTap", params);
	}
	
	//Scroll Down Guesture
	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap();
		params.put("element", ((RemoteWebElement) element).getId());
		params.put("direction", "down");
		js.executeScript("mobile:scroll", params);
	}
	
	//Long Press Guesture
	public void longPressGuesture(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap();
		params.put("element", ((RemoteWebElement) element).getId());
		params.put("duration", 2.0);
		js.executeScript("mobile:touchAndHole", params);
		
	}

	//Swipe Guesture
	public void swipe(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Map<String, Object> params = new HashMap();
		params.put("element", ((RemoteWebElement) element).getId());
		params.put("direction", "left");
		js.executeScript("mobile:swipe", params);
	}

}
