package com.scrollingevents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolleffectwithcoordinates {

	   protected static String url="https://www.selenium.dev/";
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
public void scrollwithcoordinates() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	//scroll down by 150px for 11 times
	for(int i=0;i<10;i++ ) {
		js.executeScript("window.scrollBy(0,150)");
		Thread.sleep(1000);
	}
	
	//scroll up
	for(int i=0;i<10;i++ ) {
		js.executeScript("window.scrollBy(0,-150)");
		Thread.sleep(1000);
	}
}

@Test
public void bottomofpage() throws InterruptedException {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	Thread.sleep(3000);
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}	
}
