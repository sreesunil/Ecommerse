package ecommercetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constants.FileConstant;
import constants.VootConstants;
import io.appium.java_client.AppiumDriver;


public class BaseTest {

	public static AppiumDriver driver;

	static ExtentReports extent = new ExtentReports();
	static ExtentSparkReporter spark = null;
	public static ExtentTest test = null;

	public static Logger logger = LogManager.getLogger(BaseTest.class.getName());

	public static void LaunchApp() throws IOException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("appPackage", VootConstants.APP_PACKAGE);
		capabilities.setCapability("appActivity", VootConstants.APP_ACTIVITY);
		capabilities.setCapability("deviceName", VootConstants.DEVICE_NAME);
		capabilities.setCapability("platformName", VootConstants.PLATFORM_NAME);
		capabilities.setCapability("platformVersion", VootConstants.PLATFORM_VERSION);

		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		logger.info("App Launched");

	}

	@BeforeMethod
	public static void setup(Method name) {
		try {
			BaseTest.test = extent.createTest(name.getName());
		} catch (Exception exc) {
			System.out.println(exc.getMessage());
		}

	}

	@BeforeTest
	public static void setDriver() {
		spark = new ExtentSparkReporter(new File(FileConstant.REPORT_PATH));
		extent.attachReporter(spark);

	}

	public static AppiumDriver getDriver() {

		return driver;

	}

	@AfterTest
	public static void removeDriver() {

		extent.flush();
	}

}
