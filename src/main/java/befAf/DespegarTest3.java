package befAf;

import org.testng.annotations.Test;
import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import pageObjects.BaseTest;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;

public class DespegarTest3 extends BaseTest{
	
	private WebDriver driver = null;
 
	@BeforeClass(alwaysRun=true)
	public void beforeClass(ITestContext context) {
		String nTS = context.getCurrentXmlTest().getParameter("Navegador");
		String n = nTS != null ? nTS : "CHROME";
		driver = BaseTest.iniciarBrowser(n);
		BaseTest.mainPageDespegar(driver);
	}

	@Test(groups = {"grupo3"})
	public void Alojamiento() throws InterruptedException {
		DespegarHomePage hP = new DespegarHomePage(driver);
		Assert.assertTrue(hP.DespegarV());
		hP.irAlojamiento();
		DespegarAlojamientoPage a = new DespegarAlojamientoPage(driver);
		a.alojamiento("Rio Cuarto, Cordoba, Argentina");
		DespegarResultPage r = new DespegarResultPage(driver);
		Assert.assertTrue(r.Resultado());
		r.Pr();
	}

	@AfterClass(alwaysRun=true)
	public void afterClass() {
		driver.close();
	}
}
