package com.pages.android;

import java.util.List;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utilities.AndroidGestures;

public class ProductCatalogPage extends AndroidGestures{

	public ProductCatalogPage(AndroidDriver driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text = 'ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	public void addItemToCart(int index) {
		
		addToCart.get(index).click();
		
	}
	
	public CartPage goToCartPage() {
		cart.click();
		return new CartPage(driver);
	}

}
