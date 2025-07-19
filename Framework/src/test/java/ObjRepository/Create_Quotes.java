package ObjRepository;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.QuotesPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class Create_Quotes {

	public static void main(String[] args) throws IOException, InterruptedException {
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		//String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		String quotesubject=eutil.getDataFromExcel("Quotes", 1, 0);
		String quotestage=eutil.getDataFromExcel("Quotes", 1, 1);
		
		String billingaddress=eutil.getDataFromExcel("Quotes", 1, 2);
		String shipppingaddress=eutil.getDataFromExcel("Quotes", 1, 3);
		String billingpo=eutil.getDataFromExcel("Quotes", 1, 4);
		String shippingpo=eutil.getDataFromExcel("Quotes", 1, 5);
		String billingcity=eutil.getDataFromExcel("Quotes", 1, 6);
		String city=eutil.getDataFromExcel("Quotes", 1, 7);
		String billingstate=eutil.getDataFromExcel("Quotes", 1, 8);
		String state=eutil.getDataFromExcel("Quotes", 1, 9);
		String billingpostal=eutil.getDataFromExcel("Quotes", 1, 10);
		String postal=eutil.getDataFromExcel("Quotes", 1, 11);
		String billingcountry=eutil.getDataFromExcel("Quotes", 1, 12);
		String country=eutil.getDataFromExcel("Quotes", 1, 13);
		String productshipping=eutil.getDataFromExcel("Quotes", 1, 14);
		String discount=eutil.getDataFromExcel("Quotes", 1, 15);
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		hp.getQuotesLink().click();
		hp.getCreateQuoteLink().click();
		
		QuotesPage qp=new QuotesPage(driver);
		qp.QuoteDetails(quotesubject, quotestage);
		qp.getQuoteDateClick().click();
		String date = jutil.getRequiredDateddMMYYYY(5);
		qp.getQuoteDateClick().sendKeys(date);
		
		qp.getQuoteopprtButton().click();
		 String parentwindow1=driver.getWindowHandle();
			Set<String> childwindow1=driver.getWindowHandles();
			childwindow1.remove(parentwindow1);
			 for(String id:childwindow1)
			{driver.switchTo().window(id);
				break;}
		qp.getQuoteOppSelectButton().click(); 
		driver.switchTo().window(parentwindow1);
				
		qp.getQuoteContactButton().click();
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		childwindow.remove(parentwindow);
		 for(String id:childwindow)
		{driver.switchTo().window(id);
			break;}
		 qp.getQuoteContactSelectButton().click();
		 driver.switchTo().window(parentwindow);
		 
	   	qp.getFrameBilling().click();
		qp.QuoteBillingDetails(billingaddress, shipppingaddress, billingpo, shippingpo, billingcity, city, billingstate, state, billingpostal, postal, billingcountry, country);
        qp.getAddProductButtonend().click();
        String parentwindow2=driver.getWindowHandle();
		Set<String> childwindow2=driver.getWindowHandles();
		childwindow2.remove(parentwindow2);
		 for(String id:childwindow2)
		{driver.switchTo().window(id);
			break;}
        qp.getQuoteProductSelectButton().click();
        driver.switchTo().window(parentwindow2);
        
       
        //Actions a=new Actions(driver);
      // a.moveToElement(qp.getQuoteEnterDiscount()).doubleClick(qp.getQuoteEnterDiscount()).build().perform();
      // qp.getQuoteEnterDiscount().sendKeys("2");
        qp.QuoteAddProductField(discount, productshipping);  //need to change
        Thread.sleep(2000);
        qp.getCreateQuoteButton().click();
		
       
        qp.validateandCloseToastMsg();
        //ToastMessage tm=new ToastMessage(driver, quotesubject, randominteger);
		hp.getUsericonbtn().click();
		hp.clickOnLogOutButton();
		driver.quit();
		
		
		
		 
		

	}

}
