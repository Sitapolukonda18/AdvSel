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

import GenericUtility.JavaUtility;

public class LeadPage {
	    WebDriver driver;
	
		public LeadPage(WebDriver driver) {
	    this.driver=driver;
	    PageFactory.initElements(driver, this);
}
		@FindBy(name="name")
		private WebElement leadName;
		@FindBy(name="company")
		private WebElement leadCompany;
		@FindBy(name="leadSource")
		private WebElement leadSource;
		@FindBy(name="industry")
		private WebElement leadIndustry;
		@FindBy(name="phone")
		private WebElement leadPhone;
		@FindBy(name="leadStatus")
		private WebElement leadStatus;
		@FindBy(name="rating")
		private WebElement leadRating;
		@FindBy(xpath="(//button[@type='button'])[2]") // 
		private WebElement leadcampaignbutton;
		@FindBy(name="assignedTo")
		private WebElement LeadAssignTo;
		
		@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
		private WebElement selectButton;
		
		@FindBy(xpath="//button[text()='Create Lead']")
		private WebElement leadCreateButton;
		 
		
		public WebElement getLeadCreateButton() {
			return leadCreateButton;
		}
		
		public WebElement getSelectButton() {
			return selectButton;
		}
		public WebElement getLeadAssignTo() {
			return LeadAssignTo;
		}
		public WebElement getLeadcampaignbutton() {
			return leadcampaignbutton;
		}
		public WebElement getLeadName() {
			return leadName;
		}
		public WebElement getLeadCompany() {
			return leadCompany;
		}
		public WebElement getLeadSource() {
			return leadSource;
		}
		public WebElement getLeadIndustry() {
			return leadIndustry;
		}
		 
		public WebElement getLeadPhone() {
			return leadPhone;
		}
		public WebElement getLeadStatus() {
			return leadStatus;
		}
		public WebElement getLeadRating() {
			return leadRating;
		}

		public void LeadDetails(String leadname, String leadcompany, String leadsource, String leadindustry, String leadphone, String leadstatus, String leadrating, String leadassignto)
		{
			Random random=new Random();
			int randominteger=random.nextInt(300);
			leadName.sendKeys(leadname+randominteger);
			leadCompany.sendKeys(leadcompany);
			leadSource.sendKeys(leadsource);
			leadIndustry.sendKeys(leadindustry);
			leadStatus.sendKeys(leadstatus);
			leadRating.clear();
			leadRating.sendKeys("1");
			leadPhone.sendKeys(leadphone); 
			LeadAssignTo.sendKeys(leadassignto);
			
			
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
		     	   System.out.println("Lead Created Successfully");
		        else
		     	   System.out.println("Lead Not Created, please try again");
		        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		}

}
