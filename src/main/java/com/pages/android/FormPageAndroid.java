package com.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.AndroidGestures;

public class FormPageAndroid extends AndroidGestures{
	
	public FormPageAndroid(AndroidDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
		
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryDropDown;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement genderMaleRadioBtn;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement genderFemaleRadioBtn;
	
	@AndroidFindBy(className = "android.widget.Button")
	private WebElement letsShopBtn;
	
	public void selectCountry(String countryName) {
		countryDropDown.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}


	public void enterName(String name) {
		nameField.sendKeys(name);
		driver.hideKeyboard();
	}
	
	public void selectGender(String gender) {
		
		if(gender.contains("female"))
			genderFemaleRadioBtn.click();
		else if (gender.contains("male"))
			genderMaleRadioBtn.click();
		
	}
	
	public ProductCatalogPageAndroid clickOnLsetsShopBtn() {
		letsShopBtn.click();
		return new ProductCatalogPageAndroid(driver);
		
	}
	
	public void setActivity() {

		Activity activity = new Activity("com.androidsample.generalstore",
				"com.androidsample.generalstore.MainActivity");

		((JavascriptExecutor) driver).executeScript("mobile:startActivity", ImmutableMap.of("intent", "com.androidsample.generalstore/com.androidsample.generalstore.SplashActivity"));
        System.out.println("Switched back to main page .");
    }

}
