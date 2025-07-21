package Demoone;

import java.io.IOException;
import java.time.Duration;

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
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;


@Listeners(ListenerImplementationClass.class)
public class Create_Campaign_TEST extends BaseClass{
	
	@Test(groups = "smoke")
	public void createCampaign() throws EncryptedDocumentException, IOException
	{
    
	JavaUtility jutil=new JavaUtility();
	int randominteger=jutil.getRandomNumber(); //yes mam 
	
	ExcelUtility eutil=new ExcelUtility();
	
	String campaignname=eutil.getDataFromExcel("Campaign", 1, 0);
	String camptarget=eutil.getDataFromExcel("Campaign", 1, 1);
	String campstatus=eutil.getDataFromExcel("Campaign", 1, 2);

	//adding comment for pull the code
		
	CampaignPage cp=new CampaignPage(driver);
	cp.clickOnCreateCpnBtn();
	cp.getCampaignnameTF().sendKeys(campaignname+randominteger);
	cp.getTargetsizeTF().clear();
	cp.getTargetsizeTF().sendKeys(camptarget+randominteger);
	cp.getCampaignexpectedclosedate();
	String date = jutil.getRequiredDateddMMYYYY(5);
	cp.getCampaignexpectedclosedate().sendKeys(date);
	cp.clickOnCampaignCreateButton();
		
	 //BELOW IS FOR ASSERTION CONCEPT
	
	WebElement message=cp.getToastMsg();
	wutil.waitForVisibilityOfWebelement(driver, message);
	String msg = message.getText();
    Boolean status=msg.contains(campaignname);
    
    //HARD ASSERT
   Assert.assertEquals(status, true, "Failed to create campaign"+campaignname); //false
   Reporter.log("successfully created the campaign"+campaignname, true);
   

    //SOFT ASSERT 
    
  /* SoftAssert soft=new SoftAssert();
    soft.assertEquals(status, true, "Failed to create the campaign"+campaignname); //false
    soft.assertAll();*/
    
  cp.validateandCloseToastMsg();

	 
}
	
	/*@Test(groups = "smokeDuplicate")
	public void createCampaignduplicate() throws EncryptedDocumentException, IOException
	{
    
	JavaUtility jutil=new JavaUtility();
	int randominteger=jutil.getRandomNumber();
	
	ExcelUtility eutil=new ExcelUtility();
	
	String campaignname=eutil.getDataFromExcel("Campaign", 1, 0);
	String camptarget=eutil.getDataFromExcel("Campaign", 1, 1);
	String campstatus=eutil.getDataFromExcel("Campaign", 1, 2);
		
	CampaignPage cp=new CampaignPage(driver);
	cp.clickOnCreateCpnBtn();
	cp.getCampaignnameTF().sendKeys(campaignname+randominteger);
	cp.getTargetsizeTF().clear();
	cp.getTargetsizeTF().sendKeys(camptarget+randominteger);
	cp.getCampaignexpectedclosedate();
	String date = jutil.getRequiredDateddMMYYYY(5);
	cp.getCampaignexpectedclosedate().sendKeys(date);
	cp.clickOnCampaignCreateButton();
		
	ToastMessage tm=new ToastMessage(driver, campaignname, randominteger);*/
	
	 


}
