package testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.android.CartPageAndroid;
import com.pages.android.ProductCatalogPageAndroid;

import baseTest.BaseTestAndroid;

public class AppTestAndroid extends BaseTestAndroid {

	@Test(dataProvider = "getData")
	public void fillForm(HashMap<String, String> input) throws InterruptedException {

		Thread.sleep(2000);
		form.enterName(input.get("name"));
		form.selectGender(input.get("gender"));
		form.selectCountry(input.get("country"));
		ProductCatalogPageAndroid catalog = form.clickOnLsetsShopBtn();
		catalog.addItemToCart(0);
		catalog.addItemToCart(0);
		CartPageAndroid cart = catalog.goToCartPage();
		cart.getproductList();
		cart.getTotalAmountDisplayed();
		cart.submitOrder();
	}

	@BeforeMethod
	public void openTheFirstScreen() {

		form.setActivity();
	}

	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"/src/test/java/testcases/shoppingapp.json");
		return new Object[][] { { data.get(0) }, { data.get(1) } };
	}

}
