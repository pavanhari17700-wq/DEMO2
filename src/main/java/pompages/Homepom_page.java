package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepom_page {

	//Declaration
		@FindBy(partialLinkText = "Home")
		private WebElement Homeheadertxt;
		
		@FindBy(xpath = "(//a[text()='Organizations'])[1]")
		private WebElement Organizationstab;
		
		@FindBy(xpath = "//a[text()='Contacts']")
		private WebElement Contactstab;
		
		@FindBy(xpath = "//img[contains(@src,'images/user.PNG')]")
		private WebElement Adminicon;
		
		@FindBy(xpath = "//a[text()='Sign Out']")
		private WebElement Signout;
		
		//Initilization
		public Homepom_page (WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		//Utilization
		public String getHomeheader() {
			return Homeheadertxt.getText();
			
		}
		
		public void getOrganizationstab() {
			 Organizationstab.click();
		}

		public void getContactstab() {
			 Contactstab.click();
		}

		public WebElement getAdminicon() {
			return Adminicon;
		}

		public void getSignout() {
			 Signout.click();
		}
	
	
}
