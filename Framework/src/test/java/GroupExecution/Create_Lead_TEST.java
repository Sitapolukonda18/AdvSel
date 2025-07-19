package GroupExecution;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import ObjectRepository.LeadPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class Create_Lead_TEST extends BaseClass{
	
	@Test 
	public void CreateLEad() throws EncryptedDocumentException, IOException {
	
	JavaUtility jutil=new JavaUtility();
	int randominteger=jutil.getRandomNumber();
	ExcelUtility eutil=new ExcelUtility();
	
	String leadname=eutil.getDataFromExcel("Lead", 1, 0);
	String leadcompany=eutil.getDataFromExcel("Lead", 1, 1);
	String leadsource=eutil.getDataFromExcel("Lead", 1, 2);
	String leadindustry=eutil.getDataFromExcel("Lead", 1, 3);
	String leadphone=eutil.getDataFromExcel("Lead", 1, 4);
	String leadstatus=eutil.getDataFromExcel("Lead", 1, 5);
	String leadrating=eutil.getDataFromExcel("Lead", 1, 6);
	String leadassignTo=eutil.getDataFromExcel("Lead", 1, 7);
 
	
	HomePage hp=new HomePage(driver);
	hp.getLeadsLinktf().click();
	hp.getCreateLeadButton1().click();
	
	LeadPage ldpg=new LeadPage(driver);
	ldpg.LeadDetails(leadname, leadcompany, leadsource, leadindustry, leadphone, leadstatus, leadrating, leadassignTo);
	ldpg.getLeadcampaignbutton().click();
	
    String parentwindow=driver.getWindowHandle();
	Set<String> childwindow=driver.getWindowHandles();
	childwindow.remove(parentwindow);
	 for(String id:childwindow)
	{driver.switchTo().window(id);
		break;}
   
	ldpg.getSelectButton().click();
	
	driver.switchTo().window(parentwindow);
	ldpg.getLeadCreateButton().click();	 
	
	//ToastMessage tm=new ToastMessage(driver, leadname, randominteger);
	
	 //BELOW IS FOR ASSERTION CONCEPT
	
	WebElement message=ldpg.getToastMsg();
	wutil.waitForVisibilityOfWebelement(driver, message);
	String msg = message.getText();
    Boolean status=msg.contains(leadname);
    
    //HARD ASSERT
   Assert.assertEquals(status, true, "Failed to create lead"+leadname); //false
   Reporter.log("successfully created the lead"+leadname, true);
   

    //SOFT ASSERT 
    
  /*  SoftAssert soft=new SoftAssert();
    soft.assertEquals(status, true, "Failed to create the lead"+leadname); //false
    soft.assertAll();
  */  
  ldpg.validateandCloseToastMsg();
	 
	
	}

}
