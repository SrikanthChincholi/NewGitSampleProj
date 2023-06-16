package sampleproj.sampleproj;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import dataproviders.DataProviders;
import dbconfig.DBConfiguration;
import dbconfig.ReadDataFromDB;
import sampleproj.sampleproj.BaseClass;
import sampleproj.utils.LoggerClass;
import sampleproj.utils.PropertyReader;

public class LoginTest extends BaseClass {

	String url = PropertyReader.getValue("url");
	Logger log = LoggerClass.getLog(LoginTest.class);
	List<ReadDataFromDB> dbdata;
	static int i = 0;

	@Test(dataProviderClass = DataProviders.class, dataProvider = "Login")
	public void login(String username, String password, Method meth) throws Exception {
		try {
			dbdata = DBConfiguration.getDataFromDB();
			d.get().get(url);
			log.info(dbdata.get(i).getUserlocation());
			log.info(dbdata.get(i).getUseroccupation());
			log.info(dbdata.get(i).getUserage());
			i++;
			test.log(Status.INFO, url + "entered");
			d.get().findElement(By.xpath("//input[@name='username']")).sendKeys(username);
			test.pass(username + "entered !!");
			Thread.sleep(3000);
			d.get().findElement(By.xpath("//input[@name='password']")).sendKeys(password);
			assertEquals(password, "admin123");
			test.pass(password + "entered !!");
			Thread.sleep(3000);
			
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
