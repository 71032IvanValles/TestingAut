package tests;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DespegarTestCi {
	
	@Test(description = "Validar los clicks de los botones de la barra superior de despegar.com")
	
	public void validarBotones() throws Exception{
		System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.despegar.com.ar/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		List<WebElement> listaDeElementos = driver.findElements(By.xpath("//ul[@class='header-list-products']/li"));
		for(WebElement elemento : listaDeElementos) {
			//WebElement aElemento = elemento.findElement(By.xpath("./a[@title]"));
			//aElemento.click();
			System.out.print(elemento.getText() + " ");
			Assert.assertTrue(elemento.isDisplayed());
			
	}
		driver.close();

	    
	    
	 
	    
	    
	}
}
