package sampleproj.sampleproj;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import sampleproj.utils.LoggerClass;
import sampleproj.utils.PropertyReader;

public class TestClass2 {

	static WebDriver d;
	String url = PropertyReader.getValue("url");
	Logger log = LoggerClass.getLog(TestClass2.class);

	@Test(dataProvider = "login")
	public void test1(String username, String password) throws Exception {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("Browser opened");
		d.get(url);
		log.info(url + " entered !!");
		d.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		log.info(username + " entered !!");
		d.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		log.info(password + " entered !!");
		Thread.sleep(5000);
		d.quit();
		log.info("browser closed");
	}

	@DataProvider(name = "login")
	private Object[][] login() {
		return new Object[][] { { "admin", "admin123" }, { "admin", "admin123" } };
	}

}
