package ecommercetest;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constants.WaitConstants;
import ecommersepage.Ecommercepage;
import io.appium.java_client.AppiumDriver;

import listeners.CommonListeners;

@Listeners(CommonListeners.class)
public class EcommerceTest extends BaseTest {

	@BeforeClass
	public void Launch() throws IOException {
		LaunchApp();



	}

	//@Test(priority = 3)
	public void TC01() throws IOException {

		AppiumDriver driver = BaseTest.getDriver();

		Ecommercepage ecommercepage = new Ecommercepage(driver);
		WaitConstants.waitForElement(driver);

		ecommercepage.profileTab.click();

		BaseTest.logger.info("Click Successful");

	}

	@Test(priority = 1)
	public void TC02() {
		
		AppiumDriver driver = BaseTest.getDriver();
		

		Ecommercepage ecommercepage = new Ecommercepage(driver);
		
		ecommercepage.searchText(driver);

		BaseTest.logger.info("Product Selected");
	}
	
	@Test(priority = 4)
	public void TC03() {
		
		AppiumDriver driver = BaseTest.getDriver();
		
		Ecommercepage ecommercepage = new Ecommercepage(driver);
		ecommercepage.screenRotate(driver);
		
		BaseTest.logger.info("Screen rotate");
		
	}
	@Test(priority = 2)
	public void TC04() {
		
		Ecommercepage ecommercepage = new Ecommercepage(driver);
		ecommercepage.runAppInBackBround(driver);
	}

}
