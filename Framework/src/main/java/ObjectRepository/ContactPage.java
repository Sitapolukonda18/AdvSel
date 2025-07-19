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

public class ContactPage {
	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
	@FindBy(name="organizationName")
	private WebElement contactOrganizationName;
	
	@FindBy(name="title")
	private WebElement contactTitle;
	
	@FindBy(name="contactName")
	private WebElement contactNametf;
	
	public WebElement getContactNametf() {
		return contactNametf;
	}
	@FindBy(name="mobile")
	private WebElement contactMobile;
	@FindBy(xpath="(//button[@type='button'])[2]")  
	private WebElement contactcampaignbutton;
	@FindBy(xpath="(//button[@class=\"select-btn\"])[3]")
	private WebElement contactselectButton;
	@FindBy(xpath="//button[text()='Create Contact']")
	private WebElement contactCreateButton;
	@FindBy(name="email")
	private WebElement contactEmail;
	@FindBy(name="department")
	private WebElement contactDepartment;
	@FindBy(name="officePhone")
	private WebElement officePhone;

	public WebElement getContactEmail() {
		return contactEmail;
	}
    public WebElement getContactDepartment() {
		return contactDepartment;
	}



	public WebElement getOfficePhone() {
		return officePhone;
	}

	public WebElement getContactCreateButton() {
		return contactCreateButton;
	}

	public WebElement getContactselectButton() {
		return contactselectButton;
	}

	public WebElement getContactOrganizationName() {
		return contactOrganizationName;
	}

	public WebElement getContactcampaignbutton() {
		return contactcampaignbutton;
	}

	public WebElement getContactTitle() {
		return contactTitle;
	}

	 

	public WebElement getContactMobile() {
		return contactMobile;
	}
	
	public void ContactDetails(String organization, String title, String contactname, String mobile, String email, String department, String officephone)
	{
		contactOrganizationName.sendKeys(organization);
		Random random=new Random();
		int randominteger=random.nextInt(300);
	
		contactTitle.sendKeys(title);
		contactNametf.sendKeys(contactname+randominteger);
		contactMobile.sendKeys(mobile);
		contactEmail.sendKeys(email);
		contactDepartment.sendKeys(department);
		officePhone.sendKeys(officephone);
		
		
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
	     	   System.out.println("Contact Created Successfully");
	        else
	     	   System.out.println("Contact Not Created, please try again");
	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	}
}
