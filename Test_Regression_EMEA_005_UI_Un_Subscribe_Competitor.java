package CompanyTest;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import PageObjects.LoginPage;
import utilities.BaseDriver;
import utilities.Locators;

public class Test_Regression_EMEA_005_UI_Un_Subscribe_Competitor extends BaseDriver {
	
	@BeforeTest
	public void setUp() {
		getDriver();
		System.out.println("\n Company Data Management \n");
	}
	
	
	
	
	
	@Test
	public void Regression_EMEA_005_UI_Un_Subscribe_Competitor () {
		ExtentReports logger=ExtentReports.get(Test_Regression_EMEA_005_UI_Un_Subscribe_Competitor.class);
		logger.init(getPathReport(), false);
		
		
		LoginPage loginpage = new LoginPage(driver);
		
		// Test Steps
		logger.startTest("Test_Regression_EMEA_005_UI_Un_Subscribe_Competitor");
		System.out.println("Step 1. Login to EMDM Page");		
		driver.navigate().to(Locators.COMPANY_DATA_MANAGEMENT1);
		//Assert.assertTrue(loginpage.validate_loginPage(logger));
		loginpage.login_page(logger);
		
		logger.endTest();
	}
	
	@AfterTest
	public void tearDown() {
		System.out.println("\n Test Ends. \n");
		
	}
}
