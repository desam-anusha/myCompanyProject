package CompanyTest;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import utilities.BaseDriver;
import utilities.Locators;
import PageObjects.LoginPage;
import PageObjects.HomePage;
import PageObjects.SearchLocationPage;
import PageObjects.SearchPartyPage;


public class Separate_Search_String_Service_using_Name_Country_City_and_state extends BaseDriver {

	@BeforeTest
	public void setUp() {
		getDriver();
		System.out.println("\n Company Data Management \n");
		
	}
	
	
	@Test
	public void test () throws Throwable{
		ExtentReports logger=ExtentReports.get(Separate_Search_String_Service_using_Name_Country_City_and_state.class);
		logger.init(getPathReport(), false);
		driver.navigate().to(Locators.COMPANY_DATA_MANAGEMENT1);
		
		SearchPartyPage SearchPartyP = new SearchPartyPage(driver);
		LoginPage LoginP = new LoginPage(driver);
		HomePage HomeP = new HomePage(driver);
		
		
		String Name = "Bank";
		String Country = "United States";
		String City = "Honolulu";
		String State = "Hawaii";

		
		// Test Steps
		
		logger.startTest("Search existing Location loud search via name");
		
		System.out.println("Step 1 - logon EMDM UI");
		LoginP.user_Login("fsanchez@hpe.com", "rat.joy-66");
		Thread.sleep(1000);
		
		System.out.println("Step 2 - Click on Search->Search Party");
		HomeP.click_Search_Dropdown();
		HomeP.click_Search_Party();
		
		System.out.println("Step 3 - Perform Search Using: Part of a Name (Example Bank, from full name Bank of Australia + City + Country)");
		SearchPartyP.fill_form(Name, City);
		SearchPartyP.select_Country(Country);
		Thread.sleep(500);
		SearchPartyP.select_State(State);
		Thread.sleep(100);
		SearchPartyP.click_searchButton();
		Thread.sleep(4000);
		Assert.assertTrue(SearchPartyP.validate_Search_Results(Name, City, Country));
		
		logger.endTest();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("\n Test Ends. \n");
		driver.quit();
	}

}
