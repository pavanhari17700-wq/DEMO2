package Contact_module;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContactwithsupportDatesTest {

	
	@Test
	public void supportdateTest() throws InterruptedException {
		
		String Browser="chrome";	
		String lastname = "Tommy";
		WebDriver driver=null;
		//lanch The Browser
		if (Browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (Browser.equals("edge")) {
			driver=new EdgeDriver();
		}else if (Browser.equals("Firefox")) {
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		
		//Maximize the Browser
		driver.manage().window().maximize();
		
		//Implicity wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Navigate To The Application
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		
		//Identify User NAme TF And Pass Data In Tf
		driver.findElement(By.name("user_name")).sendKeys("admin");
		
		//Identify Password Tf And Pass The data In Tf
		driver.findElement(By.name("user_password")).sendKeys("Password@123");
		
		//Identify Login Button And Click On It
		driver.findElement(By.id("submitButton")).click();
		
		//Identify The Home Page
		if (driver.getCurrentUrl().contains("Home")) {
			System.out.println("Home Page Should Be Displayed");
		}else {
			System.out.println("Login Test Fail");
		}
		
		//Identify Contacts Tab And Click On It
		driver.findElement(By.linkText("Contacts")).click();
		
		//Identify Plus Icon And click
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		//identify And Pass The Data in Last Name Text Field
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		//identify Calender And click On It
		WebElement startdate = driver.findElement(By.xpath("//input[@name='support_start_date']"));
		startdate.click();
		startdate.clear();
		startdate.sendKeys("2026-04-30");
		
		//Identify Save Button And Click On It
				driver.findElement(By.xpath("//input[contains(@title,'Save')]")).click();
				
				//Identify Header And Validate
				WebElement info = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]"));
				
				if (info.isDisplayed()) {
					System.out.println("Header displayed");
				}else {
					System.out.println("Header not displayed");	
				}
				
				//Identify Contacts Tab And Click On It
				driver.findElement(By.linkText("Contacts")).click();
				
				//Identify Delete button And Click On It
				driver.findElement(By.xpath("//a[text()='"+lastname+"']/../..//a[text()='del']")).click();
				
				//Handle Popup ANd Click On Ok Button
				driver.switchTo().alert().accept();
				
				Thread.sleep(2000);
				
				//click on Admin button
				WebElement Adminicon = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				

				//move the cursor to Admin Button
				Actions act=new Actions(driver);
				
				act.moveToElement(Adminicon).perform();
				
				//click On Sign Out
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

				System.out.println("SignOut Successfully");
				driver.quit();
		
		
		
	}
	
}
