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

public class PurchaseOrderPage {
WebDriver driver;
	
	public PurchaseOrderPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
	@FindBy(name="subject")
	private WebElement POSubject;
	@FindBy(name="status")
	private WebElement POStatus;
	@FindBy(name="dueDate")
	private WebElement PODateClick;
	@FindBy(xpath="(//button[@type='button'])[2]")  
	private WebElement POContactButton;
	@FindBy(xpath="(//button[@type='button'])[2]")  
	private WebElement POcontactButton;
	@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
	private WebElement POcontactSelectButton;
	
	@FindBy(xpath="(//div[@class='form-container'])[2]")
	private WebElement POframeBilling;
	
	public WebElement getPOFrameBilling() {
		return POframeBilling;
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
	
	public WebElement getPOframeBilling() {
		return POframeBilling;
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
	public void POBillingDetails(String billingaddress, String shipppingaddress, String billingpo, String shippingpo, String billingcity, String city,String billingstate, String state,String billingpostal, String postal, String billingcountry, String country)
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
	
	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement POaddProductButtonend;
	
	@FindBy(xpath="//input[@placeholder='Enter discount']")
	private WebElement POEnterDiscount;
	
	@FindBy(xpath="//input[@placeholder='Enter shipping charges']")
	private WebElement POProductShipping;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement POCreateQuoteButton;
	
	@FindBy(xpath="(//button[@class=\"select-btn\"])[1]")
	private WebElement POProductSelectButton;
	
	 
	
	public WebElement getPOProductSelectButton() {
		return POProductSelectButton;
	}
	public WebElement getPOaddProductButtonend() {
		return POaddProductButtonend;
	}
	public WebElement getPOEnterDiscount() {
		return POEnterDiscount;
	}
	public WebElement getPOProductShipping() {
		return POProductShipping;
	}
	public WebElement getPOCreateQuoteButton() {
		return POCreateQuoteButton;
	}
	public WebElement getPOcontactButton() {
		return POcontactButton;
	}
	public WebElement getPOcontactSelectButton() {
		return POcontactSelectButton;
	}
	public WebElement getPODateClick() {
		return PODateClick;
	}
	public WebElement getPOContactButton() {
		return POContactButton;
	}
	public WebElement getPOSubject() {
		return POSubject;
	}
	public WebElement getPOStatus() {
		return POStatus;
	}
	 
	public void PODetails(String posubject, String postatus) {
		Random random=new Random();
		int randominteger=random.nextInt(300);
		POSubject.sendKeys(posubject+randominteger);
		POStatus.sendKeys(postatus);
	}
	
	public void POAddProductField(String discount, String productshipping)
	{
	POEnterDiscount.sendKeys(productshipping);
	POProductShipping.sendKeys(discount);
	
	}

	@FindBy(xpath="//button[@type='submit']")
	private WebElement POCreateButton;
	
	
	
	public WebElement getPOCreateButton() {
		return POCreateButton;
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
	     	   System.out.println("PurchaseOrder Created Successfully");
	        else
	     	   System.out.println("PurchaseOrder Not Created, please try again");
	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	}

}
