package ObjRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
import WebDriverUtility.WebDriverUtility;

public class Create_AdminConsole {

	public static void main(String[] args) throws IOException, AWTException {
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		 
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new FirefoxDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		
		Actions a = new Actions(driver);
		WebElement ele = hp.getAdminConsoleLink();
		a.moveToElement(ele).perform();
		 		//hp.getViewUserclick().click();
		a.click(ele);
		
		driver.findElement(By.linkText("Create User")).click();
	//Robot r = new Robot();
   // r.keyPress(KeyEvent.VK_DOWN);
    //r.keyPress(KeyEvent.VK_DOWN);
   // r.keyPress(KeyEvent.VK_ENTER);
		
		//driver.findElement(By.linkText("Create User")).click();
		
		
	}

}
