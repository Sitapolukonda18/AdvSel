package ObjRepository;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
 
import ObjectRepository.LeadPage;

import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class Create_Lead {

	public static void main(String[] args) throws IOException {
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		//String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		String leadname=eutil.getDataFromExcel("Lead", 1, 0);
		String leadcompany=eutil.getDataFromExcel("Lead", 1, 1);
		String leadsource=eutil.getDataFromExcel("Lead", 1, 2);
		String leadindustry=eutil.getDataFromExcel("Lead", 1, 3);
		String leadphone=eutil.getDataFromExcel("Lead", 1, 4);
		String leadstatus=eutil.getDataFromExcel("Lead", 1, 5);
		String leadrating=eutil.getDataFromExcel("Lead", 1, 6);
		String leadassignTo=eutil.getDataFromExcel("Lead", 1, 7);
	 
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new FirefoxDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
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
		
		ldpg.validateandCloseToastMsg();
		//ToastMessage tm=new ToastMessage(driver, leadname, randominteger);
		hp.getUsericonbtn().click();
		hp.clickOnLogOutButton();
		driver.quit();
		
		
		 
		
		
 
	}

}
