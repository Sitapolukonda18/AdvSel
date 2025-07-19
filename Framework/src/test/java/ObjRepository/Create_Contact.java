package ObjRepository;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;

import ObjectRepository.ContactPage;
import ObjectRepository.HomePage;
 
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class Create_Contact {

	public static void main(String[] args) throws IOException
	{
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelUtility eutil=new ExcelUtility();
		
		//String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		String organization = eutil.getDataFromExcel("contact", 1, 0);
		String title = eutil.getDataFromExcel("contact", 1, 1);
		String contactname = eutil.getDataFromExcel("contact", 1, 2);
		String mobile = eutil.getDataFromExcel("contact", 1, 3);
		String email = eutil.getDataFromExcel("contact", 1, 4);
		String department=eutil.getDataFromExcel("contact", 1, 5);
		String officephone=eutil.getDataFromExcel("contact", 1, 6);
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		hp.getContactLink().click();
		hp.getCreateContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.ContactDetails(organization, title, contactname, mobile, email, department, officephone);
		cp.getContactcampaignbutton().click();
		
		String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		childwindow.remove(parentwindow);
		 for(String id:childwindow)
		{driver.switchTo().window(id);
			break;}
				
		cp.getContactselectButton().click();
		driver.switchTo().window(parentwindow);
		cp.getContactCreateButton().click();
			
		
		cp.validateandCloseToastMsg();
		
		//ToastMessage tm=new ToastMessage(driver, title, randominteger);
		hp.getUsericonbtn().click();
		hp.clickOnLogOutButton();
		driver.quit();
	
 
	}

}
