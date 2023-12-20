package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import constants.FileConstant;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class CommonUtils {
	
	
	public static String getStringDateAndTimestamp() {
		String value = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return value;
	}
	
	
	  public static String getScreenshots(AppiumDriver driver) throws IOException {
	  String path = FileConstant.SCREENSHOT_PATH; TakesScreenshot screen =
	  (TakesScreenshot)driver; File src = screen.getScreenshotAs(OutputType.FILE);
	  File destination = new File(path); FileUtils.copyFile(src, destination);
	  return path; }
	 
	
}
