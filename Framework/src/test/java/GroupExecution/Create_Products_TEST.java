package GroupExecution;

import java.io.IOException;

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
import ObjectRepository.ProductsPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class Create_Products_TEST extends BaseClass{
	
	@Test 
	public void CreateProduct() throws EncryptedDocumentException, IOException {
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
				
		String prodname=eutil.getDataFromExcel("Products", 1, 0);
		String prodquantity=eutil.getDataFromExcel("Products", 1, 1);
		String prodprice=eutil.getDataFromExcel("Products", 1, 2);
		
		HomePage hp=new HomePage(driver);
		hp.getProductsLink().click();
		hp.getCreateProductsLink().click();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.ProductsDetils(prodname, prodquantity, prodprice);
		pp.getProductCategory().click();
		pp.getProductctgryselectoption().click();
		pp.getProductVendor().click();
		pp.getProductselectvendoroption().click();
		pp.getProductsSubmitButton().click();
		
		//ToastMessage tm=new ToastMessage(driver, prodname, randominteger);
		
		//BELOW IS FOR ASSERTION CONCEPT
		
				WebElement message=pp.getToastMsg();
				wutil.waitForVisibilityOfWebelement(driver, message);
				String msg = message.getText();
			    Boolean status=msg.contains(prodname);
			    
			    //HARD ASSERT
			   Assert.assertEquals(status, true, "Failed to create product"+prodname); //false
			   Reporter.log("successfully created the product"+prodname, true);
			   

			    //SOFT ASSERT 
			    
			   /* SoftAssert soft=new SoftAssert();
			    soft.assertEquals(status, true, "Failed to create the product"+prodname); //false
			    soft.assertAll();
			  */
			//  pp.validateandCloseToastMsg();
		 
		
		
	}

}
