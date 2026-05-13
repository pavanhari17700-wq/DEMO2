package Organization_module;


import java.io.IOException; 

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
import pompages.createnew_organization_pompage;
import pompages.loginpom_page;
import pompages.organization_pom_page;
import pompages.organizationinfopom_page;


//@Listeners(listners.Listners.class)
public class Createorganization_moduletest extends Baseclass {

	
	/*
	 
	 
	 @Listeners(listners.Listners.class)
	 
	 only test level 
	 whenever we go for batch,group,parallel,cb we turn off listners because we given in suite level in xml code 
	 
	 */
	

		@Test(groups = "smoke",retryAnalyzer = listners.RetryAnalyse.class)
		public void Createorgname_With_Industery_Typetest()throws InterruptedException, EncryptedDocumentException, IOException {

//			// fetch property file data using PropertyFileUtility
//			Genericfile p = new Genericfile();
//
//			String url = p.propertyutlityfile("url");
//			String Browser = p.propertyutlityfile("browser");
//			String username = p.propertyutlityfile("username");
//			String password = p.propertyutlityfile("password");
//			String timeouts = p.propertyutlityfile("timeouts");

			//listners.Listners.test.log(Status.INFO, "fetching Random Intege");

			UtilityObjectclass.getTest().log(Status.INFO, "fetching the Random Integer");

			
			javautility jutil=new javautility();
			int randam = jutil.fetchRandom();
			
			// Get The Test Data From Excel File Using ExcelFileUtility
			
			UtilityObjectclass.getTest().log(Status.INFO, "fetching the  data from excel file");

			
			ExcelFileUtility exc = new ExcelFileUtility();
			String orgname = exc.fetchDataFromExcelFile("Organization", 4, 3)+randam;
			String Banking = exc.fetchDataFromExcelFile("Organization", 4, 4);
			String Analyst = exc.fetchDataFromExcelFile("Organization", 4, 5);

			
//			String Browser="chrome";	
//			String orgname = "Astra";
//			WebDriver driver = null;
//			// lanch The Browser
//			if (Browser.equals("chrome")) {
//				driver = new ChromeDriver();
//			} else if (Browser.equals("edge")) {
//				driver = new EdgeDriver();
//			} else if (Browser.equals("Firefox")) {
//				driver = new FirefoxDriver();
//			} else {
//				driver = new ChromeDriver();
//			}
//
//			WebdriverUtility wutil=new WebdriverUtility();
//			// Maximize the Browser
//			//driver.manage().window().maximize();
//			wutil.Maximize_Browser(driver);
//			
//			// Implicity wait
//			//long Timeouts = Long.parseLong(timeouts);
//			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
//			wutil.WaitForElement_implictly(driver, timeouts);
//			
//			// Navigate To The Application
//			//driver.get(url);
//			wutil.NavigateToApplication(driver, url);
//			
//			// Create objet for logingpage
//			loginpom_page log = new loginpom_page(driver);
//
//			// Identify User NAme TF And Pass Data In Tf
//			// driver.findElement(By.name("user_name")).sendKeys(username);
//			//log.getUsernametf().sendKeys(username);
//			// Identify Password Tf And Pass The data In Tf
//			// driver.findElement(By.name("user_password")).sendKeys(password);
//			//log.getPasswordtf().sendKeys(password);
//			// Identify Login Button And Click On It
//			// driver.findElement(By.id("submitButton")).click();
//			//log.getLoginbtn().click();
//			log.loginPage(username, password);
//			
			// Identify The Home Page

			//			if (driver.getCurrentUrl().contains("Home")) {
//				Reporter.log("Home Page Should Be Displayed",true);
//			} else {
//				Reporter.log("Login Test Fail",true);
//			}
			
			UtilityObjectclass.getTest().log(Status.INFO, "verify home page");

			
		SoftAssert as = new SoftAssert();
		as.assertTrue(driver.getCurrentUrl().contains("Home"),"validating home page");

			// Create Object For Homepage
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
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization name text field and pass The data");

			cno.getOrganization_name(orgname);

			// click On Industary DropDown
			// WebElement industrydrop = driver.findElement(By.name("industry"));
			UtilityObjectclass.getTest().log(Status.INFO, "identify industry dropdown and click on it");

			WebElement industrydrop = cno.getIndustrydrop();

			// Handle The Dropdown We Create opject For Select Class
//			Select se = new Select(industrydrop);
	//
//			if (se.isMultiple()) {
//				Reporter.log("It Is Multiple Dropdown");
//			} else {
//				Reporter.log("It Is Single Dropdown");
	//
//				se.selectByContainsVisibleText(Banking);
//			}
			
			UtilityObjectclass.getTest().log(Status.INFO, "handling industry dropdown");

			
			wutil.SelectDDbyVisibletext(industrydrop, Banking);

			// click On Type DropDown
			// WebElement Typedrop = driver.findElement(By.name("accounttype"));
			
			UtilityObjectclass.getTest().log(Status.INFO, "identify type dropdown and click on it");

			
			WebElement Typedrop = cno.getTypedrop();

			// Handle The Dropdown We Create opject For Select Class
//			Select se1 = new Select(Typedrop);
	//
//			if (se1.isMultiple()) {
//				Reporter.log("It Is Multiple Dropdown");
//			} else {
//				Reporter.log("It Is Single Dropdown");
	//
//				se1.selectByContainsVisibleText(Analyst);
//			}
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "handling type  of dropdown");

