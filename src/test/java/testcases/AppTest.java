package testcases;

import org.testng.annotations.Test;

import com.pages.android.CartPage;
import com.pages.android.FormPage;
import com.pages.android.ProductCatalogPage;

import baseTest.BaseTest;

public class AppTest extends BaseTest{
	
	@Test
	public void fillForm() throws InterruptedException {
		
		FormPage form = new FormPage(driver);
		Thread.sleep(2000);
		form.enterName("Rima");
		form.selectGender("female");
		form.selectCountry("Argentina");
		ProductCatalogPage catalog = form.clickOnLsetsShopBtn();
		catalog.addItemToCart(0);
		catalog.addItemToCart(0);
		CartPage cart = catalog.goToCartPage();
		cart.getproductList();
		cart.getTotalAmountDisplayed();
		cart.submitOrder();
	}

}
