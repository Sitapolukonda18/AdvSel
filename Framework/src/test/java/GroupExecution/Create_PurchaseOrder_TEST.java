package GroupExecution;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClass.BaseClass;
import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ListenerUtility.ListenerImplementationClass;
import ObjectRepository.HomePage;
import ObjectRepository.PurchaseOrderPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class Create_PurchaseOrder_TEST extends BaseClass{
	@Test

	public void CreatePurchaseOrder() throws EncryptedDocumentException, IOException {
			JavaUtility jutil=new JavaUtility();
			int randominteger=jutil.getRandomNumber();
			ExcelUtility eutil=new ExcelUtility();
			 
			
			String posubject=eutil.getDataFromExcel("Purchase Order", 1, 0);
			String postatus=eutil.getDataFromExcel("Purchase Order", 1, 1);
			
			String billingaddress=eutil.getDataFromExcel("Purchase Order", 1, 2);
			String shipppingaddress=eutil.getDataFromExcel("Purchase Order", 1, 3);
			String billingpo=eutil.getDataFromExcel("Purchase Order", 1, 4);
			String shippingpo=eutil.getDataFromExcel("Purchase Order", 1, 5);
			String billingcity=eutil.getDataFromExcel("Purchase Order", 1, 6);
			String city=eutil.getDataFromExcel("Purchase Order", 1, 7);
			String billingstate=eutil.getDataFromExcel("Purchase Order", 1, 8);
			String state=eutil.getDataFromExcel("Purchase Order", 1, 9);
			String billingpostal=eutil.getDataFromExcel("Purchase Order", 1, 10);
			String postal=eutil.getDataFromExcel("Purchase Order", 1, 11);
			String billingcountry=eutil.getDataFromExcel("Purchase Order", 1, 12);
			String country=eutil.getDataFromExcel("Purchase Order", 1, 13);
			String productshipping=eutil.getDataFromExcel("Purchase Order", 1, 14);
			String discount=eutil.getDataFromExcel("Purchase Order", 1, 15);
			
			 
			
			HomePage hp=new HomePage(driver);
			 
			hp.getPurchaseOrderLink().click();
			hp.getPurchaseOrderCreateLink().click();
			
			PurchaseOrderPage po=new PurchaseOrderPage(driver);
			po.PODetails(posubject, postatus);
			po.getPODateClick().click();
			String date = jutil.getRequiredDateddMMYYYY(5);
			po.getPODateClick().sendKeys(date);
			
			po.getPOcontactButton().click();
			 String parentwindow1=driver.getWindowHandle();
				Set<String> childwindow1=driver.getWindowHandles();
				childwindow1.remove(parentwindow1);
				 for(String id:childwindow1)
				{driver.switchTo().window(id);
					break;}
			po.getPOcontactSelectButton().click();
			driver.switchTo().window(parentwindow1);
			po.getPOFrameBilling().click();
			po.POBillingDetails(billingaddress, shipppingaddress, billingpo, shippingpo, billingcity, city, billingstate, state, billingpostal, postal, billingcountry, country);
            
			po.getPOaddProductButtonend().click();
			String parentwindow=driver.getWindowHandle();
			Set<String> childwindow=driver.getWindowHandles();
			childwindow.remove(parentwindow);
			 for(String id:childwindow)
			{driver.switchTo().window(id);
				break;}
			po.getPOProductSelectButton().click();
			driver.switchTo().window(parentwindow);
			po.POAddProductField(discount, productshipping);
			po.getPOCreateButton().click();
			
			//BELOW IS FOR ASSERTION CONCEPT
			
			WebElement message=po.getToastMsg();
			wutil.waitForVisibilityOfWebelement(driver, message);
			String msg = message.getText();
		    Boolean status=msg.contains(posubject);
		    
		    //HARD ASSERT
		  Assert.assertEquals(status, true, "Failed to create purchase order"+posubject); //false
		   Reporter.log("successfully created the purchase order"+posubject, true);
		 

		    //SOFT ASSERT 
		    po.validateandCloseToastMsg();
		    
		 /*  SoftAssert soft=new SoftAssert();
		    soft.assertEquals(status, true, "Failed to create the purchase order"+posubject); //false
		    soft.assertAll();
		  */
		 // 
	 
			
			
			
	}

}