			wutil.SelectDDbyVisibletext(Typedrop, Analyst);

			// Identify Save Button And Click On It
			// driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Save Button And Click On It");

			cno.getSavebtn();

			// Identify Verifyindustry And Validate
			
			UtilityObjectclass.getTest().log(Status.PASS, "verify organization is created with banking in industry dropdown");

			
			
			organizationinfopom_page orginfo=new organizationinfopom_page(driver);
			String Verifyindustry = orginfo.getVerifyIndustry_DDtxt();
//			if (Verifyindustry.contains(Banking)) {
//				Reporter.log("Organization Created With Industary",true);
//			} else {
//				Reporter.log("Organization Test Fail",true);
			
			Assert.assertTrue(Verifyindustry.contains(Banking), "organization created with  industy");

				// Identify Verifytype And Validate
			
			UtilityObjectclass.getTest().log(Status.PASS, "verify organization is created with analyst in type dropdown");

			
				String Verifytype = orginfo.getVerifyType_DDtxt();

//				if (Verifytype.contains(Analyst)) {
//					Reporter.log("Organization Created With Type",true);
//				} else {
//					Reporter.log("Organization Test Fail",true);
//				}
//			}
				
				Assert.assertTrue(Verifytype.contains(Analyst), "organization created with type analyst");


			// Identify Organization Tab And Click On It
			// driver.findElement(By.linkText("Organizations")).click();
				
				UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization Tab And Click On It");

				
			hom.getOrganizationstab();
         
			// Identify Delete button And Click On It
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Delete button And Click On It in organization page");

			
			driver.findElement(By.xpath("//a[text()='" + orgname+ "' and @title='Organizations']/../../descendant::a[text()='del']")).click();

			Thread.sleep(2000);
			
			// Handle Pop ANd Click On Ok Button
			//driver.switchTo().alert().accept();
			
			UtilityObjectclass.getTest().log(Status.INFO, "Handle alert Pop ANd Click On Ok Button");

			
			wutil.handleAlertClickonOK(driver);
			
			Thread.sleep(2000);

			// click on Admin button
			// WebElement Adminicon =
			// driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
//			WebElement Adminicon = hom.getAdminicon();
//
//			// move the cursor to Admin Button
//			//Actions act = new Actions(driver);
//			//act.moveToElement(Adminicon).perform();
//			wutil.MouserOverToElement(driver, Adminicon);
//			
			// click On Sign Out
			// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//	hom.getSignout();
			
