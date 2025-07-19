package ObjectRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.JavaUtility;

public class CampaignPage {

	 		WebDriver driver;
		
	 		public CampaignPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	 		@FindBy(linkText="Campaigns")
			private WebElement campaignlink;
			
			@FindBy(xpath="//span[text()='Create Campaign']")
			private WebElement CreateCampaignbutton;
			
			@FindBy(name="expectedCloseDate")
			private WebElement campaignexpectedclosedate;
			
		public WebElement getCampaignexpectedclosedate() {
				return campaignexpectedclosedate;
			}

		public WebElement getCampaignlink() {
				return campaignlink;
			}

			public WebElement getCreateCampaignbutton() {
				return CreateCampaignbutton;
			}

			public WebElement getCampaigncreatebutton() {
				return campaigncreatebutton;
			}
		@FindBy(name="campaignName")
		private WebElement campaignnameTF;
		
		@FindBy(name="targetSize")
		private WebElement targetsizeTF;
		
		@FindBy(xpath="//span[text()='Create Campaign']")
		private WebElement createcampaignbtn;
		
		@FindBy(xpath="//button[text()='Create Campaign']")
		private WebElement campaigncreatebutton;

		public WebElement getCampaignnameTF() {
			return campaignnameTF;
		}

		public WebElement getTargetsizeTF() {
			return targetsizeTF;
		}

		public WebElement getCreatecampaignbtn() {
			return createcampaignbtn;
		}
		
		public void clickOnCreateCpnBtn() {
			createcampaignbtn.click();
		}
		
		public void clickOnCampaignCreateButton() {
			campaigncreatebutton.click();
		}
		                                                           //EDIT CAMPAIGN
		
		@FindBy(xpath="(//i[@title='Edit'])[2]")
		private WebElement editCampaign;
		
		public WebElement getEditCampaign() {
			return editCampaign;
		}
		
		@FindBy(xpath="//input[@name='targetAudience']")
				private WebElement targetAudience;
		
	
		
		public WebElement getTargetAudience() {
			return targetAudience;
		}		
		@FindBy(xpath="//button[text()='Update Campaign']")
		private WebElement UpdateCampaign;
		public WebElement getUpdateCampaign() {
			return UpdateCampaign;
		}
                                                                   //DELETE CAMPAIGN
	
	
		@FindBy(xpath="//select[@class='form-control']")
		private WebElement clickDropdown1;
		
		@FindBy(xpath="//option[text()='Search by Campaign Id']")
		private WebElement clickbyCampId;
		
		@FindBy(xpath="//option[text()='Search by Campaign Name']")
		private WebElement clickbyCampName;
		
		@FindBy(xpath="//input[@class='form-control']")
		private WebElement clickDropdown2;
		
		@FindBy(xpath="(//i[@title='Delete'])[5]")
		private WebElement deleteOption;

		@FindBy(xpath="//input[@value='Cancel']")
		private WebElement clickCancel;
		
		@FindBy(xpath="//button[text()='×']")
		private WebElement deleteCampaignClose;
		
		@FindBy(xpath="(//tr[@class='tr'])[2]")
		private WebElement deletebyCampaignID;
		
		@FindBy(xpath="//a[text()='2']")
		private WebElement changePage;
		
		
		
		public WebElement getChangePage() {
			return changePage;
		}

		public WebElement getDeletebyCampaignID() {
			return deletebyCampaignID;
		}

		public WebElement getDeleteCampaignClose() {
			return deleteCampaignClose;
		}

		public WebElement getClickCancel() {
			return clickCancel;
		}

		public WebElement getClickDelete() {
			return clickDelete;
		}
		@FindBy(xpath="//input[@value='Delete']")
		private WebElement clickDelete;
		
		public WebElement getDeleteOption() {
			return deleteOption;
		}

		public WebElement getClickDropdown1() {
			return clickDropdown1;
		}

		public WebElement getClickDropdown2() {
			return clickDropdown2;
		}

	 
		public WebElement getClickbyCampId() {
			return clickbyCampId;
		}

		public WebElement getClickbyCampName() {
			return clickbyCampName;
		}                                               //TOAST MSG 
		
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
		     	   System.out.println("Campaign Created Successfully");
		        else
		     	   System.out.println("Campaign Not Created, please try again");
		        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		}
		
	

}
