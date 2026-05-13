package Contact_module;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import Baseclass_utility.Baseclass;
import Utility.ExcelFileUtility;
import Utility.Genericfile;
import Utility.WebdriverUtility;
import Utility.javautility;
import listners.UtilityObjectclass;
import pompages.Homepom_page;
import pompages.contact_pom_page;
import pompages.contactinfo_pompage;
import pompages.createnew_contact_pompage;
import pompages.createnew_organization_pompage;
import pompages.loginpom_page;
import pompages.organization_pom_page;
import pompages.organizationinfopom_page;


//@Listeners(listners.Listners.class)    

/*
 
 
 @Listeners(listners.Listners.class)
 
 only test level 
 whenever we go for batch,group,parallel,cb we turn off listners because we given in suite level in xml code 
 
 */


//hi this class is used to  contact module

public class Createcontact_moduletest extends Baseclass {

	
	@Test(groups = "smoke" , retryAnalyzer = listners.RetryAnalyse.class)
	public void CreateContact_Withlastname_test() throws InterruptedException, EncryptedDocumentException, IOException, SQLException {
		//Reporter.log("Browser Setup",true);
		// fetch property file data using PropertyFileUtility
		
		
		//listners.Listners.test.log(Status.INFO, "fetching Random Intege");
		UtilityObjectclass.getTest().log(Status.INFO, "fetching the  random integer");
		
		javautility jutil=new javautility();
		int randam = jutil.fetchRandom();
		
		// Get The Test Data From Excel File Using ExcelFileUtility
		
		UtilityObjectclass.getTest().log(Status.INFO, "fetching the  data from excel");

		
		ExcelFileUtility exc = new ExcelFileUtility();
		String lastname = exc.fetchDataFromExcelFile("Contact", 1, 3)+randam;

		//launchthebrowser();
		
//		String Browser="chrome";	
//		String lastname = "Tommy";
		
		//WebdriverUtility wutil=new WebdriverUtility();
		// Maximize the Browser
		//driver.manage().window().maximize();
		//wutil.Maximize_Browser(driver);
		
		
		//login();
		
		// Implicity wait
		//long Timeouts = Long.parseLong(timeouts);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
		
		// Navigate To The Application
		//driver.get(url);
		
		// Create objet for logingpage
		//loginpom_page log = new loginpom_page(driver);

		// Identify User NAme TF And Pass Data In Tf
		// driver.findElement(By.name("user_name")).sendKeys(username);
		//log.getUsernametf().sendKeys(username);
		// Identify Password Tf And Pass The data In Tf
		// driver.findElement(By.name("user_password")).sendKeys(password);
		//log.getPasswordtf().sendKeys(password);
		// Identify Login Button And Click On It
		// driver.findElement(By.id("submitButton")).click();
		//log.getLoginbtn().click();
		
		// Identify The Home Page
//		if (driver.getCurrentUrl().contains("Home")) {
//			Reporter.log("Home Page Should Be Displayed",true);
//		} else {
//			Reporter.log("Login Test Fail",true);
//		}
		
		SoftAssert as = new SoftAssert();
		as.assertTrue(driver.getCurrentUrl().contains("Home"),"validating home page");

		
		UtilityObjectclass.getTest().log(Status.INFO, "verified home page");


		// Identify Contacts Tab And Click On It
		//driver.findElement(By.linkText("Contacts")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify contact tab and click on it");

		
		Homepom_page hom=new Homepom_page(driver);
		hom.getContactstab();
		
		// Identify Plus Icon And click
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		// Identify Plus Icon And click
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify plus icon and click on it");

		contact_pom_page contact=new contact_pom_page(driver);
		contact.getContact_plusicon();
		
		
		
		// identify And Pass The Data in Last Name Text Field
		//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname+randam);
		
		//identify org name tf and pass org name
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify and pass data  inlast name text field");

		
		createnew_contact_pompage cno=new createnew_contact_pompage(driver);
		cno.getLastnametxt(lastname);
		
		// Identify Save Button And Click On It
		//driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify save button and click on it");

		
		cno.getSavebtn();
		
		// Identify Header And Validate
		
		UtilityObjectclass.getTest().log(Status.PASS, "identify and validate the contact information header");

		
		contactinfo_pompage cinfo=new contactinfo_pompage(driver);
		String info = cinfo.getContacinfotheader();

//		if (info.contains("Contact Information")) {
//			Reporter.log("Contact Information Header displayed",true);
//		} else {
//			Reporter.log("Contact Information Header not displayed",true);
//		}
		
		Assert.assertTrue(info.contains("Contact Information"), "Contact Information Header displayed");

		
		UtilityObjectclass.getTest().log(Status.PASS, "identify and validate the contact created with lastname");

		
		
		String lastnametxt = cinfo.getVerifylastnametxt();
//		if (lastnametxt.contains(lastname)) {
//			Reporter.log("Contact Created With Last name",true);
//		} else {
//			Reporter.log("Contact Not Created With Lastname",true);
//		}

		Assert.assertTrue(lastnametxt.contains(lastname), "Contact Created With Last name");

		
		
		// Identify Contacts Tab And Click On It
		//driver.findElement(By.linkText("Contacts")).click();
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify contact tab and click on it");

		hom.getContactstab();
		
		// Identify Delete button And Click On It
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify delete button and click on it");

		
		driver.findElement(By.xpath("//a[text()='" + lastname+ "']/../..//a[text()='del']")).click();

		Thread.sleep(2000);
		
		// Handle Pop ANd Click On Ok Button
		//driver.switchTo().alert().accept();
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "Handle Pop ANd Click On Ok Button");

		
		wutil.handleAlertClickonOK(driver);
		
		
		
		
		
