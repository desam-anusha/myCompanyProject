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

public class Separate_Search_String_Service_using_Name_and_Country extends BaseDriver {
	
	@BeforeTest
	public void setUp() {
		getDriver();
		System.out.println("\n Company Data Management \n");
		
	}
	
	@Test
	public void test () throws Throwable{
		ExtentReports logger=ExtentReports.get(Separate_Search_String_Service_using_Name_and_Country.class);
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
		LoginP.user_Login("fsanchez@hpe.com", "");
		Thread.sleep(1000);
		
		System.out.println("Step 2 - Click on Search->Search Party");
		HomeP.click_Search_Dropdown();
		HomeP.click_Search_Party();
		
		System.out.println("Step 3 - Perform Search Using: Name (Example Bank of Australia + Country)");
		SearchPartyP.fill_form(Name);
		SearchPartyP.select_Country(Country);
		SearchPartyP.click_searchButton();
		Thread.sleep(500000);
		Assert.assertTrue(SearchPartyP.validate_Search_Results(Name, Country));
		
		logger.endTest();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("\n Test Ends. \n");
		driver.quit();
	}

	
	

}