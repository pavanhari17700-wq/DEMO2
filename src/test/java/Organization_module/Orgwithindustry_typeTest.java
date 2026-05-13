package Organization_module;


	
	
	import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.annotations.Test;

	
	public class Orgwithindustry_typeTest {

	

		@Test

		public void createOrg_Test() throws InterruptedException, IOException {

			FileInputStream fis = new FileInputStream("./src/test/resources/Common.properties");
			
			Properties p = new Properties();
			p.load(fis);
			String browser=p.getProperty("browser");
			
			FileInputStream els=new FileInputStream("./src/test/resources/VTIGER.xlsx");
			
			Object book = WorkbookFactory.create(els);
			
			//String browser = "chrome";
			String orgname = "Agni";

			WebDriver driver = null;

			if (browser.equals("chrome"))
				driver = new ChromeDriver();
			else if (browser.equals("edge"))
				driver = new EdgeDriver();
			else if (browser.equals("firefox"))
				driver = new FirefoxDriver();
			else
				driver = new ChromeDriver();

			// maximize the browser
			driver.manage().window().maximize();

			// implicit wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// explicit wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// navigate to the browser
			driver.get("http://localhost:8888/index.php?action=Login&module=Users");

			// identify the username TF and enter username
			driver.findElement(By.name("user_name")).sendKeys("admin");

			// identify the password TF and enter password
			driver.findElement(By.name("user_password")).sendKeys("Pavan@123");

			// Identify the submit button and click on it
			driver.findElement(By.id("submitButton")).click();

			// Identify the element to verify Homepage
			WebElement homePageElement = driver.findElement(By.xpath("//img[@style='width:16px;height:16px;']"));

			if (homePageElement.isDisplayed()) {
				System.out.println("Homepage is displayed");
			} else {
				System.out.println("Failed to load Homepage");
			}

			// identify the org tab and click on it
			driver.findElement(By.linkText("Organizations")).click();

			// identify the create "plus" icon and click on it
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			// identify org name text field and enter org name
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			
			
			//select industry dropdown 
			
			WebElement industry = driver.findElement(By.name("industry"));
			Select s = new Select(industry);
			s.selectByVisibleText("Banking");
			
			//select the type dropdown 
			
			WebElement type = driver.findElement(By.name("accounttype"));
			Select s1 = new Select(type);
			//s.selectByVisibleText("Analyst");
			s1.selectByVisibleText("Partner");

			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

			// verify that org is created or not
			WebElement orgcreated = driver.findElement(By.xpath("//span[contains(text(),'Organization Information')]"));

			if (orgcreated.getText().contains(orgname)) {
				System.out.println("Organization created successfully");
			} else {
				System.out.println("Failed to create organization");
			}

			// again click on the organization tab
			driver.findElement(By.linkText("Organizations")).click();

			// delete the org which created above
			driver.findElement(By.xpath("//a[text()='"+ orgname+"' and @title='Organizations']/../..//a[text()='del']")).click();

			// handle the popup , change focus to alert and accept it
			driver.switchTo().alert().accept();
			Thread.sleep(3000);

			// mouse hover to administration icon and click and signout link
			Actions act = new Actions(driver);

			WebElement adminIcon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			act.moveToElement(adminIcon).perform();

			// click on signout link
			driver.findElement(By.linkText("Sign Out")).click();

			// close the browser
			//driver.quit();

		}
	}
	
	
	

