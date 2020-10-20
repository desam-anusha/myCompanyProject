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
import PageObjects.SearchPartyPage;

public class Separate_Search_String_Serviceusing_Name_Country_City extends BaseDriver {
	
	@BeforeTest
	public void setUp() {
		getDriver();
		System.out.println("\n Company Data Management \n");
		
	}
	
	
	@Test
	public void test () throws Throwable{
		ExtentReports logger=ExtentReports.get(Separate_Search_String_Serviceusing_Name_Country_City.class);
		logger.init(getPathReport(), false);
		driver.navigate().to(Locators.COMPANY_DATA_MANAGEMENT1);
		
		SearchPartyPage SearchPartyP = new SearchPartyPage(driver);
		LoginPage LoginP = new LoginPage(driver);
		HomePage HomeP = new HomePage(driver);
		
		
		String Name = "Bank";
		String Country = "United States";
		String City = "Dallas";

		
		// Test Steps
		
		logger.startTest("Search existing Location loud search via name");
		
		System.out.println("Step 1 - logon EMDM UI");
		LoginP.user_Login("lakshmi-narayana.gogineni@hpe.com","Password_06");
		Thread.sleep(1000);
		
		System.out.println("Step 2 - Click on Search->Search Party");
		HomeP.click_Search_Dropdown();
		HomeP.click_Search_Party();
		
		System.out.println("Step 3 - Perform Search Using: Part of a Name (Example Bank, from full name Bank of Australia + City + Country)");
		SearchPartyP.fill_form(Name, City);
		SearchPartyP.select_Country(Country);
		SearchPartyP.click_searchButton();
		Thread.sleep(800000);
		Assert.assertTrue(SearchPartyP.validate_Search_Results(Name, City, Country));
		
		logger.endTest();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("\n Test Ends. \n");
		driver.quit();
	}

}
