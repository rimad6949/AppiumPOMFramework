package testcases;

import org.testng.annotations.Test;

import com.pages.android.FormPage;

import baseTest.BaseTest;

public class FormPageTest extends BaseTest{
	
	@Test
	public void fillForm() throws InterruptedException {
		
		FormPage form = new FormPage(driver);
		Thread.sleep(2000);
		form.enterName("Rima");
		form.selectGender("female");
		form.selectCountry("Argentina");
		form.clickOnLsetsShopBtn();
	
	}

}
