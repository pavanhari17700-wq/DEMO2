package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organization_pom_page {

	
	//Declaration
		@FindBy(xpath = "//a[text()='Organizations' and @class='hdrLink']")
		private WebElement Organizations_text;
		
		@FindBy(xpath = "//img[@title='Create Organization...']")
		private WebElement plusicon;
		
		
		

		//Initilization
		public organization_pom_page(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}

		//Utilization
		
		
		public String getOrganizations_text() {
			return Organizations_text.getText();
		}

		public void getPlusicon() {
			 plusicon.click();
		}
	
	
}
