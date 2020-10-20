package PageObjects;


import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.BaseDriver;
import utilities.Locators;


public class HomePage extends BaseDriver{

	public HomePage(WebDriver driver){
		BaseDriver.driver = driver;
		PageFactory.initElements(BaseDriver.driver, this);
	}
	
	@FindBy(how = How.XPATH, using = Locators.SEARCH_DROPDOWN)
	WebElement searchDropdown;
	@FindBy(how = How.XPATH, using = Locators.SEARCH_LOCATION)
	WebElement searchLocation;
	@FindBy(how = How.XPATH, using = Locators.SEARCH_PARTY)
	WebElement searchParty;
	
	

	public void click_Search_Dropdown() throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchDropdown));
				
				if (searchDropdown.isEnabled()) {
					searchDropdown.click();
				}else {
					System.out.println("Search Dropdown is not Enabled");
				}
			
		}
		catch(NoSuchElementException ex) {
				System.out.println("Something went wrgong: " + ex);
			}
	
	}
	
	
	public void click_Search_Location() throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchLocation));
				
				if (searchLocation.isEnabled()) {
					searchLocation.click();
				}else {
					System.out.println("Search Location is not Enabled");
				}
			
		}
		catch(NoSuchElementException ex) {
				System.out.println("Something went wrgong: " + ex);
			}
	
	}
	
	public void click_Search_Party() throws Throwable{
		
		try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(searchParty));
				
				if (searchParty.isEnabled()) {
					searchParty.click();
				}else {
					System.out.println("Search Party is not Enabled");
				}
			
		}
		catch(NoSuchElementException ex) {
				System.out.println("Something went wrgong: " + ex);
			}
	
	}
		
}