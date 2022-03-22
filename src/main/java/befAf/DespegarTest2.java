package befAf;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import pageObjects.BaseTest;

public class DespegarTest2 extends BaseTest {
	
	private WebDriver driver = null;

	@BeforeMethod(alwaysRun=true)
	public void setup(ITestContext context) {
		String nTS = context.getCurrentXmlTest().getParameter("Navegador");
		String n = nTS != null ? nTS : "CHROME";
		driver = BaseTest.iniciarBrowser(n);
		BaseTest.mainPageDespegar(driver);
	}

	@Test(groups= {"grupo2"})
	public void AProvide(String c) throws InterruptedException {
		DespegarHomePage hP = new DespegarHomePage(driver);
		Assert.assertTrue(hP.DespegarV());
		hP.irAlojamiento();
		DespegarAlojamientoPage a = new DespegarAlojamientoPage(driver);
		a.alojamiento(c);
		DespegarResultPage r = new DespegarResultPage(driver);
		Assert.assertTrue(r.Resultado());

	}

	@AfterMethod(alwaysRun = true)
	public void endSetup() {
		driver.close();
	}

	@DataProvider(name = "ciudad")
	public Object[][] dataProvide() {
		return new Object[][] { { " El Calafate, Santa Cruz, Argentina" }, { " Rio Cuarto, Cordoba, Argentina" },
				{ " Buenos Aires, Ciudad de Buenos Aires, Argentina" } };
	}
}


