package com.scrollingevents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Infinitescroll {

	   protected static String url="https://the-internet.herokuapp.com/infinite_scroll";
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
public void infitescroll() throws InterruptedException {
	 for(int i=0;i<5;i++) {
		   JavascriptExecutor js=(JavascriptExecutor) driver; //tyoecast webdriver to javascriptexecutor
		   js.executeScript("window.scrollTo(0,document.body.scrollHeight");  //scroll down
		   Thread.sleep(3000);	
	   }
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}
}
