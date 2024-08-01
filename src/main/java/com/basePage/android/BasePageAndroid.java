package com.basePage.android;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utilities.AndroidGestures;

// Base class that implements Android driver

public class BasePageAndroid {

	public AndroidDriver driver;

	public BasePageAndroid(AndroidDriver driver) {

		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

}
