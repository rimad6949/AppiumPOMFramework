package testcases;

import org.testng.annotations.Test;

import com.pages.android.CartPageAndroid;
import com.pages.android.FormPageAndroid;
import com.pages.android.ProductCatalogPageAndroid;

import baseTest.BaseTestAndroid;

public class AppTestAndroid extends BaseTestAndroid{
	
	@Test
	public void fillForm() throws InterruptedException {
		
		FormPageAndroid form = new FormPageAndroid(driver);
		Thread.sleep(2000);
		form.enterName("Rima");
		form.selectGender("female");
		form.selectCountry("Argentina");
		ProductCatalogPageAndroid catalog = form.clickOnLsetsShopBtn();
		catalog.addItemToCart(0);
		catalog.addItemToCart(0);
		CartPageAndroid cart = catalog.goToCartPage();
		cart.getproductList();
		cart.getTotalAmountDisplayed();
		cart.submitOrder();
	}

}
