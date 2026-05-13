package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpom_page {

	
	//Declaration
		@FindBy(linkText = "vtiger")
		private WebElement loginheadertxt;
		
		@FindBy(xpath = "//input[@name='user_name']")
		private WebElement usernametf;
		
		@FindBy(xpath = "//input[@name='user_password']")
		private WebElement passwordtf;
		
		@FindBy(xpath = "//input[@id='submitButton']")
		private WebElement loginbtn;
		
		//Initilization

		public loginpom_page(WebDriver driver) {
			PageFactory.initElements(driver ,this);
		}

		//Utilization
		public String getLoginheadertxt() {
			return loginheadertxt.getText();
		}

		public void getUsernametf(String username) {
			usernametf.sendKeys(username);
		}

		public void getPasswordtf(String password) {
			 passwordtf.sendKeys(password);
		}

		public void getLoginbtn() {
			 loginbtn.click();
		}
		
		public void loginPage(String username,String password) {
			usernametf.sendKeys(username);
			passwordtf.sendKeys(password);
			loginbtn.click();
		}
	
	
}
