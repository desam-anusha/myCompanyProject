package PageObjects;
import java.util.Iterator;
import java.util.List;
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


public class SearchPartyPage extends BaseDriver{

	public SearchPartyPage(WebDriver driver){
		BaseDriver.driver = driver;
		PageFactory.initElements(BaseDriver.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.PARTY_NAME_FIELD)
	WebElement partyNameField;
	@FindBy(how = How.XPATH, using = Locators.PARTY_COUNTRY_DROPDOWN)
	WebElement partyCountryDropdown;
	@FindBy(how = How.XPATH, using = Locators.PARTY_CITY_DROPDOWN)
	WebElement partyCityDropdown;
	@FindBy(how = How.XPATH, using = Locators.PARTY_SEARCH_BUTTON)
	WebElement partySearchButton;
	@FindBy(how = How.XPATH, using = Locators.PARTY_CITY_FIELD)
	WebElement partyCityField;
	@FindBy(how = How.XPATH, using = Locators.PARTY_RESULT_R1)
	List<WebElement> partyResultR1;
	@FindBy(how = How.XPATH, using = Locators.PARTY_STATE_DROPDOWN)
	WebElement partyStateDropdown;
	
	
	
	
	
	
	public void fill_form(String name, String city) throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partyNameField));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partyCountryDropdown));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partyCityDropdown));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partySearchButton));
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partyCityField));
			
			if (partyNameField.isEnabled()) {
				partyNameField.sendKeys(name);
			}else {
				System.out.println("Party Name is not Enabled");
			}
			
			if (partyCityField.isEnabled()) {
				partyCityField.sendKeys(city);
			}else {
				System.out.println("City is not Enabled");
			}
			
			
		}		
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	
	public void select_Country(String Country) throws Throwable{
		
		try {
			
			
			if (partyCountryDropdown.isEnabled()) {
				Select drpCountry = new Select(partyCountryDropdown);
				drpCountry.selectByVisibleText(Country);
				Thread.sleep(1000);
			}else {
				System.out.println("Seach button is not Enabled");
			}	
			
		}
		catch(Exception ex){
				System.out.println(ex);
		}
	}
	
	
	
	public void click_searchButton() throws Throwable{
		
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partySearchButton));
			
			if (partySearchButton.isEnabled()) {
				partySearchButton.click();
				Thread.sleep(1000);
			}else {
				System.out.println("Seach button is not Enabled");
			}
			
			
		}
		catch(Exception ex){
				System.out.println(ex);
		}
	}
	
	
	public boolean validate_Search_Results(String Name, String City,String Country) throws Throwable{     //Doubt(how to use and y we use)
		
		try {
			
			String value = "";
			int nameN = 0;
			int cityN = 0;
			int countryN = 0;
			
			Iterator<WebElement> itr = partyResultR1.iterator();
			
			while(itr.hasNext()) {
				value = itr.next().getText();
				if (value.contains(Name)) {
					System.out.println(value);
					nameN += 1;
				}
				if (value.contains(City)) {
					System.out.println(value);
					cityN += 1;
				}
				if (value.contains(Country)) {
					System.out.println(value);
					countryN += 1;
				}
			}
			
			if (nameN != cityN && cityN != countryN) {
				return false;
			}
		
			return true;
		}
		catch(Exception ex){
				System.out.println(ex);
				return false;
		}
	}
	
	public void fill_form(String name) throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(partyNameField));
			
			if (partyNameField.isEnabled()) {
				partyNameField.sendKeys(name);
			}else {
				System.out.println("Party Name is not Enabled");
			}
			
		}		
		catch(Exception ex){
			System.out.println(ex);
		}
	}	
	
	public boolean validate_Search_Results(String Name, String Country) throws Throwable{
		
		try {
			
			String value = "";
			int nameN = 0;
			int countryN = 0;
			
			Iterator<WebElement> itr = partyResultR1.iterator();
			
			while(itr.hasNext()) {
				value = itr.next().getText();
				if (value.contains(Name)) {
					System.out.println(value);
					nameN += 1;
				}

				if (value.contains(Country)) {
					System.out.println(value);
					countryN += 1;
				}
			}
			
			if (nameN != countryN) {
				return false;
			}
		
			return true;
		}
		catch(Exception ex){
				System.out.println(ex);
				return false;
		}
	}
	
	public void select_State(String State) throws Throwable{
		
		try {
			
			
			if (partyCountryDropdown.isEnabled()) {
				Select drpCountry = new Select(partyStateDropdown);
				drpCountry.selectByVisibleText(State);
				Thread.sleep(1000);
			}else {
				System.out.println("Seach button is not Enabled");
			}
			
			
		}
		catch(Exception ex){
				System.out.println(ex);
		}
	}	
	
	
	

}
	


	

