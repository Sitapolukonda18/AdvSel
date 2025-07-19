package ObjRepository;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.CampaignPage;
import ObjectRepository.HomePage;
import WebDriverUtility.WebDriverUtility;

public class Delete_Campaign {

	public static void main(String[] args) throws IOException {
		 
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelUtility eutil=new ExcelUtility();
		String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		                          
		CampaignPage cp=new CampaignPage(driver);
		                                            //UPDATE CAMPAIGN
		cp.getEditCampaign().click();
		cp.getTargetAudience().sendKeys("1");
		cp.getUpdateCampaign().click();
		
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(toastMsg));
        String msg = toastMsg.getText();
		 if(msg.contains("Successfully"))
	     	   System.out.println("Campaign Edited Successfully");
	        else
	     	   System.out.println("Campaign Not Edited, please try again");
	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
	        
	      hp.getUsericonbtn().click();
			hp.clickOnLogOutButton();
			driver.quit();
		
		                                               //DELETE CAMPAIGN
		/*cp.getChangePage().click();
		cp.getClickDropdown1().click();
		cp.getClickbyCampName().click();
		//cp.getClickbyCampId().click();
		cp.getClickDropdown2().click();
		
		//cp.getClickbyCampName().sendKeys("Campaign");
	 
		 
		cp.getDeleteOption().click();
		//cp.getClickCancel().click(); // clicking on cancel option from popup
		//cp.getDeleteCampaignClose().click();//close the popup
		cp.getClickDelete().click();
		
		WebElement toastMsg = driver.findElement(By.xpath("//div[@role='alert']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(toastMsg));
        String msg = toastMsg.getText();
		 if(msg.contains("Successfully"))
	     	   System.out.println("Campaign Deleted Successfully");
	        else
	     	   System.out.println("Campaign Not Deleted, please try again");
	        driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		
	        
	      hp.getUsericonbtn().click();
			hp.clickOnLogOutButton();
			driver.quit();*/
		
		

	}

}
