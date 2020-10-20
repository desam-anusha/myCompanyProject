package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseDriver;
import utilities.Locators;

public class SearchLocationPage extends BaseDriver{
	
	public SearchLocationPage(WebDriver driver){
		BaseDriver.driver = driver;
		PageFactory.initElements(BaseDriver.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.LOCATION_LOCATION_NAME)
	WebElement userLocatioName;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_ADDRESS_LINE1)
	WebElement locationAddressLine1;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_CITY)
	WebElement locationCity;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_POSTAL_CODE)
	WebElement locationPostalCode;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_SEARCH_BUTTON)
	WebElement searchButton;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_COUNTRY_FIELD_DROPDOWN)
	WebElement countryDropdown;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_FRST_RESULT)
	WebElement locationFirstResult;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_RESULT_ADDRESS)
	WebElement locationResultAddress;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_RESULT_NAME)
	WebElement locationResultName;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_RESULT_ZIP)
	WebElement locationResultZip;
	@FindBy(how = How.XPATH, using = Locators.LOCATION_RESULT_CITY)
	WebElement locationResultCity;
	
	
	
	
	
	
	

	public void fill_form(String locationName,String address1,String postalCode,String city) throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(userLocatioName));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locationAddressLine1));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locationCity));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locationPostalCode));
			
			if (userLocatioName.isEnabled()) {
				userLocatioName.sendKeys(locationName);
			}else {
				System.out.println("	Location Name is not Enabled");
			}
			if (locationAddressLine1.isEnabled()) {
				locationAddressLine1.sendKeys(address1);
			}else {
				System.out.println("	Address1 field is not Enabled");
			}
			if (locationCity.isEnabled()) {
				locationCity.sendKeys(city);
			}else {
				System.out.println("	City field is not Enabled");
			}
			if (locationPostalCode.isEnabled()) {
				locationPostalCode.sendKeys(postalCode);
			}else {
				System.out.println("	Postal Code field is not Enabled");
			}
			
			
			
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	
	}
	
	
	public void click_searchButton() throws Throwable{
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchButton));
			
			if (searchButton.isEnabled()) {
				searchButton.click();
				Thread.sleep(1000);
			}else {
				System.out.println("	Seach button is not Enabled");
			}
			
			
		}
		catch(Exception ex){
				System.out.println(ex);
		}
	}
	
	public void select_US_country() throws Throwable{
		
		try {
			
			
			if (countryDropdown.isEnabled()) {
				Select drpCountry = new Select(countryDropdown);
				drpCountry.selectByVisibleText("United States");
				Thread.sleep(1000);
			}else {
				System.out.println("	Seach button is not Enabled");
			}
			
			
		}
		catch(Exception ex){
				System.out.println(ex);
		}
	}
	
	
	
	public void click_first_result_location() throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(locationFirstResult));
			if (locationFirstResult.isEnabled()) {
				locationFirstResult.click();
				
			}else {
				System.out.println("	No results");
			}
			
			
		}
		catch(Exception ex){
				System.out.println(ex);
		}
	}
	
	
	
public boolean validate_search_results(String locationName,String address1,String postalCode,String city) throws Throwable{
		
		try {
			boolean result = true;
			Thread.sleep(1000);			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", locationResultName);
			Thread.sleep(3000);
			if (locationResultName.isDisplayed()){
				String locationName1 = locationResultName.getAttribute("value");
				System.out.println("	Location Name found: " + locationName1 );
				System.out.println("	Location Name expected: " + locationName );
				if (locationName1.contains(locationName)) {
					System.out.println("	-Location Name expected matches");
					
				}else {
					System.out.println("	-Expected location name mismatches");
					result = false;
				}
			}else {
				System.out.println("	-Location Name is not Enabled");
			}
			
			if (locationResultAddress.isDisplayed()){
				String address2 = locationResultAddress.getAttribute("value");
				System.out.println("	Address found: " + address2 );
				System.out.println("	Address expected: " + address1 );
				if (address2.contains(address1)) {
					System.out.println("	-Address expected matches");
				}else {
					System.out.println("	-Address mismatches");
					result = false;
				}
			}else {
				System.out.println("	-Address is not Enabled");	
			}
			
			/*
			if (locationResultZip.isEnabled()){
				String postalCode2 = locationResultZip.getAttribute("value");
				System.out.println("	Postal code found: " + postalCode2 );
				System.out.println("	Postal code expected: " + postalCode );
				if (postalCode.contains(postalCode2)) {
					System.out.println("	-Postal code expected matches");
				}else {
					System.out.println("	-Postal code mismatches");
					result = false;
				}
			}else {
				System.out.println("	-Postal code is not Enabled");	
			}
			*/
			
			
			if (locationResultCity.isDisplayed()){
				String city2 = locationResultCity.getAttribute("value");
				System.out.println("	City found: " + city2 );
				System.out.println("	City expected: " + city );
				if (city.contains(city2)) {
					System.out.println("	-City expected matches");
				}else {
					System.out.println("	-City mismatches");
					result = false;
				}
			}else {
				System.out.println("	-Citye is not Enabled");	
			}
			
			return result;

		}
		catch(Exception ex){
				System.out.println(ex);
				return false;
		}
	}
	

	public void waitForSpinner() {
	
	
		try {
	
			WebElement spinner = (WebElement) driver.findElements(By.xpath("//div[@class='loader-overlay ng-star-inserted']//span"));
		
			while (spinner.isDisplayed()) {
				//Go to sleep my fiend....
			}
	
	
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		
	}
}




	
	