		Thread.sleep(2000);

		// click on Admin button
		//WebElement Adminicon = hom.getAdminicon();

		// move the cursor to Admin Button
		//Actions act = new Actions(driver);
		//act.moveToElement(Adminicon).perform();
		//wutil.MouserOverToElement(driver, Adminicon);
		
		// click On Sign Out
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
		//logout();
		
		//hom.getSignout();
		
		//Reporter.log("SignOut Successfully");
		//driver.quit();
		//wutil.QuitTheBrowser(driver);
		
		
		//Close The Excel File
		
		UtilityObjectclass.getTest().log(Status.INFO, "close the excel");
       exc.closeExcel();
		as.assertAll();
		
	}
	
	@Test(groups = "regression" ,retryAnalyzer = listners.RetryAnalyse.class)
	public void CreateContact_With_orgnametest() throws InterruptedException, EncryptedDocumentException, IOException {

		// fetch property file data using PropertyFileUtility
//		Genericfile p = new Genericfile();
//
//		String url = p.propertyutlityfile("url");
//		String Browser = p.propertyutlityfile("browser");
//		String username = p.propertyutlityfile("username");
//		String password = p.propertyutlityfile("password");
//		String timeouts = p.propertyutlityfile("timeouts");

		UtilityObjectclass.getTest().log(Status.INFO, "fetching random integer");

		
		
		javautility jutil = new javautility();
		int randam = jutil.fetchRandom();

		
		// Get The Test Data From Excel File Using ExcelFileUtility
		
		UtilityObjectclass.getTest().log(Status.INFO, "fetching data from excel");

		
		ExcelFileUtility exc = new ExcelFileUtility();
		String orgname = exc.fetchDataFromExcelFile("Contact", 7, 4)+randam;
		String lastname = exc.fetchDataFromExcelFile("Contact", 7, 3)+randam;

//				WebDriver driver = null;
//		// lanch The Browser
//		if (Browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (Browser.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (Browser.equals("Firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//		WebdriverUtility wutil = new WebdriverUtility();
//		// Maximize the Browser
//		// driver.manage().window().maximize();
//		wutil.Maximize_Browser(driver);
//
//		// Implicity wait
//		// long Timeouts = Long.parseLong(timeouts);
//		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
//		wutil.WaitForElement_implictly(driver, timeouts);
//
//		// Navigate To The Application
//		// driver.get(url);
//		wutil.NavigateToApplication(driver, url);
//
//		loginpom_page log = new loginpom_page(driver);
//		// Identify User NAme TF And Pass Data In Tf
//		// driver.findElement(By.name("user_name")).sendKeys(username);
//		// Identify Password Tf And Pass The data In Tf
//		// driver.findElement(By.name("user_password")).sendKeys(password);
//		// Identify Login Button And Click On It
//		// driver.findElement(By.id("submitButton")).click();
//		log.loginPage(username, password);

		// Identify The Home Page
//		if (driver.getCurrentUrl().contains("Home")) {
//			Reporter.log("Home Page Should Be Displayed",true);
//		} else {
//			Reporter.log("Login Test Fail",true);
//		}
		
		UtilityObjectclass.getTest().log(Status.INFO, "verify home page");

		
		SoftAssert as = new SoftAssert();
		as.assertTrue(driver.getCurrentUrl().contains("Home"),"validating home page");

		

		Homepom_page hom = new Homepom_page(driver);

		// Identify Organization Tab And Click On It
		// driver.findElement(By.linkText("Organizations")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization Tab And Click On It");

		
		hom.getOrganizationstab();

		// Create Object For Organizationpage
		organization_pom_page org = new organization_pom_page(driver);

		// Identify Plus Icon And click
		// driver.findElement(By.xpath("//img[@title='Create
		// Organization...']")).click();
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Plus Icon And click on it in organization page");
          org.getPlusicon();

		// Create object for organization information page
		createnew_organization_pompage cno = new createnew_organization_pompage(driver);

		// Identify Organization Tf and pass The data
		// driver.findElement(By.name("accountname")).sendKeys(orgname);
		
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization Tf and pass The data");

		cno.getOrganization_name(orgname);

		// Identify Save Button And Click On It
		// driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Save Button And Click On It");

		
		cno.getSavebtn();

		// Identify Headerinfo And Validate
		
		
		organizationinfopom_page orginfo=new organizationinfopom_page(driver);
		
		String Headinfo = orginfo.getOrginfoheader();
		
		UtilityObjectclass.getTest().log(Status.PASS, "verify organization information header");

//		if (Headinfo.contains("Organization Information")) {
//			Reporter.log("Organization Information Header Successfully Displayed",true);
//		} else {
//			Reporter.log("Organization Information Header not Displayed",true);
//
//		}
		
		Assert.assertTrue(Headinfo.contains("Organization Information"), "Organization Information Header displayed");

		
		

		// Identify Contacts Tab And Click On It
		// driver.findElement(By.linkText("Contacts")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Contacts Tab And Click On It");

		
		hom.getContactstab();

		// Identify Plus Icon And click
		// driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify plus icon  And Click On It in contact page");

		contact_pom_page contact = new contact_pom_page(driver);
		contact.getContact_plusicon();

		// identify And Pass The Data in Last Name Text Field
		// driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname+randam);
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify lastname text field and pass the data");

		
		createnew_contact_pompage newcon = new createnew_contact_pompage(driver);
		newcon.getLastnametxt(lastname);

		// identify And Click Organization name pluse icon
		// driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify organization name plus icon and click on it in contact page");

		
		newcon.getOrganization_name_plusicon();

		// Handle Child Window Popup
		
		UtilityObjectclass.getTest().log(Status.INFO, "Handle Child Window Popup");

		
		
		Set<String> Allwindow = wutil.FetchAllwindowid(driver);

		String parentwindows = wutil.Fetchwindowid(driver);

//		for (String all : parentwindow) {
//			driver.switchTo().window(all);
//			if (driver.getCurrentUrl().contains("module=Accounts&action=Popup")) {
//				Reporter.log("controle in child page");
//
//				driver.findElement(By.xpath("//a[text()='jspiders']")).click();
//				break;
//			} else {
//				Reporter.log("controle in parent page");
//
//			}
//		}
		Thread.sleep(5000);
		
		UtilityObjectclass.getTest().log(Status.INFO, "verify current page url in child window popup");

		
		wutil.SwitchChildwindow_URL(driver, "module=Accounts&action=Popup");
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify search button and pass the data");


		newcon.getSearchbox(orgname);
		Thread.sleep(5000);
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify search button and click on it");

		
		newcon.getSearchbtn();
		Thread.sleep(5000);
		
		UtilityObjectclass.getTest().log(Status.INFO, "switch back to child window to parent window");

		
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();

//		driver.switchTo().window(parentwindow);
		wutil.SwitchToParentWindow(driver, parentwindows);

		// Identify Save Button And Click On It
		//driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		UtilityObjectclass.getTest().log(Status.INFO, "identify and click on save button in contact page");

		
		newcon.getSavebtn();
		
		// Identify Header And Validate
		
		UtilityObjectclass.getTest().log(Status.PASS, "verifycontact information header and validate");

		contactinfo_pompage cinfo=new contactinfo_pompage(driver);
		String info = cinfo.getContacinfotheader();

//		if (info.contains("Contact Information")) {
//			Reporter.log("Contact Information Header displayed");
//		} else {
//			Reporter.log("Contact Information Header not displayed");
//		}

		
		
		Assert.assertTrue(info.contains("Contact Information"), "Contact Information Header displayed");

	
		// Identify Contacts Tab And Click On It
		//driver.findElement(By.linkText("Contacts")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify and click on Contacts Tab");

		
		hom.getContactstab();
		
		// Identify Delete button And Click On It
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify and click on Delete button in contact page");

		
		driver.findElement(By.xpath("//a[text()='" + lastname +"']/../..//a[text()='del']")).click();

		Thread.sleep(2000);
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "handle alert popup and click on ok button");

		wutil.handleAlertClickonOK(driver);

		Thread.sleep(2000);
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify and click on organization tab");

		hom.getOrganizationstab();

		Thread.sleep(2000);
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify and click on Delete button in organization page");

		
		driver.findElement(By.xpath(
				"//a[text()='" + orgname + "' and @title='Organizations']/../../descendant::a[text()='del']"))
				.click();

		// Handle Pop ANd Click On Ok Button
		// driver.switchTo().alert().accept();
		UtilityObjectclass.getTest().log(Status.INFO, "handle alert popup and click on ok button");

		Thread.sleep(2000);
		wutil.handleAlertClickonOK(driver);

		Thread.sleep(2000);

		// click on Admin button
	//	WebElement Adminicon = hom.getAdminicon();

		// move the cursor to Admin Button
		// Actions act = new Actions(driver);
		// act.moveToElement(Adminicon).perform();
	//	wutil.MouserOverToElement(driver, Adminicon);

		// click On Sign Out
		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	//	hom.getSignout();
		
	//	Reporter.log("SignOut Successfully");
		// driver.quit();
	//	wutil.QuitTheBrowser(driver);
		
		
		//close the excel file 
		UtilityObjectclass.getTest().log(Status.INFO, "close excel");

		exc.closeExcel();
		
