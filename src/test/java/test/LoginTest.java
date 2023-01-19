package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	WebDriver driver;
	
	
	
	@Test
	@Parameters({"userName", "password","dashboardHeaderText"})
	public void validUserShouldBeAbleToLogin(String Username, String Password, String dashboardHeaderText) {
		
		driver = BrowserFactory.init();
		
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.insertUserName(Username);
		loginPage.insertPassword(Password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardpage =PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.ValidateDashboardPage(dashboardHeaderText);
		BrowserFactory.tearDown();
		
	}

}
