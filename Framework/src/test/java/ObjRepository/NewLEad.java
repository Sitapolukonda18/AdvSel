package ObjRepository;

import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.NewLead;
import WebDriverUtility.NewWebDriverUtility;
import WebDriverUtility.WebDriverUtility;

public class NewLEad {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub

		 
		PropertyFileUtility putil=new PropertyFileUtility();
		String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		//CROSS BROWSER TESTING 
			
		JavaUtility jutil=new JavaUtility();
		int r=jutil.getRandomNumber();
		
		ExcelUtility eutil=new ExcelUtility();
		String leadname=eutil.getDataFromExcel("Lead", 1, 0);
		String leadcompany=eutil.getDataFromExcel("Lead", 1, 1);
		String leadsource=eutil.getDataFromExcel("Lead", 1, 2);
		String leadindustry=eutil.getDataFromExcel("Lead", 1, 3);
		String leadphone=eutil.getDataFromExcel("Lead", 1, 4);
		String leadstatus=eutil.getDataFromExcel("Lead", 1, 5);
		String leadrating=eutil.getDataFromExcel("Lead", 1, 6);
		String leadassignTo=eutil.getDataFromExcel("Lead", 1, 7);
	 //Launching the url
		NewWebDriverUtility wutil=new NewWebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		hp.getLeadsLinktf().click();
		hp.getCreateLeadButton1().click();
		
		NewLead nld=new NewLead(driver);
		
		nld.getLeadNametf().sendKeys(leadname+r);
		nld.getLeadSourcetf().sendKeys(leadsource+r);
		nld.getCompanytf().sendKeys(leadcompany+r);
		nld.getIndustrytf().sendKeys(leadindustry+r);
		nld.getLeadStatustf().sendKeys(leadstatus+r);
		nld.getPhonetf().sendKeys(leadphone);
		nld.getRating().sendKeys(leadrating+r);
		nld.getAddCpgnBtn().click();
		
		/*String parentwindow=driver.getWindowHandle();
		Set<String> childwindow=driver.getWindowHandles();
		childwindow.remove(parentwindow);
		   for(String id:childwindow)
		{
			driver.switchTo().window(id);
			break;
		}*/
		
		wutil.switchNewBrowserTab(driver);
		
 
		nld.getSelectbtn().click();
		wutil.switchToParent(driver);
		//driver.switchTo().window(parentwindow);
		
		nld.getCreateLeadSubmitButton().click();
		driver.quit();
	 
	}


}
