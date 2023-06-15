/*
 * package extentreport;
 * 
 * import com.aventstack.extentreports.ExtentReports; import
 * com.aventstack.extentreports.ExtentTest; import
 * com.aventstack.extentreports.reporter.ExtentSparkReporter;
 * 
 * public class ExtentReportClass {
 * 
 * public static ExtentReports reports; public static ExtentSparkReporter
 * sparkreport;
 * 
 * private static ExtentReports reportConfig() throws Exception { reports = new
 * ExtentReports(); sparkreport = new
 * ExtentSparkReporter(System.getProperty("user.dir") +
 * "//Reports//TestReport.html"); reports.attachReporter(sparkreport);
 * reports.setSystemInfo("Machine", "testing/prod"); reports.setSystemInfo("OS",
 * "windows 11"); reports.setSystemInfo("user", "Srikanth");
 * sparkreport.loadXMLConfig(System.getProperty("user.dir") +
 * "\\src\\main\\resource\\extent-config.xml"); return reports; }
 * 
 * public static ExtentReports getReportConfig() throws Exception {
 * if(reports==null) { return reportConfig(); } return reports; } }
 */