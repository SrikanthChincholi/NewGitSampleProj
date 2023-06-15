package sampleproj.sampleproj;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	private static ExtentReports reports;
	private static ExtentSparkReporter sparkreport;
	ExtentTest test;
	static WebDriver d;

	@BeforeSuite
	public void suiteConfig() throws Exception {
		reports = getReportConfig();
	}

	@BeforeTest()
	public void beforeTest(ITestContext context) throws Exception {
			test = reports.createTest(context.getName()).createNode(context.getName());
	}

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser, Method meth) {
		getBrowser(browser);
		test.info("Browser Launched !!");
	
	}

	@AfterMethod
	public void atest(Method meth, ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, meth.getName() + " Test Passed");
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(meth.getName() + "  " + result.getThrowable(),ExtentColor.RED));
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, meth.getName() + " Test Skipped");
		}
		d.quit();
		test.log(Status.PASS, "Browser closed !!");
		
	}

	@AfterTest
	public void atest() {
		reports.flush();
	}

	private static WebDriver getBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			d = new ChromeDriver(options);
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			return d;
		} else if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			return d;
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			return d;
		} else {
			System.out.println("No browser found");
			return null;
		}

	}

	private static ExtentReports reportConfig() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String reportPath = System.getProperty("user.dir") + "/Reports/ExecutionReport_" + actualDate + ".html";
		reports = new ExtentReports();
		sparkreport = new ExtentSparkReporter(reportPath);
		reports.attachReporter(sparkreport);
		reports.setSystemInfo("Machine", "testing/prod");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("user", "Srikanth");
		//sparkreport.loadXMLConfig(System.getProperty("user.dir") + "\\src\\main\\resource\\extent-config.xml");
		sparkreport.config().setReportName("Automation Testing");
		sparkreport.config().setDocumentTitle("Regression Test");
		sparkreport.config().setTheme(Theme.DARK);
		sparkreport.config().setTimeStampFormat("dd-MM-yyy HH-mm-ss");
	
		return reports;
	}

	private static ExtentReports getReportConfig() throws Exception {
		if (reports == null) {
			return reportConfig();
		}
		return reports;
	}

}
