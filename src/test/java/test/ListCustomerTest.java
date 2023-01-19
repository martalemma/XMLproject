package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	

	WebDriver driver;
	@Test
	@Parameters({ "userName", "password", "dashboardHeaderText","fullName", "company", "email", "phone", "address", "city", "state", "zip", "country", "currency", "group"})
	public void ValidUserShoulBeTbleToAddCustomerFromListCustomer(String userName,String password,String dashboardHeaderText, String fullName, String company, String email, String phone,String address,String city, String state,String zip, String country, String currency,String group) throws InterruptedException {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(userName);
		loginPage.insertPassword(password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardpage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.ValidateDashboardPage(dashboardHeaderText);
		dashboardpage.clickCustomerMenu();
		dashboardpage.clickListCustomerMenu();
		
		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.clickAddCustomerOnListCustomerPage();
		listCustomerPage.insertFullName(fullName);
		listCustomerPage.selectCompanyDropDown(company);
		listCustomerPage.inserEmai(email);
		listCustomerPage.insertPhoneNum(phone);
		listCustomerPage.insertAddress(address);
		listCustomerPage.insertCity(city);
		listCustomerPage.insertState(state);
		listCustomerPage.insertZip(zip);
		listCustomerPage.selectCountry(country);
		listCustomerPage.selectCurrency(currency);
		listCustomerPage.selectGroup(group);
		listCustomerPage.clickSave();
		dashboardpage.clickListCustomerMenu();
		listCustomerPage.insertOnSearchBox();
		listCustomerPage.verifySearchedNameAndProfile();
		

		
//		BrowserFactory.tearDown();
	}



}
