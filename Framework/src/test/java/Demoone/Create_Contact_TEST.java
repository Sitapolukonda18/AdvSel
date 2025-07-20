package Demoone;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
import ObjectRepository.ContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class Create_Contact_TEST extends BaseClass{
	
	@Test(groups = "regression")
	public void CreateContact() throws EncryptedDocumentException, IOException
	{
		
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		
		ExcelUtility eutil=new ExcelUtility();
		
		String organization = eutil.getDataFromExcel("contact", 1, 0);
		String title = eutil.getDataFromExcel("contact", 1, 1);
		String contactname = eutil.getDataFromExcel("contact", 1, 2);
		String mobile = eutil.getDataFromExcel("contact", 1, 3);
		String email = eutil.getDataFromExcel("contact", 1, 4);
		String department=eutil.getDataFromExcel("contact", 1, 5);
		String officephone=eutil.getDataFromExcel("contact", 1, 6);
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		hp.getCreateContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.ContactDetails(organization, title, contactname, mobile, email, department, officephone);
		cp.getContactcampaignbutton().click();
		
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		childwindow.remove(parentwindow);
		for(String id:childwindow)
		{
			driver.switchTo().window(id);
			break;
		}
		cp.getContactselectButton().click();
		driver.switchTo().window(parentwindow);
		cp.getContactCreateButton().click();
		
		 //BELOW IS FOR ASSERTION CONCEPT
		
		WebElement message=cp.getToastMsg();
		wutil.waitForVisibilityOfWebelement(driver, message);
		String msg = message.getText();
	    Boolean status=msg.contains(contactname);
	    
	    //HARD ASSERT
	  Assert.assertEquals(status, true, "Failed to create contact"+contactname); //false
	   Reporter.log("successfully created the contact"+contactname, true);
	   

	    //SOFT ASSERT 
	    
	  /*SoftAssert soft=new SoftAssert();
	    soft.assertEquals(status, true, "Failed to create the contact"+contactname); //false
	    soft.assertAll();*/
	    
	  cp.validateandCloseToastMsg();
		
	 
	}

}
