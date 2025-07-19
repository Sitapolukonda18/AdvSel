package ObjRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import GenericUtility.ExcelUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import ObjectRepository.HomePage;
import ObjectRepository.ProductsPage;
import ObjectRepository.ToastMessage;
import WebDriverUtility.WebDriverUtility;

public class Create_Products {

	public static void main(String[] args) throws IOException {
		JavaUtility jutil=new JavaUtility();
		int randominteger=jutil.getRandomNumber();
		ExcelUtility eutil=new ExcelUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		//String browser=putil.getDataFromPropertiesFile("Browser");
		String url=putil.getDataFromPropertiesFile("url");
		String username=putil.getDataFromPropertiesFile("username");
		String password=putil.getDataFromPropertiesFile("password");
		
		String prodname=eutil.getDataFromExcel("Products", 1, 0);
		String prodquantity=eutil.getDataFromExcel("Products", 1, 1);
		String prodprice=eutil.getDataFromExcel("Products", 1, 2);
		
		WebDriverUtility wutil=new WebDriverUtility();
		WebDriver driver = new EdgeDriver();
		wutil.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(url);
		
		HomePage hp=new HomePage(driver);
		hp.LoginAction(username, password);
		hp.getProductsLink().click();
		hp.getCreateProductsLink().click();
		
		ProductsPage pp=new ProductsPage(driver);
		pp.ProductsDetils(prodname, prodquantity, prodprice);
		pp.getProductCategory().click();
		pp.getProductctgryselectoption().click();
		pp.getProductVendor().click();
		pp.getProductselectvendoroption().click();
		pp.getProductsSubmitButton().click();
		
		//System.out.println(pp.getToastMsg().getText());
		//pp.getToastmsgClose().click();
		
		pp.validateandCloseToastMsg();
		//ToastMessage tm=new ToastMessage(driver, prodname, randominteger);
		hp.getUsericonbtn().click();
		hp.clickOnLogOutButton();
		driver.quit();
		
		
		
		
		
		
	 

	}

}
