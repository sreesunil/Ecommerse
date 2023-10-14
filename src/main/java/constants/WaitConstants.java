package constants;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;



public class WaitConstants {
	
	
	
	public static void waitForElement(AppiumDriver driver) {
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		

	}

}
