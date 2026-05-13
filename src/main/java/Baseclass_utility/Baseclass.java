package Baseclass_utility;




import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import Utility.Genericfile;
import Utility.WebdriverUtility;
import Utility.database_utility;
import listners.UtilityObjectclass;
import pompages.Homepom_page;
import pompages.loginpom_page;

public class Baseclass {

	
	public database_utility dbutil;
	public Genericfile gf = new Genericfile();
	public WebdriverUtility wutil=new WebdriverUtility();
	public WebDriver driver = null;
	
	public static WebDriver sdriver = null;
	
	@BeforeSuite
	public void connectwithdb() throws SQLException {
		dbutil=new database_utility();
		dbutil.getconnectwith_DB();
		Reporter.log("connected with database",true);
	}
	
	@BeforeTest
	public void configParallelExe() {
		Reporter.log("configured the parallel exe",true);
	}
	
	//@Parameters("browser")   //only for cross browser    public void launchthebrowser(string browser) throws IOException {
	@BeforeClass
	public void launchthebrowser() throws IOException {
		Reporter.log("Launching browser",true);
		String browser = gf.propertyutlityfile("browser");
		//launch the browser
		if(browser.equals("chrome"))
			driver = new ChromeDriver();
		else if(browser.equals("edge"))
			driver = new EdgeDriver();
		else if(browser.equals("firefox"))
			driver = new FirefoxDriver();
		else
			driver = new ChromeDriver();
		
		
		sdriver = driver;
		UtilityObjectclass.setDriver(driver);
	}
	
	
	@BeforeMethod
	public void login() throws IOException {
		String url = gf.propertyutlityfile("url");
		String username = gf.propertyutlityfile("username");
		String password = gf.propertyutlityfile("password");
		String timeouts = gf.propertyutlityfile("timeouts");
		
		wutil.Maximize_Browser(driver);
		wutil.WaitForElement_implictly(driver, timeouts);
		wutil.NavigateToApplication(driver, url);
		
		loginpom_page l = new loginpom_page(driver);
		
		l.loginPage(username, password);
		Reporter.log("Logged into the application",true);

	}
	
	
	@AfterMethod
	public void logout() {
		Homepom_page hom = new Homepom_page(driver);
		wutil.MouserOverToElement(driver, hom.getAdminicon());
		hom.getSignout();
		Reporter.log("Logged out of the application",true);
	}
	
	@AfterClass
	public void quitthebrowser() {
		wutil.QuitTheBrowser(driver);
		Reporter.log("quitting the browser",true);
	}
	
	@AfterTest
	public void closeconfigpe() {
		Reporter.log("close config of parallel exe",true);
	}
	
	
	
	@AfterSuite
	public void Disconnect_db() throws SQLException {
		dbutil.disconnectwith_DB();
		Reporter.log("Disconnected with database",true);
	}
	
	
	
	
	
}
























