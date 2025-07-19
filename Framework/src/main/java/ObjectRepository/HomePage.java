package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	        
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}                                                    //CAMPAIGN LINK
	
	@FindBy(linkText="Campaigns")
	private WebElement campaignlink;
	
	@FindBy(xpath="//span[text()='Create Campaign']")
	private WebElement CreateCampaignbutton;
	
public WebElement getCampaignlink() {
		return campaignlink;
	}

	public WebElement getCreateCampaignbutton() {
		return CreateCampaignbutton;
	}                                                 //LEAD LINK
	
	@FindBy(partialLinkText="Lead")
	private WebElement leadsLinktf;
	
	@FindBy(xpath="//span[text()='Create Lead']")
	private WebElement createLeadButton1;

	public WebElement getLeadsLinktf() {
		return leadsLinktf;
	}

	public WebElement getCreateLeadButton1() {
		return createLeadButton1;
	}                                                //CONTACTS LINK
	
 
	@FindBy(linkText="Contacts")
	private WebElement contactLink;
	
	@FindBy(xpath="//span[text()='Create Contact']")
	private WebElement createContactLink;

	public WebElement getContactLink() {
		return contactLink;
	}

	public WebElement getCreateContactLink() {
		return createContactLink;
	}
	
	                                                         //OPPORTUNITIES
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(xpath="//span[text()='Create Opportunity']")
	private WebElement createOpportunitiesLink;
	
	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getCreateOpportunitiesLink() {
		return createOpportunitiesLink;
	}
	                                                         //PRODUCTS
	@FindBy(linkText="Products")
	private WebElement ProductsLink;
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement createProductsLink;

	public WebElement getProductsLink() {
		return ProductsLink;
	}

	public WebElement getCreateProductsLink() {
		return createProductsLink;
	}
	                                                           //QUOTES
	@FindBy(linkText="Quotes")
	private WebElement QuotesLink;
	
	@FindBy(xpath="//span[text()='Create Quote']")
	private WebElement CreateQuoteLink;
	
    public WebElement getQuotesLink() {
		return QuotesLink;
	}

	public WebElement getCreateQuoteLink() {
		return CreateQuoteLink;
	}
                                                                 //PURCHASE ORDER
	@FindBy(linkText="Purchase Order")
	private WebElement PurchaseOrderLink;
	
	@FindBy(xpath="//span[text()='Create Order']")
	private WebElement purchaseOrderCreateLink;
	

	public WebElement getPurchaseOrderLink() {
		return PurchaseOrderLink;
	}

	public WebElement getPurchaseOrderCreateLink() {
		return purchaseOrderCreateLink;
	}
                                                                  //ADMIN CONSOLE
	
	
	@FindBy(xpath ="//div[@class='nav-link']")
	private WebElement AdminConsoleLink;
	
	public WebElement getAdminConsoleLink() {
		return AdminConsoleLink;
	}
	
	@FindBy(linkText = "Create User")
	private WebElement createUserclick;
	
	@FindBy(linkText = "View User")
	private WebElement viewUserclick;


	public WebElement getCreateUserclick() {
		return createUserclick;
	}

	public WebElement getViewUserclick() {
		return viewUserclick;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
                                                                      //LOGIN
	//@FindAll({@FindBy(id="usernam"),@FindBy(name="username")})
		//private WebElement usernametf;

	@FindBy(name="username")
	private WebElement usernametf;
	
	@FindBy(name="password")
	private WebElement passwordtf;
	
	@FindBy(xpath="//button[text()='Sign In']")
	private WebElement LoginButton;
	
	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	public void clickOnLoginButton() {
		LoginButton.click();
	}
	
	public void LoginAction(String username, String password) {
		usernametf.sendKeys(username);
		passwordtf.sendKeys(password);
		LoginButton.click();
	}
	                                                                 //LOGOUT
	@FindBy(xpath="//div[@class='user-icon']")
	private WebElement usericonbtn;
	
	@FindBy(xpath="//div[@class='dropdown-item logout']")
	private WebElement logoutbutton;
	
	public WebElement getUsericonbtn() {
		return usericonbtn;
	}

	public WebElement getLogoutbutton() {
		return logoutbutton;
	}
	
	public void clickOnLogOutButton() {
		logoutbutton.click();
	}
	
	

}
