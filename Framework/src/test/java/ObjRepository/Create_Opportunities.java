package ObjRepository;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.OpportunitiesPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class Create_Opportunities {

	public static void main(String[] args) throws IOException {
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		//String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		String oppname=eutil.getDataFromExcel("Opportunities", 1, 0);
		String oppamount=eutil.getDataFromExcel("Opportunities", 1, 1);
		String oppbusinesstype=eutil.getDataFromExcel("Opportunities", 1, 2);
		String oppnextstep=eutil.getDataFromExcel("Opportunities", 1, 3);
		String oppsalesstage=eutil.getDataFromExcel("Opportunities", 1, 4);
		String oppprobability=eutil.getDataFromExcel("Opportunities", 1, 5);
		String oppassignto=eutil.getDataFromExcel("Opportunities", 1, 6);
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
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
		 
		op.validateandCloseToastMsg();
		
		//ToastMessage tm=new ToastMessage(driver, oppname, randominteger);
		hp.getUsericonbtn().click();
		hp.clickOnLogOutButton();
		driver.quit();
		
		
 
	}

}
