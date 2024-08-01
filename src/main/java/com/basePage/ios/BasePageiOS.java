package com.basePage.ios;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

//Base class that implements ios driver

public class BasePageiOS {

	public IOSDriver driver;
	
	public BasePageiOS(IOSDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
}
