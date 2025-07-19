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

public class ProductsPage {
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
    this.driver=driver;
    PageFactory.initElements(driver, this);
}
	 
	@FindBy(name="productName")
	private WebElement productName;
	@FindBy(name="quantity")
	private WebElement productQuantity;
	@FindBy(name="price")
	private WebElement productPrice;
	
	@FindBy(name="productCategory")
	private WebElement productCategory;
	@FindBy(name="vendorId")
	private WebElement productVendor;
	
	@FindBy(xpath="//option[@value='Furniture']")
	private WebElement productctgryselectoption;
	
	@FindBy(xpath="//option[@value='VID_001']")
	private WebElement productselectvendoroption;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement ProductsSubmitButton;
	
	
	public WebElement getProductsSubmitButton() {
		return ProductsSubmitButton;
	}
	public WebElement getProductselectvendoroption() {
		return productselectvendoroption;
	}
	public WebElement getProductctgryselectoption() {
		return productctgryselectoption;
	}
	public WebElement getProductCategory() {
		return productCategory;
	}
	public WebElement getProductVendor() {
		return productVendor;
	}
	public WebElement getProductName() {
		return productName;
	}
	public WebElement getProductQuantity() {
		return productQuantity;
	}
	public WebElement getProductPrice() {
		return productPrice;
	}
	 
	
	public void ProductsDetils(String prodname, String prodquantity, String prodprice)
	{
		Random random=new Random();
		int randominteger=random.nextInt(300);
		productName.sendKeys(prodname+randominteger);
		productQuantity.clear();
		productQuantity.sendKeys(prodquantity+randominteger);
		productPrice.clear();
		productPrice.sendKeys(prodprice+randominteger);
		
		
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
	     	   System.out.println("Products Created Successfully");
	        else
	     	   System.out.println("Products Not Created, please try again");
	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
	}

}
