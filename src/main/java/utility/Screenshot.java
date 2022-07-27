package utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import pojo.ChromeBrowser;


public class Screenshot {
	
	public static void TakeScreenshot (WebDriver driver, String name ) throws IOException {
		
		//WebDriver url= ChromeBrowser.Openbrowser("https://kite.zerodha.com/");
	
		String d = Screenshot.date();
		
		File Source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File Destination = new File("C:\\Users\\Public\\Screenshots\\" +name + d+ ".jpg");
		
		FileHandler.copy(Source, Destination);
	}

	public static String date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MMM-dd HH-mm-ss");
		LocalDateTime cuttentTime = LocalDateTime.now();
		String d =dtf.format(cuttentTime);
		return d;
	}
}
