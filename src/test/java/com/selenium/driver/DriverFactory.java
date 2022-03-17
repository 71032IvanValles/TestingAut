package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

public class DriverFactory {
	private enum browsers{
		EXPLORER, SAFARI, FIREFOX, CHROME
	};
 
  public static WebDriver LevantarBrowser (WebDriver driver, String browserName, String URL) 
  {
	  switch (browsers.valueOf(browserName)) {
	  case CHROME:
	  {
		  System.setProperty("webdriver.chrome.driver", "C:\\Drivers/chromedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new ChromeDriver();
		  break;
	  }
	  case EXPLORER:
	  {
		  System.setProperty("webdriver.edge.driver", "C:\\Drivers/msedgedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new EdgeDriver();
		  break;
	  }
	  case FIREFOX:
	  {
		  System.setProperty("webdriver.firefox.driver", "C:\\Drivers/geckodriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new FirefoxDriver();
		  break;
	  }
	  default:
		  Reporter.log("No selecciono ningun browser correcto, se le asginara chrome");
		  System.setProperty("webdriver.edge.driver", "C:\\Drivers/chromedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new EdgeDriver();
		  break;
	  }
	  driver.get(URL);
	  driver.manage().window().maximize();
	  return driver;
  }
}
