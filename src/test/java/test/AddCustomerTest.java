package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddCustomerTest {
	
	WebDriver driver;
	@Test
	@Parameters({ "userName", "password", "dashboardHeaderText","fullName", "company", "email", "phone", "address", "city", "state", "zip", "country", "currency", "group"})
	public void ValidUserShoulBeTbleToAddCustomer(String userName,String password,String dashboardHeaderText, String fullName, String company, String email, String phone,String address,String city, String state,String zip, String country, String currency,String group) throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.ValidateDashboardPage(dashboardHeaderText);
		dashboardpage.clickCustomerMenu();
		dashboardpage.clickAddCustomerMenu();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
	    addCustomerPage.insertFullName(fullName);
		addCustomerPage.selectCompanyDropDown(company);
		addCustomerPage.inserEmai(email);
		addCustomerPage.insertPhoneNum(phone);
		addCustomerPage.insertAddress(address);
		addCustomerPage.insertCity(city);
		addCustomerPage.insertState(state);
		addCustomerPage.insertZip(zip);
		addCustomerPage.selectCountry(country);
		addCustomerPage.selectCurrency(currency);
		addCustomerPage.selectGroup(group);
        addCustomerPage.clickSave();
        dashboardpage.clickListCustomerMenu();
        addCustomerPage.verifyInsertedNameAndDelete();
        addCustomerPage.clickDeleteConformationButton();

		
//		BrowserFactory.tearDown();
	}


	
}
