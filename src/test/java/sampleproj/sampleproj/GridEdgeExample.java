package sampleproj.sampleproj;

import java.net.MalformedURLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import gridconfig.RemoteWebDriverConfig;

public class GridEdgeExample extends RemoteWebDriverConfig {

	@Test
	public void edgetest() throws MalformedURLException, Exception {
	
		getDriver().get().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(getDriver().get(), Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
	    getDriver().get().findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
		Thread.sleep(3000);
		getDriver().get().findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		Thread.sleep(3000);
		getDriver().get().findElement(By.xpath("//button[@type='submit']")).click();
		closeBrowser();
	}

}
