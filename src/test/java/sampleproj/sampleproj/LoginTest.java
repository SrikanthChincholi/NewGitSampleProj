package sampleproj.sampleproj;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataproviders.DataProviders;
import sampleproj.utils.PropertyReader;

public class LoginTest extends BaseClass {

	String url = PropertyReader.getValue("url");

	@Test(dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void login(String username, String password,Method meth) throws Exception {
		try {
			d.get(url);
			test.log(Status.INFO, url + "entered");
			d.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			test.pass(username + "entered !!");
			Thread.sleep(3000);
			d.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			assertEquals(password, "admin123");
			test.pass(password + "entered !!");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
