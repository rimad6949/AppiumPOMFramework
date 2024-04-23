package com.pages.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v116.systeminfo.SystemInfo;
import org.testng.Assert;

import com.basePage.android.BasePage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends BasePage {

	public CartPage(AndroidDriver driver) {
		super(driver);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/termsButton")
	public WebElement terms;

	@AndroidFindBy(id = "android:id/button1")
	public WebElement acceptTermsBtn;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	public WebElement proceedBtn;

	@AndroidFindBy(className = "android.widget.CheckBox")
	public WebElement checkBox;

	Double totalAmtOfTheProducts = 0.0;

	public void getproductList() {

		int numOfProductCount = productList.size();
		for (int i = 0; i < numOfProductCount; i++) {

			String individualProductPrice = productList.get(i).getText();
			individualProductPrice = individualProductPrice.replace("$", "");
			System.out.println(individualProductPrice);
			Double getAmt = Double.parseDouble(individualProductPrice);
			System.out.println(getAmt);
			totalAmtOfTheProducts = totalAmtOfTheProducts + getAmt;
			System.out.println(totalAmtOfTheProducts);

		}
	}

	public void getTotalAmountDisplayed() {

		String finalAmt = totalAmount.getText();
		finalAmt = finalAmt.replace("$", "");
		Double finalAmtDisplayed = Double.parseDouble(finalAmt);		
		System.out.println(finalAmtDisplayed);
		Assert.assertEquals(totalAmtOfTheProducts, finalAmtDisplayed);
	}

	public void submitOrder() {
		checkBox.click();
		proceedBtn.click();
	}

}
