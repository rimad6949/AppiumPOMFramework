package com.pages.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.AndroidGestures;

public class FormPage extends AndroidGestures{
	
	public FormPage(AndroidDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
		
	@AndroidFindBy(id = "android:id/text1")
	public WebElement countryDropDown;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	public WebElement genderMaleRadioBtn;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	public WebElement genderFemaleRadioBtn;
	
	@AndroidFindBy(className = "android.widget.Button")
	public WebElement letsShopBtn;
	
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
	
	public void clickOnLsetsShopBtn() {
		letsShopBtn.click();
		
	}

}
