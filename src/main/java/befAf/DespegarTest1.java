package befAf;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.DespegarAlojamientoPage;
import pageObjects.DespegarHomePage;
import pageObjects.DespegarResultPage;
import pageObjects.BaseTest;

public class DespegarTest1 extends BaseTest {
	private WebDriver driver = null;

	@BeforeClass(alwaysRun=true)
	public void setup(ITestContext context) {
		String nTS = context.getCurrentXmlTest().getParameter("Navegador");
		String n = nTS != null ? nTS : "CHROME";
		driver = BaseTest.iniciarBrowser(n);
		BaseTest.mainPageDespegar(driver);
	}

	@Test(groups = {"grupo1"})
	public void aTest() throws InterruptedException {
		DespegarHomePage hP = new DespegarHomePage(driver);
		Assert.assertTrue(hP.DespegarV());
		hP.irAlojamiento();
		DespegarAlojamientoPage a = new DespegarAlojamientoPage(driver);
		a.alojamiento("Villa María, Córdoba, Argentina");
	}

	@Test()
	public void ResultPage() throws InterruptedException {
		DespegarResultPage r = new DespegarResultPage(driver);
		Assert.assertTrue(r.Resultado());
	}

	@AfterClass(alwaysRun=true)
	public void endSetup() {
		driver.close();
	}
}

