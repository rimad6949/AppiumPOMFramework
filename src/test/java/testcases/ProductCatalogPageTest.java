package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.pages.android.ProductCatalogPage;

import baseTest.BaseTest;

public class ProductCatalogPageTest extends BaseTest{
	
	@Test
	public void addToCart() throws InterruptedException {
		FormPageTest form = new FormPageTest();
		form.fillForm();
		
		
		ProductCatalogPage catalog = new ProductCatalogPage(driver);		
		catalog.addItemToCart(0);
		catalog.addItemToCart(0);
		catalog.goToCartPage();
		Thread.sleep(2000);
	}

}
