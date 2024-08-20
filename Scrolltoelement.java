package com.scrollingevents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scrolltoelement {

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
public void scrolltoelement() throws InterruptedException {
	 JavascriptExecutor js=(JavascriptExecutor) driver;
	 WebElement elementlocator=driver.findElement(By.xpath("//div[starts-with(text(),'Make Money with Us')]"));
	 js.executeScript("arguments[0].scrollIntoView(true)",elementlocator);
	 Thread.sleep(4000);
	
}

@AfterSuite
public void closechromebrowser() {
	  driver.quit();
}

}
