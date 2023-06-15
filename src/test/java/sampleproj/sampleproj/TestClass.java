package sampleproj.sampleproj;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sampleproj.utils.LoggerClass;
import sampleproj.utils.PropertyReader;

public class TestClass {

	static WebDriver d;
	String url = PropertyReader.getValue("url");
	String username = PropertyReader.getValue("username");
	String password = PropertyReader.getValue("password");

	Logger log = LoggerClass.getLog(TestClass.class);

	@Test
	public void test1() throws Exception {
		try {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			log.info("Browser opened");
			d.get(url);
			log.info("url entered !!");
			d.findElement(By.xpath("//input[@name='usernam']")).sendKeys(username);
			log.info("Username entered !!");
			d.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			log.info("Password entered !!");
			Thread.sleep(5000);
			d.quit();
			log.info("browser closed");
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		} finally {
			d.quit();
			log.info("browser closed");
		}
	}

}
