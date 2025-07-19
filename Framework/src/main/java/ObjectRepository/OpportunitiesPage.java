package ObjectRepository;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpportunitiesPage {
	 WebDriver driver;
		
		public OpportunitiesPage(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
}
		@FindBy(name="opportunityName")
		private WebElement opportunityName;
		@FindBy(name="amount")
		private WebElement oppAmount;
		@FindBy(name="businessType")
		private WebElement oppBusinessType;
		@FindBy(name="nextStep")
		private WebElement oppNextStep;
		@FindBy(name="salesStage")
		private WebElement oppSalesStage;
		@FindBy(name="probability")
		private WebElement oppProbability;
		@FindBy(name="assignedTo")
		private WebElement oppAssignedTo;
		
		@FindBy(xpath="(//button[@type='button'])[2]")  //(xpath="(//button[@type='button'])[2]")  
		private WebElement oppLeadPlusButton;
		 
		public WebElement getOppLeadPlusButton() {
			return oppLeadPlusButton;
		}
		@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
		private WebElement oppleadselectButton;
				
		public WebElement getOppleadselectButton() {
			return oppleadselectButton;
		}
		@FindBy(xpath="//button[text()='Create Opportunity']")
		private WebElement opportunitySubmitButton;

		public WebElement getOpportunitySubmitButton() {
			return opportunitySubmitButton;
		}
		public WebElement getOpportunityName() {
			return opportunityName;
		}
		public WebElement getOppAmount() {
			return oppAmount;
		}
		public WebElement getOppBusinessType() {
			return oppBusinessType;
		}
		public WebElement getOppNextStep() {
			return oppNextStep;
		}
		public WebElement getOppSalesStage() {
			return oppSalesStage;
		}
		public WebElement getOppProbability() {
			return oppProbability;
		}
		public WebElement getOppAssignedTo() {
			return oppAssignedTo;
		}
		
		public void OpportunityDetails(String opportunityname, String oppamount, String oppbusinesstype, String oppnextstep , String oppsalesstage, String oppprobability, String oppassignedto ) {
			Random random=new Random();
			int randominteger=random.nextInt(300);
			opportunityName.sendKeys(opportunityname+randominteger);
			oppAmount.sendKeys(oppamount);
			oppBusinessType.sendKeys(oppbusinesstype);
			oppNextStep.sendKeys(oppnextstep);
			oppSalesStage.sendKeys(oppsalesstage);
			oppProbability.clear();
			oppProbability.sendKeys(oppprobability);
			oppAssignedTo.sendKeys(oppassignedto);
			
			
		}
		@FindBy(xpath="//div[@role='alert']")
		private WebElement toastMsg;

		public WebElement getToastMsg() {
			return toastMsg;
		}
		
		public void validateandCloseToastMsg() {
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(toastMsg));
	        String msg = toastMsg.getText();
			 if(msg.contains("Successfully"))
		     	   System.out.println("Opportunities Created Successfully");
		        else
		     	   System.out.println("Opportunities Not Created, please try again");
		        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		}
		
}
