package demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class LaunchApp {

	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity", ".activities.ActivitySplash");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "13");
		
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
		
	}

}
