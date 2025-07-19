package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLead {
	
	WebDriver driver;
	public NewLead(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='Create Lead']")
	private WebElement createLeadbtn;
	
	@FindBy(name="name")
	private WebElement leadNametf;
	
	@FindBy(name="company")
	private WebElement companytf;

	@FindBy(name="leadSource")
	private WebElement leadSourcetf;
	
	@FindBy(name="industry")
	private WebElement industrytf;
	
	@FindBy(name="leadStatus")
	private WebElement leadStatustf;

	@FindBy(name="phone")
	private WebElement phonetf;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	private WebElement addCpgnBtn;
	
	@FindBy(xpath="(//button[@class='select-btn'])[2]")
	private WebElement selectbtn;
	
	@FindBy(xpath="//button[@type='submit']")
    private WebElement createLeadSubmitButton;

	@FindBy(name="rating")
	private WebElement rating;


	public WebElement getRating() {
		return rating;
	}

	public WebElement getCreateLeadbtn() {
		return createLeadbtn;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLeadNametf() {
		return leadNametf;
	}

	public WebElement getCompanytf() {
		return companytf;
	}
	
	public WebElement getLeadSourcetf() {
		return leadSourcetf;
	}
	

	public WebElement getIndustrytf() {
		return industrytf;
	}

	public WebElement getLeadStatustf() {
		return leadStatustf;
	}
	
	public WebElement getPhonetf() {
		return phonetf;
	}

	public WebElement getAddCpgnBtn() {
		return addCpgnBtn;
		
	}
	
	public WebElement getSelectbtn() {
		return selectbtn;
	}

	public WebElement getCreateLeadSubmitButton() {
		return createLeadSubmitButton;
	}

	public void clickOnCreateLeadBtn() {
		createLeadbtn.click();	
	}
	
	

}
