package ObjRepository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;
 
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class Create_Campaign {
	public static void main(String[] args) throws IOException {
		
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelUtility eutil=new ExcelUtility();
		String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		String campaignname=eutil.getDataFromExcel("Campaign", 1, 0);
		String campstatus=eutil.getDataFromExcel("Campaign", 1, 2);
		String camptarget=eutil.getDataFromExcel("Campaign", 1, 1);
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		
		CampaignPage cp=new CampaignPage(driver);
		cp.clickOnCreateCpnBtn();
		cp.getCampaignnameTF().sendKeys(campaignname+randominteger);
		cp.getTargetsizeTF().clear();
		cp.getTargetsizeTF().sendKeys(camptarget+randominteger);
		cp.getCampaignexpectedclosedate();
		String date = jutil.getRequiredDateddMMYYYY(5);
		cp.getCampaignexpectedclosedate().sendKeys(date);
		cp.clickOnCampaignCreateButton();
		
		cp.validateandCloseToastMsg();
		
		//ToastMessage tm=new ToastMessage(driver, campaignname, randominteger);
		/* WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
	     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	     wait.until(ExpectedConditions.visibilityOf(toastMsg));
	     
	     String msg = toastMsg.getText();
	     boolean status=msg.contains(campaignname);
	     Assert.assertEquals(status, true, "Failed to create campaign"+campaignname);
	     Reporter.log("successfully created the campaign"+campaignname, true);*/
	
	 	hp.getUsericonbtn().click();
		hp.getLogoutbutton().click();
		
		driver.quit();
		 
	}
	

}
