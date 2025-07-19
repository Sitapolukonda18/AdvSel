package BaseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class BaseClass {
	
	public WebDriver driver;
	public PropertyFileUtility putil=new PropertyFileUtility();
	public WebDriverUtility wutil=new WebDriverUtility();
	public static WebDriver sDriver=null;                                        // FOR LISTENERS ONLY 
	
	@BeforeSuite(groups = {"smoke","regression"})
	public void configBS() {
		Reporter.log("Establish DB Connectivity", true);
	}
	
	@BeforeTest(groups = {"smoke","regression"})
	public void configBT() {
		Reporter.log("Pre-Conditions", true);
	}
	
	//@Parameters("browser")                                         //FOR CROSS BROWSER DISTRIBUTED PARALLEL TESTING 
	@BeforeClass(groups = {"smoke","regression"})
	//public void configBC(String brow) throws IOException {
	public void configBC() throws IOException {
		Reporter.log("Launching the Browser", true);
	//	String browser=brow;                                         //FOR CROSS BROWSER DISTRIBUTED PARALLEL TESTING 
		String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		
		if(browser.equalsIgnoreCase("CHROME")) {
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("Edge")) {
			driver=new EdgeDriver();
		}else if(browser.equalsIgnoreCase("Firefox")) {
			driver=new FirefoxDriver();
		} else {
			driver=new ChromeDriver();
		}
		
		sDriver=driver; // FOR LISTENERS ONLY 
		
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(url);
	}
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void configBM() throws IOException {
		Reporter.log("Login Action Started", true);
		
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void configAM() throws InterruptedException{
		Reporter.log("Lggedout successfully", true);
		
		HomePage hp=new HomePage(driver);
		hp.getUsericonbtn().click();
		hp.getLogoutbutton().click();
		
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void configAC() {
		
		driver.close();
		
		Reporter.log("Browser closed successfully", true);
	}
	
	@AfterTest(groups = {"smoke","regression"})
	public void configAT() {
		Reporter.log("Post-Conditions", true);
	}
	
	@AfterSuite(groups = {"smoke","regression"})
	public void configAS() {
		Reporter.log("Disconnect Database", true);
	}
	
	

}
