package gridconfig;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
/***
  * 
  * 
  * @params 
  * @author DELL
  *
  */
public class RemoteWebDriverConfig {

	static ThreadLocal<RemoteWebDriver> d = new ThreadLocal<RemoteWebDriver>();
	static DesiredCapabilities cap;

	@Parameters({ "browser" })
	@BeforeMethod
	public static void setDriver(String browser) throws MalformedURLException, Exception {
		if (browser.equalsIgnoreCase("chrome")) {
			Thread.sleep(3000);
			cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);
			d.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
			d.get().manage().window().maximize();

		} else if (browser.equalsIgnoreCase("firefox")) {
			Thread.sleep(3000);
			cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);
			d.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
			d.get().manage().window().maximize();
			
		} else if (browser.equalsIgnoreCase("MicrosoftEdge")) {
			Thread.sleep(3000);
			cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);
			d.set(new RemoteWebDriver(new URL("http://localhost:4444"), cap));
			d.get().manage().window().maximize();

		}
		
		
	}

	@AfterMethod
	public static void closeBrowser() {
		d.get().quit();
		//d.remove();
	}

	public static ThreadLocal<RemoteWebDriver> getDriver() {
		return d;
	}

}
