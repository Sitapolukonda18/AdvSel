package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*public class ToastMessage {
	
	WebDriver driver;
	
		public ToastMessage(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
        }
		
		@FindBy(xpath="//div[@role='alert']")
		private WebElement toastmsg;
		

		public WebElement getToastmsg() {
			return toastmsg;
			
		}
*/
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import java.time.Duration;

		public class ToastMessage {

		    public ToastMessage(WebDriver driver, String expectedText, int timeoutInSeconds) {
		        try {
		            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
		            WebElement toastMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

		            String actualText = toastMsg.getText();
		            if (actualText.contains(expectedText)) {
		                System.out.println(" Created Successfully");
		            } else {
		                System.out.println(" Not Created, Please try again");
		            }

		            WebElement closeButton = driver.findElement(By.xpath("//button[@aria-label='close']"));
		            closeButton.click();
		        } catch (Exception e) {
		            System.out.println("⚠️ Failed to verify or close toast message: " + e.getMessage());
		        }
		    }
		}

		
		
		


