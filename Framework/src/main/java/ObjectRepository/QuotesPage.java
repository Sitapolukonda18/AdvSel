package ObjectRepository;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QuotesPage {
WebDriver driver;
	
	public QuotesPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
	@FindBy(name="subject")
	private WebElement quoteSubject;
	@FindBy(name="quoteStage")
	private WebElement quoteStage;
	
	@FindBy(name="validTill")
	private WebElement quoteDateClick;
	
	@FindBy(xpath="(//button[@type='button'])[2]")  
	private WebElement quoteopprtButton;
	
	 
	@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
	private WebElement quoteOppSelectButton;
	
	@FindBy(xpath="(//button[@type='button'])[3]") // 
	private WebElement quoteContactButton;
	
	@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
	private WebElement quoteContactSelectButton;
	
	@FindBy(xpath="(//div[@class='form-container'])[2]")
	private WebElement frameBilling;
	
	public WebElement getFrameBilling() {
		return frameBilling;
	}
	@FindBy(xpath="(//textarea[@name='address'])[1]")
	private WebElement billingAddress;
	@FindBy(xpath="(//textarea[@name='address'])[2]")
	private WebElement shipingAddress;
	@FindBy(xpath="(//input[@name='poBox'])[1]")
	private WebElement billingPoBox;
	@FindBy(xpath="(//input[@name='poBox'])[2]")
	private WebElement shipingPoBox;
	@FindBy(xpath="(//input[@name='city'])[1]")
	private WebElement billingCity;
	@FindBy(xpath="(//input[@name='city'])[2]")
	private WebElement City;
	@FindBy(xpath="(//input[@name='state'])[1]")
	private WebElement billingState;
	@FindBy(xpath="(//input[@name='state'])[2]")
	private WebElement State; 
	@FindBy(xpath="(//input[@name='postalCode'])[1]")
	private WebElement billingPostalCode;
	@FindBy(xpath="(//input[@name='postalCode'])[2]")
	private WebElement postalCode; 
	@FindBy(xpath="(//input[@name='country'])[1]")
	private WebElement billingCountry;
	@FindBy(xpath="(//input[@name='country'])[2]")
	private WebElement Country; 
	
	@FindBy(xpath="(//div[@class='form-container'])[2]")
	private WebElement frameSwitch;

	@FindBy(xpath="(//button[@type='button'])[4]")
	private WebElement addProductButtonend;
	
	@FindBy(xpath="//input[@placeholder='Enter discount']")
	private WebElement quoteEnterDiscount;
	
	@FindBy(xpath="//input[@placeholder='Enter shipping charges']")
	private WebElement quoteProductShipping;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement CreateQuoteButton;
	
	
	
	public WebElement getCreateQuoteButton() {
		return CreateQuoteButton;
	}

	public WebElement getQuoteProductShipping() {
		return quoteProductShipping;
	}

	public WebElement getQuoteEnterDiscount() {
		return quoteEnterDiscount;
	}
	@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
	private WebElement quoteProductSelectButton;
	
	public WebElement getQuoteProductSelectButton() {
		return quoteProductSelectButton;
	}

	public WebElement getAddProductButtonend() {
		return addProductButtonend;
	}

	public WebElement getFrameSwitch() {
		return frameSwitch;
	}

	public WebElement getBillingAddress() {
		return billingAddress;
	}

	public WebElement getShipingAddress() {
		return shipingAddress;
	}

	public WebElement getBillingPoBox() {
		return billingPoBox;
	}

	public WebElement getShipingPoBox() {
		return shipingPoBox;
	}

	public WebElement getBillingCity() {
		return billingCity;
	}

	public WebElement getCity() {
		return City;
	}

	public WebElement getBillingState() {
		return billingState;
	}

	public WebElement getState() {
		return State;
	}

	public WebElement getBillingPostalCode() {
		return billingPostalCode;
	}

	public WebElement getPostalCode() {
		return postalCode;
	}

	public WebElement getBillingCountry() {
		return billingCountry;
	}

	public WebElement getCountry() {
		return Country;
	}

	public WebElement getQuoteContactSelectButton() {
		return quoteContactSelectButton;
	}

	public WebElement getQuoteContactButton() {
		return quoteContactButton;
	}

	public WebElement getQuoteOppSelectButton() {
		return quoteOppSelectButton;
	}

	public WebElement getQuoteSubject() {
		return quoteSubject;
	}

	public WebElement getQuoteStage() {
		return quoteStage;
	}

	public WebElement getQuoteDateClick() {
		return quoteDateClick;
	}

	public WebElement getQuoteopprtButton() {
		return quoteopprtButton;
	}
 
	
	public void QuoteDetails(String quotesubject, String quotestage)
	{
		Random random=new Random();
		int randominteger=random.nextInt(300);
		quoteSubject.sendKeys(quotesubject+randominteger);
		quoteStage.sendKeys(quotestage);
	}
	
	public void QuoteBillingDetails(String billingaddress, String shipppingaddress, String billingpo, String shippingpo, String billingcity, String city,String billingstate, String state,String billingpostal, String postal, String billingcountry, String country)
	{
		Random random=new Random();
		int randominteger=random.nextInt(300);
		billingAddress.sendKeys(billingaddress+randominteger);
		shipingAddress.sendKeys(shipppingaddress);
		billingPoBox.sendKeys(billingpo);
		shipingPoBox.sendKeys(shippingpo);
		billingCity.sendKeys(billingcity);
		City.sendKeys(city);
		billingState.sendKeys(billingstate);
		State.sendKeys(state);
		billingPostalCode.sendKeys(billingpostal);
		postalCode.sendKeys(postal);
		billingCountry.sendKeys(billingcountry);
		Country.sendKeys(country);
		
	}
	
	
	public void QuoteAddProductField(String discount, String productshipping)
	{
	quoteEnterDiscount.sendKeys(productshipping);
	quoteProductShipping.sendKeys(discount);
	
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
	     	   System.out.println("Quotes Created Successfully");
	        else
	     	   System.out.println("Quotes Not Created, please try again");
	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	}

}
