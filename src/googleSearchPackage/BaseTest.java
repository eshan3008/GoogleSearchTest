package googleSearchPackage;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseTest {

	/** The driver. */
	protected WebDriver driver;

	/**
	 * Global setup.
	 */

	/**
	 * Setup.
	 */
	@BeforeClass
	protected void setup() {
		
		String os= System.getProperty("os.name").toLowerCase();
		WebDriver driver= new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver,3);
		
		if(os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "/usr/local/bin");
		}
		else {
			// set property for chromedriver.exe like for windows
		}

		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("disable-infobars");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Wrap up.
	 */
	@AfterClass
	public void wrapUp() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}
