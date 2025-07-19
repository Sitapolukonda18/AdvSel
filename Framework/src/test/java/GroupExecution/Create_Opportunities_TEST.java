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
import ObjectRepository.OpportunitiesPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

@Listeners(ListenerImplementationClass.class)
public class Create_Opportunities_TEST extends BaseClass{
	
	@Test 
	public void CreateOpportunities() throws EncryptedDocumentException, IOException
	{
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
		
		String oppname=eutil.getDataFromExcel("Opportunities", 1, 0);
		String oppamount=eutil.getDataFromExcel("Opportunities", 1, 1);
		String oppbusinesstype=eutil.getDataFromExcel("Opportunities", 1, 2);
		String oppnextstep=eutil.getDataFromExcel("Opportunities", 1, 3);
		String oppsalesstage=eutil.getDataFromExcel("Opportunities", 1, 4);
		String oppprobability=eutil.getDataFromExcel("Opportunities", 1, 5);
		String oppassignto=eutil.getDataFromExcel("Opportunities", 1, 6);
		
		HomePage hp=new HomePage(driver);
		hp.getOpportunitiesLink().click();
		hp.getCreateOpportunitiesLink().click();
		
		OpportunitiesPage op=new OpportunitiesPage(driver);
		op.OpportunityDetails(oppname, oppamount, oppbusinesstype, oppnextstep, oppsalesstage, oppprobability, oppassignto);
		
		op.getOppLeadPlusButton().click();
		
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		childwindow.remove(parentwindow);
		 for(String id:childwindow)
		{driver.switchTo().window(id);
			break;}
	   
		op.getOppleadselectButton().click();
		driver.switchTo().window(parentwindow);
		op.getOpportunitySubmitButton().click();
		
		//ToastMessage tm=new ToastMessage(driver, oppname, randominteger);
		
		//BELOW IS FOR ASSERTION CONCEPT
		
		WebElement message=op.getToastMsg();
		wutil.waitForVisibilityOfWebelement(driver, message);
		String msg = message.getText();
	    Boolean status=msg.contains(oppname);
	    
	    //HARD ASSERT
	   Assert.assertEquals(status, true, "Failed to create Opportunities"+oppname); //false
	   Reporter.log("successfully created the Opportunities"+oppname, true);
	 

	    //SOFT ASSERT 
	    
	 /*   SoftAssert soft=new SoftAssert();
	    soft.assertEquals(status, true, "Failed to create the Opportunities"+oppname); //false
	    soft.assertAll();*/
	  
	  op.validateandCloseToastMsg();
		
		
		
		
	}

}
