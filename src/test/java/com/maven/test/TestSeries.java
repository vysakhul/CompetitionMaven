package com.maven.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import com.auto.mainpage.LandingPage;
import com.auto.values.TestValues;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSeries {
	LandingPage lp;
	WebDriver driver;
	public static Properties prop = null;

	
  @BeforeMethod
  public void prep() {

	  try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources" + "/config.properties");
		prop.load(ip);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();		
	}
	  
	  if(prop.getProperty("browser").equals("chrome"))
	  {
		  WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver(); 
	  }
	  else if(prop.getProperty("browser").equals("firefox"))
	  {
		  WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
	  }
	  driver.get(prop.getProperty("url"));
	  driver.manage().window().maximize();  		
  }

  
  @Test(priority = 1)
  public void AutoOne() throws Exception
  {	  
	  lp = new LandingPage(driver); 
	  lp.setName(TestValues.NAME);
	  lp.setPhone(TestValues.PHONE);
	  lp.setEmail(TestValues.EMAIL);
	  lp.setPass(TestValues.PASSWORD);
	  lp.setAddress(TestValues.ADDRESS);
	  Thread.sleep(3000);
  }
  
  @Test(priority = 2)
  public void AutoTwo() throws Exception
  {
	 driver.findElement(By.id("male")).click();
	 driver.findElement(By.id("tuesday")).click();
	 driver.findElement(By.id("friday")).click();
	 Thread.sleep(3000);
  }
  
  
  @Test(priority = 3)
  public void AutoThree() throws Exception
  {
	  Select country = new Select(driver.findElement(By.className("custom-select")));
	  country.selectByValue("1");
	  Thread.sleep(3000);
  }
  
  @Test(priority = 4)
  public void AutoFour() throws Exception
  {
	  driver.findElement(By.xpath("//label[@for='2years']")).click();
	  driver.findElement(By.xpath("//label[@for='selenium']")).click();
	  driver.findElement(By.xpath("//label[@for='testng']")).click();
	  Thread.sleep(3000);
  }
  
  @AfterMethod
  public void shutdown()
  {
	  driver.close();
  }
  
}
