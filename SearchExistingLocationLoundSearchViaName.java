package CompanyTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import utilities.BaseDriver;
import utilities.Locators;
import PageObjects.LoginPage;
import PageObjects.HomePage;
import PageObjects.SearchLocationPage;



public class SearchExistingLocationLoundSearchViaName extends BaseDriver {
	
	
	@BeforeTest
	public void setUp() {
		getDriver();
		System.out.println("\n Company Data Management \n");
		
	}
	
	
	@Test
	public void test () throws Throwable{
		ExtentReports logger=ExtentReports.get(SearchExistingLocationLoundSearchViaName.class);
		logger.init(getPathReport(), false);
		driver.navigate().to(Locators.COMPANY_DATA_MANAGEMENT1);
		
		
		LoginPage LoginP = new LoginPage(driver);
		HomePage HomeP = new HomePage(driver);
		SearchLocationPage SearchLocationP = new SearchLocationPage(driver);
		
		String locationName = "HP Inc.";
		String address1 = "1501 Page Mill Rd";
		String postalCode = "94304-1126";
		String city = "Palo Alto";
		
		// Test Steps
		
		logger.startTest("Search existing Location loud search via name");
		
		System.out.println("Step 1 - logon EMDM UI");
		LoginP.user_Login("fsanchez@hpe.com", "rat.joy-66");
		Thread.sleep(1000);
		
		System.out.println("Step 2 - Click on Search->Search location");
		HomeP.click_Search_Dropdown();
		HomeP.click_Search_Location();
		
		System.out.println("Step 3 - Enter Location Name, address details on the search page.");
		SearchLocationP.fill_form(locationName, address1, postalCode, city);
		SearchLocationP.select_US_country();
		
		System.out.println("Step 4 - Click on Search Button.");
		SearchLocationP.click_searchButton();
		//SearchLocationP.waitForSpinner();
		Thread.sleep(120000);
		SearchLocationP.click_first_result_location();
		Thread.sleep(2000);
		Assert.assertTrue(SearchLocationP.validate_search_results(locationName, address1, postalCode, city));
		logger.endTest();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("\n Test Ends. \n");
		driver.quit();
	}

	
	
	
}
