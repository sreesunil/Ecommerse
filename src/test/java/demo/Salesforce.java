package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Salesforce {
	
	

	AndroidDriver driver;

	@Test
	public void LaunchApp() throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.salesforce.chatter");
		dc.setCapability("appActivity", "com.salesforce.chatter.Chatter");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "13");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
		driver.findElement(By.id("com.salesforce.chatter:id/mi_accept")).click();
		
		//com.salesforce.auth.ChatterLoginActivity
		
		//com.salesforce.chatter.Chatter

	}

}