			//wutil.QuitTheBrowser(driver);
			
			//close the excel
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "close the excel");

			exc.closeExcel();
			
			as.assertAll();
			
		}
		
		@Test(groups = "regression",retryAnalyzer = listners.RetryAnalyse.class )
		public void Createorgname_Withphonenumber_test() throws InterruptedException, IOException {

			// fetch property file data using PropertyFileUtility
//			Genericfile p = new Genericfile();
//
//			String url = p.propertyutlityfile("url");
//			String Browser = p.propertyutlityfile("browser");
//			String username = p.propertyutlityfile("username");
//			String password = p.propertyutlityfile("password");
//			String timeouts = p.propertyutlityfile("timeouts");

			
			UtilityObjectclass.getTest().log(Status.INFO, "fetch random integer");

			
			javautility jutil=new javautility();
			int randam = jutil.fetchRandom();
			
			// Get The Test Data From Excel File Using ExcelFileUtility
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "fetch data from excel");

			ExcelFileUtility exc = new ExcelFileUtility();
			String orgname = exc.fetchDataFromExcelFile("Organization", 1, 3)+randam;
			String phno = exc.fetchDataFromExcelFile("Organization", 8, 4);

			
//			String Browser="chrome";	
//			String orgname = "Astra";
//			WebDriver driver = null;
//			// lanch The Browser
//			if (Browser.equals("chrome")) {
//				driver = new ChromeDriver();
//			} else if (Browser.equals("edge")) {
//				driver = new EdgeDriver();
//			} else if (Browser.equals("Firefox")) {
//				driver = new FirefoxDriver();
//			} else {
//				driver = new ChromeDriver();
//			}
//
//			WebdriverUtility wutil=new WebdriverUtility();
//			// Maximize the Browser
//			//driver.manage().window().maximize();
//			wutil.Maximize_Browser(driver);
//			
//			// Implicity wait
//			//long Timeouts = Long.parseLong(timeouts);
//			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
//			wutil.WaitForElement_implictly(driver, timeouts);
//			
//			// Navigate To The Application
//			//driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//			wutil.NavigateToApplication(driver, url);
//			
//			// Create objet for logingpage
//			loginpom_page log = new loginpom_page(driver);

			// Identify User NAme TF And Pass Data In Tf
			// driver.findElement(By.name("user_name")).sendKeys(username);
			//log.getUsernametf().sendKeys(username);
			// Identify Password Tf And Pass The data In Tf
			// driver.findElement(By.name("user_password")).sendKeys(password);
			//log.getPasswordtf().sendKeys(password);
			// Identify Login Button And Click On It
			// driver.findElement(By.id("submitButton")).click();
			//log.getLoginbtn().click();
			//log.loginPage(username, password);

			// Identify The Home Page
//			if (driver.getCurrentUrl().contains("Home")) {
//				Reporter.log("Home Page Should Be Displayed",true);
//			} else {
//				Reporter.log("Login Test Fail",true);
//			}

			UtilityObjectclass.getTest().log(Status.INFO, "verify home page");

			SoftAssert as = new SoftAssert();
			as.assertTrue(driver.getCurrentUrl().contains("Home"),"validating home page");

			// Create Object For Homepage
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
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization name  Tf and pass The data");

			
			cno.getOrganization_name(orgname);

			// Identify And Pass The Date In Phone Number Test Field
			// driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phno);
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify  Phone Number Test Field And Pass The Data");

			cno.getPhnotxt(phno);

			// Identify Save Button And Click On It
			// driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Save Button And Click On It");

			cno.getSavebtn();

			// Identify Headerinfo And Validate
			
			UtilityObjectclass.getTest().log(Status.PASS, "verify organization information header is displayed");

			
			organizationinfopom_page orginfo=new organizationinfopom_page(driver);
			String infoheader = orginfo.getOrginfoheader();
