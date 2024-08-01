package com.pages.ios;

import org.openqa.selenium.WebElement;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import utilities.iOSGestures;

public class HomePageiOS extends iOSGestures {

	public HomePageiOS(IOSDriver driver) {
		super(driver);

	}

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Alert Views\"`]")
	public WebElement alertView;

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"Text Entry\"`]")
	public WebElement textEntry;

	@iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
	public WebElement confirmPopup;

	@iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
	public WebElement titleTextbox;

	@iOSXCUITFindBy(xpath="//XCUIElementTypeButton[@name=\"OK\"]")
	public WebElement oKBtn;

	public void alertViewFlow() {
		alertView.click();
		textEntry.click();
		titleTextbox.sendKeys("I am Blessed");
		oKBtn.click();
	}

}
