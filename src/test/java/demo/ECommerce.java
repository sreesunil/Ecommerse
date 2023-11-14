package demo;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class ECommerce {

	AndroidDriver driver;

	@BeforeClass
	public void LaunchApp() throws MalformedURLException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("appPackage", "com.solodroid.solomerce");
		dc.setCapability("appActivity", ".activities.ActivitySplash");
		dc.setCapability("deviceName", "Samsung");
		dc.setCapability("platformName", "Android");
		dc.setCapability("platformVersion", "13");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);

	}

	 //@Test(priority = 2)
	public void TC01() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("com.solodroid.solomerce:id/nav_profile")).click();
		driver.runAppInBackground(Duration.ofSeconds(8));

	}

	// @Test(priority = 1)
	public void TC02() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("com.solodroid.solomerce:id/search")).click();
		driver.findElement(By.id("com.solodroid.solomerce:id/search_src_text")).sendKeys("Watch");
		driver.hideKeyboard();

		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.rotate(ScreenOrientation.PORTRAIT);

	}

	//@Test
	public void TC03() throws InterruptedException {

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("unlockType", "PIN");
		dc.setCapability("unlockKey", "111111");
		driver.lockDevice();
		Thread.sleep(6000);
		driver.unlockDevice();

	}

	// @Test(priority = 3)
	public void TC04() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement category = driver.findElement(By.id("com.solodroid.solomerce:id/nav_category"));
		Point categorysize = category.getLocation();

		System.out.println(categorysize.x);
		System.out.println(categorysize.y);

		TouchAction action = new TouchAction<>(driver);
		action.tap(PointOption.point(categorysize.x, categorysize.y)).perform();

	}

	//@Test
	public void TC05() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));
		TouchAction swipeAction = new TouchAction<>(driver);
		swipeAction.press(PointOption.point(655, 1200)).waitAction().moveTo(PointOption.point(30, 1200)).release()
				.perform();
		Thread.sleep(3000);
		swipeAction.press(PointOption.point(30, 1200)).waitAction().moveTo(PointOption.point(655, 1200)).release()
				.perform();

	}

	//@Test
	public void TC06() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement search = driver.findElement(By.id("com.solodroid.solomerce:id/search"));

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()" + ".resourceId(\"com.solodroid.solomerce:id/viewpager\"))"
						+ ".scrollForward().scrollIntoView(new UiSelector()"
						+ ".textContains(\"Money Counter Kozure MC-101\"))").click();

	}
	
	@Test
	public void TC07() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("android.widget.ImageView")).click();
	}
	
	

	// @AfterTest
	public void removeDriver() {
		driver.quit();

	}

}
