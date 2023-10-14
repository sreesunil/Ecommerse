package ecommersepage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.ScreenOrientation;

import org.openqa.selenium.support.PageFactory;

import constants.WaitConstants;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Ecommercepage {

	AppiumDriver driver;

	public Ecommercepage(AppiumDriver driver) {

		//this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	

	@AndroidFindBy(id = "com.solodroid.solomerce:id/nav_profile")
	public MobileElement profileTab;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/search")
	public MobileElement searchTab;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/search_src_text")
	public MobileElement searchText;
	
	@AndroidFindBy(id = "com.solodroid.solomerce:id/nav_category")
	public MobileElement category;
	
	
	public void searchText(AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		if(searchTab.isDisplayed()) {
			searchTab.click();
			searchText.sendKeys("Watch");
			driver.hideKeyboard();
		}
	}
	
	public void screenRotate(AppiumDriver driver) {
		
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
	
	public void runAppInBackBround(AppiumDriver driver) {
		
		driver.runAppInBackground(Duration.ofSeconds(8));
	}

}
