package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.Assert;

public class DespegarTest {
	private WebDriver driver;
	By alojamientoLocator = By.xpath("//a[@href=\"//www.despegar.com.ar/hoteles/\"]");
	By ingresoCiudadLocator = By.cssSelector("div.input-container>input[placeholder='Ingres� una ciudad, alojamiento o punto de inter�s'");
	By calendarioLocator = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-02']//div[@class='sbox5-monthgrid-datenumber-number'][text()='18']");
	By entradaLocator = By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input1\"]");
	By salidaLocator = By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input2-container\"]");
	By calendarioSalidaLocator = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month]='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='3']");
	
	@Test(description = "Validar seleccionar alojamiento con destino y fechas con 3 adultos y 1 menor y que figure algo")
	
	public void ValidarBusquedaDespegar() throws InterruptedException {
	    System.setProperty("webdriver.chrome.driver", "C:/Drivers/chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.despegar.com.ar/");
	    driver.findElement(alojamientoLocator).click();
	    Thread.sleep(2000);
	    driver.findElement(ingresoCiudadLocator).sendKeys(" Villa Carlos Paz, Córdoba, Argentina");
	    Thread.sleep(2000);
	    driver.findElement(ingresoCiudadLocator).sendKeys(Keys.ENTER);
	    Thread.sleep(2000);
	    driver.findElement(entradaLocator).click();
	    Thread.sleep(2000);
	    driver.findElement(calendarioLocator).click();
	    Thread.sleep(2000);
	    driver.findElement(salidaLocator).click();
	    Thread.sleep(2000);
	    driver.findElement(calendarioSalidaLocator).click();
	    
	    
	    
	 
	    
	    
	}
}
