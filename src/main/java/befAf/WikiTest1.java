package befAf;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.WikiHomePage;
import pageObjects.WikiResultPage;
import pageObjects.BaseTest;

public class WikiTest1 extends BaseTest {
	private WebDriver driver = null;

	@BeforeClass
	public void setup(ITestContext context) {
		String nTS = context.getCurrentXmlTest().getParameter("Navegador");
		String n = nTS != null ? nTS : "CHROME";
		driver = BaseTest.iniciarBrowser(n);
		BaseTest.mainPageWiki(driver);
	}

	@Test
	public void BusquedaWiki() {
		WikiHomePage hP = new WikiHomePage(driver);
		Assert.assertTrue(hP.searchInputesVisible());
		WikiResultPage rP = hP.searchInput("Selenium");
		Assert.assertTrue(rP.tituloVisible());
	}

	@AfterClass
	public void endSetup() {
		driver.close();
	}
}
