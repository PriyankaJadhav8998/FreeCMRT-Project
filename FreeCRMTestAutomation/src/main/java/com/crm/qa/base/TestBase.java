package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class TestBase {

public static WebDriver driver;
 public static Properties prop;
 
 public TestBase() {
	 
	 try {
		 prop = new Properties();
		 FileInputStream ip = new FileInputStream(
	System.getProperty("user.dir") + "C:\\Users\\admin\\Eclipse-Workspace 2\\FreeCRMTestAutomation\\"
			+ "src\\main\\java\\com\\crm\\qa\\config\\config.properties" );
		 prop.load(ip);
		 }
	 catch(FileNotFoundException e) {
		 e.printStackTrace();
	 }
	 catch (IOException e) {
		 e.printStackTrace();
	 }
 }



public static void initialization() {
	String browserName = prop.getProperty("browser");
	if(browserName.equals("chrome")) {
		System.setProperty("WebDriver.chrome.driver","D:\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
	 driver = new ChromeDriver();
	}
	else
		if(browserName.equals("FF")) {
			System.setProperty("WebDriver.gecko.driver","C:\\Users\\admin\\Downloads\\geckodriver-v0.33.0-win-aarch64\\geckodriver.exe");
			 driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(prop.getProperty("url"));
}
}
}