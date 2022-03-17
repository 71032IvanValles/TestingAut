package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private WebDriver driver;

	public static void gotoMainPageWiki(WebDriver driver) {
		driver.get("http://wikipedia.org");
	}

	public static void gotoMainPageDespegar(WebDriver driver) {
		driver.get("https://www.despegar.com.ar/");
	}

	public WebDriver chromeDriverConnection() {
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public static WebDriver iniciarBrowser(String browserName) {
		WebDriver driver = null;
		switch (browserName) {
		case "CHROME": {System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			System.out.println("Abro Chrome");
			driver = new ChromeDriver();
			break;
		}
		case "FIREFOX": {
			System.setProperty("webdriver.gecko.driver", "C:\\Drivers\\geckodriver.exe");
			System.out.println("Abro Firefox");
			driver = new FirefoxDriver();
			break;
		}
		default: {
			System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
			System.out.println("Abro Chrome");
			driver = new ChromeDriver();
			break;
		}

		}
		return driver;

	}
}
