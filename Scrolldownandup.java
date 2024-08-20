package com.scrollingevents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolldownandup {

	   protected static String url="https://www.amazon.com/";
	   WebDriver driver;

@BeforeSuite 
public void startchromebrowser() {
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
}	

@BeforeClass
public void openurl() {
	  driver.get(url);
}

@Test
public void scrolldownandup() throws InterruptedException {
	   JavascriptExecutor js=(JavascriptExecutor) driver; //tyoecast webdriver to javascriptexecutor
	   js.executeScript("window.scrollTo(0,document.body.scrollHeight)");  //scroll down
	   Thread.sleep(3000);
	   
	   js.executeScript("window.scrollTo(0,0)");  //scroll up
	   Thread.sleep(3000);
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
