package CompanyTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import PageObjects.CreatePage;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.SearchPartyPage;
import utilities.BaseDriver;
import utilities.Locators;

public class Automation_regression_006_UI extends BaseDriver{

	@BeforeTest
	public void setup() {
		getDriver();
		System.out.println("\n company data management\n");
	}
	
		@Test
		public void test_Automation_regression_006_UI() throws Throwable {
			ExtentReports logger=ExtentReports.get(Automation_regression_006_UI.class);
			logger.init(getPathReport(), false);
			driver.navigate().to(Locators.COMPANY_DATA_MANAGEMENT1);
			
			CreatePage createC = new CreatePage(driver);
			LoginPage login=new LoginPage(driver);
			HomePage HomeP = new HomePage(driver);
			
			String organizationName = "HP";
			
			logger.startTest("Automation_regression_006_UI");
			System.out.println("Step 1. Login to the main page");
			login.user_Login("lakshmi-narayana.gogineni@hpe.com","Password_06");
			HomeP.click_Search_Party();
			
			System.out.println("Step 3 - Perform Search Using: Part of a Name (Example Organization NAme)");
			createC.fill_form(organizationName);
			Thread.sleep(100000);
//			CreatePage.fill_form(organizationName);
//			Thread.sleep(800000);
//			Assert.assertTrue(CreatePage.CreatePage(organizationName));
		}
		
		@AfterTest
		public void tearDown() {
			driver.quit();
		}
	}