//			if (infoheader.contains("Organization Information")) {
//				Reporter.log("Information Header Successfully Displayed",true);
//			} else {
//				Reporter.log("Information Header Not Displayed",true);
//
//			}
			
			Assert.assertTrue(infoheader.contains("Organization Information"), "Information Header Successfully Displayed");


			//Verify Phno Number 
			
			UtilityObjectclass.getTest().log(Status.PASS, "verify phone number is displayed");

			
			String phnotxt = orginfo.getVerifyPhnotxt();
//			if (phnotxt.contains("7841256930")) {
//				Reporter.log("Successfully Created With Phno Number",true);
//			} else {
//				Reporter.log("Create with Phno Test Fail",true);
//				
//			}
			
			
			Assert.assertTrue(phnotxt.contains("7841256930"), "phno number Successfully Displayed");

			
			// Identify Organization Tab And Click On It
			// driver.findElement(By.linkText("Organizations")).click();
			
			
			UtilityObjectclass.getTest().log(Status.PASS, "Identify Organization Tab And Click On It");

			hom.getOrganizationstab();

			// Identify Delete button And Click On It
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Delete button And Click On It in organization page");

			
			driver.findElement(By.xpath("//a[text()='" + orgname+ "' and @title='Organizations']/../../descendant::a[text()='del']")).click();

			Thread.sleep(2000);
			// Handle Pop ANd Click On Ok Button
			//driver.switchTo().alert().accept();
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "Handle  alert Pop ANd Click On Ok Button");

			wutil.handleAlertClickonOK(driver);
			
			Thread.sleep(2000);

			// click on Admin button
			// WebElement Adminicon =
			// driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			// WebElement Adminicon = hom.getAdminicon();

			// move the cursor to Admin Button
			//Actions act = new Actions(driver);
			//act.moveToElement(Adminicon).perform();
			//wutil.MouserOverToElement(driver, Adminicon);
			
			// click On Sign Out
			// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			//hom.getSignout();

			//Reporter.log("SignOut Successfully");
			//driver.close();
			//wutil.QuitTheBrowser(driver);
			
			//close the excel
			UtilityObjectclass.getTest().log(Status.INFO, "close the excel");

			exc.closeExcel();
			
			as.assertAll();
			
			
		}
		
		@Test(groups = "regression" ,retryAnalyzer = listners.RetryAnalyse.class)
		public void Createorgname_test() throws InterruptedException, IOException {

//			// fetch property file data using utility
//			Genericfile p = new Genericfile();
//
//			String url = p.propertyutlityfile("url");
//			String Browser = p.propertyutlityfile("browser");
//			String username = p.propertyutlityfile("username");
//			String password = p.propertyutlityfile("password");
//			
//			String timeouts = p.propertyutlityfile("timeouts");
			
			UtilityObjectclass.getTest().log(Status.INFO, "fetch random integer");

			
			
			javautility jutil = new javautility();
			int randam = jutil.fetchRandom();
			
			// Get The Test Data From Excel File Using ExcelFileUtility
			
			UtilityObjectclass.getTest().log(Status.INFO, "fetch data from excel");

			
			ExcelFileUtility exc = new ExcelFileUtility();
			String orgname = exc.fetchDataFromExcelFile("Contact", 1, 3)+randam;
			

//			WebDriver driver = null;
//			// lanch The Browser
//			if (Browser.equals("chrome")) {
//				driver = new ChromeDriver();
//			} else if (Browser.equals("edge")) {
//				driver = new EdgeDriver();
//			} else if (Browser.equals("Firefox")) {
//				driver = new FirefoxDriver();
//			} else {
//				driver = new ChromeDriver();
//			}
//
//			WebdriverUtility wutil = new WebdriverUtility();
//			// Maximize the Browser
//			wutil.Maximize_Browser(driver);
//
//			// Implicity wait
//			// long Timeouts = Long.parseLong(timeouts);
//			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeouts));
//			wutil.WaitForElement_implictly(driver, timeouts);
//			
//			// Navigate To The Application
//			//driver.get(url);
//			wutil.NavigateToApplication(driver, url);
//			
//			// Create objet for logingpage
//			loginpom_page log = new loginpom_page(driver);
//
//			// Identify User NAme TF And Pass Data In Tf
//			// driver.findElement(By.name("user_name")).sendKeys(username);
//			//log.getUsernametf().sendKeys(username);
//			// Identify Password Tf And Pass The data In Tf
//			// driver.findElement(By.name("user_password")).sendKeys(password);
//			//log.getPasswordtf().sendKeys(password);
//			// Identify Login Button And Click On It
//			// driver.findElement(By.id("submitButton")).click();
//			//	log.getLoginbtn().click();
//			log.loginPage(username, password);
//			
			// Identify The Home Page
//			if (driver.getCurrentUrl().contains("Home")) {
//				Reporter.log("Home Page Should Be Displayed",true);
//			} else {
//				Reporter.log("Login Test Fail",true);
//			}
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "verify home page is displayed");

			
			SoftAssert as = new SoftAssert();
			as.assertTrue(driver.getCurrentUrl().contains("Home"),"validating home page");


			//Create object for Homepom page
		Homepom_page hom = new Homepom_page(driver);

			// Identify Organization Tab And Click On It
		UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization Tab And Click On It");

			hom.getOrganizationstab();

			// Create Object For Organizationpage
			organization_pom_page org = new organization_pom_page(driver);

			// Identify Plus Icon And click
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Plus Icon And click on it");

			org.getPlusicon();

			// Create object for organization information page
			createnew_organization_pompage cno = new createnew_organization_pompage(driver);
			UtilityObjectclass.getTest().log(Status.INFO, "identify organization text field and pass the data");

			
			cno.getOrganization_name(orgname);
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "identify save button and click on it");  

			cno.getSavebtn();

			//Identify And Validate Information text
			organizationinfopom_page orginfo=new organizationinfopom_page(driver);
			
			
			 String Headinfo = orginfo.getOrginfoheader();
			 
				UtilityObjectclass.getTest().log(Status.PASS, "organization information header and validate"); 

			 
