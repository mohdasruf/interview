package com.automation;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
   @Test
   public void test1(){
	  
	   System.setProperty("webdriver.chrome.driver","C:\\Users\\toshiba\\Downloads\\chromedriver_win32\\chromedriver.exe");
	   WebDriver driver = new ChromeDriver();
	   driver.get("http://www.facebook.com");
	   driver.close();
   }
   
}
