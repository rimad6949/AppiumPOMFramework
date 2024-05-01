package com.pages.ios;

import org.openqa.selenium.WebElement;

import com.basePage.ios.BasePageiOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class iOSAppTest extends BasePageiOS{

	public iOSAppTest(IOSDriver driver) {
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
	
	@iOSXCUITFindBy(iOSNsPredicate = "**/XCUIElementTypeButton[`label == \"OK\"`]")
	public WebElement oKBtn;
	
	public void alertViewFlow() {
		alertView.click();
		textEntry.click();
		titleTextbox.sendKeys("I am Blessed");
		oKBtn.click();
	}

}