//			if (Headinfo.contains("Organization Information")) {
//				Reporter.log("Header Successfully Displayed",true);
//			} else {
//				Reporter.log("Header not Displayed",true);
//
//			}
				Assert.assertTrue(Headinfo.contains("Organization Information"), "Header Successfully Displayed");

			 
			
			 

			// Identify Organization Tab And Click On It
			// driver.findElement(By.linkText("Organizations")).click();
				UtilityObjectclass.getTest().log(Status.INFO, "Identify Organization Tab And Click On It");  

			hom.getOrganizationstab();

			// Identify Delete button And Click On It
			
			
			UtilityObjectclass.getTest().log(Status.INFO, "Identify Delete button And Click On It");  

			driver.findElement(By.xpath(
					"//a[text()='" + orgname +"' and @title='Organizations']/../../descendant::a[text()='del']")).click();

			Thread.sleep(2000);
			
			// Handle Pop ANd Click On Ok Button
			//driver.switchTo().alert().accept();
			
			UtilityObjectclass.getTest().log(Status.INFO, "Handle  alert Pop ANd Click On Ok Button");  

			wutil.handleAlertClickonOK(driver);
			
			Thread.sleep(2000);

			// click on Admin button
			// WebElement Adminicon =
			// driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			//WebElement Adminicon = hom.getAdminicon();

			// move the cursor to Admin Button
//			Actions act = new Actions(driver);
//			act.moveToElement(Adminicon).perform();
			//wutil.MouserOverToElement(driver, Adminicon);
			
			// click On Sign Out
			// driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			//hom.getSignout();
			//wutil.QuitTheBrowser(driver);
			
			
			//close the excel
			UtilityObjectclass.getTest().log(Status.INFO, "close the excel");  

			exc.closeExcel();
			as.assertAll();
			
		}
	}
	
	
	
	

