package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ListCustomerPage extends BasePage{
	
	WebDriver driver;

	public ListCustomerPage(WebDriver driver) {
		this.driver = driver;

	}

//	WebElement
	@FindBy(how = How.XPATH, using = "//input[@id='account']")
	  WebElement FULLNAME_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='cid']")
	  WebElement COMPANY_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='email']")
	  WebElement EMAIL_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']")
	  WebElement PHONENUMBER_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	  WebElement ADDRESS_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	  WebElement CITY_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	  WebElement STATE_Element;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']")
	  WebElement ZIP_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='country']")
	  WebElement COUNTRY_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='currency']")
	  WebElement CURRENCY_Element;
	@FindBy(how = How.XPATH, using = "//select[@id='group']")
	  WebElement GROUP_Element;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']")
	   WebElement SAVE_Element;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary']")
	   WebElement DELETE_CONFORMATION_Element;
    @FindBy(how = How.XPATH,using = "//a[@class='btn btn-success']") 
       WebElement ADDCUSTOMER_ON_LISTCUSTOMER_Element;
    @FindBy(how = How.XPATH,using = "//input[@id='foo_filter']") 
        WebElement LISTCUSTOMER_SEARCH_BOX_Element;
	 

// corresponding method
	String insertName;

	public void insertFullName(String fullName) {
		insertName = fullName + generatRandomNum(999);
		FULLNAME_Element.sendKeys(insertName);
	}

	public void selectCompanyDropDown(String company) {
		selectDropDownMenu(COMPANY_Element, company);

	}

	public void inserEmai(String email) {
		String insertEmail = generatRandomNum(999) + email;
		EMAIL_Element.sendKeys(insertEmail);
	}

	public void insertPhoneNum(String phone) {
		PHONENUMBER_Element.sendKeys(phone + generatRandomNum(999));
	}

	public void insertAddress(String address) {
		ADDRESS_Element.sendKeys(address);
	}

	public void insertCity(String city) {
		CITY_Element.sendKeys(city);
	}

	public void insertState(String state) {
		STATE_Element.sendKeys(state);
	}

	public void insertZip(String zip) {
		ZIP_Element.sendKeys(zip);
	}

	public void selectCountry(String country) {
		selectDropDownMenu(COUNTRY_Element, country);
	}

	public void selectCurrency(String currency) {
		selectDropDownMenu(CURRENCY_Element, currency);
	}

	public void selectGroup(String group) {
		selectDropDownMenu(GROUP_Element, group);
	}

	public void clickSave() {
		SAVE_Element.click();
	}

	
	
	public void clickDeleteconformationButton() {
		DELETE_CONFORMATION_Element.click();

	}
	public void clickAddCustomerOnListCustomerPage() throws InterruptedException {
		Thread.sleep(2000);
		ADDCUSTOMER_ON_LISTCUSTOMER_Element.click();
		
	}
	public void insertOnSearchBox() {
		LISTCUSTOMER_SEARCH_BOX_Element.sendKeys(insertName);
		
	}
	
	     // tbody/tr[i]/td[3]/
		// tbody/tr[1]/td[3]/following-sibling::td[4]/a[2]
		String beforex_path = "//tbody/tr[";
		String afterx_path = "]/td[3]";
		String afterx_path_profile = "]/td[3]/following-sibling::td[4]/a[1]";

		public void verifySearchedNameAndProfile() throws InterruptedException {
			Thread.sleep(2000);
			for (int i = 1; i <= 5; i++) {
				String enteredName = driver.findElement(By.xpath(beforex_path + i + afterx_path)).getText();
				System.out.println("Searched Name available");
	           if (enteredName.contentEquals(insertName)) {
					System.out.println("Entered name matched");
					driver.findElement(By.xpath(beforex_path + i + afterx_path_profile)).click();
					break;
				}
				
			}

		}

	

}



