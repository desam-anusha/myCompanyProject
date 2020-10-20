package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BaseDriver;
import utilities.Locators;

public class CreatePage extends BaseDriver {
	public  CreatePage(WebDriver driver){
		BaseDriver.driver = driver;
		PageFactory.initElements(BaseDriver.driver, this);
	}
	@FindBy(how = How.XPATH, using = Locators.CREATE_PARTY_FIELD)
	WebElement createPartyfield;
	@FindBy(how = How.XPATH, using = Locators.CREATE_LOACTION_FIELD)
	WebElement createLocationfield;
	@FindBy(how = How.XPATH, using = Locators.CREATE_PARTY_ORGANIZATION)
	WebElement createPartyOrganization;
	@FindBy(how = How.XPATH, using = Locators.PARTY_STATE_DROPDOWN)
	WebElement partyStateDropdown;
	
	public void fill_form(String organizationName) throws Throwable{
			try {
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(createPartyOrganization));
			
			if (createPartyOrganization.isEnabled()) {
				createPartyOrganization.sendKeys("HP");
			}
			else {
				System.out.println("	Location Name is not Enabled");
			}
			}
	
			catch (Exception e) {
		// TODO: handle exception
	}}

	public static boolean validate_create_Results(String organizationName) {
		// TODO Auto-generated method stub
		return false;
	}}




