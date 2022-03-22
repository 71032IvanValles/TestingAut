package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WikiTestsDP {
  @DataProvider (name = "Data Provider Wiki")
  public Object[][] metodoDP(){
	  return new Object[][] { {"Lionel Messi"},{"Cristiano Ronaldo"},{"LeBron James"} };
  }
	
  @Test(dataProvider = "Data Provider Wiki", description = "Validar que los títulos de Wikipedia sean visibles")
  public void ValidarUsoDataProv(String texto) throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	    driver.get("http://wikipedia.org");
	    WebElement searchInput = driver.findElement(By.id("searchInput"));
	    Assert.assertTrue(searchInput.isDisplayed(), "Input no Visible");    
	    searchInput.sendKeys(texto);
	    searchInput.submit();
	    Thread.sleep(2000);	    
	    WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
	    Assert.assertTrue(tituloResultado.isDisplayed(), "No se puede visualizar el título");
	    
  }
}