as.assertAll();
	}
	
	
	
	
	@Test(groups = "regression" ,retryAnalyzer = listners.RetryAnalyse.class)
	public void CreateContact_WithSupportdates_test()throws InterruptedException, EncryptedDocumentException, IOException {

		// fetch property file data using PropertyFileUtility
//		Genericfile p = new Genericfile();
//
//		String url = p.propertyutlityfile("url");
//		String Browser = p.propertyutlityfile("browser");
//		String username = p.propertyutlityfile("username");
//		String password = p.propertyutlityfile("password");
//		String timeouts = p.propertyutlityfile("timeouts");
//				UtilityObjectclass.getTest().log(Status.INFO, "Identify and click on Delete button in contact page");
		UtilityObjectclass.getTest().log(Status.INFO, "fetching random integer");

		javautility jutil=new javautility();
		int randam = jutil.fetchRandom();
		String startdate = jutil.fetchcurrentdate();
		String enddate = jutil.fetchdateaftersomedays();

		// Get The Test Data From Excel File Using ExcelFileUtility
		UtilityObjectclass.getTest().log(Status.INFO, "fetching data from excel file");

		
		ExcelFileUtility exc = new ExcelFileUtility();
		String lastname = exc.fetchDataFromExcelFile("Contact", 4, 3)+randam;

		
//		String Browser="chrome";	
//		String lastname = "Tommy";
//		WebDriver driver = null;
//		// lanch The Browser
//		if (Browser.equals("chrome")) {
//			driver = new ChromeDriver();
//		} else if (Browser.equals("edge")) {
//			driver = new EdgeDriver();
//		} else if (Browser.equals("Firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			driver = new ChromeDriver();
//		}
//
//		WebdriverUtility wutil=new WebdriverUtility();
//		// Maximize the Browser
//		//driver.manage().window().maximize();
//		wutil.Maximize_Browser(driver);
//		
//		// Implicity wait
//		//long Timeouts = Long.parseLong(timeouts);
//		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
//		wutil.WaitForElement_implictly(driver, timeouts);
//		
//		// Navigate To The Application
//		//driver.get(url);
//		wutil.NavigateToApplication(driver, url);
//		
//		loginpom_page log=new loginpom_page(driver);
//		// Identify User NAme TF And Pass Data In Tf
//		//driver.findElement(By.name("user_name")).sendKeys(username);
//		// Identify Password Tf And Pass The data In Tf
//		//driver.findElement(By.name("user_password")).sendKeys(password);
//		// Identify Login Button And Click On It
//		//driver.findElement(By.id("submitButton")).click();
//		log.loginPage(username, password);

		// Identify The Home Page
//		if (driver.getCurrentUrl().contains("Home")) {
//			Reporter.log("Home Page Should Be Displayed");
//		} else {
//			Reporter.log("Login Test Fail");
//		}
		
		UtilityObjectclass.getTest().log(Status.INFO, "verify home page displayed");

		SoftAssert as = new SoftAssert();
		as.assertTrue(driver.getCurrentUrl().contains("Home"),"validating home page");


		// Identify Contacts Tab And Click On It
		//driver.findElement(By.linkText("Contacts")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Contacts Tab And Click On It");

		
	Homepom_page hom=new Homepom_page(driver);
		hom.getContactstab();

		// Identify Plus Icon And click
		//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify Plus Icon And click on it");

		
		contact_pom_page contact=new contact_pom_page(driver);
		contact.getContact_plusicon();
		
		// identify And Pass The Data in Last Name Text Field
		//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname+randam);
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify And Pass The Data in Last Name Text Field");

		createnew_contact_pompage cno=new createnew_contact_pompage(driver);
		cno.getLastnametxt(lastname);
		
		// identify Calender And click On It
//		WebElement supportstartdate = cno.getStartdate();
//		supportstartdate.click();
//		supportstartdate.clear();
//		supportstartdate.sendKeys(startdate);
		
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify And Pass The Data in supported  start date text Field");

		cno.getStartdate(startdate);
		
//		WebElement supportenddate = cno.getEnddate();
//		supportenddate.click();
//		supportenddate.clear();
//		supportenddate.sendKeys(enddate);
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify And Pass The Data in supported  end date text Field");

		
		cno.getEnddate(enddate);
		
		// Identify Save Button And Click On It
		//driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "identify Save Button And Click On It");

		
		cno.getSavebtn();
		
		// Identify Header And Validate
		contactinfo_pompage cinfo=new contactinfo_pompage(driver);
		UtilityObjectclass.getTest().log(Status.PASS, "verify contact information page and validated");

		String info = cinfo.getContacinfotheader();
		
//		if (info.contains("Contact Information")) {
//			Reporter.log("Contact Information Header displayed",true);
//		} else {
//			Reporter.log("Contact Information Header not displayed",true);
//		}

		Assert.assertTrue(info.contains("Contact Information"), "Contact Information Header displayed");

		
		
		// Identify Contacts Tab And Click On It
		//driver.findElement(By.linkText("Contacts")).click();
		
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Contacts Tab And Click On It");

		
		hom.getContactstab();
		Thread.sleep(2000);
		// Identify Delete button And Click On It
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Delete button And Click On It");

		driver.findElement(By.xpath("//a[text()='" + lastname+ "']/../..//a[text()='del']")).click();

		// Handle Pop ANd Click On Ok Button
		//driver.switchTo().alert().accept();
		UtilityObjectclass.getTest().log(Status.INFO, "Handle Pop ANd Click On Ok Button");

		
		wutil.handleAlertClickonOK(driver);
		
		Thread.sleep(2000);

		// click on Admin button
//		WebElement Adminicon = hom.getAdminicon();
//
//		// move the cursor to Admin Button
//		//Actions act = new Actions(driver);
//		//act.moveToElement(Adminicon).perform();
//		wutil.MouserOverToElement(driver, Adminicon);
//		
//		// click On Sign Out
//		//driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		hom.getSignout();
//		
//		Reporter.log("SignOut Successfully");
//		//driver.quit();
//		wutil.QuitTheBrowser(driver);
		//close excel
		
		UtilityObjectclass.getTest().log(Status.INFO, "close excel");
exc.closeExcel();
		as.assertAll();
	}
	
	
	
	
	
	
}
